package com.wuzhou.test06static;

//设计模式之懒汉式 ：可能存在线程安全问题

public class TestSingleton1 {

}
class Singleton1{
	
	private Singleton1() {
	}
	
	private static Singleton1 instance = null;
	//第一次调用 创建一次 ;第二次进来已经创建好 
	public static Singleton1 getInstance(){
		if(instance == null){
			instance=new Singleton1();
		}
		return instance;
	} 
}