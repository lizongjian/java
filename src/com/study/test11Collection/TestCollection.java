package com.wuzhou.test11Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import sun.security.x509.IPAddressName;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestCollection {
	@Test
	public void method(){
		Collection coll = new ArrayList();
		//1.大小
		System.out.println(coll.size());
		//2.添加
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		System.out.println(coll.size());
		//3.是否为空
		boolean flag= coll.isEmpty();
		System.out.println(flag);
		//4.清空coll.clear();
		System.out.println(coll);
	}
	
	@Test
	public void method1(){ 
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		//5.是否包含
		boolean flag =coll.contains(123);
		System.out.println(flag);
		//6.添加自定义类型
		coll.add(new Person("aa",123));
		System.out.println(coll);
		//7.retainall(Collection c)
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void method2(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		coll1.removeAll(coll1);
		System.out.println(coll);
		
		//8.集合与数组的转换
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add("AA");
		coll2.add(new Date());
		Object[] obj=coll2.toArray();
		for(int i=0;i<obj.length;i++){
			System.out.println("#"+obj[i]);
		}
		
		//9.iterator():返回一个 iterator接口的实现类的对象（遍历集合元素）
		Iterator i= coll.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}	
	
	@Test
	public void testArray(){
		Person person0 = new Person("1", 12);
		Person person1 = new Person("1", 12);
		Person person2 = new Person("1", 12);
		Person person3 = new Person("1", 12);
		Person[] persons = new Person[4];
		persons[0]=person0;
		persons[1]=person1;
		persons[2]=person2;
		persons[3]=person3;
		for(Person person : persons){
			System.out.println(person);
		}
		
	}
}
