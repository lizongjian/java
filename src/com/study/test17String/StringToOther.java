package com.wuzhou.test17String;

import org.junit.Test;

public class StringToOther {
	/*
	 * 1字符串与基本数据类型、包装类之间的转换
	 * ①字符串----》基本数据类型、包装类    :调用相应包装类的parseXxx(String str)
	 * ②基本数据类型、包装类----》字符串    ：调用String中的valueOf()方法
	 * 
	 * 2.字符串与字节数组的转换
	 * ①字符串----》字节数组：调用字符串的getBytes()
	 * ②字节数组----》字符串：调用字符串的构造器
	 * 
	 * 3.字符串与字符数组的转换
	 * ①字符串----》字符数组：调用字符串的tocharArray();
	 * ②字符数组----》字符串：调用字符串的构造器
	 */
	@Test
	public void test(){
		//1.字符串与基本数据类型、包装类之间的转换
		String str="123";
		int i = Integer.parseInt(str);
		System.out.println(i);
		String str1 = i+"";
		String str2 = String.valueOf(i);
		
		//2.字符串与字节数组的转换
		String str3="abcde";
		byte[] b= str3.getBytes();
		for(byte by : b){
			System.out.println((char)by);
		}
		
		//3.字符串与字符数组的转换
		String str4 = "中国";
		char[] c=str4.toCharArray();
		for(char ch : c){
			System.out.println(ch);
		}
		String str5 = new String(c);
		System.out.println(str5);
	}
}
