package com.wuzhou.test13enum;

public class TestSeason {
	public static void main(String[] args) {
		Season spring= Season.SPRING;
		System.out.println(spring);
	}

}
class Season{
	//1.提供类的属性，声明为private final
	private final String seasonName;
	private final String seasonDesc;
	
	//2.声明为final的属性，在构造器中初始化。
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	//3.提供公用的方法调用属性
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	public static final Season SPRING = new Season("Spring", "春天");
	public static final Season SUMMER = new Season("SUMMER", "夏天");
	public static final Season FALL = new Season("FALL", "秋天");
	public static final Season WINTER = new Season("WINTER", "白雪皑皑");

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc="
				+ seasonDesc + "]";
	}
	
}