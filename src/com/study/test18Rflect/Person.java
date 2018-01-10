package com.wuzhou.test18Rflect;

@MyAnnotation(value="java")
public class Person extends Creature<String> implements Comparable,MyInterface{
	private static final long serialVersionUID = 2210377988328920893L;
	public String name;
	private int age;
	int id;
	public Person() {
		System.out.println("无参构造器");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@MyAnnotation(value="123")
	public void show(){
		System.out.println("我是一个人");
	}
	
	private void display(String nation) throws Exception{
		System.out.println("我的国籍是："+nation);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class Bird{
		
	}
	
}
