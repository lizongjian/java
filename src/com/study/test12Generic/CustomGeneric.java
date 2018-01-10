package com.wuzhou.test12Generic;

import java.util.ArrayList;
import java.util.List;

//自定义泛型类
public class CustomGeneric<T> {
	private String name;
	private int id;
	private T t;
	List<T> list = new ArrayList<T>();
	
	//定义泛型方法
	public <E> E getE(E e){
		return e;
	}
	//实现从数组到集合的复制
	public <E> List<E> fromArrayToList(E[] e,List<E> list){
		for(E e1 : e){
			list.add(e1);
		}
		return list;
	}
	public void add(T t){
		list.add(t);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "CustomGeneric [name=" + name + ", id=" + id + ", t=" + t + "]";
	}
	
	

}
