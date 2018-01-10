package com.wuzhou.test03;

public class Cylinder extends Circle {
	private int heigth;

		
	public Cylinder(){
		this.heigth=1;
	}
	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public double findVolume(){
		return findArea()*this.heigth;
	}
}
