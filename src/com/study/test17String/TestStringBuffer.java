package com.wuzhou.test17String;

import org.junit.Test;

/*
 * java.lang.StringBuffer :可变的字符序列，可以对字符串内容进行增删
 * 
 * 总结:添加:append() 
 * 	         插入: insert(int index,String str);
 * 	         反转：reverse();反转此StringBuffer
 * 		删除：delete(int startIndex,int endIndex)
 * 		查询：charAt(int n)
 * 		修改一个：setCharAt(int index,char c)
 * 		修改多个：replace(int startIndex,int endIndex,String str)
 * 		
 */
public class TestStringBuffer{
	@Test
	public void test(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("abc").append(123).append(true);
		System.out.println(sb);
		
		sb.insert(0,"123");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		char c = sb.charAt(0);
		System.out.println(c);
		
		sb.setCharAt(0, 'k');
		System.out.println(sb);
		
		sb.replace(0, 10, "1");
		System.out.println(sb);
	}
}
