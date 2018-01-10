package com.wuzhou.test17String;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * 与时间相关的时间类
 * 1.System 类下的currentTimeMillis();
 * 2.Date类：java.util.Date以及其子类java.sql.Date 
 * 3.SimpleDateFormat类 国际化
 * 4.Calendar类
 * 
 */
public class TestDate {
	
	/*
	 * java.util.Date不易于国际化
	 */
	@Test
	public void test1(){
		//创建Date的实例
		Date date = new Date();
		System.out.println(date);
		
		Date date1 = new Date(1480127043034L);
		System.out.println(date1.getTime());
		
		java.sql.Date date2 = new java.sql.Date(214187498174L);
		System.out.println(date2);
	}
	
	
	/*
	 * java.text.SimpleDateFormat类易于国际化
	 * 格式化：日期----》文本 使用SimpleDateFormat的format()
	 * 解析：文本----》日期  
	 */
	@Test
	public void test2() throws ParseException{
		//1.格式化1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());
		System.out.println(date);
		
		//2.格式化2
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date1 = sdf1.format(new Date());
		System.out.println(date1);
		
		//3.解析
		Date date2 = sdf.parse("16-11-26 上午10:40");
		System.out.println(date2);
	}
	
	
	/*
	 * "三天打鱼两天晒网" 1990-01-01 XXXX-XX-XX 在打鱼还是在晒网
	 */
	//返回date1和date2之间的天数 date1 < date2
	public int getDays(String date1,String date2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long milliTime=d2.getTime()-d1.getTime();//返回毫秒数
		return (int)milliTime/1000/3600/24+1;//假如是3.5的时候 返回的是3 则加一
	}
	
	@Test
	public void test3() throws ParseException{
		String str = "1990-01-01";
		String str1 = "2014-5-12";
		int days=getDays(str, str1);
		if(days%5==0 || days%5==4){
			System.out.println("晒网");
		}else{
			System.out.println("打鱼");
		}
	}
	
	//Calendar:日历 get() 获得某个属性   add()  set()
	@Test
	public void test4(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
	}
}






