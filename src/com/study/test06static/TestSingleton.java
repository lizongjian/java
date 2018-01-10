package com.wuzhou.test06static;

//单例模式之饿汉式
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		System.out.println(s1==s2);
		
	}

}
class Singleton{
	//1.私有构造器
	private Singleton() {
	}
	//私有化实例对象
	private static Singleton instance = new Singleton();
	//公有的获取实例对象的方法
	public static Singleton getInstance(){
		return instance;
	}
	
}
