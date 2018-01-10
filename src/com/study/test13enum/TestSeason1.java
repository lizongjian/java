package com.wuzhou.test13enum;

import java.lang.Thread.State;

/**
 * 枚举类
 *1.自定义枚举类
 *2.用enum来定义
 *		--常用方法       values
 *		--如何让枚举类实现接口：可以让不同的枚举类的对象调用被重写的抽象方法，执行的效果不一样。
 *						     （相当于每个对象都重写抽象方法）
 */
public class TestSeason1 {
	public static void main(String[] args) {
		Season1 spring= Season1.SPRING;
		System.out.println(spring);
		
		spring.show();
		
		System.out.println();

		Season1[] Season1s= Season1.values();
		for(Season1 s : Season1s){
			System.out.println(s);
		}
		
		System.out.println();
		
		State[] states= Thread.State.values();
		for(State state : states){
			System.out.println(state);
		}
	}

}

interface info{
	public abstract void show();
}

enum Season1 implements info {

	SPRING("Spring", "春天"){
		public void show(){
			System.out.println("春天在哪里");
		}
	},
	SUMMER("SUMMER", "夏天"){
		public void show(){
			System.out.println("夏天");
		}
	},
	FALL("FALL", "秋天"){
		public void show(){
			System.out.println("秋天");
		}
	},
	WINTER("WINTER", "白雪皑皑"){
		public void show(){
			System.out.println("冬天");
		}
	};
	
	private final String seasonName;
	private final String seasonDesc;
	
	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}
	

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc="
				+ seasonDesc + "]";
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}