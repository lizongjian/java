package com.wuzhou.test17String;

import org.junit.Test;

public class TestStringReverse {
	public static void main(String[] args) {
		String str =TestStringReverse.reverse("abcdefg");
		System.out.println(str);
		
		String str1=TestStringReverse.reverse1("abcdef");
		System.out.println(str1);
		
		String str2 = TestStringReverse.reverse2("abcde");
		System.out.println(str2);
	}
	
	//字符串的反转 方法一
	@Test
	public static String reverse(String str){
		char[] c=str.toCharArray();
		for(int i=0,j=str.length()-1;i<j;i++,j--){
			char temp=c[i];
			c[i]=c[j];
			c[j]=temp;
		}
		return new String(c);
	}
	
	//字符串的反转 方法二
	public static String reverse1(String str){
		//1.把String转成StringBuffer
//		StringBuffer sb = new StringBuffer(str);
//		sb.reverse();
		return new StringBuffer(str).reverse().toString();
	}
	
	//字符串的反转 方法三
	public static String reverse2(String str){
		StringBuffer sb = new StringBuffer();
		for(int i =str.length()-1;i>-1;i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
