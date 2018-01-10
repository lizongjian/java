package com.wuzhou.test11Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;


public class TestCollectionTerator {
	@Test
	public void method(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aa");
		coll.add(new Date());
		coll.add(new Person("bb", 22));
		System.out.println(coll);
		Iterator iterator = coll.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void method2(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aa");
		coll.add(new Date());
		coll.add(new Person("bb", 22));
		Iterator iterator = coll.iterator();
		//抛异常
		while((iterator.next())!=null){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void method3(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aa");
		coll.add(new Date());
		coll.add(new Person("bb", 22));
		Iterator iterator = coll.iterator();
		//增强for循环(要遍历元素的类型  变量：遍历元素的引用)
		for(Object obj : coll){
			System.out.println(obj);
		}
	}
	
	@Test
	//数组使用增强循环
	public void method4(){
		//int[] i = new int[]{1,2,3,4,5,67,9,8};
		int[] i = new int[5];
		i[0]=10;
		i[1]=9;
		i[2]=8;
		i[3]=7;
		i[4]=6;
		Arrays.sort(i);
		for(int j : i){
			System.out.println(j);
		}
	}
	
	@Test
	//增强循环和普通循环的区别
	public void method5(){
		int[] i = new int[]{1,2,3,4,5,67,9,8};
		for(int j : i){
			j=1;
			System.out.println(j);
		}
		for(int j : i){
			System.out.println(j);
		}
	}
}
