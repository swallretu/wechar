package com.weichat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;



public class BaseUtil {

	public static String APPID = "wx09cbf2186670fddc";
	public static String SECRET = "b7405a1144656ea5c48316470dbf4440";

	/**
	 * 获取token
	 * @return
	 * @throws Exception
	 */
	public static String getToken() throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ APPID + "&secret=" + SECRET;
		String jsonResult = sendPost(url, "");
		System.out.println(jsonResult);
		int startIndex = jsonResult.indexOf("access_token");
		int endIndex = jsonResult.indexOf(",");
		String resultMsg = jsonResult.substring(startIndex + 15, endIndex - 1);
		System.out.println(resultMsg);
		return resultMsg;
	}

	/**
	 * 生成菜单接口
	 * @return
	 * @throws Exception
	 */
	public String createMenu() throws Exception {
		String access_token = getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;
		String param = "{"
				+ "\"button\":[{\"type\":\"view\",\"name\":\"去医院\",\"key\":\"main\",\"url\":\"http://www.quyiyuan.com/\"},{\"name\":\"我的微信\",\"sub_button\":[{\"type\":\"view\",\"name\":\"我的简介\",\"url\":\"http://www.soso.com/\"},{\"type\":\"scancode_push\",\"name\":\"扫码推事件\",\"key\":\"sao\"},{\"type\":\"scancode_waitmsg\",\"name\":\"只扫码\",\"key\":\"justsao\"},{\"type\":\"location_select\",\"name\":\"发送位置\",\"key\":\"locate\"},{\"type\":\"pic_photo_or_album\",\"name\":\"相册\",\"key\":\"photo\"}]}]"
				+ "}";
		String resultMsg = sendPost(url, param);
		System.out.println(resultMsg);
		return resultMsg;
	}

	
	/**
	 *响应用户的文本消息请求
	 * @return
	 * @throws Exception 
	 */
	public String responseUserTextMsgReq(String MsgType,String ToUser,String respMsg	) throws Exception{
		String access_token = getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
		String param = "	{\"touser\":\""+ToUser+"\",\"msgtype\":\""+MsgType+"\",\"text\":{\"content\":\""+respMsg+"\"}}";
		System.out.println(param);
		String resultMsg = sendPost(url, param);
		return resultMsg;
	}

	
	
	public static void main(String[] args) throws Exception {
		BaseUtil web = new BaseUtil();
		web.getToken();
	}

	/**
	 * 通过post解析url
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// System.out.println(result);
		return result;
	}
	
	
    
    /**
     * 判断用户请求来自于哪一种设备(ios or android)
     * @param request
     * @return
     */
    public String checkPostType(HttpServletRequest request){
    	
    	String url = request.getHeader("user-agent");
    	String agent = "";
		HLogger.info("requestHeader user-agent :"+url);
    	if(url.contains("Windows")){
			agent = "windows";
			HLogger.info("agent = "+agent);
    	}
		if(url.contains("iPhone") || url.contains("IPod") || url.contains("IPad")){
			agent = "ios";
			HLogger.info("agent = "+agent);
		}
		if(url.contains("Android")){
			agent = "android";
			HLogger.info("agent = "+agent);
		}else{
			agent = "无此类型设备";
			HLogger.info("agent = "+agent);
		}
    	return agent;
    }
        
}
