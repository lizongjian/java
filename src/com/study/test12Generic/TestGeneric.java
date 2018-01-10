package com.wuzhou.test12Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/*
 * 泛型的使用
 * 1.在集合中使用泛型
 * 2.自定义泛型类或接口、以及泛型方法。
 * 3.泛型和继承的关系。
 * 4.通配符
 * 
 * 注意：不能在static方法和catch语句中中使用泛型
 * 
 * 
 */
public class TestGeneric {
	//1.集合中没使用泛型时
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add(89);
		list.add(90);
		list.add(98);
		//没有使用泛型时 任何Object对象及子类都可以加入
		list.add(new String("11"));
		
		for(int i=0;i<list.size();i++){
			//每次要都强转
			int j=(int)list.get(i);
			System.out.println(j);
		}
	}
	
	//2.集合中使用泛型
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		//list.add("11"); 
	
		/*for(Integer i :list){
			System.out.println(i);
		}*/
		
		Iterator<Integer> iterator= list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	//2.1map中使用泛型
	@Test
	public void test3(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "爱惜");
		map.put(2, "珍奥");
		
		Set<Entry<Integer,String>> set= map.entrySet();
		for(Entry<Integer,String> o: set){
			System.out.println(o);
		}
		
	}
	
	//2.2.自定义泛型类的使用
	@Test
	public void test4(){
		CustomGeneric<String> customGeneric = new CustomGeneric<String>();
		
		//2.3.泛型方法的调用
		Double double1=customGeneric.getE(3.4);
		
		//2.4.泛型方法的使用
		Integer[] i=new Integer[]{1,2,3,4,5,6};
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2=customGeneric.fromArrayToList(i, list);
		System.out.println(list2);
	}
	
	
	@Test
	public void test5(){
		/*
		 * 3.泛型和继承的关系
		 * 若类A是类B的子类那么List<A>就不是List<B>的子接口
		 */
		Object obj =null;
		String str="A";
		obj=str;
		
		Object[] obj1=null;
		String[] str1=new String[5];
		str1[0]="a";
		str1[1]="b";
		str1[2]="c";
		str1[3]="d";
		str1[4]="e";
		obj1=str1;
		
		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
		//List1 不是list的子类 他们是并列关系
		//list=list1;
				
		
	}
	
	/*
	 * 4.通配符 ?
	 * 4.1--- List<A>、List<B>、。。。。都是List<?>的子类
	 * 
	 * 4.2--- ? extends A ：可以存放A以及子类 (小于等于A)
	 * 4.3---? super A： 可以存放A以及父类(大于等于A)
	 */
	public void test6(){
		List<?> list = null;
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		//4.1子类对象赋值给父类的引用。（多态）
		list=list1;
		list=list2;
		
		show(list1);
		//show(list2);
		show1(list2);
		
		//4.2? extends A ：可以存放A以及子类
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3=list4;
		//list3=list1;
		
		//4.3---? super A： 可以存放A以及父类
		List<? super Number> list5 = null;
		list5=list1;
	}
	
	public void show(Collection<Object> coll){
		
	}
	public void show1(Collection<?> coll){
		
	}
	
	
	//通配符使用注意
	@Test
	public void test7(){
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("b");
		list.add("c");
		
		//允向声明为通配符的集合类中读取对象
		List<?> list2 = list;
		Iterator<?> iterator= list2.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		//不允向声明为通配符的集合类中写入对象 。唯一可以存的是null
		//list2.add("123");
	}
	
}
