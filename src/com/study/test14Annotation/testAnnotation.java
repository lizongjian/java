package com.wuzhou.test14Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解： 1.JDK提供的常用注解
 * 
 * @override:重写
 * @deprecated：过时
 * @SuppressWarnings:抑制编译器警告 2.如何自定义注解 3.元注解
 *
 */
public class testAnnotation {
	public static void main(String[] args) {
		Person p = new Student();
		p.walk();
		
		@SuppressWarnings({ "rawtypes", "unused" })
		List list = new ArrayList();
}
}
@CustomAnnotation(value="")
class Student extends Person{
	@Override
	public void eat() {
		System.out.println("学生吃饭");
	}
	@Override
	public void walk() {
		System.out.println("学生走路");	
	}
}

class Person{
	String name;
	String age;

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	@Deprecated
	public void walk(){
		System.out.println("走路");
	}
	public void eat(){
		System.out.println("吃饭");
	}
}
