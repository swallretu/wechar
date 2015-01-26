package com.weichat.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.weichat.message.resp.Article;
import com.weichat.message.resp.MusicMessage;
import com.weichat.message.resp.NewsMessage;
import com.weichat.message.resp.TextMessage;

public class MessageUtil {
	/**
	 * 返回消息类型:文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	/**
	 * 返回消息类型:音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	/**
	 * 返回消息类型:图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	/**
	 * 请求消息类型:文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	/**
	 * 请求消息类型:图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	/**
	 * 请求消息类型:连接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	/**
	 * 请求消息类型:获得位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	/**
	 * 请求消息类型:音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	/**
	 * 请求消息类型:推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	/**
	 * 事件类型：订阅
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	/**
	 * 事件类型:取消订阅
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 事件类型:click 点击事件
	 */
	public static final String EVNET_TYPE_CLIECK = "click"; 
	/**
	 * 事件类型：获得用户地理位置事件
	 */
	public static final String EVENT_TYPE_LOCATION="LOCATION";
	/**
	 * 用来存放所有用户的位置信息
	 */
	public static Map<String,String> userlocations = new HashMap<String,String>();
	public static XStream xstream = new XStream(new XppDriver()
	  {
	    public HierarchicalStreamWriter createWriter(Writer out) {
	      return new PrettyPrintWriter(out)
	      {
	        boolean cdata;

	        public void startNode(String name, Class clazz)
	        {
	          super.startNode(name, clazz);
	        }

	        protected void writeText(QuickWriter writer, String text) {
	          if (this.cdata) {
	              writer.write("<![CDATA[");
	              writer.write(text);
	              writer.write("]]>");
	          } else {
	            writer.write(text);
	          }
	        }
	      };
	    }
	  });

	/**
	 * 解析微信发来的请求
	 * @param request
	 * @return
	 */
	public static Map<String,String> parseXML(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		InputStream input = null;
		try {
			input = request.getInputStream();
			SAXReader reader = new SAXReader();
			Document document = reader.read(input);
			Element root = document.getRootElement();
			List<Element> elementlist = root.elements();
			for (Element ele : elementlist) {
				map.put(ele.getName(),ele.getText());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
	
	  public static String textMessageToXml(TextMessage textMessage)
	  {
		  xstream.alias("xml", textMessage.getClass());
		  return xstream.toXML(textMessage);
	  }

	  public static String musicMessageToXml(MusicMessage musicMessage)
	  {
	    xstream.alias("xml", musicMessage.getClass());
	    return xstream.toXML(musicMessage);
	  }

	  public static String newsMessageToXml(NewsMessage newsMessage)
	  {
	    xstream.alias("xml", newsMessage.getClass());
	    xstream.alias("item", new Article().getClass());
	    return xstream.toXML(newsMessage);
	  }

}
