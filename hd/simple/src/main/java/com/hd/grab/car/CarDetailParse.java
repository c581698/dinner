package com.hd.grab.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import com.sleepycat.je.tree.Key;

public class CarDetailParse {
	/**
	 
	 var config = {
	 		"returncode":0,
	 		"message":null,
	 		"result":{
	 			"specid":25153,
	 			"paramtypeitems":[{
	 				"name":"基本参数",
	 				"paramitems":[
	 					{"name":"车型名称","valueitems":[{"specid":25153,"value":"Rapide 2016款 6.0L S"}]},
	 					{"name":"厂商指导价(元)","valueitems":[{"specid":25153,"value":"364.50万"}]},
	 					{"name":"厂商","valueitems":[{"specid":25153,"value":"阿斯顿・马丁"}]},
	 					{"name":"级别","valueitems":[{"specid":25153,"value":"大型车"}]},
	 					{"name":"发动机","valueitems":[{"specid":25153,"value":"6.0L 559马力 V12"}]},
	 					{"name":"变速箱","valueitems":[{"specid":25153,"value":"8挡手自一体"}]},
	 					{"name":"长*宽*高(mm)","valueitems":[{"specid":25153,"value":"5019*2140*1360"}]},
	 					{"name":"车身结构","valueitems":[{"specid":25153,"value":"5门4座掀背车"}]},
	 					{"name":"最高车速(km/h)","valueitems":[{"specid":25153,"value":"327"}]},
	 					{"name":"官方0-100km/h加速(s)","valueitems":[{"specid":25153,"value":"4.4"}]},
	 					{"name":"实测0-100km/h加速(s)","valueitems":[{"specid":25153,"value":"-"}]},
	 					{"name":"实测100-0km/h制动(m)","valueitems":[{"specid":25153,"value":"-"}]},
	 					{"name":"实测油耗(L/100km)","valueitems":[{"specid":25153,"value":"-"}]},
	 					{"name":"工信部综合油耗(L/100km)","valueitems":[{"specid":25153,"value":"-"}]},
	 					{"name":"实测离地间隙(mm)","valueitems":[{"specid":25153,"value":"-"}]},
	 					{"name":"整车质保","valueitems":[{"specid":25153,"value":"三年不限公里"}]}
	 				]},{
	 				"name":"车身",
	 				"paramitems":[
	 					{"name":"长度(mm)","valueitems":[{"specid":25153,"value":"5019"}]},
	 					{"name":"宽度(mm)","valueitems":[{"specid":25153,"value":"2140"}]},{"name":"高度(mm)","valueitems":[{"specid":25153,"value":"1360"}]},{"name":"轴距(mm)","valueitems":[{"specid":25153,"value":"2989"}]},{"name":"前轮距(mm)","valueitems":[{"specid":25153,"value":"-"}]},{"name":"后轮距(mm)","valueitems":[{"specid":25153,"value":"-"}]},{"name":"最小离地间隙(mm)","valueitems":[{"specid":25153,"value":"-"}]},{"name":"整备质量(kg)","valueitems":[{"specid":25153,"value":"1990"}]},{"name":"车身结构","valueitems":[{"specid":25153,"value":"掀背车"}]},{"name":"车门数(个)","valueitems":[{"specid":25153,"value":"5"}]},{"name":"座位数(个)","valueitems":[{"specid":25153,"value":"4"}]},{"name":"油箱容积(L)","valueitems":[{"specid":25153,"value":"91"}]},{"name":"行李厢容积(L)","valueitems":[{"specid":25153,"value":"-"}]}]},{"name":"发动机","paramitems":[{"name":"发动机型号","valueitems":[{"specid":25153,"value":"-"}]},{"name":"排量(mL)","valueitems":[{"specid":25153,"value":"5935"}]},{"name":"排量(L)","valueitems":[{"specid":25153,"value":"6.0"}]},{"name":"进气形式","valueitems":[{"specid":25153,"value":"自然吸气"}]},{"name":"气缸排列形式","valueitems":[{"specid":25153,"value":"V"}]},{"name":"气缸数(个)","valueitems":[{"specid":25153,"value":"12"}]},{"name":"每缸气门数(个)","valueitems":[{"specid":25153,"value":"4"}]},{"name":"压缩比","valueitems":[{"specid":25153,"value":"10.9"}]},{"name":"配气机构","valueitems":[{"specid":25153,"value":"DOHC"}]},{"name":"缸径(mm)","valueitems":[{"specid":25153,"value":"-"}]},{"name":"行程(mm)","valueitems":[{"specid":25153,"value":"-"}]},{"name":"最大马力(Ps)","valueitems":[{"specid":25153,"value":"559"}]},{"name":"最大功率(kW)","valueitems":[{"specid":25153,"value":"411"}]},{"name":"最大功率转速(rpm)","valueitems":[{"specid":25153,"value":"6650"}]},{"name":"最大扭矩(N・m)","valueitems":[{"specid":25153,"value":"630"}]},{"name":"最大扭矩转速(rpm)","valueitems":[{"specid":25153,"value":"5500"}]},{"name":"发动机特有技术","valueitems":[{"specid":25153,"value":"-"}]},{"name":"燃料形式","valueitems":[{"specid":25153,"value":"汽油"}]},{"name":"燃油标号","valueitems":[{"specid":25153,"value":"97号(京95号)"}]},{"name":"供油方式","valueitems":[{"specid":25153,"value":"多点电喷"}]},{"name":"缸盖材料","valueitems":[{"specid":25153,"value":"铝镁合金"}]},{"name":"缸体材料","valueitems":[{"specid":25153,"value":"铝镁合金"}]},{"name":"环保标准","valueitems":[{"specid":25153,"value":"欧V"}]}]},{"name":"变速箱","paramitems":[{"name":"简称","valueitems":[{"specid":25153,"value":"8挡手自一体"}]},{"name":"挡位个数","valueitems":[{"specid":25153,"value":"8"}]},{"name":"变速箱类型","valueitems":[{"specid":25153,"value":"手自一体变速箱(AT)"}]}]},{"name":"底盘转向","paramitems":[{"name":"驱动方式","valueitems":[{"specid":25153,"value":"前置后驱"}]},{"name":"前悬架类型","valueitems":[{"specid":25153,"value":"螺旋弹簧双叉臂独立悬架"}]},{"name":"后悬架类型","valueitems":[{"specid":25153,"value":"螺旋弹簧双叉臂独立悬架"}]},{"name":"助力类型","valueitems":[{"specid":25153,"value":"电动助力"}]},{"name":"车体结构","valueitems":[{"specid":25153,"value":"承载式"}]}]},{"name":"车轮制动","paramitems":[{"name":"前制动器类型","valueitems":[{"specid":25153,"value":"通风盘式"}]},{"name":"后制动器类型","valueitems":[{"specid":25153,"value":"通风盘式"}]},{"name":"驻车制动类型","valueitems":[{"specid":25153,"value":"电子驻车"}]},{"name":"前轮胎规格","valueitems":[{"specid":25153,"value":"245/40 R20"}]},{"name":"后轮胎规格","valueitems":[{"specid":25153,"value":"295/35 R20"}]},{"name":"备胎规格","valueitems":[{"specid":25153,"value":"无"}]}]}]}};
    
     */
	/**
     var option = {
     		"returncode":0,
     		"message":null,
     		"result":{
     			"specid":25153,
     			"configtypeitems":[{
     				"name":"安全装备",
     				"configitems":[
     					{"name":"主/副驾驶座安全气囊","valueitems":[{"specid":25153,"value":"主●&nbsp;/&nbsp;副●","price":null}]},
     					{"name":"前/后排侧气囊","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后-","price":null}]},
     					{"name":"前/后排头部气囊(气帘)","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后●","price":null}]},
     					{"name":"膝部气囊","valueitems":[{"specid":25153,"value":"-","price":null}]},
     					{"name":"胎压监测装置","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"零胎压继续行驶","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"安全带未系提示","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"ISOFIX儿童座椅接口","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"发动机电子防盗","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"车内中控锁","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"遥控钥匙","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"无钥匙启动系统","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"无钥匙进入系统","valueitems":[{"specid":25153,"value":"●","price":null}]}]},{
     				"name":"操控配置",
     				"configitems":[
     					{"name":"ABS防抱死","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"制动力分配(EBD/CBC等)","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"刹车辅助(EBA/BAS/BA等)","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"牵引力控制(ASR/TCS/TRC等)","valueitems":[{"specid":25153,"value":"●","price":null}]},
     					{"name":"车身稳定控制(ESC/ESP/DSC等)","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"上坡辅助","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"自动驻车","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"陡坡缓降","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"可变悬架","valueitems":[{"specid":25153,"value":"软硬调节","price":null}]},{"name":"空气悬架","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"可变转向比","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"前桥限滑差速器/差速锁","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"中央差速器锁止功能","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后桥限滑差速器/差速锁","valueitems":[{"specid":25153,"value":"限滑差速器","price":null}]}]},{"name":"外部配置","configitems":[{"name":"电动天窗","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"全景天窗","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"运动外观套件","valueitems":[{"specid":25153,"value":"○","price":null}]},{"name":"铝合金轮圈","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"电动吸合门","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"侧滑门","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"电动后备厢","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"感应后备厢","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"车顶行李架","valueitems":[{"specid":25153,"value":"-","price":null}]}]},{"name":"内部配置","configitems":[{"name":"真皮方向盘","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"方向盘调节","valueitems":[{"specid":25153,"value":"上下+前后调节","price":null}]},{"name":"方向盘电动调节","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"多功能方向盘","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"方向盘换挡","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"方向盘加热","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"方向盘记忆","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"定速巡航","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"前/后驻车雷达","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后●","price":null}]},{"name":"倒车视频影像","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"行车电脑显示屏","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"全液晶仪表盘","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"HUD抬头数字显示","valueitems":[{"specid":25153,"value":"-","price":null}]}]},{"name":"座椅配置","configitems":[{"name":"座椅材质","valueitems":[{"specid":25153,"value":"真皮","price":null}]},{"name":"运动风格座椅","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"座椅高低调节","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"腰部支撑调节","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"肩部支撑调节","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"主/副驾驶座电动调节","valueitems":[{"specid":25153,"value":"主●&nbsp;/&nbsp;副●","price":null}]},{"name":"第二排靠背角度调节","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"第二排座椅移动","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后排座椅电动调节","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"电动座椅记忆","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"前/后排座椅加热","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后●","price":null}]},{"name":"前/后排座椅通风","valueitems":[{"specid":25153,"value":"前○&nbsp;/&nbsp;后○","price":null}]},{"name":"前/后排座椅按摩","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"第三排座椅","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后排座椅放倒方式","valueitems":[{"specid":25153,"value":"比例放倒","price":null}]},{"name":"前/后中央扶手","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后●","price":null}]},{"name":"后排杯架","valueitems":[{"specid":25153,"value":"●","price":null}]}]},{"name":"多媒体配置","configitems":[{"name":"GPS导航系统","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"定位互动服务","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"中控台彩色大屏","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"蓝牙/车载电话","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"车载电视","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后排液晶屏","valueitems":[{"specid":25153,"value":"○","price":null}]},{"name":"220V/230V电源","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"外接音源接口","valueitems":[{"specid":25153,"value":"USB+AUX","price":null}]},{"name":"CD支持MP3/WMA","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"多媒体系统","valueitems":[{"specid":25153,"value":"多碟CD(选装多碟DVD)","price":null}]},{"name":"扬声器品牌","valueitems":[{"specid":25153,"value":"(选装Bang & Olufsen)","price":null}]},{"name":"扬声器数量","valueitems":[{"specid":25153,"value":"10-11喇叭","price":null}]}]},{"name":"灯光配置","configitems":[{"name":"近光灯","valueitems":[{"specid":25153,"value":"氙气","price":null}]},{"name":"远光灯","valueitems":[{"specid":25153,"value":"氙气","price":null}]},{"name":"日间行车灯","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"自适应远近光","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"自动头灯","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"转向辅助灯","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"转向头灯","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"前雾灯","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"大灯高度可调","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"大灯清洗装置","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"车内氛围灯","valueitems":[{"specid":25153,"value":"-","price":null}]}]},{"name":"玻璃/后视镜","configitems":[{"name":"前/后电动车窗","valueitems":[{"specid":25153,"value":"前●&nbsp;/&nbsp;后●","price":null}]},{"name":"车窗防夹手功能","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"防紫外线/隔热玻璃","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"后视镜电动调节","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"后视镜加热","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"内/外后视镜自动防眩目","valueitems":[{"specid":25153,"value":"内●&nbsp;/&nbsp;外-","price":null}]},{"name":"后视镜电动折叠","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"后视镜记忆","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"后风挡遮阳帘","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后排侧遮阳帘","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后排侧隐私玻璃","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"遮阳板化妆镜","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"后雨刷","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"感应雨刷","valueitems":[{"specid":25153,"value":"●","price":null}]}]},{"name":"空调/冰箱","configitems":[{"name":"空调控制方式","valueitems":[{"specid":25153,"value":"自动●","price":null}]},{"name":"后排独立空调","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"后座出风口","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"温度分区控制","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"车内空气调节/花粉过滤","valueitems":[{"specid":25153,"value":"●","price":null}]},{"name":"车载冰箱","valueitems":[{"specid":25153,"value":"-","price":null}]}]},{"name":"高科技配置","configitems":[{"name":"自动泊车入位","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"发动机启停技术","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"并线辅助","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"车道偏离预警系统","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"主动刹车/主动安全系统","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"整体主动转向系统","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"夜视系统","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"中控液晶屏分屏显示","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"自适应巡航","valueitems":[{"specid":25153,"value":"-","price":null}]},{"name":"全景摄像头","valueitems":[{"specid":25153,"value":"-","price":null}]}]}]}};
	 
	 */
	static String SPEC_URL = "http://car.autohome.com.cn/config/spec/%s.html";
	static String SQL_TEMP = "update car_type set ";
	static Pattern DATA_PRE = Pattern.compile("\\{\"name\":((\"(.*?)\",\").*?(value\":(.*?)))\\}\\]\\}");
	static Pattern PARAM_PRE = Pattern.compile("\"paramtypeitems\":(.*?)\\}\\};");
	static Pattern CONFIG_PRE = Pattern.compile("\"configtypeitems\":(.*?)\\}\\};");
	static String VALUE_IS_NULL = "^(null{1})|(\"[\\-无]{1}\")$";
	static String KEY_IS_NULL = "^(基本参数|安全装备|车身|发动机|变速箱|底盘转向|车轮制动|操控配置|外部配置|内部配置|座椅配置|多媒体配置|灯光配置|玻璃/后视镜|空调/冰箱|高科技配置|选装包{1})$";
	static Pattern GET_FIRST_VALUE = Pattern.compile("^(.*?)(?!<=\\})");
	static Pattern SEAT_COUNT = Pattern.compile("门(.*?)座");
	static Pattern MATCH_COUNT = Pattern.compile("●");
	static Pattern AUTO_OPER = Pattern.compile("自动");
	
	static String SQL_PRE = "update car_type set ";
	static FileOutputStream FOS;
	static Map<String, Method> methodMap = new HashMap<String, Method>(10);
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String str = "主● / 副●";
				//"4门5座三厢车";
				//"{ 	\"returncode\":0, 	\"message\":null, 	\"result\":{ 	\"specid\":25153, 	\"paramtypeitems\":[{ 		\"name\":\"基本参数\", 		\"paramitems\":[ 		{\"name\":\"车型名称\",\"valueitems\":[{\"specid\":25153,\"value\":\"Rapide 2016款 6.0L S\"}]}, 		{\"name\":\"厂商指导价(元)\",\"valueitems\":[{\"specid\":25153,\"value\":\"364.50万\"}]}, 		{\"name\":\"厂商\",\"valueitems\":[{\"specid\":25153,\"value\":\"阿斯顿・马丁\"}]}, 		{\"name\":\"级别\",\"valueitems\":[{\"specid\":25153,\"value\":\"大型车\"}]}, 		{\"name\":\"发动机\",\"valueitems\":[{\"specid\":25153,\"value\":\"6.0L 559马力 V12\"}]}, 		{\"name\":\"变速箱\",\"valueitems\":[{\"specid\":25153,\"value\":\"8挡手自一体\"}]}, 		{\"name\":\"长*宽*高(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"5019*2140*1360\"}]}, 		{\"name\":\"车身结构\",\"valueitems\":[{\"specid\":25153,\"value\":\"5门4座掀背车\"}]}, 		{\"name\":\"最高车速(km/h)\",\"valueitems\":[{\"specid\":25153,\"value\":\"327\"}]}, 		{\"name\":\"官方0-100km/h加速(s)\",\"valueitems\":[{\"specid\":25153,\"value\":\"4.4\"}]}, 		{\"name\":\"实测0-100km/h加速(s)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}, 		{\"name\":\"实测100-0km/h制动(m)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}, 		{\"name\":\"实测油耗(L/100km)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}, 		{\"name\":\"工信部综合油耗(L/100km)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}, 		{\"name\":\"实测离地间隙(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}, 		{\"name\":\"整车质保\",\"valueitems\":[{\"specid\":25153,\"value\":\"三年不限公里\"}]} 		]},{ 		\"name\":\"车身\", 		\"paramitems\":[ 		{\"name\":\"长度(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"5019\"}]}, 		{\"name\":\"宽度(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"2140\"}]},{\"name\":\"高度(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"1360\"}]},{\"name\":\"轴距(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"2989\"}]},{\"name\":\"前轮距(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"后轮距(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"最小离地间隙(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"整备质量(kg)\",\"valueitems\":[{\"specid\":25153,\"value\":\"1990\"}]},{\"name\":\"车身结构\",\"valueitems\":[{\"specid\":25153,\"value\":\"掀背车\"}]},{\"name\":\"车门数(个)\",\"valueitems\":[{\"specid\":25153,\"value\":\"5\"}]},{\"name\":\"座位数(个)\",\"valueitems\":[{\"specid\":25153,\"value\":\"4\"}]},{\"name\":\"油箱容积(L)\",\"valueitems\":[{\"specid\":25153,\"value\":\"91\"}]},{\"name\":\"行李厢容积(L)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]}]},{\"name\":\"发动机\",\"paramitems\":[{\"name\":\"发动机型号\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"排量(mL)\",\"valueitems\":[{\"specid\":25153,\"value\":\"5935\"}]},{\"name\":\"排量(L)\",\"valueitems\":[{\"specid\":25153,\"value\":\"6.0\"}]},{\"name\":\"进气形式\",\"valueitems\":[{\"specid\":25153,\"value\":\"自然吸气\"}]},{\"name\":\"气缸排列形式\",\"valueitems\":[{\"specid\":25153,\"value\":\"V\"}]},{\"name\":\"气缸数(个)\",\"valueitems\":[{\"specid\":25153,\"value\":\"12\"}]},{\"name\":\"每缸气门数(个)\",\"valueitems\":[{\"specid\":25153,\"value\":\"4\"}]},{\"name\":\"压缩比\",\"valueitems\":[{\"specid\":25153,\"value\":\"10.9\"}]},{\"name\":\"配气机构\",\"valueitems\":[{\"specid\":25153,\"value\":\"DOHC\"}]},{\"name\":\"缸径(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"行程(mm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"最大马力(Ps)\",\"valueitems\":[{\"specid\":25153,\"value\":\"559\"}]},{\"name\":\"最大功率(kW)\",\"valueitems\":[{\"specid\":25153,\"value\":\"411\"}]},{\"name\":\"最大功率转速(rpm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"6650\"}]},{\"name\":\"最大扭矩(N・m)\",\"valueitems\":[{\"specid\":25153,\"value\":\"630\"}]},{\"name\":\"最大扭矩转速(rpm)\",\"valueitems\":[{\"specid\":25153,\"value\":\"5500\"}]},{\"name\":\"发动机特有技术\",\"valueitems\":[{\"specid\":25153,\"value\":\"-\"}]},{\"name\":\"燃料形式\",\"valueitems\":[{\"specid\":25153,\"value\":\"汽油\"}]},{\"name\":\"燃油标号\",\"valueitems\":[{\"specid\":25153,\"value\":\"97号(京95号)\"}]},{\"name\":\"供油方式\",\"valueitems\":[{\"specid\":25153,\"value\":\"多点电喷\"}]},{\"name\":\"缸盖材料\",\"valueitems\":[{\"specid\":25153,\"value\":\"铝镁合金\"}]},{\"name\":\"缸体材料\",\"valueitems\":[{\"specid\":25153,\"value\":\"铝镁合金\"}]},{\"name\":\"环保标准\",\"valueitems\":[{\"specid\":25153,\"value\":\"欧V\"}]}]},{\"name\":\"变速箱\",\"paramitems\":[{\"name\":\"简称\",\"valueitems\":[{\"specid\":25153,\"value\":\"8挡手自一体\"}]},{\"name\":\"挡位个数\",\"valueitems\":[{\"specid\":25153,\"value\":\"8\"}]},{\"name\":\"变速箱类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"手自一体变速箱(AT)\"}]}]},{\"name\":\"底盘转向\",\"paramitems\":[{\"name\":\"驱动方式\",\"valueitems\":[{\"specid\":25153,\"value\":\"前置后驱\"}]},{\"name\":\"前悬架类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"螺旋弹簧双叉臂独立悬架\"}]},{\"name\":\"后悬架类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"螺旋弹簧双叉臂独立悬架\"}]},{\"name\":\"助力类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"电动助力\"}]},{\"name\":\"车体结构\",\"valueitems\":[{\"specid\":25153,\"value\":\"承载式\"}]}]},{\"name\":\"车轮制动\",\"paramitems\":[{\"name\":\"前制动器类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"通风盘式\"}]},{\"name\":\"后制动器类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"通风盘式\"}]},{\"name\":\"驻车制动类型\",\"valueitems\":[{\"specid\":25153,\"value\":\"电子驻车\"}]},{\"name\":\"前轮胎规格\",\"valueitems\":[{\"specid\":25153,\"value\":\"245/40 R20\"}]},{\"name\":\"后轮胎规格\",\"valueitems\":[{\"specid\":25153,\"value\":\"295/35 R20\"}]},{\"name\":\"备胎规格\",\"valueitems\":[{\"specid\":25153,\"value\":\"无\"}]}]}]}};    ";
		/*Matcher m = SEAT_COUNT.matcher(str);
		
        while (m.find()) {
        	System.out.println(m.group(1));
        }*/
//		parseRow(str);
//		System.out.println("安全装备".matches(KEY_IS_NULL));
//		initRawData("");
//		System.out.println(Main.matchCount(MATCH_COUNT, str, "●"));
	}
	static Map<String, String> parseRow(String raw){
		Map<String, String> values = new HashMap<String, String>(100);
		Matcher m = DATA_PRE.matcher(raw);
		
        while (m.find()) {
        	if(m.groupCount() == 5 && !m.group(3).matches(KEY_IS_NULL)){
        		int index = m.group(5).indexOf("}");
        		String val = m.group(5);
        		
        		if(index!=-1){
        			val = val.substring(0, index);
        		}
        		index = val.indexOf(",");
        		
        		if(index!=-1){
        			val = val.substring(0, index);
        		}
        		
        		if(!val.matches(VALUE_IS_NULL) ){
        			values.put(m.group(3), val);
        		}else{
        			Main.LOG.info(m.group(0));
        		}
        	}else{
        		Main.LOG.info("parseRow debug:\n\r\t"+m.group(0));
        	}
        }
        
        if(values.isEmpty()){
        	Main.LOG.debug("parseRow raw error:\n\r\t"+raw);
        	return null;
        }
        
        return values;
	}
	static String buildSQL(Map<String, String> values,int id) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		StringBuilder remark = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		for(String key:values.keySet()){
			String value = values.get(key);
			Mapper mp = null;
			String mappger = Key_Map.get(key);
			try {
				if(StringUtils.isNotBlank(mappger)){
					mp = Mapper.valueOf(mappger);
				}else
					mp = Mapper.valueOf(key);
			} catch (Exception e) {
			}
			
			if(null != mp){
				String result= (String)methodMap.get(mp.getMethod()).invoke(null, value);
				
				tmp.append(String.format(" %s=%s,", mp.name,result));
			}else{
				remark.append(key).append(":").append(value.replaceAll("\"", "")).append(",");
			}
		}
		
		return tmp.append("remark='").append(remark).append("' where id=").append(id).append(";").toString();
	}
	static void initParseMethod(){
		Method[] methods = FieldMapper.class.getDeclaredMethods();
		
		for(Method m : methods){
			methodMap.put(m.getName(), m);
		}
	}
	public static void parse(String filePath,int carTypeId,boolean flush) throws ClientProtocolException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Main.initLog("car_detail");
		initParseMethod();
		
		String html = Main.get(String.format(SPEC_URL, carTypeId));
//		String metadata = initRawData(html);

		Map<String, String> values = parseRow(html);
		StringBuilder sql =new StringBuilder(SQL_PRE);
		
		if(null != values){
			sql.append(buildSQL(values,carTypeId));
		}
		
		write2File(filePath, sql.toString(), flush);
	}
	static String initRawData(String html){
		Main.LOG.info(html);
		
		StringBuilder bui = new StringBuilder();
		
		Map<String, String> values = new HashMap<String, String>(50);
		Matcher m = PARAM_PRE.matcher(html);
		
        while (m.find()) {
        	bui.append(m.group(2));
        }
        
        m = CONFIG_PRE.matcher(html);
		
        while (m.find()) {
        	bui.append(m.group(2));
        }
		
		return bui.toString();
	}
	static void write2File(String fileName,String sql,boolean flush) throws IOException{
		if(StringUtils.isNotBlank(fileName)){
			File file = new File(fileName);
			file.createNewFile();
			
			if(null != FOS){
				FOS.flush();
				FOS.close();
			}
			FOS = new FileOutputStream(file,true);
		}
		
		FOS.write((sql+"\r\n").getBytes());
		
		if(flush)
			FOS.flush();
	}
	static Map<String, String> Key_Map = new HashMap<String, String>();
	static void initMapper(){
		Key_Map.put("主/副驾驶座安全气囊", "主副驾驶座安全气囊");
		Key_Map.put("排量(mL)", "排量");
		Key_Map.put("每缸气门数(个)", "每缸气门数");
		Key_Map.put("长度(mm)", "长度");
		Key_Map.put("整备质量(kg)", "整备质量");
		Key_Map.put("座位数(个)", "座位数");
	}
}
enum Mapper{
	级别("getText","level"),
	变速箱类型("getText","gearbox_type"),
	座位数("getText","seat_count"),
	驱动方式("getText","driver_type"),
	主副驾驶座安全气囊("getMSafe","major_cab_airbag"),
	空调控制方式("getOper","aircon_control_type"),
	排量("getText","engine_capacity"),
	进气形式("getText","engine_air_intake_mode"),
	气缸排列形式("getText","engine_arrangement"),
	每缸气门数("getText","engine_valve_num"),
	长度("getText","length"),
	整备质量("getText","weight");
	
	public String name;
	public String method;
	private Mapper(String method,String name){
		this.name = name;
		this.method = method;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class FieldMapper{
	static String getText(String value){
		return value;
	}
	static String getSeatCount(String value){
		return  Main.exeREG(CarDetailParse.SEAT_COUNT, value, 1);
	}
	static String getMSafe(String value){
		String str = String.format("'%s',minor_cab_airbag='%s'", Main.matchCount(CarDetailParse.MATCH_COUNT, value,"●")>0?"是":"否",Main.matchCount(CarDetailParse.MATCH_COUNT, value,"●")>1?"是":"否");
		return  str;
	}
	static String getOper(String value){
		return Main.matchCount(CarDetailParse.MATCH_COUNT, value,"自动")>0?"\"自动\"":"\"手动\"";
	}
}