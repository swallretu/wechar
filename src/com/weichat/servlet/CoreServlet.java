package com.weichat.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.weichat.service.CoreService;
import com.weichat.util.SignUtil;


@WebServlet("/CoreServlet")
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CoreServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter doGet()");

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			out.write(echostr.getBytes("UTF-8"));
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter doPost()");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		
		String respMessage = CoreService.processRequeest(request);

		PrintWriter writer = response.getWriter();
		writer.print(respMessage);
		writer.close();
	}
	
}
