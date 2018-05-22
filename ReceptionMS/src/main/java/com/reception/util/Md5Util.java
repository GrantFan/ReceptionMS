package com.reception.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Util {

	/**
	 * 利用MD5进行加密 　　* @param str 待加密的字符串 　　* @return 加密后的字符串 　　
	 * 
	 * @throws NoSuchAlgorithmException
	 *             没有这种产生消息摘要的算法 　　 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) {
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符串
			String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newstr;
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
			return str;
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
			return str;
		}

	}

	/**
	 * 判断用户密码是否正确 　　　　* @param newpasswd 用户输入的密码 　　　　 * @param oldpasswd
	 * 数据库中存储的密码－－用户密码的摘要 　　　　* @return 　　　　
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 *             　　　　
	 */
	public static boolean checkStrByMd5(String newStr, String oldStr) {
		if (EncoderByMd5(newStr).equals(oldStr)) {
			return true;
		}
		return false;
	}
}
