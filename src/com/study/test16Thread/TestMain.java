package com.wuzhou.test16Thread;

//单线程： 主线程
public class TestMain {
	public static void main(String[] args) {
		method2();
	}
	public static void method1(){
		System.out.println("method1");
	}
	public static void method2(){
		method1();
		System.out.println("method2");
	}
}
