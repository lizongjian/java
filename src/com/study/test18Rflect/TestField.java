package com.wuzhou.test18Rflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	
	
	//获取对应运行时类的属性
	@Test
	public void test(){
		Class clazz = Person.class;
		
		//1.getFields()：只能获取(包括父类)声明为public的属性
		Field[] f1= clazz.getFields();
		for(Field fi : f1){
			System.out.println(fi);
		}
		System.out.println();
		
		//2.getDeclaredFields():获取类本身声明的所有属性
		Field[] f2 = clazz.getDeclaredFields();
		for(Field fi : f2){
			System.out.println(fi);
		}
	}


	//属性结构： 权限修饰符 变量类型 变量名
	//获取属性的各个结构
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] f1= clazz.getDeclaredFields();
		for(Field fi : f1){
			//1.获取每个属性的权限修饰符
			int i = fi.getModifiers();
			String str= Modifier.toString(i);
			System.out.print(str+" ");
			
			//2.获取每个属性的类型
			System.out.print(fi.getType()+" ");
			
			//3.获取每个属性的属性名
			System.out.print(fi.getName()+" ");
			System.out.println();
		}
	}
	
	//-----------------------------------------------------------
	
	//调用运行时类中指定的属性
	@Test
	public void test3() throws Exception{
		String className="com.wuzhou.test18Rflect.Person";
		Class clazz = Class.forName(className);
		//1.获取指定的属性
		Field name= clazz.getField("name");
		System.out.println(name);
		
		//2.创建运行时类的对象
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		
		//3.将运行时类的指定的属性赋值
		name.set(p, "李宗");
		System.out.println(p);
		
		//当属性权限修饰符为private时
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(p,12);
		System.out.println(p);
	}
	
}
