package com.wuzhou.test03;

public class Circle {
	private int circle;
	
	public Circle(){
		this.circle=1;
	}

	public int getCircle() {
		return circle;
	}

	public void setCircle(int circle) {
		this.circle = circle;
	}
	
	public double findArea(){
		return Math.PI*circle*circle;
	}
}
