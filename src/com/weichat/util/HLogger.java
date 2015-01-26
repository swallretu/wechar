package com.weichat.util;


import org.apache.log4j.Logger;

public final class HLogger
{
	private static final Logger _logger = Logger.getLogger(HLogger.class.getClass());
	
	public static void Debug(Object o)
	{
		trace(o,LoggerLevel.DEBUG);
	}

	public static void debug(Object o)
	{
		Debug(o);
	}
	
	
	public static void Debug(java.lang.Class t, Object o)
	{
		trace(o,LoggerLevel.DEBUG);
	}

	
	public static void debugString(String output){
		_logger.debug(output);
	}


	public static void info(Object o)
	{
		Info(o);
	}


	public static void Info(Object o)
	{
		trace(o,LoggerLevel.INFO);
	}

	public static void Info(java.lang.Class t, Object o)
	{
		trace(o,LoggerLevel.INFO);
	}

	
	public static void infoString(String output){
		_logger.info(output);
	}
	
	public static void warn(Object o){
		Warn(o);
	}
	
	public static void Warn(Object o)
	{
		trace(o,LoggerLevel.WARN);
	}

	public static void Warn(java.lang.Class t, Object o)
	{
		trace(o,LoggerLevel.WARN);
	}

	public static void warnString(String output){
		_logger.warn(output);
	}
	

	public static void error(Object in){
		Error(in);
	}
	
	
	public static void Error(Object in)
	{
		if (in instanceof Throwable) {
			errorStackTrace(in);
		}else{
			errorString(in+"");
			trace(in,LoggerLevel.ERROR);
		}
	}

	private static void errorStackTrace(Object in) {
		StackTraceElement[] ste = ((Throwable) in).getStackTrace();
		int i0=0;
		boolean isTrue = false;
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			
			if(temp.indexOf("quyiyuan") > 1){
				isTrue = true;
			}
			if(isTrue && temp.indexOf("quyiyuan") < 0){
				break;
			}
			StringBuffer ident=new StringBuffer();
			for(int ii=0;ii<=i0;ii++){
				ident.append("\t");
			}
			errorString(ident+temp);
			i0++;
		}
	}
	
	
	private static void debugStackTrace(Object o,Object in) {
		StackTraceElement[] ste = ((Throwable) in).getStackTrace();
		int i0=0;
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			String tempUpper=temp.toUpperCase();
			if(tempUpper.indexOf("QUYIYUAN")>=0 && (temp.indexOf("HLogger"))<0){
				StringBuffer ident=new StringBuffer();
				for(int ii=0;ii<=i0;ii++){
					ident.append("\t");
				}
				debugString(o+""+ident+temp);
				i0++;
			}
		}
	}
	
	private static void infoStackTrace(Object o,Object in) {
		StackTraceElement[] ste = ((Throwable) in).getStackTrace();
		int i0=0;
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			String tempUpper=temp.toUpperCase();
			if(tempUpper.indexOf("QUYIYUAN")>=0 && temp.indexOf("HLogger")<0){
				StringBuffer ident=new StringBuffer();
				for(int ii=0;ii<=i0;ii++){
					ident.append("\t");
				}
				infoString(o+""+ident+temp);
			}
		}
	}
	
	private static void warnStackTrace(Object o,Object in) {
		StackTraceElement[] ste = ((Throwable) in).getStackTrace();
		int i0=0;
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			String tempUpper=temp.toUpperCase();
			if(tempUpper.indexOf("QUYIYUAN")>=0 && (temp.indexOf("HLogger"))<0){
				StringBuffer ident=new StringBuffer();
				for(int ii=0;ii<=i0;ii++){
					ident.append("\t");
				}
				if(i0==0){
					warnString(o+""+ident+temp);
				}else{
					warnString(ident+temp);
				}
				i0++;
			}
		}
	}

	public static void Error(java.lang.Class t, Throwable o)
	{
		Error(o);
	}

	
	private static void errorString(String output){
		_logger.error(output);
	}
	
	
	/**
	 * comments:
	 * 跟踪调用堆栈
	 * sjl modify 2014年1月27日下午1:32:30
	 */
	private static void trace(Object o,LoggerLevel level) {
		Throwable ex = new Throwable();
		
		if(level==LoggerLevel.DEBUG){
			debugStackTrace(o,ex);
		}else if(level==LoggerLevel.INFO){
			infoStackTrace(o,ex);
		}else if(level==LoggerLevel.WARN){
			warnStackTrace(o,ex);
		}else if(level==LoggerLevel.ERROR){
			errorStackTrace(ex);
		}
	}

	
	/**
	 * comments:
	 * 
	 * sjl modify 2014年1月27日下午1:25:28
	 */
	public enum LoggerLevel{
		DEBUG,INFO,WARN,ERROR,FATAL
	}
	
	/**
	 *任务：
	 *描述：输出日志文件，同时返回异常堆栈字符串 KYEEAPP-974
	 *人员：施建龙
	 *时间：2014年11月5日下午8:33:45
	 **/
	public static String warnStackTrace(Object o) {
		Throwable ex = new Throwable();
		StringBuffer sb=new StringBuffer();
		StackTraceElement[] ste = ((Throwable) ex).getStackTrace();
		int i0=0;
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			String tempUpper=temp.toUpperCase();
			if(tempUpper.indexOf("QUYIYUAN")>=0 && (temp.indexOf("HLogger"))<0){
				StringBuffer ident=new StringBuffer();
				for(int ii=0;ii<=i0;ii++){
					ident.append("\t");
				}
				sb.append(ident+temp);
				if(i0==0){
					warnString(o+""+ident+temp);
				}else{
					warnString(ident+temp);
				}
				i0++;
			}
		}
		return sb.toString();
	}
	
	/**
	 *任务：
	 *描述：临时使用，输出所有信息的StackTrace
	 *人员：施建龙
	 *时间：2014年11月19日下午2:14:29
	 **/
	public static void infoStackTrace(Object o) {
		Throwable ex = new Throwable();
		StackTraceElement[] ste = ((Throwable) ex).getStackTrace();
		infoString(o+"");
		for (int i = 0; i < ste.length; i++) {
			String temp=ste[i].toString();
			StringBuffer ident=new StringBuffer();
			infoString(""+ident+temp);
		}
	}
}