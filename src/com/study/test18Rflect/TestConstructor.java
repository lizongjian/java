package com.wuzhou.test18Rflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test() throws Exception{
		String className="com.wuzhou.test18Rflect.Person";
		Class clazz= Class.forName(className);
		
		/*
		 * 1.创建对应运行时类的对象  
		 * 要求a.要求有无参构造器   
		 * 要求b.访问修饰符足够
		 */
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
	}
	
	//获取运行时类的所有构造器
	@Test
	public void test2(){
		Person p = new Person();
		Class clazz= p.getClass();
		
		//getConstructors():获取本类的public的构造器
		Constructor[] con = clazz.getConstructors();
		for(Constructor c : con){
			System.out.println(c);
		}
		
		System.out.println();
		
		//getDeclaredConstructors():获取所有包括父类的public构造器
		Constructor[] con1 = clazz.getDeclaredConstructors();
		for(Constructor c : con1){
			System.out.println(c);
		}
	}
	
	//-----------------------------------------------------
	
	//调用指定构造器
	@Test
	public void test3() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Person p = new Person();
		Class clazz= p.getClass();
		Constructor con= clazz.getDeclaredConstructor(String.class,int.class);
		con.setAccessible(true);
		Person p1 = (Person)con.newInstance("uu",12);
		System.out.println(p1);
	}
}
