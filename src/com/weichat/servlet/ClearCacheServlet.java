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
 * 描述：用来清理保存在缓存中的数据
 * 作者：屈剑飞
 * 时间：2015年1月22日下午10:50:02
 * 类名: ClearMemoryServlet 
 * </pre>
*/
public class ClearCacheServlet extends HttpServlet {
	static HospitalInfoServlet test = new HospitalInfoServlet();
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("清空testservlet缓存");
		clearMemory();
		System.out.println("清空testservlet缓存成功");
	}

	/**
	 * <pre>
	 * 任务： 
	 * 描述：清理缓存
	 * 作者：屈剑飞
	 * 时间：2015年1月22日下午10:50:30
	 * returnType：void
	 * </pre>
	*/
	private static void clearMemory(){
		System.out.println("testservlet缓存清空中。。。");
		test.allHospital.clear();
		System.out.println("testservlet缓存清空结束");
	}
}
