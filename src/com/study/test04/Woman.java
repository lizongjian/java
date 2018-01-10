package com.wuzhou.test04;

public class Woman extends Person{
	private boolean isBeauty;
	
	public boolean isBeauty() {
		return isBeauty;
	}

	public void setBeauty(boolean isBeauty) {
		this.isBeauty = isBeauty;
	}
	public void eat(){
		System.out.println("少吃饭");
	}
	public void walk(){
		System.out.println("少走路");
	}
}
