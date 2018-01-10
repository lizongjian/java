package com.wuzhou.test05;

public class TestAnimal {
	public static void main(String[] args) {
		TestAnimal t =new TestAnimal();
		
		t.func(new Animal());
		t.func(new Dog());
		t.func(new Cat());
	}
	
	public void func(Animal a){
		//子类重写的方法
		a.eat();
		a.jump();
		//子类本身的方法
		if(a instanceof Dog){
			Dog d = (Dog)a;
			d.Wang();
		}
		if(a instanceof Cat){
			Cat c = (Cat)a;
			c.Miao();
		}
		
	}
	
//	public void function(Dog a){ 没有多态的时候
//		a.eat();
//		a.jump();
//	}
}
class Animal{
	String name;
	int age;
	
	public void eat(){
		System.out.println("动物进食");
	} 
	public void jump(){
		System.out.println("动物跳");
	} 
}
class Dog extends Animal{
	public void eat(){
		System.out.println("狗进食");
	} 
	public void jump(){
		System.out.println("狗跳");
	} 
	public void Wang(){
		System.out.println("汪汪");
	}
	

}

class Cat extends Animal{
	public void eat(){
		System.out.println("猫进食");
	} 
	public void jump(){
		System.out.println("猫跳");
	} 
	public void Miao(){
		System.out.println("喵喵");
	}
}