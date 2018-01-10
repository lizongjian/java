package com.wuzhou.test09InnerClass;

import com.sun.swing.internal.plaf.basic.resources.basic;



public class TestInnerClass {
	public static void main(String[] args) {
		//静态内部类
		Person.Dog d = new Person.Dog();
		//非静态内部类
		Person p = new Person();
		Person.Brid b = p.new Brid();
		b.show();
	}
	
	
}

class Person{
	String name;
	int age;
	//成员内部类
	class Brid{
		String name="鹦鹉";
		int id;
		public void show(){
			System.out.println("Brid");
		}
	}
	static class Dog{
		String name = "哈士奇";
	}
}