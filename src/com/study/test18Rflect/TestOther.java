package com.wuzhou.test18Rflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOther {

	// 1.获取运行时类的父类
	@Test
	public void test() {
		Class clazz = Person.class;
		Class sup = clazz.getSuperclass();
		System.out.println(sup);
	}

	// 2.获取运行时类带泛型的父类
	@Test
	public void test2() {
		Class clazz = Person.class;
		Type supG = clazz.getGenericSuperclass();
		System.out.println(supG);
	}

	// 3.获取父类的泛型    *重点
	@Test
	public void test3() {
		Class clazz = Person.class;
		Type supG = clazz.getGenericSuperclass();
		
		//获取泛型参数
		ParameterizedType param=(ParameterizedType)supG;
		Type[] t= param.getActualTypeArguments();
		for(Type type : t){
			System.out.println(type.getTypeName());
		}
		System.out.println(((Class)t[0]).getTypeName());
	}
	
	//4.获取运行类实现的接口
	
	//5.获取运行时类所在的包
	
	//6.获取运行时类的注解
	
	//7.获取运行时类的内部类
}
