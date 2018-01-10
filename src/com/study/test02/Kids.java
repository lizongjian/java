package com.wuzhou.test02;

public class Kids extends ManKind {
	private int yearsold;

	public int getYearsold() {
		return yearsold;
	}

	public void setYearsold(int yearsold) {
		this.yearsold = yearsold;
	}
	public void printAge(){
		System.out.println("年龄为："+this.yearsold);
	}
}
