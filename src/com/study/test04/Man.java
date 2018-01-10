package com.wuzhou.test04;

public class Man extends Person{
	private boolean smoking;
	
	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	public void eat(){
		System.out.println("多吃饭");
	}
	public void walk(){
		System.out.println("多走路");
	}
	public void cao(){
		System.out.println("caob");
	}
}
