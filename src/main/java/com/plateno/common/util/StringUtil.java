package com.plateno.common.util;

import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * 
	 * @描述:字符串判空
	 * @param src
	 * @return
	 * @返回类型 boolean
	 * @创建人 Chenliqiao
	 * @创建时间 2017年5月25日下午5:05:42
	 */
	public static boolean isBlank(String src){
		if(src==null||"".equals(src))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @描述:字符串是否是整数
	 * @param src
	 * @return
	 * @返回类型 boolean
	 * @创建人 Chenliqiao
	 * @创建时间 2017年5月25日下午5:08:42
	 */
	public static boolean isInteger(String src){
		if(isBlank(src))
			return false;
		 Pattern pattern = Pattern.compile("[0-9]*");  
		 return pattern.matcher(src.trim()).matches();       
	}
	
	public static void main(String[] args) {
		System.out.println(isInteger("sdfasdf"));
	}

}
