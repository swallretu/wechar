package com.weichat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		System.out.println("come in servlet");
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
