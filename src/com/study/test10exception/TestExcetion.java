package com.wuzhou.test10exception;

public class TestExcetion {
	public static void main(String[] args) {
		int i = method();
		System.out.println(i);
	
	}
	public static int method(){
		try {
			System.out.println(10/0);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}finally{
			return 2;
		}
	}
}
