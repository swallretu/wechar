package com.weichat.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.sun.jmx.snmp.EnumRowStatus;
import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import com.weichat.message.Hospital;
import com.weichat.message.user;
import com.weichat.util.JSONUtil;

public class HospitalInfoServlet extends HttpServlet {
	
	public static Map<String,Object> allHospital;//全部医院
	public static Map sanJHospital;//三甲医院
//	
//	private static Log log = LogFactory.getLog(testservlet.class);
	public static Map hospitalLevelMap;
    
	public void init() throws ServletException {
		System.out.println("testServlet init...");
		super.init();
		List<Hospital> hospitals = createHospitalList();
		hospitalLevelMap = initHospitalLevel("hospitalLevel.properties",hospitalLevelMap);
		
		if(null == allHospital){
			
			System.out.println("allHospital == null 初始化allHospital map");
			allHospital = new HashMap<String,Object>();
			allHospital.put("allHospital", hospitals);
		}else if(allHospital.size() == 0){
			System.out.println("allHospital.size() == 0 初始化allHospital map");
			allHospital.put("allHospital", hospitals);
		}
		System.out.println(hospitalLevelMap);	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 通过Enumeration遍历request的Head信息
		Enumeration<String> enumes = request.getHeaderNames();
		while(enumes.hasMoreElements()){
			String key = enumes.nextElement();
			System.out.println("+++++++++++++++++");
			System.out.println(key+","+request.getHeader(key));
		}*/
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("come in post");
//		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域问题
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String level = request.getParameter("level");
		
		List<Hospital> list = null;
		if(null == allHospital){
			
			list = createHospitalList();//初始化所有医院信息
			System.out.println("list from request to get Process");
			allHospital.put("allHospital", list);//再将list加入到缓存中
		}else if(allHospital.size() == 0){
			
			list = createHospitalList();//初始化所有医院信息
			System.out.println("list from request to get Process");
			allHospital.put("allHospital", list);//再将list加入到缓存中
		}
		else{
			list = (List<Hospital>) allHospital.get("allHospital");
			System.out.println("list from memory");
		}
		
		String jsonMsg ="";
		if("".equals(level) || null == level){
			
			jsonMsg = getHosptialInfo(list);
			System.out.println(jsonMsg);
			
		}else{
			System.out.println("全部医院："+list.size());
			list = findHosptialsByLevel("0",list);
			System.out.println(hospitalLevelMap.get(level)+"："+list.size());
			
			jsonMsg =getHosptialInfo(list) ;
			System.out.println(jsonMsg);
		}
		out.write(jsonMsg);
		out.flush();
		out.close();
	}
	
	/**
	 * <pre>
	 * 任务： 
	 * 描述：根据医院等级查询医院
	 * 作者：屈剑飞
	 * 时间：2015年1月22日下午4:46:40
	 * @param hospitalLevel 
	 * @return
	 * returnType：Map
	 * </pre>
	*/
	public static List<Hospital> findHosptialsByLevel(String hospitalLevel,List<Hospital> list){
		if(null == hospitalLevel || "".equals(hospitalLevel)){
			return list;
		}
		List<Hospital> levelList = new ArrayList<Hospital>();
		for (Hospital hop : list) {
			if(hospitalLevel.equals(hop.getHospitalLevel())){
				levelList.add(hop);
			}
		}
		return levelList;
	}
	
	
	/**
	 * <pre>
	 * 任务： 
	 * 描述：初始化医院信息 
	 * 作者：屈剑飞
	 * 时间：2015年1月22日下午5:02:21
	 * @return
	 * returnType：List
	 * </pre>
	*/
	public static List<Hospital> createHospitalList(){
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		Hospital hosp1 = new Hospital(1650,246,"湖南省人民医院","体验街20号",108.88207002847,34.213420427771,"0");
		Hospital hosp2 = new Hospital(1662,10,"测试端","体验街20号",108.87217002847,34.214420427771,"0");
		Hospital hosp3 = new Hospital(1679,255,"湘南学院附属医院","体验街20号",108.87227002847,34.233120427771,"1");
		Hospital hosp4 = new Hospital(1680,57,"唐山市铁路中心医院","体验街20号",108.90237002847,34.227220427771,"1");
		Hospital hosp5 = new Hospital(1682,246,"武汉亚洲心脏病医院","体验街20号",108.89247002847,34.213320427771,"2");
		Hospital hosp6 = new Hospital(1710,246,"武汉协和医院","体验街20号",108.89257002847,34.239499997771,"2");
		
		Hospital hosp7 = new Hospital(1711,129,"陕西省人民医院","陕西省黄雁村",108.88307002847,34.223420427771,"3");
		Hospital hosp8 = new Hospital(1712,112,"西安高新医院","高新区团结南路20号",108.86917002847,34.204420427771,"3");
		Hospital hosp9 = new Hospital(1713,101,"西安西京医院","西安市轻工市场附近",108.88427002847,34.233120427771,"4");
		Hospital hosp10 = new Hospital(1714,29,"陕西省武警医院","永明路21号武警支队家属区附近",108.90237002847,34.229220427771,"4");
		Hospital hosp11 = new Hospital(1715,1029,"陕西省森工医院","户县",108.85247002847,34.223320427771,"5");
		Hospital hosp12 = new Hospital(1716,320,"西安美年大体检中心","劳动南路十字东南角",108.89444442847,34.228888997771,"5");
		Hospital hosp13 = new Hospital(1717,155,"小白兔口腔","高新区",108.86207002847,34.216777771,"6");
		Hospital hosp14 = new Hospital(1718,10,"西安市丽人医院","科技路十字东南角向东200米",108.88337002847,34.224420427771,"6");
		Hospital hosp15 = new Hospital(1719,229,"西安市九龙男科","高新四路12号",108.90227002847,34.233120427771,"7");
		Hospital hosp16 = new Hospital(1720,172,"西安市第四军医大学附属医院","东新街12号",108.92237002847,34.227220427771,"7");
		Hospital hosp17 = new Hospital(1721,198,"西安市交通大学附属医院","纬一街10号",108.89247002847,34.212320427771,"8");
		Hospital hosp18 = new Hospital(1722,109,"西安市工人医院","西稍门十字向东50米",108.93257002847,34.239499997771,"8");
		hospitalList.add(hosp1);hospitalList.add(hosp2);hospitalList.add(hosp3);hospitalList.add(hosp4);hospitalList.add(hosp5);
		hospitalList.add(hosp6);hospitalList.add(hosp7);hospitalList.add(hosp8);hospitalList.add(hosp9);hospitalList.add(hosp10);
		hospitalList.add(hosp11);hospitalList.add(hosp12);hospitalList.add(hosp13);hospitalList.add(hosp14);hospitalList.add(hosp15);
		hospitalList.add(hosp16);hospitalList.add(hosp17);hospitalList.add(hosp18);
		
		return hospitalList;
	}
	

	/**
	 * <pre>
	 * 任务： 
	 * 描述：将输入的properties配置文件转为Map 
	 * 作者：屈剑飞
	 * 时间：2015年1月22日下午4:20:34
	 * @param map 将配置文件要存放的map
	 * @param fileName 要读取的配置文件的文件名
	 * @return 将保存了配置文件内容的map返回
	 * returnType：Map
	 * </pre>
	*/
	public static Map initHospitalLevel(String fileName,Map map){
		
		if(map == null){
			map = new HashMap();
		}
		
		InputStream input = null;//创建一个字符流输入流用来读取hospitalLevel.properties文件
		Reader r = null;//创建一个Reader的字符输入流
		try {
			input = HospitalInfoServlet.class.getClassLoader().getResourceAsStream("/"+fileName);
			r = new InputStreamReader(input,"UTF-8");
			
			Properties prop = new Properties();
			prop.load(r);
			
			map = prop;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(r != null){//关闭规则，先关闭最外层的流(即父类的流)
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(input != null){
						try {
							input.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return map;
	}
	
	/**
	 * <pre>
	 * 任务： 
	 * 描述： 将医院信息转为json
	 * 作者：屈剑飞
	 * 时间：2015年1月20日下午2:02:03
	 * @return
	 * returnType：String
	 * </pre>
	*/
	public static String getHosptialInfo(List<Hospital> list){
		Map hospitals = new HashMap();
		hospitals.put("hospitals", list);
		String jsonMsg = JSON.toJSONString(hospitals);
		return jsonMsg;
	}

}
