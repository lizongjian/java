package com.wuzhou.test17String;

import org.junit.Test;
/**
 * 1.去掉指定字符串首尾空格
 * 2.指定字符串部分反转
 * 3.某字符在字符串中出现次数
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		//System.out.println(StringDemo.trim("   sdad  asd   "));
		//System.out.println(StringDemo.reverseString("abcdefg", 0, 3));
		//System.out.println(StringDemo.reverseString1("abcdefg", 0, 1));
		int i=StringDemo.getTime("abcefgcsdasdasf","c");
		System.out.println(i);
	}
	
	
	//1.去掉指定字符串首尾空格
	@Test
	public static String trim(String str){
		int start=0;
		int end=str.length()-1;
		while(start<end&&str.charAt(start)==' '){
			start++;
		}
		while(start<end&&str.charAt(end)==' '){
			end--;
		}
		return str.substring(start,end+1);
	}
	
	//2.实现字符串指定部分的反转 方法一 （用StringBuffer将此算法优化）
	@Test
	public static String reverseString(String str,int start,int end){
		char[] c=str.toCharArray();//字符串---》字符数组
		return reverseArray(c,start,end);
	}
	
	public static String reverseArray(char[] c,int start,int end){
		for(int i=start,j=end;i<j;i++,j--){//实现字符数组的反转
			char temp =c[i];
			c[i]=c[j];
			c[j]=temp;
		}
		return new String(c);//字符数组----》字符串
	}
	
	//2.1实现字符串指定部分的反转 方法二
	//分成三部分  前后不变 中间要变的部分 abcdefg
	@Test
	public static String reverseString1(String str,int start,int end){
		String str1 =str.substring(0, start);
		for(int i=end;i>=start;i--){
			char c= str.charAt(i);
			str1+=c;
		}
		str1+=str.substring(end+1);
		return str1;
	}
	
	//3.某字符在字符串中出现次数.判断str2在str1中出现的次数
	//1)先判断str2在str1中首次出现的位置，然后截取后面的子串再判断
	@Test
	public static int getTime(String str1,String str2){
		int count=0;
		int len;
		while((len=str1.indexOf(str2))!=-1){
			count++;
			str1.substring(len+str2.length());
		}
		return count;	
	}
}
