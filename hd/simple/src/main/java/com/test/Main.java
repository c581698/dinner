package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.ORB;

import com.sleepycat.je.SecondaryDatabase;
import com.test.dao.BaseDao;
import com.twtr.common.utils.CollectionUtils;
import com.twtr.common.utils.DateUtils;
import com.twtr.model.common.entity.BaseEntity;
import com.twtr.model.modules.basic.ServItem;
import com.twtr.model.modules.repair.RepSettlement;

public class Main {

	static SqlSession session;

	public static void main(String[] args) throws Exception {
	}

	public static void runShell() throws Exception {
		//String cmd =
   	 File dir = new File("C:\\Users\\Px\\Desktop\\Release\\");
   	String cmdArgs[] = {"C:\\Users\\Px\\Desktop\\Release\\demo","recognize","-p","C:\\Users\\Px\\Desktop\\Release\\7.jpg"};
		try {

	    	 Process p = Runtime.getRuntime().exec(cmdArgs,null,dir); 
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBk"));  
	         String line = null;  
	         StringBuilder sb = new StringBuilder();  
	         while ((line = br.readLine()) != null) {  
	        	 sb.append(line + "\n");  
	         }
	         System.out.println(sb.toString()); 
	         
	    	 br = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
	         sb = new StringBuilder();  
	         while ((line = br.readLine()) != null) {  
	        	 sb.append(line + "\n");  
	         }
	         System.out.println("ERROR:"+sb.toString());
	         br.close();
	         p.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public static boolean generateImage(String imgStr, String imgFilePath) {
		//
		if (imgStr == null) // 图像数据为空
			return false;

		try {
			// Base64解码
			byte[] b = Base64.decodeBase64(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片

			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	static String getImgStr(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
	}

	static void buildConn() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		session = sqlSessionFactory.openSession();

		BaseDao dao = session.getMapper(BaseDao.class);

		List<ServItem> list = dao.queryServs("1");

		System.out.println(list.size());
	}
}
class Test{
	private Class<BaseEntity> clazz;
	
	public Test(Class<BaseEntity> cla) {
		setClazz(cla);
	}

	public Class<BaseEntity> getClazz() {
		return clazz;
	}

	public void setClazz(Class<BaseEntity> clazz) {
		this.clazz = clazz;
	}
}