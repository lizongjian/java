package com.wuzhou.test10exception;

public class CustonExcetion extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CustonExcetion() {
	}
	public CustonExcetion(String mes) {
		super(mes);
	}
}
