package com.wuzhou.Test01;

public class Test01 {
	public static void main(String[] args) {
		Customer c = new Customer("lizongjian");
		Account a = new Account(1, 1000, 0.0123);
		c.setAccount(a);
		c.getAccount().deposit(100);
		c.getAccount().withDraw(960);
		c.getAccount().withDraw(2000);
		System.out.println(c.getAccount());
	}
}
