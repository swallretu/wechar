package com.weichat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
	
	private static String token = "123456";
	
	/**
	 * 验证签名信息
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);//对三个参数进行字典排序
		StringBuilder content = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpstr = null;
		
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());//将三个参数拼接成字符串进行"SHA-1"加密
			tmpstr = byteToStr(digest);//将字节数组转为字符串
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		content = null;
		
		//将sha1加密后的字符串与signature对比，标示请求来源于微信
		return tmpstr !=null ? tmpstr.equals(signature.toUpperCase()) : false;
	}
	
	/**
	 * 将字节数组转为16进制字符串
	 * @param by
	 * @return
	 */
	public static String byteToStr(byte[] by){
		String digest = "";
		for (int i = 0; i < by.length; i++) {
			digest += byteToHexStr(by[i]); 
		}
		return digest;
	} 
	
	/**
	 * 将字节转为16进制字符串
	 * @param by
	 * @return
	 */
	public static String byteToHexStr(byte by){
		char[] digest = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] tempArr = new char[2];
		tempArr[0] = digest[(by>>>4) & 0X0F];
		tempArr[1] = digest[by & 0X0F];
		
		String s = new String(tempArr);
		return s;
	}
}
