package com.wuzhou.test15IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	//对象的序列化过程：将内存中的对象通过ObjectInputSteam转换为二进制流，存储在硬盘中
	@Test
	public void test1(){
		Person p = new Person("李", 22);
		Person p1 = new Person("宗", 22);
		
		ObjectOutputStream oos =null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
			oos.writeObject(p);
			oos.flush();
			oos.writeObject(p1);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	//对象的反序列化过程,
	@Test
	public void testObjectInputStream(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
			Person p1=(Person) ois.readObject();
			
			System.out.println(p1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * 要实现序列化的类
 * 1.要求此类是可序列化的：实现Serializable接口
 * 2.要求属性也要实现serializable接口
 * 3.提供一个版本号
 */

class Person implements Serializable{
	private static final long serialVersionUID = -2043266071472339084L;
	String name;
	Integer age;
	
	public Person(String name,Integer age){
		this.name=name;
		this.age=age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}