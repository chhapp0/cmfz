package com.baizhi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author lenovo
 *
 */
public class Md5Util {
	/**
	 * 用来生成md5加密结果
	 * @param password  加密内容
	 * @return
	 */
	public static String getMd5Code(String password){
		try {
			//java.secutiry
			MessageDigest messageDigest = MessageDigest.getInstance("md5") ;
			//加密
			byte[] digest = messageDigest.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			//byte转为16进制长度是32位字符串  byte  -128~~~127    0~~255
			for (byte b : digest) {  //0x0-0  0x1-1   0xa-10 0xf 15 0x10-16 0x11-17    
				int c = b & 0xff;
				if(c<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(c));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
