package com.weichat.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weichat.util.BaseUtil;
import com.weichat.util.HLogger;
import com.weichat.util.MessageUtil;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String ak = "pmCgmADsAsD9rEXkqWNcTzjd";//调用百度接口必须参数，有百度提供
       
	/**
	 * 获得用户的UnionID
	 * @param request
	 * @return
	 */
	public static String getUserUnionID(HttpServletRequest request){
		HLogger.info("开始执行getUserUnionID()");
		String accessToken = "";
		try {
			accessToken = BaseUtil.getToken();
			HLogger.info("accessToken is "+accessToken);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			HLogger.error("获得accessToken失败:"+e.getMessage());
		} 
		
		Map<String, String> requestMap =  null;
		try {
			requestMap = MessageUtil.parseXML(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			HLogger.info("获取requestMap异常："+e.getMessage());
		}
		String userOpenId = requestMap.get("FromUserName");
		HLogger.info("FromUserName is "+userOpenId);
		
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid="+userOpenId+"&lang=zh_CN";
		HLogger.info("url is "+url);
		
		String jsonMsg = BaseUtil.sendPost(url,"");
		HLogger.info("getUserUnionID json result："+jsonMsg);
		
		JSONObject jsonObj = JSON.parseObject(jsonMsg);
		String unionid = jsonObj.getString("unionid");	
		HLogger.info("unionid ："+unionid);
		
		return unionid;
	}
	
	public static String getUserCityByLocation(String Latitude,String Longitude){//纬度，经度
		//百度API 根据经纬度来获得具体的城市信息
		String url = "http://api.map.baidu.com/geocoder/v2/?ak="+ak+"&location="+Latitude+","+Longitude+"&output=json&pois=1";
		String jsonMsg = BaseUtil.sendPost(url, "");
		HLogger.info("jsonMsg is :"+jsonMsg);
		
		JSONObject jsonObj = JSON.parseObject(jsonMsg);
		HLogger.info("jsonObj is :"+jsonObj);
		
		JSONObject result = jsonObj.getJSONObject("result");
		HLogger.info("result is :"+result);

		JSONObject addressComponent = result.getJSONObject("addressComponent");
		HLogger.info("addressComponent is :"+addressComponent);		
		
		StringBuffer province = new StringBuffer(addressComponent.getString("province"));//省
		StringBuffer city = new StringBuffer(addressComponent.getString("city"));//市
		StringBuffer district = new StringBuffer(addressComponent.getString("district"));//区
		
		String location = (province.append(city).append(district)).toString();
		HLogger.info("用户位置 :"+location);
		return location;
	}


	public static void main(String[] args) {
		//纬度在前，经度在后
		String url = "http://api.map.baidu.com/geocoder/v2/?ak=pmCgmADsAsD9rEXkqWNcTzjd&location=30.548397,104.04701&output=json&pois=1";
		getUserCityByLocation("30.548397","104.04701");
	}
}
