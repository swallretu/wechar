package com.weichat.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.weichat.message.user;

/**
 * @author 剑飞
 * 处理json
 */
public class JSONUtil {

		/**
		 * 将数据转为json
		 * @param obj
		 * @return
		 */
		public static String objectToJSON(Object obj){
			String str = JSON.toJSONString(obj);
			return	str;
		}
				
		/**
		 * 直接将json数据发到前台
		 * @param response
		 * @param jsonStr
		 */
		public static void sendJsonMsgByResponse(HttpServletResponse response,String jsonStr){
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;chatset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.write(jsonStr);
				out.flush();
			} catch (IOException e) {
				System.out.println("response 获取异常："+e.getMessage());
			}finally{
				if(out != null){
					out.close();
				}
			}
			
		}
		
		
}
