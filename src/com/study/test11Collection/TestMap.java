package com.wuzhou.test11Collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
/*
 * Collection接口：
 * 
 * Map接口：
 * 		|------hashMap:主要实现类
 * 		|------linkedHashMap:使用链表维护添加的进Map的顺序，故遍历map时，按照添加的顺序遍历。
 * 		|------TreeMap:按照添加进map中的元素的key的指定属性进行排序。（要求key是同一个类的对象）
 * 		|------HashTable:古老的实现类，线程安全，不建议使用。
 * 				|------Properties:子类，常用来处理属性文件。键和值都是string类型的。
 * 
 * 
 */
public class TestMap {
	/*
	 * 添加删除查询：  Object put() remove putAll clear;
	 * 			  get containsKey containsValue size isEmpty equals
	 * 
	 * 遍历：  Set KeySet():遍历键
	 * 	    Collection values():遍历值
	 *      Set entrySet():遍历一个单元（记录key-vaule）
	 * 
	 * HashMap：1.Key是用Set来存放的，不可重复的。value是用Collection存放的，可重复。
	 * 		        一个key-value对是一个Entry。所有的Entry是用Set存放的，也是不可以重复的。
	 * 			2.向hashMap中添加元素时，会调用key所在类的equals方法，判断两个key是否相同。
	 * 			  若相同，则只能够添加进后添加的那个。
	 * 
	 */
	
	/*
	 * 添加删除查询
	 */
	@Test
	public void method1(){
		Map m = new HashMap();
		m.put(1, 1);
		m.put(2, 12);
		m.put(3, 123);
		m.put(3, 1234);
		m.put(4, 12345);
		m.put(null, null);
		int i=m.size();
		System.out.println(i);
		System.out.println(m);
		m.remove(1);
		System.out.println(m);
	}
	
	/*
	 * 
	 * 遍历Map元素：
	 */
	@Test
	public void method2(){
		Map m = new HashMap();
		m.put(1, 1);
		m.put(2, 12);
		m.put(3, 123);
		m.put(3, 1234);
		m.put(4, 12345);
		m.put(null, null);
		
		//1.遍历key
		Set set=m.keySet();
		Iterator iterator= set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		//2.遍历values
		Collection coll=m.values();
		for(Object object : coll){
			System.out.println(object);
		}
		
		//3.遍历key-vaule (先得到key 再用Set中的get方法获取value)
		Set set1=m.keySet();
		for(Object object : set1){
			System.out.println(object+"---->"+m.get(object));
		}
		
		//3.遍历key-vaule 
		Set set2=m.entrySet();
		for(Object object : set2){
			System.out.println("#"+object);
		}
	
	}
	
		/*
		 * linkedHashMap
		 * 
		 */
		@Test
		public void linkedHashMap(){
			Map m = new LinkedHashMap();
			m.put(1, 1);
			m.put(2, 12);
			m.put(3, 123);
			m.put(3, 1234);
			m.put(4, 12345);
			m.put(null, null);
			
			Set set=m.keySet();
			for(Object object : set){
				System.out.println(object+"----"+m.get(object));
			}
		}
		/*
		 * TreeMap
		 * 
		 */
		@Test
		public void treeMap(){
			Map m = new TreeMap();
			m.put(1, 1);
			m.put(2, 12);
			m.put(3, 123);
			m.put(3, 1234);
			m.put(4, 12345);
			
			Set set=m.keySet();
			for(Object object : set){
				System.out.println(object+"----"+m.get(object));
			}
		}
		
		/*
		 * 
		 * Properties
		 */
		@Test
		public void Properties(){
			Properties p = new Properties();
			try {
				p.load(new FileInputStream(new File("jdbc.properties")));
				String user=p.getProperty("user");
				String password=p.getProperty("password");
				System.out.println(user+"--"+password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
