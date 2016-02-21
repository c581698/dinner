package com.hd.grab.car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BrandImgParse {

	static String BRAND_IMG_URL = "http://car.autohome.com.cn/zhaoche/pinpai/";
	static int imgSize = 50;
	static Pattern BRAND_ID_PRE = Pattern.compile("brand-(.*?)\\.html");
	static Pattern BRAND_URL_PRE = Pattern.compile("src=\"(.*?)\"></a>");
	static Pattern BRAND_LOGO_PRE = Pattern.compile(String.format("/%s/(.*?)$", imgSize));
	static String LOGO_FILENAME_PRE = "[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$";
	
	public static void main(String[] args) throws IOException {
	}

	public static void parse(String filePath,String downloadPath) throws ClientProtocolException, IOException {
		Main.initLog("brand_img");
		
		String html = Main.get(BRAND_IMG_URL);

		Document doc = Jsoup.parse(html);

		Elements pngs = doc.select("a.pic");
		
		List<BrandImg> imgs = new ArrayList<BrandImg>();
		
		for(Element el: pngs){
			BrandImg img = getBrandImg(el.outerHtml());
			
			if(img != null){
				imgs.add(img);
			}
		}
		
		initRoot(downloadPath);
		
		Main.buildSQL(imgs, filePath);
	}
	
	static void initRoot(String root){
		File dir = new File(System.getProperty("user.dir")+root);
		
		if(!dir.exists() || dir.isFile()){
			dir.mkdirs();
		}
	}
	
	static BrandImg getBrandImg(String text){
		try {
			String brandId = match(BRAND_ID_PRE, text);
			String url = match(BRAND_URL_PRE, text);
			String logo = match(BRAND_LOGO_PRE, url);
			
			if(!logo.matches(LOGO_FILENAME_PRE)){
				logo = UUID.randomUUID().toString().replaceAll("-", "") + logo.substring(logo.lastIndexOf("."));
			}
			
			return new BrandImg(brandId,logo,url);
		} catch (Exception e) {
			Main.LOG.error("BrandImg解析出错："+text);
		}
		
		return null;
	}
	
	static String match(Pattern p,String str) throws Exception{
		Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            strs.add(m.group(1));            
        }
        
        if(strs.isEmpty() || strs.size() > 1){
        	throw new Exception();
        }
        
        return strs.get(0);
	}
}
class BrandImg extends Brand{
	String brandId;
	String logo;
	String url;
	
	public BrandImg(String brandId,String logo,String url) {
		this.brandId = brandId;
		this.logo = logo;
		this.url = url;
	}
	
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String getTemplate() {
		return "update car_brand set logo='%s' where id=%s;";
	}
	@Override
	public void after(Object... obj) {
		
	}
	@Override
	public boolean before() {
		try {
			return Main.get(this.url,this.logo) != null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public String toSql(Object...strings){
		return String.format(this.getTemplate(), new String[]{this.logo,this.brandId});
	}
}