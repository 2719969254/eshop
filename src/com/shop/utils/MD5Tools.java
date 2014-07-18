package com.shop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Tools {
	
	/**
	 * MD5�㷨,�����ַ������Ż�MD5������ַ���
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public  static String getMD5String(String str){
		//����MD5�㷨
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		//��Stringͨ��MD5ת��Ϊ�ֽ�����
		byte[] digest = md.digest(str.getBytes());
		
		//����BASE64Encoder����
		BASE64Encoder en = new BASE64Encoder();
		
		//�ֽ�����ͨ��base64���б��룬�����µ�String
		String encode = en.encode(digest);
		return encode;
	}
}
