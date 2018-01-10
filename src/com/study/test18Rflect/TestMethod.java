package com.wuzhou.test18Rflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestMethod {
	//1.获取运行时类的方法
	@Test
	public void test(){
		Class clazz = Person.class;
		//1.getMethods():获取运行时类和所有父类的public的方法
		Method[] me = clazz.getMethods();
		for(Method m : me){
			System.out.println(m);
		}
		System.out.println();
		//2.getDeclaredMethods():获取本类声明的所有方法 (不包括父类)
		Method[] me1 = clazz.getDeclaredMethods();
		for(Method method : me1){
			System.out.println(method);
		}
	}

	//方法结构：注解 权限修饰符 返回值类型 方法名 参数列表  throws的异常
	@Test
	public void test2(){
		
	}
	
	
	//----------------------------------------------------
	//调用运行时类指定的方法
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		Method m1=clazz.getMethod("show");
		System.out.println(m1);
		
		Person p = (Person) clazz.newInstance();
		//返回值对应你调用的方法的返回值
		Object returnValue = m1.invoke(p);
		System.out.println(returnValue);
		
	    Method m2= clazz.getMethod("toString");
	    Object returnValue1=m2.invoke(p);
	    System.out.println(returnValue1);
	    
	    //调用静态方法或属性 不用实例化对象也能调用
	}
	
}
