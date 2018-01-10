package com.wuzhou.test17String;

import org.junit.Test;

public class TestString {
	/**
	 * String ：代表不可变的字符序列，底层使用char[]存放。
	 * String：是final的。
	 * 
	 *
	 */
	@Test
	public void test1(){
		String str1 = "javaee";
		String str2 = "javaee";
		String str3 = new String("javaee");
		
		String str4 = "javaee"+"andriod";//相当于"javaeeandriod"
		String str5 = "andriod";
		String str6 = str1+str5;
		String str7 = str6.intern();
		str5=str5+"hadoop";
		
		System.out.println(str1==str2);//true
		System.out.println(str1==str3);//false
		System.out.println(str1.equals(str3));//true 
		
		System.out.println(str4==str6);//false
		System.out.println(str4.equals(str6));//true
		System.out.println(str4==str7);
		
		Person p1 = new Person("aa");
		Person p2 = new Person("aa");
		System.out.println("--"+(p1.name==p2.name));
	}
	
	@Test
	public void test2(){
		String str1="abcdefg";
		String str2="de";
		
		System.out.println(str1.length());
		System.out.println(str1.indexOf(str2));
		System.out.println(str1.startsWith(str2));
	}
	
	@Test
	public void test3(){
		String str1="北流,国际大酒店,北流";
		String str2="玉林国际大酒店";
		
		String str3=str1.substring(2);
		String str4=str1.substring(0, 2);
		System.out.println(str3);
		System.out.println(str4);
		
		String str5=str1.replace("北流", "广西");
		System.out.println(str5);
		System.out.println(str1);
		System.out.println();
	
		
		String[] str6=str1.split(",");
		for(String s : str6){
			System.out.println(s);
		}
	}

}
class Person{
	String name;
	public Person(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}