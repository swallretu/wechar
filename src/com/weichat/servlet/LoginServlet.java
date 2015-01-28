package com.weichat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.weichat.util.HLogger;


/** 
 * <pre>
 * 任务：
 * 描述：登陆servlet
 * 作者：屈剑飞
 * 时间：2015年1月27日下午11:38:01
 * 类名: LoginServlet 
 * </pre>
*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check in accont");
//		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域问题
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		
		Map<String,String> resultMap = new HashMap<String,String>();
		request.getRequestDispatcher("success.jsp").forward(request, response);
		response.getWriter().write("sss");
//		String email = request.getParameter("email");
//		String passwd = request.getParameter("passwd");
//		
//		if(null != email && !"".equals(email) && null != passwd && !"".equals(passwd)){
//			if("qujianfei@hotmail.com".equals(email) && "123".equals(passwd)){
//				request.getRequestDispatcher("../success.jsp").forward(request, response);
//			}else{
//				resultMap.put("state", "1");
//				resultMap.put("message", "用户名或密码错误");
//			}
//		}else{
//				resultMap.put("state", "2");
//				resultMap.put("message", "用户名和密码不能为空");
//		}
	}
	
}
