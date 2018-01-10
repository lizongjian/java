package com.wuzhou.test17String;

import org.junit.Test;

/**
 * StringBuilder:可变的字符序列 java5.0新特性，线程不安全。效率高于StringBuffer
 *
 */
public class TestStringBuilder {
	/**
	 * 对比String。StringBuffer。StringBuilder三者在添加的效率
	 * 效率 String < StringBuffer < StringBuilder
	 */
	@Test
	public void test(){
		long startTime=0L;
		long endTime= 0L;
		String text="";
		StringBuffer sb1 = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();
		
		//String
		startTime=System.currentTimeMillis();
		for(int i =0;i<20000;i++){
			text=text+i;
		}
		endTime=System.currentTimeMillis();
		System.out.println("String:"+(endTime-startTime));
		
		//StringBuffer
		startTime=System.currentTimeMillis();
		for(int i =0;i<20000;i++){
			sb1.append(String.valueOf(i));
		}
		endTime=System.currentTimeMillis();
		System.out.println("StringBuffer:"+(endTime-startTime));
		
		
		//StringBuilder
		startTime=System.currentTimeMillis();
		for(int i =0;i<20000;i++){
			sb2.append(String.valueOf(i));
		}
		endTime=System.currentTimeMillis();
		System.out.println("StringBuilder:"+(endTime-startTime));
		
	}
}
