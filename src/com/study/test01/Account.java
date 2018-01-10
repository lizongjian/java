package com.wuzhou.Test01;

public class Account {
	private int id;
	private double balance;
	private double annualInterrestRate;
	
	public Account(int id,double balance,double annualInterrestRate){
		this.id=id;
		this.balance=balance;
		this.annualInterrestRate=annualInterrestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterrestRate() {
		return annualInterrestRate;
	}

	public void setAnnualInterrestRate(double annualInterrestRate) {
		this.annualInterrestRate = annualInterrestRate;
	}
	public void withDraw(double amount){
		if(amount<=balance){
		this.balance-=amount;
		}else{
			System.out.println("余额不足");
		}
	}
	public void deposit(double amount){
		this.balance+=amount;
	}
	
}
