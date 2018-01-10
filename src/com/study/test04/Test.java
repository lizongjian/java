package com.wuzhou.test04;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.walk();
		
		Man m = new Man();
		m.eat();
		m.walk();
		
		
		Person p1 =new Man();//上转型
		p1.eat();
		p1.walk();
		
		if(p1 instanceof Man){ //对象 instanceof 类 判断  对象是否是类（类的父类）的实例
			Man m1 = (Man)p1;// 下转型
			m1.cao();
		}
		
		
	}
}
