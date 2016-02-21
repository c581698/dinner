package com.hd.grab.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

public class Main {

	final static String BRAND_ROOT_URL = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=1";
	final static String SERIOUS_URL = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=3&value=";
	final static String TYPE_URL = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=5&value=";
	final static String CONTENT_ENCODING = "UTF-8";
	final static String DOWNLOAD_PATH = "/img/";
	static CloseableHttpClient httpclient;
	static ContentType CT;
	static List<Series> All_Series = new ArrayList<Series>();
	static Logger LOG;

	public static void main(String[] args) throws ClientProtocolException, IOException {
		try {
			initHttp();

			// buildBrand();

			// BrandImgParse.parse("brand_img.sql",DOWNLOAD_PATH);

			String typeId = "[{'id':1001473},{'id':1001474},{'id':1001475},{'id':1001476},{'id':1001477},{'id':1001481},{'id':1001485},{'id':1001511},{'id':1001512},{'id':1001513},{'id':1001514},{'id':1001515},{'id':1001516},{'id':1001517},{'id':1001518},{'id':1001519},{'id':1001521},{'id':1001522},{'id':1001523},{'id':1001524},{'id':1001525},{'id':1001526},{'id':1001529},{'id':1001530},{'id':1001531},{'id':1001532},{'id':1001533},{'id':1001534},{'id':1001535},{'id':1001536},{'id':1001537},{'id':1001539},{'id':1001541},{'id':1001542},{'id':1001543},{'id':1001544},{'id':1001545},{'id':1001546},{'id':1001547},{'id':1001548},{'id':1001549},{'id':1001550},{'id':1001592},{'id':1001593},{'id':1001594},{'id':1001595},{'id':1001596},{'id':1001597},{'id':1001598},{'id':1001599},{'id':1001600},{'id':1001601},{'id':1001602},{'id':1001603},{'id':1001604},{'id':1001605},{'id':1001607},{'id':1001608},{'id':1001610},{'id':1001616},{'id':1001617},{'id':1001619},{'id':1001621},{'id':1001623},{'id':1001624},{'id':1001625},{'id':1001628},{'id':1001629},{'id':1001630},{'id':1001631},{'id':1001632},{'id':1001635},{'id':1001639},{'id':1001640},{'id':1001641},{'id':1001643},{'id':1001644},{'id':1001645},{'id':1001646},{'id':1001647},{'id':1001648},{'id':1001649},{'id':1001650},{'id':1001651},{'id':1001652},{'id':1001655},{'id':1001656},{'id':1001657},{'id':1001658},{'id':1001659},{'id':1001660},{'id':1001661},{'id':1001662},{'id':1001663},{'id':1001664},{'id':1001665},{'id':1001666},{'id':1001667},{'id':1001668},{'id':1001669},{'id':1001670},{'id':1001671},{'id':1001672},{'id':1001673},{'id':1001674},{'id':1001675},{'id':1001676},{'id':1001677},{'id':1001678},{'id':1001679},{'id':1001685},{'id':1001686},{'id':1001687},{'id':1001688},{'id':1001689},{'id':1001690},{'id':1001691},{'id':1001692},{'id':1001693},{'id':1001694},{'id':1001697},{'id':1001704},{'id':1001705},{'id':1001706},{'id':1001707},{'id':1001708},{'id':1001709},{'id':1001716},{'id':1001718},{'id':1001720},{'id':1001721},{'id':1001722},{'id':1001723},{'id':1001724},{'id':1001725},{'id':1001727},{'id':1001728},{'id':1001729},{'id':1001730},{'id':1001731},{'id':1001732},{'id':1001733},{'id':1001734},{'id':1001735},{'id':1001736},{'id':1001737},{'id':1001738},{'id':1001739},{'id':1001740},{'id':1001741},{'id':1001742},{'id':1001743},{'id':1001750},{'id':1001751},{'id':1001752},{'id':1001753},{'id':1001754},{'id':1001755},{'id':1001756},{'id':1001757},{'id':1001758},{'id':1001760},{'id':1001761},{'id':1001762},{'id':1001763},{'id':1001764},{'id':1001765},{'id':1001766},{'id':1001767},{'id':1001768},{'id':1001769},{'id':1001770},{'id':1001771},{'id':1001772},{'id':1001773},{'id':1001774},{'id':1001775},{'id':1001776},{'id':1001777},{'id':1001778},{'id':1001779},{'id':1001780},{'id':1001781},{'id':1001782},{'id':1001783},{'id':1001784},{'id':1001785},{'id':1001786},{'id':1001787},{'id':1001788},{'id':1001789},{'id':1001790},{'id':1001791},{'id':1001792},{'id':1001794},{'id':1001795},{'id':1001796},{'id':1001798},{'id':1001800},{'id':1001802},{'id':1001805},{'id':1001813},{'id':1001814},{'id':1001815},{'id':1001816},{'id':1001817},{'id':1001818},{'id':1001819},{'id':1001820},{'id':1001821},{'id':1001824},{'id':1001825},{'id':1001826},{'id':1001827},{'id':1001828},{'id':1001829},{'id':1001830},{'id':1001831},{'id':1001832},{'id':1001833},{'id':1001834},{'id':1001835},{'id':1001836},{'id':1001837},{'id':1001838},{'id':1001839},{'id':1001840},{'id':1001841},{'id':1001842},{'id':1001848},{'id':1001849},{'id':1001851},{'id':1001852},{'id':1001854},{'id':1001855},{'id':1001857},{'id':1001858},{'id':1001860},{'id':1001861},{'id':1001862},{'id':1001863},{'id':1001864},{'id':1001865},{'id':1001866},{'id':1001868},{'id':1001870},{'id':1001871},{'id':1001872},{'id':1001873},{'id':1001874},{'id':1001875},{'id':1001876},{'id':1001877},{'id':1001878},{'id':1001879},{'id':1001880},{'id':1001881},{'id':1001882},{'id':1001883},{'id':1001884},{'id':1001885},{'id':1001886},{'id':1001887},{'id':1001888},{'id':1001889},{'id':1001893},{'id':1001896},{'id':1001897},{'id':1001898},{'id':1001899},{'id':1001900},{'id':1001902},{'id':1001903},{'id':1001904},{'id':1001905},{'id':1001906},{'id':1001907},{'id':1001908},{'id':1001909},{'id':1001910},{'id':1001911},{'id':1001912},{'id':1001913},{'id':1001914},{'id':1001921},{'id':1001922},{'id':1001923},{'id':1001932},{'id':1001933},{'id':1001934},{'id':1001935},{'id':1001936},{'id':1001937},{'id':1001938},{'id':1001939},{'id':1001940},{'id':1001941},{'id':1001942},{'id':1001943},{'id':1001944},{'id':1001945},{'id':1001946},{'id':1001947},{'id':1001951},{'id':1001952},{'id':1001953},{'id':1001954},{'id':1001955},{'id':1001956},{'id':1001957},{'id':1001958},{'id':1001959},{'id':1001960},{'id':1001961},{'id':1001962},{'id':1001963},{'id':1001964},{'id':1001965},{'id':1001966},{'id':1001967},{'id':1001968},{'id':1001969},{'id':1001970},{'id':1001973},{'id':1001974},{'id':1001975},{'id':1001976},{'id':1001978},{'id':1001979},{'id':1001980},{'id':1001985},{'id':1001987},{'id':1001988},{'id':1001990},{'id':1001993},{'id':1001994},{'id':1001995},{'id':1001996},{'id':1001997},{'id':1001998},{'id':1001999},{'id':1002000},{'id':1002001},{'id':1002002},{'id':1002003},{'id':1002004},{'id':1002005},{'id':1002006},{'id':1002007},{'id':1002008},{'id':1002009},{'id':1002010},{'id':1002011},{'id':1002012},{'id':1002015},{'id':1002016},{'id':1002017},{'id':1002018},{'id':1002019},{'id':1002020},{'id':1002021},{'id':1002022},{'id':1002023},{'id':1002024},{'id':1002025},{'id':1002026},{'id':1002027},{'id':1002028},{'id':1002029},{'id':1002030},{'id':1002035},{'id':1002036},{'id':1002037},{'id':1002038},{'id':1002039},{'id':1002040},{'id':1002041},{'id':1002042},{'id':1002043},{'id':1002044},{'id':1002045},{'id':1002046},{'id':1002047},{'id':1002048},{'id':1002049},{'id':1002050},{'id':1002051},{'id':1002052},{'id':1002057},{'id':1002058},{'id':1002059},{'id':1002060},{'id':1002061},{'id':1002062},{'id':1002063},{'id':1002064},{'id':1002065},{'id':1002066},{'id':1002067},{'id':1002068},{'id':1002069},{'id':1002070},{'id':1002071},{'id':1002072},{'id':1002073},{'id':1002074},{'id':1002077},{'id':1002078},{'id':1002079},{'id':1002080},{'id':1002081},{'id':1002084},{'id':1002085},{'id':1002086},{'id':1002087},{'id':1002088},{'id':1002089},{'id':1002090},{'id':1002091},{'id':1002092},{'id':1002093},{'id':1002094},{'id':1002095},{'id':1002096},{'id':1002097},{'id':1002098},{'id':1002099},{'id':1002100},{'id':1002101},{'id':1002102},{'id':1002103},{'id':1002104},{'id':1002105},{'id':1002106},{'id':1002107},{'id':1002112},{'id':1002130},{'id':1002136},{'id':1002152},{'id':1002153},{'id':1002154},{'id':1002155},{'id':1002156},{'id':1002157},{'id':1002158},{'id':1002159},{'id':1002160},{'id':1002162},{'id':1002164},{'id':1002166},{'id':1002167},{'id':1002168},{'id':1002169},{'id':1002170},{'id':1002173},{'id':1002174},{'id':1002175},{'id':1002176},{'id':1002178},{'id':1002179},{'id':1002182},{'id':1002183},{'id':1002184},{'id':1002185},{'id':1002186},{'id':1002187},{'id':1002188},{'id':1002189},{'id':1002190},{'id':1002191},{'id':1002192},{'id':1002193},{'id':1002194},{'id':1002195},{'id':1002197},{'id':1002198},{'id':1002199},{'id':1002200},{'id':1002201},{'id':1002206},{'id':1002209},{'id':1002210},{'id':1002211},{'id':1002212},{'id':1002213},{'id':1002214},{'id':1002215},{'id':1002222},{'id':1002224},{'id':1002225},{'id':1002234},{'id':1002235},{'id':1002251},{'id':1002263},{'id':1002305},{'id':1002306},{'id':1002308},{'id':1002309},{'id':1002327},{'id':1002341},{'id':1002342},{'id':1002343},{'id':1002344},{'id':1002345},{'id':1002346},{'id':1002347},{'id':1002348},{'id':1002349},{'id':1002350},{'id':1002351},{'id':1002352},{'id':1002353},{'id':1002354},{'id':1002355},{'id':1002356},{'id':1002357},{'id':1002358},{'id':1002359},{'id':1002360},{'id':1002361},{'id':1002362},{'id':1002363},{'id':1002365},{'id':1002366},{'id':1002367},{'id':1002368},{'id':1002369},{'id':1002377},{'id':1002378},{'id':1002379},{'id':1002380},{'id':1002381},{'id':1002382},{'id':1002383},{'id':1002384},{'id':1002385},{'id':1002386},{'id':1002388},{'id':1002389},{'id':1002390},{'id':1002391},{'id':1002392},{'id':1002393},{'id':1002394},{'id':1002395},{'id':1002396},{'id':1002397},{'id':1002398},{'id':1002399},{'id':1002400},{'id':1002401},{'id':1002402},{'id':1002403},{'id':1002404},{'id':1002405},{'id':1002406},{'id':1002407},{'id':1002408},{'id':1002409},{'id':1002410},{'id':1002411},{'id':1002412},{'id':1002413},{'id':1002414},{'id':1002415},{'id':1002416},{'id':1002417},{'id':1002418},{'id':1002419},{'id':1002420},{'id':1002421},{'id':1002422},{'id':1002423},{'id':1002424},{'id':1002425},{'id':1002426},{'id':1002428},{'id':1002429},{'id':1002430},{'id':1002431},{'id':1002432},{'id':1002433},{'id':1002434},{'id':1002435},{'id':1002440},{'id':1002441},{'id':1002442},{'id':1002443},{'id':1002444},{'id':1002445},{'id':1002446},{'id':1002447},{'id':1002448},{'id':1002449},{'id':1002450},{'id':1002451},{'id':1002452},{'id':1002453},{'id':1002454},{'id':1002455},{'id':1002456},{'id':1002457},{'id':1002458},{'id':1002459},{'id':1002460},{'id':1002463},{'id':1002464},{'id':1002465},{'id':1002466},{'id':1002467},{'id':1002472},{'id':1002473},{'id':1002474},{'id':1002475},{'id':1002476},{'id':1002477},{'id':1002479},{'id':1002480},{'id':1002481},{'id':1002482},{'id':1002483},{'id':1002484},{'id':1002485},{'id':1002486},{'id':1002488},{'id':1002489},{'id':1002491},{'id':1002492},{'id':1002494},{'id':1002497},{'id':1002498},{'id':1002499},{'id':1002500},{'id':1002501},{'id':1002506},{'id':1002507},{'id':1002508},{'id':1002509},{'id':1002510},{'id':1002513},{'id':1002514},{'id':1002515},{'id':1002516},{'id':1002517},{'id':1002518},{'id':1002519},{'id':1002520},{'id':1002521},{'id':1002522},{'id':1002523},{'id':1002524},{'id':1002525},{'id':1002526},{'id':1002527},{'id':1002528},{'id':1002529},{'id':1002530},{'id':1002531},{'id':1002532},{'id':1002533},{'id':1002534},{'id':1002535},{'id':1002536},{'id':1002537},{'id':1002538},{'id':1002539},{'id':1002540},{'id':1002541},{'id':1002542},{'id':1002543},{'id':1002544},{'id':1002545},{'id':1002546},{'id':1002547},{'id':1002548},{'id':1002549},{'id':1002550},{'id':1002551},{'id':1002552},{'id':1002553},{'id':1002554},{'id':1002555},{'id':1002556},{'id':1002557},{'id':1002558},{'id':1002559},{'id':1002560},{'id':1002561},{'id':1002562},{'id':1002563},{'id':1002564},{'id':1002565},{'id':1002566},{'id':1002567},{'id':1002568},{'id':1002569},{'id':1002570},{'id':1002571},{'id':1002572},{'id':1002573},{'id':1002574},{'id':1002575},{'id':1002576},{'id':1002577},{'id':1002578},{'id':1002579},{'id':1002580},{'id':1002581},{'id':1002582},{'id':1002583},{'id':1002584},{'id':1002585},{'id':1002586},{'id':1002589},{'id':1002590},{'id':1002591},{'id':1002592},{'id':1002593},{'id':1002594},{'id':1002597},{'id':1002598},{'id':1002599},{'id':1002600},{'id':1002603},{'id':1002604},{'id':1002605},{'id':1002606},{'id':1002607},{'id':1002609},{'id':1002610},{'id':1002611},{'id':1002612},{'id':1002613},{'id':1002614},{'id':1002615},{'id':1002616},{'id':1002617},{'id':1002618},{'id':1002619},{'id':1002620},{'id':1002621},{'id':1002622},{'id':1002623},{'id':1002624},{'id':1002625},{'id':1002626},{'id':1002627},{'id':1002628},{'id':1002629},{'id':1002630},{'id':1002632},{'id':1002638},{'id':1002639},{'id':1002640},{'id':1002641},{'id':1002643},{'id':1002644},{'id':1002645},{'id':1002646},{'id':1002648},{'id':1002649},{'id':1002651},{'id':1002652},{'id':1002653},{'id':1002654},{'id':1002655},{'id':1002656},{'id':1002657},{'id':1002658},{'id':1002659},{'id':1002663},{'id':1002665},{'id':1002666},{'id':1002667},{'id':1002668},{'id':1002669},{'id':1002670},{'id':1002671},{'id':1002672},{'id':1002673},{'id':1002674},{'id':1002675},{'id':1002676},{'id':1002677},{'id':1002678},{'id':1002679},{'id':1002680},{'id':1002681},{'id':1002682},{'id':1002683},{'id':1002685},{'id':1002688},{'id':1002690},{'id':1002691},{'id':1002696},{'id':1002697},{'id':1002698},{'id':1002700},{'id':1002701},{'id':1002702},{'id':1002703},{'id':1002704},{'id':1002707},{'id':1002708},{'id':1002709},{'id':1002710},{'id':1002711},{'id':1002712},{'id':1002713},{'id':1002714},{'id':1002716},{'id':1002717},{'id':1002719},{'id':1002720},{'id':1002722},{'id':1002723},{'id':1002724},{'id':1002725},{'id':1002726},{'id':1002727},{'id':1002728},{'id':1002729},{'id':1002731},{'id':1002732},{'id':1002733},{'id':1002734},{'id':1002735},{'id':1002736},{'id':1002737},{'id':1002743},{'id':1002744},{'id':1002745},{'id':1002746},{'id':1002749},{'id':1002750},{'id':1002752},{'id':1002753},{'id':1002754},{'id':1002756},{'id':1002757},{'id':1002758},{'id':1002759},{'id':1002760},{'id':1002761},{'id':1002762},{'id':1002763},{'id':1002764},{'id':1002765},{'id':1002766},{'id':1002767},{'id':1002768},{'id':1002769},{'id':1002770},{'id':1002772},{'id':1002773},{'id':1002785},{'id':1002798},{'id':1002799},{'id':1002800},{'id':1002801},{'id':1002802},{'id':1002804},{'id':1002805},{'id':1002806},{'id':1002807},{'id':1002808},{'id':1002809},{'id':1002811},{'id':1002812},{'id':1002813},{'id':1002814},{'id':1002815},{'id':1002816},{'id':1002817},{'id':1002818},{'id':1002819},{'id':1002820},{'id':1002821},{'id':1002822},{'id':1002823},{'id':1002824},{'id':1002825},{'id':1002829},{'id':1002830},{'id':1002831},{'id':1002832},{'id':1002833},{'id':1002840},{'id':1002841},{'id':1002842},{'id':1002843},{'id':1002844},{'id':1002845},{'id':1002846},{'id':1002847},{'id':1002848},{'id':1002849},{'id':1002850},{'id':1002851},{'id':1002853},{'id':1002854},{'id':1002855},{'id':1002856},{'id':1002860},{'id':1002861},{'id':1002867},{'id':1002868},{'id':1002869},{'id':1002870},{'id':1002871},{'id':1002872},{'id':1002873},{'id':1002874},{'id':1002875},{'id':1002876},{'id':1002877},{'id':1002878},{'id':1002879},{'id':1002882},{'id':1002884},{'id':1002885},{'id':1002886},{'id':1002887},{'id':1002888},{'id':1002889},{'id':1002890},{'id':1002891},{'id':1002892},{'id':1002893},{'id':1002894},{'id':1002895},{'id':1002896},{'id':1002897},{'id':1002898},{'id':1002899},{'id':1002900},{'id':1002901},{'id':1002902},{'id':1002904},{'id':1002905},{'id':1002907},{'id':1002909},{'id':1002910},{'id':1002916},{'id':1002917},{'id':1002918},{'id':1002919},{'id':1002920},{'id':1002921},{'id':1002922},{'id':1002923},{'id':1002924},{'id':1002925},{'id':1002926},{'id':1002927},{'id':1002928},{'id':1002929},{'id':1002930},{'id':1002931},{'id':1002932},{'id':1002933},{'id':1002934},{'id':1002935},{'id':1002936},{'id':1002937},{'id':1002938},{'id':1002939},{'id':1002940},{'id':1002941},{'id':1002942},{'id':1002943},{'id':1002944},{'id':1002945},{'id':1002946},{'id':1002948},{'id':1002949},{'id':1002951},{'id':1002955},{'id':1002956},{'id':1002957},{'id':1002958},{'id':1002959},{'id':1002972},{'id':1002973},{'id':1002974},{'id':1002975},{'id':1002976},{'id':1002977},{'id':1002978},{'id':1002979},{'id':1002980},{'id':1002981},{'id':1002984},{'id':1002985},{'id':1002986},{'id':1002987},{'id':1002988},{'id':1002989},{'id':1002990},{'id':1002991},{'id':1002992},{'id':1002993},{'id':1002994},{'id':1002995},{'id':1002996},{'id':1002997},{'id':1002998},{'id':1002999},{'id':1003000},{'id':1003001},{'id':1003039},{'id':1003040},{'id':1003041},{'id':1003042},{'id':1003043},{'id':1003044},{'id':1003045},{'id':1003046},{'id':1003047},{'id':1003048},{'id':1003049},{'id':1003050},{'id':1003051},{'id':1003052},{'id':1003053},{'id':1003054},{'id':1003055},{'id':1003056},{'id':1003057},{'id':1003058},{'id':1003062},{'id':1003063},{'id':1003064},{'id':1003065},{'id':1003066},{'id':1003067},{'id':1003068},{'id':1003070},{'id':1003071},{'id':1003072},{'id':1003073},{'id':1003074},{'id':1003075},{'id':1003076},{'id':1003077},{'id':1003078},{'id':1003079},{'id':1003080},{'id':1003081},{'id':1003082},{'id':1003083},{'id':1003084},{'id':1003089},{'id':1003090},{'id':1003091},{'id':1003092},{'id':1003093},{'id':1003094},{'id':1003095},{'id':1003096},{'id':1003097},{'id':1003098},{'id':1003099},{'id':1003100},{'id':1003101},{'id':1003102},{'id':1003103},{'id':1003104},{'id':1003105},{'id':1003106},{'id':1003107},{'id':1003108},{'id':1003109},{'id':1003110},{'id':1003111},{'id':1003112},{'id':1003113},{'id':1003114},{'id':1003115},{'id':1003116},{'id':1003117},{'id':1003118},{'id':1003119},{'id':1003120},{'id':1003121},{'id':1003122},{'id':1003123},{'id':1003124},{'id':1003125},{'id':1003126},{'id':1003127},{'id':1003128},{'id':1003129},{'id':1003130},{'id':1003131},{'id':1003132},{'id':1003134},{'id':1003135},{'id':1003136},{'id':1003137},{'id':1003138},{'id':1003139},{'id':1003140},{'id':1003141},{'id':1003142},{'id':1003143},{'id':1003144},{'id':1003145},{'id':1003146},{'id':1003147},{'id':1003148},{'id':1003149},{'id':1003151},{'id':1003152},{'id':1003153},{'id':1003154},{'id':1003155},{'id':1003156},{'id':1003157},{'id':1003158},{'id':1003159},{'id':1003160},{'id':1003161},{'id':1003162},{'id':1003163},{'id':1003164},{'id':1003165},{'id':1003170},{'id':1003171},{'id':1003172},{'id':1003173},{'id':1003174},{'id':1003175},{'id':1003176},{'id':1003177},{'id':1003178},{'id':1003179},{'id':1003180},{'id':1003181},{'id':1003182},{'id':1003183},{'id':1003184},{'id':1003185},{'id':1003191},{'id':1003192},{'id':1003193},{'id':1003201},{'id':1003202},{'id':1003203},{'id':1003204},{'id':1003205},{'id':1003209},{'id':1003210},{'id':1003211},{'id':1003212},{'id':1003214},{'id':1003215},{'id':1003216},{'id':1003217},{'id':1003218},{'id':1003219},{'id':1003220},{'id':1003221},{'id':1003222},{'id':1003223},{'id':1003224},{'id':1003225},{'id':1003226},{'id':1003227},{'id':1003228},{'id':1003229},{'id':1003230},{'id':1003231},{'id':1003232},{'id':1003233},{'id':1003234},{'id':1003235},{'id':1003236},{'id':1003237},{'id':1003238},{'id':1003239},{'id':1003240},{'id':1003241},{'id':1003242},{'id':1003243},{'id':1003244},{'id':1003245},{'id':1003246},{'id':1003247},{'id':1003248},{'id':1003249},{'id':1003250},{'id':1003251},{'id':1003252},{'id':1003253},{'id':1003255},{'id':1003256},{'id':1003257},{'id':1003258},{'id':1003259},{'id':1003260},{'id':1003261},{'id':1003262},{'id':1003263},{'id':1003264},{'id':1003267},{'id':1003268},{'id':1003269},{'id':1003270},{'id':1003271},{'id':1003272},{'id':1003273},{'id':1003274},{'id':1003275},{'id':1003278},{'id':1003279},{'id':1003280},{'id':1003281},{'id':1003282},{'id':1003283},{'id':1003284},{'id':1003285},{'id':1003286},{'id':1003287},{'id':1003288},{'id':1003289},{'id':1003290},{'id':1003291},{'id':1003292},{'id':1003293},{'id':1003294},{'id':1003295},{'id':1003296},{'id':1003297},{'id':1003298},{'id':1003299},{'id':1003300},{'id':1003301},{'id':1003302},{'id':1003303},{'id':1003304},{'id':1003305},{'id':1003306},{'id':1003307},{'id':1003308},{'id':1003309},{'id':1003310},{'id':1003311},{'id':1003312},{'id':1003313},{'id':1003314},{'id':1003315},{'id':1003316},{'id':1003317},{'id':1003318},{'id':1003319},{'id':1003320},{'id':1003321},{'id':1003322},{'id':1003323},{'id':1003324},{'id':1003325},{'id':1003328},{'id':1003331},{'id':1003332},{'id':1003333},{'id':1003334},{'id':1003335},{'id':1003336},{'id':1003337},{'id':1003338},{'id':1003339},{'id':1003340},{'id':1003341},{'id':1003342},{'id':1003343},{'id':1003346},{'id':1003347},{'id':1003348},{'id':1003351},{'id':1003352},{'id':1003354},{'id':1003355},{'id':1003356},{'id':1003357},{'id':1003358},{'id':1003359},{'id':1003360},{'id':1003361},{'id':1003362},{'id':1003363},{'id':1003364},{'id':1003365},{'id':1003366},{'id':1003367},{'id':1003368},{'id':1003369},{'id':1003374},{'id':1003375},{'id':1003377},{'id':1003378},{'id':1003379},{'id':1003380},{'id':1003381},{'id':1003382},{'id':1003383},{'id':1003384},{'id':1003385},{'id':1003386},{'id':1003387},{'id':1003388},{'id':1003389},{'id':1003390},{'id':1003391},{'id':1003392},{'id':1003393},{'id':1003394},{'id':1003395},{'id':1003396},{'id':1003397},{'id':1003398},{'id':1003399},{'id':1003400},{'id':1003401},{'id':1003402},{'id':1003403},{'id':1003404},{'id':1003405},{'id':1003406},{'id':1003407},{'id':1003408},{'id':1003409},{'id':1003410},{'id':1003411},{'id':1003412},{'id':1003413},{'id':1003414},{'id':1003415},{'id':1003416},{'id':1003417},{'id':1003418},{'id':1003419},{'id':1003420},{'id':1003421},{'id':1003422},{'id':1003423},{'id':1003424},{'id':1003425},{'id':1003426},{'id':1003427},{'id':1003428},{'id':1003429},{'id':1003431},{'id':1003432},{'id':1003433},{'id':1003434},{'id':1003435},{'id':1003436},{'id':1003437},{'id':1003438},{'id':1003439},{'id':1003440},{'id':1003441},{'id':1003442},{'id':1003443},{'id':1003444},{'id':1003445},{'id':1003446},{'id':1003447},{'id':1003448},{'id':1003449},{'id':1003450},{'id':1003451},{'id':1003452},{'id':1003453},{'id':1003454},{'id':1003455},{'id':1003456},{'id':1003457},{'id':1003458},{'id':1003459},{'id':1003460},{'id':1003461},{'id':1003462},{'id':1003463},{'id':1003464},{'id':1003465},{'id':1003466},{'id':1003467},{'id':1003468},{'id':1003469},{'id':1003471},{'id':1003472},{'id':1003473},{'id':1003474},{'id':1003475},{'id':1003476},{'id':1003477},{'id':1003478},{'id':1003479},{'id':1003480},{'id':1003481},{'id':1003482},{'id':1003483},{'id':1003484},{'id':1003485},{'id':1003486},{'id':1003487},{'id':1003488},{'id':1003489},{'id':1003490},{'id':1003491},{'id':1003492},{'id':1003493},{'id':1003494},{'id':1003495},{'id':1003496},{'id':1003497},{'id':1003498},{'id':1003499},{'id':1003500},{'id':1003501},{'id':1003502},{'id':1003503},{'id':1003504},{'id':1003505},{'id':1003506},{'id':1003507},{'id':1003508},{'id':1003509},{'id':1003510},{'id':1003511},{'id':1003512},{'id':1003513},{'id':1003514},{'id':1003515},{'id':1003516},{'id':1003517},{'id':1003518},{'id':1003519},{'id':1003520},{'id':1003521},{'id':1003522},{'id':1003523},{'id':1003524},{'id':1003525},{'id':1003526},{'id':1003527},{'id':1003528},{'id':1003529},{'id':1003530},{'id':1003531},{'id':1003532},{'id':1003533},{'id':1003534},{'id':1003535},{'id':1003536},{'id':1003537},{'id':1003538},{'id':1003539},{'id':1003540},{'id':1003541},{'id':1003542},{'id':1003543},{'id':1003548},{'id':1003549},{'id':1003550},{'id':1003551},{'id':1003552},{'id':1003553},{'id':1003557},{'id':1003559},{'id':1003560},{'id':1003561},{'id':1003562},{'id':1003563},{'id':1003564},{'id':1003566},{'id':1003567},{'id':1003568},{'id':1003569},{'id':1003570},{'id':1003571},{'id':1003572},{'id':1003573},{'id':1003574},{'id':1003575},{'id':1003576},{'id':1003577},{'id':1003578},{'id':1003579},{'id':1003580},{'id':1003581},{'id':1003582},{'id':1003583},{'id':1003584},{'id':1003585},{'id':1003586},{'id':1003588},{'id':1003589},{'id':1003590},{'id':1003591},{'id':1003592},{'id':1003593},{'id':1003594},{'id':1003595},{'id':1003596},{'id':1003597},{'id':1003598},{'id':1003599},{'id':1003601},{'id':1003602},{'id':1003603},{'id':1003604},{'id':1003605},{'id':1003606},{'id':1003607},{'id':1003608},{'id':1003609},{'id':1003610},{'id':1003611},{'id':1003612},{'id':1003613},{'id':1003614},{'id':1003615},{'id':1003616},{'id':1003617},{'id':1003618},{'id':1003619},{'id':1003620},{'id':1003621},{'id':1003622},{'id':1003623},{'id':1003624},{'id':1003625},{'id':1003626},{'id':1003627},{'id':1003628},{'id':1003629},{'id':1003631},{'id':1003632},{'id':1003633},{'id':1003634},{'id':1003635},{'id':1003636},{'id':1003637},{'id':1003638},{'id':1003639},{'id':1003640},{'id':1003641},{'id':1003642},{'id':1003643},{'id':1003644},{'id':1003645},{'id':1003646},{'id':1003647},{'id':1003648},{'id':1003649},{'id':1003650},{'id':1003651},{'id':1003652},{'id':1003653},{'id':1003654},{'id':1003655},{'id':1003656},{'id':1003657},{'id':1003658},{'id':1003659},{'id':1003660},{'id':1003661},{'id':1003662},{'id':1003663},{'id':1003664},{'id':1003665},{'id':1003666},{'id':1003667},{'id':1003668},{'id':1003669},{'id':1003670},{'id':1003671},{'id':1003672},{'id':1003673},{'id':1003674},{'id':1003675},{'id':1003676},{'id':1003677},{'id':1003678},{'id':1003679},{'id':1003680},{'id':1003681},{'id':1003682},{'id':1003683},{'id':1003684},{'id':1003685},{'id':1003686},{'id':1003687},{'id':1003688},{'id':1003689},{'id':1003690},{'id':1003691},{'id':1003692},{'id':1003693},{'id':1003694},{'id':1003695},{'id':1003696},{'id':1003697},{'id':1003698},{'id':1003699},{'id':1003700},{'id':1003701},{'id':1003702},{'id':1003703},{'id':1003704},{'id':1003705},{'id':1003706},{'id':1003707},{'id':1003708},{'id':1003709},{'id':1003710},{'id':1003711},{'id':1003712},{'id':1003713},{'id':1003714},{'id':1003715},{'id':1003716},{'id':1003717},{'id':1003718},{'id':1003719},{'id':1003720},{'id':1003721},{'id':1003722},{'id':1003723},{'id':1003724},{'id':1003725},{'id':1003726},{'id':1003727},{'id':1003728},{'id':1003729},{'id':1003730},{'id':1003731},{'id':1003732},{'id':1003733},{'id':1003734},{'id':1003735},{'id':1003736},{'id':1003737},{'id':1003738},{'id':1003739},{'id':1003740},{'id':1003744},{'id':1003745},{'id':1003749},{'id':1003750},{'id':1003751},{'id':1003752},{'id':1003753},{'id':1003754},{'id':1003755},{'id':1003756},{'id':1003757},{'id':1003758},{'id':1003759},{'id':1003760},{'id':1003761},{'id':1003763},{'id':1003764},{'id':1003765},{'id':1003766},{'id':1003767},{'id':1003768},{'id':1003769},{'id':1003770},{'id':1003771},{'id':1003772},{'id':1003773},{'id':1003774},{'id':1003775},{'id':1003776},{'id':1003777},{'id':1003778},{'id':1003779},{'id':1003780},{'id':1003781},{'id':1003783},{'id':1003784},{'id':1003785},{'id':1003786},{'id':1003787},{'id':1003788},{'id':1003789},{'id':1003790},{'id':1003791},{'id':1003792},{'id':1003793},{'id':1003794},{'id':1003795},{'id':1003796},{'id':1003797},{'id':1003798},{'id':1003799},{'id':1003800},{'id':1003801},{'id':1003802},{'id':1003803},{'id':1003804},{'id':1003805},{'id':1003806},{'id':1003807},{'id':1003808},{'id':1003809},{'id':1003812},{'id':1003813},{'id':1003814},{'id':1003815},{'id':1003816},{'id':1003817},{'id':1003830},{'id':1003831},{'id':1003832},{'id':1003833},{'id':1003834},{'id':1003835},{'id':1003836},{'id':1003837},{'id':1003838},{'id':1003839},{'id':1003840},{'id':1003841},{'id':1003842},{'id':1003843},{'id':1003844},{'id':1003845},{'id':1003846},{'id':1003847},{'id':1003848},{'id':1003849},{'id':1003850},{'id':1003851},{'id':1003852},{'id':1003853},{'id':1003854},{'id':1003855},{'id':1003856},{'id':1003857},{'id':1003858},{'id':1003859},{'id':1003860},{'id':1003861},{'id':1003862},{'id':1003863},{'id':1003864},{'id':1003865},{'id':1003866},{'id':1003867},{'id':1003868},{'id':1003869},{'id':1003870},{'id':1003871},{'id':1003872},{'id':1003873},{'id':1003874},{'id':1003875},{'id':1003876},{'id':1003877},{'id':1003878},{'id':1003879},{'id':1003880},{'id':1003881},{'id':1003882},{'id':1003883},{'id':1003884},{'id':1003885},{'id':1003886},{'id':1003887},{'id':1003888},{'id':1003889},{'id':1003890},{'id':1003891},{'id':1003892},{'id':1003893},{'id':1003894},{'id':1003895},{'id':1003896},{'id':1003897},{'id':1003898},{'id':1003899},{'id':1003900},{'id':1003901},{'id':1003902},{'id':1003903},{'id':1003904},{'id':1003905},{'id':1003906},{'id':1003907},{'id':1003908},{'id':1003909},{'id':1003910},{'id':1003911},{'id':1003912},{'id':1003913},{'id':1003914},{'id':1003915},{'id':1003916},{'id':1003917},{'id':1003918},{'id':1003919},{'id':1003920},{'id':1003921},{'id':1003922},{'id':1003923},{'id':1003924},{'id':1003928},{'id':1003929},{'id':1003930},{'id':1003931},{'id':1003932},{'id':1003933},{'id':1003935},{'id':1003936},{'id':1003937},{'id':1003938},{'id':1003939},{'id':1003940},{'id':1003941},{'id':1003942},{'id':1003943},{'id':1003944},{'id':1003945},{'id':1003946},{'id':1003947},{'id':1003948},{'id':1003949},{'id':1003950},{'id':1003951}]";
			
			Gson gson = new GsonBuilder().create();
			Type typeOfT = new TypeToken<List<TypeID>>() {
			}.getType();
			
			List<TypeID> ids = new ArrayList<TypeID>(20500);
			
			ids=gson.fromJson(typeId, typeOfT);
			CarDetailParse.initMapper();
			
			for(int i=0;i<ids.size();i++){
				CarDetailParse.parse((i%100)==0?(i%100)+".sql":null, ids.get(i).id, i%10==0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				if (httpclient != null)
					httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static void buildCarCate(Long seriesId, Long markerId, Long brandId) throws IOException {
		String result = get(TYPE_URL + seriesId);

		if (StringUtils.isNotBlank(result)) {
			int start = result.indexOf("[{"), end = result.lastIndexOf("}]");

			if (start > -1 && end > -1) {
				result = result.substring(start, end + 2);

				LOG.info("Result CarCate List:\n\t" + result);
			}

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			Type typeOfT = new TypeToken<List<CarCate>>() {
			}.getType();

			List<CarCate> list = gson.fromJson(result, typeOfT);

			LOG.info(String.format("读取结束，共获取数据%s条！", list.size()));

			List<CarType> carTypes = new ArrayList<CarType>();

			if (!list.isEmpty()) {
				for (CarCate cc : list) {
					carTypes.addAll(cc.buildCars(brandId, markerId, seriesId));
				}
			}

			LOG.info(String.format("********---------解析结束，共获取数据%s条！seriesId=%s", carTypes.size(), seriesId));

			buildSQL(carTypes, "type.sql");
		}
	}
	static void buildMarker(Long brandId) throws IOException {
		String result = get(SERIOUS_URL + brandId);

		if (StringUtils.isNotBlank(result)) {
			int start = result.indexOf("[{"), end = result.lastIndexOf("}]");

			if (start > -1 && end > -1) {
				result = result.substring(start, end + 2);

				LOG.info("Result Marker List:\n\t" + result);
			}

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			Type typeOfT = new TypeToken<List<Maker>>() {
			}.getType();

			List<Maker> list = gson.fromJson(result, typeOfT);

			LOG.info(String.format("读取结束，共获取数据%s条！", list.size()));

			buildSQL(list, "maker.sql", brandId);
		}
	}
	static void buildBrand() throws IOException {
		initLog("Main");
		
		String result = get(BRAND_ROOT_URL);

		if (StringUtils.isNotBlank(result)) {
			int start = result.indexOf("[{"), end = result.indexOf("}]");

			if (start > -1 && end > -1) {
				result = result.substring(start, end + 2);

				LOG.info("Result Brand List:\n\t" + result);
			}

			Gson gson = new Gson();
			Type typeOfT = new TypeToken<List<Brand>>() {
			}.getType();

			List<Brand> list = gson.fromJson(result, typeOfT);

			LOG.info(String.format("读取结束，共获取数据%s条！", list.size()));

			buildSQL(list, "brand.sql");
		}
	}
	public void postForm() {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");
		// 创建参数队列
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		formparams.add(new BasicNameValuePair("username", "admin"));
		formparams.add(new BasicNameValuePair("password", "123456"));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			LOG.info("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					LOG.info("--------------------------------------");
					LOG.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					LOG.info("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param url[0]
	 * 	url[1]文件名
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String get(String... url) throws ClientProtocolException, IOException {
		// 创建httpget.
		HttpGet httpget = new HttpGet(url[0]);
		LOG.info("executing request " + httpget.getURI());
		LOG.info("-----------------------------------------");
		// 执行get请求.
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			if (isSuccess(response)) {
				// 获取响应实体
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					CT = buildContentType(response);

					if (!CT.type.startsWith("text")) {
						downloadImg(entity.getContent(), url[1]);

						return url[1];
					} else
						return EntityUtils.toString(entity);
				} else {
					LOG.info("Response Result:没有可用的数据返回");
				}
			}
		} catch (Exception e) {
			LOG.error("GET ERROR:" + Arrays.toString(url));
		} finally {
			response.close();
		}

		return null;
	}
	static void initHttp() {
		httpclient = HttpClients.createDefault();
	}
	static void initLog(String filePrefix){
		DailyRollingFileAppender appender = (DailyRollingFileAppender)Logger.getRootLogger().getAppender("RollingFile");
		appender.setFile( filePrefix+".log"); 
		appender.activateOptions();
		
		LOG = Logger.getLogger(Main.class);
	}
	static boolean isSuccess(CloseableHttpResponse response) {
		StatusLine status = response.getStatusLine();
		int code;

		if (status != null) {
			code = status.getStatusCode();

			if (code >= 200 && code < 300) {
				return true;
			}
		}
		LOG.info("Response Not Success:" + status);

		return false;
	}
	static ContentType buildContentType(CloseableHttpResponse response) {
		Header[] contentType = response.getHeaders("Content-Type");
		ContentType type = null;

		if (contentType != null && contentType.length > 0) {
			String ctStr = contentType[0].getValue();
			String[] ctArr = null;

			if (StringUtils.isNotBlank(ctStr)) {
				ctArr = ctStr.split(";");

				type = new ContentType(ctArr[0],
						ctArr.length == 1 ? CONTENT_ENCODING : ctArr[1].replace("charset=", ""));
			}
		}

		return type;
	}
	static void buildSQL(List<? extends Brand> data, String filePath, Object... obj) throws IOException {
		File file = new File(filePath);

		if (!file.exists() || (file.exists() && file.isDirectory())) {
			file.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(file, true);

		try {
			LOG.info("******------" + filePath);

			for (Brand b : data) {
				if (b.before()) {
					fos.write((b.toSql(obj) + "\n").getBytes(CT.encoding));
					LOG.info(b.getId() + ",");
					b.after(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.flush();
			fos.close();
		}
	}
	static void downloadImg(InputStream is, String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir") + DOWNLOAD_PATH + fileName);
		byte[] data = new byte[1024];

		if (file.exists() || file.isDirectory()) {
			throw new Exception();
		}

		file.createNewFile();

		FileOutputStream fos = new FileOutputStream(file);

		while (is.read(data) > 0) {
			fos.write(data);
		}

		fos.flush();
		fos.close();
		is.close();
	}
	static String exeREG(Pattern p,String str,int index){
		Matcher m = p.matcher(str);
		
        while (m.find()) {
        	return m.group(index);
        }
        
        return null;
	}
	static int matchCount(Pattern p,String str,String sub){
		Matcher m = p.matcher(str);
		int count = 0;
		
        while (m.find()) {
        	++count;
        }
        
        return count;
	}
}
class TypeID{
	int id;
}
class ContentType {
	String type;
	String encoding;

	public ContentType(String type, String encoding) {
		this.type = type;
		this.encoding = encoding;
	}
}

class CarCate extends Maker {
	@Expose
	List<CarType> specitems = new ArrayList<CarType>();
	List<Series> seriesitems;

	public List<CarType> buildCars(Long brandId, Long markerId, Long seriesId) {
		List<CarType> list = new ArrayList<CarType>();

		if (null != specitems && !specitems.isEmpty()) {
			for (CarType type : specitems) {
				type.setYear(name);
				type.setBrandId(brandId);
				type.setMarkerId(markerId);
				type.setSeriesId(seriesId);

				list.add(type);
			}
		}

		return list;
	}
}

class CarType extends Brand {
	@Expose
	BigDecimal maxprice;
	@Expose
	BigDecimal minprice;
	@Expose
	int state;
	@Expose
	String year;
	Long brandId;
	Long markerId;
	Long seriesId;

	@Override
	String getValues(Object... strings) {
		String values = super.getValues(strings);

		values += String.format(",%s,%s,'%s',%s,%s,%s", maxprice, state, year, brandId, markerId, seriesId);

		return values;
	}

	@Override
	public void after(Object... obj) {
	}

	public BigDecimal getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
	}

	public BigDecimal getMinprice() {
		return minprice;
	}

	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getMarkerId() {
		return markerId;
	}

	public void setMarkerId(Long markerId) {
		this.markerId = markerId;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public String getTemplate() {
		return "insert into car_type(id,name,price,state,market_year,brand_id,maker_id,series_id) values(%s);";
	}
}

class Maker extends Brand {
	@Expose
	List<Series> seriesitems = new ArrayList<Series>();

	@Override
	String getValues(Object... strings) {
		String values = super.getValues(strings);

		return values + "," + strings[0];
	}

	public void after(Object... obj) {
		if (null != seriesitems && !seriesitems.isEmpty()) {
			try {
				Main.buildSQL(seriesitems, "series.sql", id, obj[0]);

				Main.LOG.info("--------------------------");
				Main.LOG.info("--------------------------");
			} catch (IOException e) {
				Main.LOG.info("************---- MARKER:" + id);
				e.printStackTrace();
			}
		}
	}

	public Maker() {
	}

	public Maker(Long id, String name, List<Series> seriesitems) {
		this.id = id;
		this.name = name;
		this.seriesitems = seriesitems;
	}

	public List<Series> getSeriesitems() {
		return seriesitems;
	}

	public void setSeriesitems(List<Series> seriesitems) {
		this.seriesitems = seriesitems;
	}

	public String getTemplate() {
		return "insert into car_maker(id,name,brand_id) values(%s);";
	}
}

class Series extends Maker {
	public String getTemplate() {
		return "insert into car_series(id,name,maker_id) values(%s);";
	}

	public void after(Object... obj) {
		try {
			Main.buildCarCate(id, (Long) obj[0], (Long) obj[1]);

			Main.LOG.info("--------------------------");
			Main.LOG.info("--------------------------");
		} catch (IOException e) {
			Main.LOG.info("************---- MARKER:" + id);
			e.printStackTrace();
		}
	}
}
