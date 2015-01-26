package com.weichat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.weichat.message.userPosition;


public class GetPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		userPosition user = new userPosition("108.88307002847","34.229220427771");
		String jsonUser = JSON.toJSONString(user);
		System.out.println(jsonUser);
		out.write(jsonUser);
		out.flush();
		out.close();
	}

}
