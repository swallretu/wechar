package com.weichat.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.weichat.message.resp.TextMessage;
import com.weichat.servlet.UserInfoServlet;
import com.weichat.util.HLogger;
import com.weichat.util.MessageUtil;

public class CoreService {
	
	public static String processRequeest(HttpServletRequest request){
		String responseMessage = "";
		String responseContent = "请求处理异常，请稍后尝试！";
		Map<String,String> requestMap = MessageUtil.parseXML(request);
		
		String FromUserName = requestMap.get("FromUserName");
		String ToUserName = requestMap.get("ToUserName");
		String MsgType = requestMap.get("MsgType");
				
		
		if(MsgType.equals("text")){
			
	        TextMessage textMessage = new TextMessage();
	        textMessage.setToUserName(FromUserName);
	        textMessage.setFromUserName(ToUserName);
	        textMessage.setCreateTime(new Date().getTime());
	        textMessage.setMsgType("text");
	        textMessage.setFuncFlag(0);
	        responseContent = "hi,您发送的是文本消息！";

	        textMessage.setContent(responseContent);
			responseMessage = MessageUtil.textMessageToXml(textMessage);
			System.out.println(responseMessage);

			return responseMessage;
			
		}else if(MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
			responseContent = "您发送的是图片消！";
		}else if(MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
			responseContent = "您发送的是一个链接！";
		}else if(MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
			responseContent = "您发送的是位置信息！";
		}else if(MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
			responseContent = "您发送的是一个音频！";
		}else if(MsgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
			
			String event = requestMap.get("Event");
			if(event.equals(MessageUtil.EVNET_TYPE_CLIECK)){
				responseContent = "这是一个点击事件！";
			}else if(event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
				responseContent = "感谢关于趣医公众账号！";
			}else if(event.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
				//如果用户取消关注了公众号因此收不到公众号消息，故不发送消息
			}else if(event.equals(MessageUtil.EVENT_TYPE_LOCATION)){
				
           	 String latitude = requestMap.get("Latitude");  //纬度
           	 String longitude = requestMap.get("Longitude"); //经度
			
           	 HLogger.info("纬度："+latitude);
           	 HLogger.info("经度："+longitude);
           	 
           	 UserInfoServlet.getUserCityByLocation(latitude, longitude);
			}
			
		}

		return responseMessage;
	}
	
}
