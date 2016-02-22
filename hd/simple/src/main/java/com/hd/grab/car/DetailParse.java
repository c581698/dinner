package com.hd.grab.car;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DetailParse {
	static Pattern PARAM_REG = Pattern.compile("paramtypeitems\":(.*?)\\}\\};");
	static Pattern CONFIG_REG = Pattern.compile("configtypeitems\":(.*?)\\}\\};");

	static Type typeOfT = new TypeToken<List<ParamRoot>>() {}.getType();
	static Type cfgType = new TypeToken<List<ConfigRoot>>() {}.getType();
	
	static Map<Integer, Integer> keys;
	
	public static void main(String[] args) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		Main.initHttp();
		Main.initLog("hd");
		
		CarDetailParse.initMapper();
		CarDetailParse.initParseMethod();
		
		Gson gson = new GsonBuilder().create();
		Type typeOfT = new TypeToken<List<TypeID>>() {
		}.getType();
		List<TypeID> ids = new ArrayList<TypeID>(20500);
		keys = new HashMap<Integer, Integer>(10000);
		
		ids=gson.fromJson(new FileReader(new File("E:\\workspace\\repo\\dinner\\hd\\simple\\type_id.json")), typeOfT);
		
		for(TypeID id : ids){
			keys.put(id.id, id.id);
		}
		int index = 0;
		for(Integer i:keys.keySet()){
			toSQL(index%1000==0?Integer.valueOf(index/1000).toString():null, i%10==0,i);
			++index;
		}
	}
	
	static void toSQL(String file,boolean flush,Integer tid) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		String str = Main.get(String.format(CarDetailParse.SPEC_URL, tid));
				//"var config = {\"returncode\":0,\"message\":null,\"result\":{\"specid\":21039,\"paramtypeitems\":[{\"name\":\"基本参数\",\"paramitems\":[{\"name\":\"车型名称\",\"valueitems\":[{\"specid\":21039,\"value\":\"宝马5系 2015款 530Le\"},{\"specid\":25239,\"value\":\"宝马5系 2015款 535Li 领先型\"}]},{\"name\":\"厂商指导价(元)\",\"valueitems\":[{\"specid\":21039,\"value\":\"69.86万\"},{\"specid\":25239,\"value\":\"68.86万\"}]},{\"name\":\"厂商\",\"valueitems\":[{\"specid\":21039,\"value\":\"华晨宝马\"},{\"specid\":25239,\"value\":\"华晨宝马\"}]},{\"name\":\"级别\",\"valueitems\":[{\"specid\":21039,\"value\":\"中大型车\"},{\"specid\":25239,\"value\":\"中大型车\"}]},{\"name\":\"发动机\",\"valueitems\":[{\"specid\":21039,\"value\":\"2.0T 218马力 L4\"},{\"specid\":25239,\"value\":\"3.0T 306马力 L6\"}]},{\"name\":\"变速箱\",\"valueitems\":[{\"specid\":21039,\"value\":\"8挡手自一体\"},{\"specid\":25239,\"value\":\"8挡手自一体\"}]},{\"name\":\"长*宽*高(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"5055*1860*1481\"},{\"specid\":25239,\"value\":\"5055*1860*1491\"}]},{\"name\":\"车身结构\",\"valueitems\":[{\"specid\":21039,\"value\":\"4门5座三厢车\"},{\"specid\":25239,\"value\":\"4门5座三厢车\"}]},{\"name\":\"最高车速(km/h)\",\"valueitems\":[{\"specid\":21039,\"value\":\"233\"},{\"specid\":25239,\"value\":\"250\"}]},{\"name\":\"官方0-100km/h加速(s)\",\"valueitems\":[{\"specid\":21039,\"value\":\"7.1\"},{\"specid\":25239,\"value\":\"6.2\"}]},{\"name\":\"实测0-100km/h加速(s)\",\"valueitems\":[{\"specid\":21039,\"value\":\"6.5\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"实测100-0km/h制动(m)\",\"valueitems\":[{\"specid\":21039,\"value\":\"39.01\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"实测油耗(L/100km)\",\"valueitems\":[{\"specid\":21039,\"value\":\"7.5\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"工信部综合油耗(L/100km)\",\"valueitems\":[{\"specid\":21039,\"value\":\"2\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"实测离地间隙(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"整车质保\",\"valueitems\":[{\"specid\":21039,\"value\":\"三年或10万公里\"},{\"specid\":25239,\"value\":\"三年或10万公里\"}]}]},{\"name\":\"车身\",\"paramitems\":[{\"name\":\"长度(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"5055\"},{\"specid\":25239,\"value\":\"5055\"}]},{\"name\":\"宽度(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"1860\"},{\"specid\":25239,\"value\":\"1860\"}]},{\"name\":\"高度(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"1481\"},{\"specid\":25239,\"value\":\"1491\"}]},{\"name\":\"轴距(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"3108\"},{\"specid\":25239,\"value\":\"3108\"}]},{\"name\":\"前轮距(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"1600\"}]},{\"name\":\"后轮距(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"1626\"}]},{\"name\":\"最小离地间隙(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"整备质量(kg)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"1850\"}]},{\"name\":\"车身结构\",\"valueitems\":[{\"specid\":21039,\"value\":\"三厢车\"},{\"specid\":25239,\"value\":\"三厢车\"}]},{\"name\":\"车门数(个)\",\"valueitems\":[{\"specid\":21039,\"value\":\"4\"},{\"specid\":25239,\"value\":\"4\"}]},{\"name\":\"座位数(个)\",\"valueitems\":[{\"specid\":21039,\"value\":\"5\"},{\"specid\":25239,\"value\":\"5\"}]},{\"name\":\"油箱容积(L)\",\"valueitems\":[{\"specid\":21039,\"value\":\"38\"},{\"specid\":25239,\"value\":\"70\"}]},{\"name\":\"行李厢容积(L)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"520\"}]}]},{\"name\":\"发动机\",\"paramitems\":[{\"name\":\"发动机型号\",\"valueitems\":[{\"specid\":21039,\"value\":\"N20B20\"},{\"specid\":25239,\"value\":\"N55B30\"}]},{\"name\":\"排量(mL)\",\"valueitems\":[{\"specid\":21039,\"value\":\"1997\"},{\"specid\":25239,\"value\":\"2979\"}]},{\"name\":\"排量(L)\",\"valueitems\":[{\"specid\":21039,\"value\":\"2.0\"},{\"specid\":25239,\"value\":\"3.0\"}]},{\"name\":\"进气形式\",\"valueitems\":[{\"specid\":21039,\"value\":\"涡轮增压\"},{\"specid\":25239,\"value\":\"涡轮增压\"}]},{\"name\":\"气缸排列形式\",\"valueitems\":[{\"specid\":21039,\"value\":\"L\"},{\"specid\":25239,\"value\":\"L\"}]},{\"name\":\"气缸数(个)\",\"valueitems\":[{\"specid\":21039,\"value\":\"4\"},{\"specid\":25239,\"value\":\"6\"}]},{\"name\":\"每缸气门数(个)\",\"valueitems\":[{\"specid\":21039,\"value\":\"4\"},{\"specid\":25239,\"value\":\"4\"}]},{\"name\":\"压缩比\",\"valueitems\":[{\"specid\":21039,\"value\":\"10\"},{\"specid\":25239,\"value\":\"10.2\"}]},{\"name\":\"配气机构\",\"valueitems\":[{\"specid\":21039,\"value\":\"DOHC\"},{\"specid\":25239,\"value\":\"DOHC\"}]},{\"name\":\"缸径(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"84\"},{\"specid\":25239,\"value\":\"84\"}]},{\"name\":\"行程(mm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"90.1\"},{\"specid\":25239,\"value\":\"89.6\"}]},{\"name\":\"最大马力(Ps)\",\"valueitems\":[{\"specid\":21039,\"value\":\"218\"},{\"specid\":25239,\"value\":\"306\"}]},{\"name\":\"最大功率(kW)\",\"valueitems\":[{\"specid\":21039,\"value\":\"160\"},{\"specid\":25239,\"value\":\"225\"}]},{\"name\":\"最大功率转速(rpm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"5000-6000\"},{\"specid\":25239,\"value\":\"5800-6000\"}]},{\"name\":\"最大扭矩(N·m)\",\"valueitems\":[{\"specid\":21039,\"value\":\"310\"},{\"specid\":25239,\"value\":\"400\"}]},{\"name\":\"最大扭矩转速(rpm)\",\"valueitems\":[{\"specid\":21039,\"value\":\"1350-4800\"},{\"specid\":25239,\"value\":\"1200-5000\"}]},{\"name\":\"发动机特有技术\",\"valueitems\":[{\"specid\":21039,\"value\":\"Double VANOS/Valvetronic\"},{\"specid\":25239,\"value\":\"Double VANOS/Valvetronic\"}]},{\"name\":\"燃料形式\",\"valueitems\":[{\"specid\":21039,\"value\":\"插电式混合动力\"},{\"specid\":25239,\"value\":\"汽油\"}]},{\"name\":\"燃油标号\",\"valueitems\":[{\"specid\":21039,\"value\":\"97号(京95号)\"},{\"specid\":25239,\"value\":\"97号(京95号)\"}]},{\"name\":\"供油方式\",\"valueitems\":[{\"specid\":21039,\"value\":\"直喷\"},{\"specid\":25239,\"value\":\"直喷\"}]},{\"name\":\"缸盖材料\",\"valueitems\":[{\"specid\":21039,\"value\":\"铝\"},{\"specid\":25239,\"value\":\"铝\"}]},{\"name\":\"缸体材料\",\"valueitems\":[{\"specid\":21039,\"value\":\"铝\"},{\"specid\":25239,\"value\":\"铝\"}]},{\"name\":\"环保标准\",\"valueitems\":[{\"specid\":21039,\"value\":\"国IV(国V)\"},{\"specid\":25239,\"value\":\"国IV(国V)\"}]}]},{\"name\":\"电动机\",\"paramitems\":[{\"name\":\"电动机总功率(kW)\",\"valueitems\":[{\"specid\":21039,\"value\":\"70\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"电动机总扭矩(N·m)\",\"valueitems\":[{\"specid\":21039,\"value\":\"250\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"前电动机最大功率(kW)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"前电动机最大扭矩(N·m)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"后电动机最大功率(kW)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"后电动机最大扭矩(N·m)\",\"valueitems\":[{\"specid\":21039,\"value\":\"-\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"工信部续航里程(km)\",\"valueitems\":[{\"specid\":21039,\"value\":\"58\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"电池容量(kWh)\",\"valueitems\":[{\"specid\":21039,\"value\":\"14\"},{\"specid\":25239,\"value\":\"-\"}]},{\"name\":\"电池组质保\",\"valueitems\":[{\"specid\":21039,\"value\":\"6年或10万公里\"},{\"specid\":25239,\"value\":\"-\"}]}]},{\"name\":\"变速箱\",\"paramitems\":[{\"name\":\"简称\",\"valueitems\":[{\"specid\":21039,\"value\":\"8挡手自一体\"},{\"specid\":25239,\"value\":\"8挡手自一体\"}]},{\"name\":\"挡位个数\",\"valueitems\":[{\"specid\":21039,\"value\":\"8\"},{\"specid\":25239,\"value\":\"8\"}]},{\"name\":\"变速箱类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"手自一体变速箱(AT)\"},{\"specid\":25239,\"value\":\"手自一体变速箱(AT)\"}]}]},{\"name\":\"底盘转向\",\"paramitems\":[{\"name\":\"驱动方式\",\"valueitems\":[{\"specid\":21039,\"value\":\"前置后驱\"},{\"specid\":25239,\"value\":\"前置后驱\"}]},{\"name\":\"前悬架类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"双叉臂式独立悬架\"},{\"specid\":25239,\"value\":\"双叉臂式独立悬架\"}]},{\"name\":\"后悬架类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"多连杆独立悬架\"},{\"specid\":25239,\"value\":\"多连杆独立悬架\"}]},{\"name\":\"助力类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"电动助力\"},{\"specid\":25239,\"value\":\"电动助力\"}]},{\"name\":\"车体结构\",\"valueitems\":[{\"specid\":21039,\"value\":\"承载式\"},{\"specid\":25239,\"value\":\"承载式\"}]}]},{\"name\":\"车轮制动\",\"paramitems\":[{\"name\":\"前制动器类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"通风盘式\"},{\"specid\":25239,\"value\":\"通风盘式\"}]},{\"name\":\"后制动器类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"通风盘式\"},{\"specid\":25239,\"value\":\"通风盘式\"}]},{\"name\":\"驻车制动类型\",\"valueitems\":[{\"specid\":21039,\"value\":\"电子驻车\"},{\"specid\":25239,\"value\":\"电子驻车\"}]},{\"name\":\"前轮胎规格\",\"valueitems\":[{\"specid\":21039,\"value\":\"245/45 R18 \"},{\"specid\":25239,\"value\":\"245/45 R18 \"}]},{\"name\":\"后轮胎规格\",\"valueitems\":[{\"specid\":21039,\"value\":\"245/45 R18 \"},{\"specid\":25239,\"value\":\"245/45 R18 \"}]},{\"name\":\"备胎规格\",\"valueitems\":[{\"specid\":21039,\"value\":\"无\"},{\"specid\":25239,\"value\":\"无\"}]}]}]}};";
		
		String param = getData(PARAM_REG, str, "paramtypeitems\":");
		String config= getData(CONFIG_REG, str, "configtypeitems\":");
		
		Map<String, Map<String, String>> values = getKV(generate(param, config));
		
		for(String id : values.keySet()){
			String sql = CarDetailParse.buildSQL(values.get(id), Integer.valueOf(id));
			
			CarDetailParse.write2File(file, sql, flush);
			
			keys.remove(id);
		}
	}
	
	static List<ValueItem> generate(String param,String config){
		Gson gson = new Gson();
		List<ValueItem> list = new ArrayList<ValueItem>();
		
		List<ParamRoot> paramList = gson.fromJson(param, typeOfT);
		List<ConfigRoot> configList = gson.fromJson(config, cfgType);
		
		if(paramList != null && configList != null){
			for(ParamRoot p:paramList){
				list.addAll(p.paramitems);
			}
			for(ConfigRoot c:configList){
				list.addAll(c.configitems);
			}
		}
		
		return list;
	}
	
	static Map<String, Map<String, String>> getKV(List<ValueItem> list){
		Map<String, Map<String, String>> maps = new HashMap<String, Map<String,String>>();
		
		if(list.isEmpty())
			return maps;
		ValueItem gen = list.get(0);
		for(Value v:gen.valueitems){
			maps.put(v.specid, new HashMap<String, String>());
		}
		
		for(ValueItem it : list){
			for(Value sub:it.valueitems){
				if(sub.value.indexOf("-")<0 && sub.value.indexOf("null")<0 && sub.value.indexOf("无")<0)
					maps.get(sub.specid).put(it.name, sub.value);
			}
		}
		
		return maps;
	}
	
	static String getData(Pattern p,String html,String rep){
		Matcher m = p.matcher(html);
		
        while (m.find()) {
        	return m.group(0).replace(rep, "").replace("}};","");
        }
        return null;
	}
}

class Root{
	String name;
}
class ParamRoot extends Root{
	List<ValueItem> paramitems;
}
class ConfigRoot extends Root{
	List<ValueItem> configitems;
}
class ValueItem extends Root{
	List<Value> valueitems;
}
class Value{
	String value;
	String specid;
}