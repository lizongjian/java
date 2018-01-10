package com.wuzhou.test11Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestList {
	//ArrayList:List的主要实现类
	
	//在Collection的基础上新增加的方法...
	@Test
	public void testList(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(0, 789);
		System.out.println(list);
		Object object= list.get(1);
		System.out.println(object);
		list.remove(0);
		System.out.println(list.get(0));
	}
	
	@Test
	public void testList2(){
		List list = new LinkedList();
		list.add(123);
		list.add(456);
		list.add(0, 789);
	}
	
	@Test
	public void testList3(){
		List<Object> list = new ArrayList<>();
		
		for(long i = 0;i<10000000L;i++){
			list.add(i);
		}
		Long startTime= new Date().getTime();
		list.remove(10000000L);
		Long endTime= new Date().getTime();
		System.out.println(endTime-startTime+"毫秒");
	}
	
	@Test
	public void testList4(){
		List<Object> list = new LinkedList<>();
		for(Long i = 0L;i<10000000L;i++){
			list.add(i);
		}
		Long startTime= new Date().getTime();
		list.remove(10000000L);
		Long endTime= new Date().getTime();
		System.out.println((endTime-startTime)+"豪秒");
	}
}
