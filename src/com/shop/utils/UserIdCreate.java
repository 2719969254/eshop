package com.shop.utils;

import java.util.UUID;

public class UserIdCreate {
	/**
	 * ͨ��UUID��������û�ID����Ψһ
	 * @return
	 */
	public static String getRandomId(){
		return UUID.randomUUID().toString();
	}
}
