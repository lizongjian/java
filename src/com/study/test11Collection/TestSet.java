package com.wuzhou.test11Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Collection
 * 		|------List:有序，可重复
 * 				|------ArrayList(主要实现类)
 * 				|------LinkedList(频繁add，remove，set，get操作时用)
 * 				|------Vector(jdk1.0,比较老，线程安全，效率低)
 * 		|------Set：无序(不是随机)，不可重复（常用的方法都是collection接口中定义的）
 * 				|------HashSet(主要实现类)：添加无序，遍历无序。
 * 				|------LinkedHashSet():在添加进LinkedHashSet时，维护对添加进去的顺序。遍历按照添加的顺序，
 * 						添加的时候在内存是无序的。所以插入元素比hashset慢，遍历时候比hashset快。
 * 				|------TreeSet()： 1.添加的元素必须是同一个类
 * 								  2.可以按照添加进集合中的元素指定的顺序遍历。
 * 						                               如:String 包装类默认从小到大遍历。
 * 						          3.自定义类遍历：当你自定义类没有实现comparable接口时，向TreeSet中
 * 							                    添加对象时，会报classcastExcetion异常。
 *                                  注意：TreeSet集合添加对象的顺序由comparable接口中的comparableto方法决定
 *                                4.当向treeset中添加自定义类的对象时，有两种排序方法。
 *                                	①自然排序
 *                                		要求自定义类实现，java.lang.Comparable接口，重写抽象方法ComparableTo(Object o)方法
 *                                		在此方法中指明按照自定义类中哪个属性进行排序。
 *                                		注意：在向treeSet添加属性时，首先按照comparebleto进行比较，一旦返回0，虽然是此属性的
 *                                			值相同，但是程序会认为这两个对象是相同的。后一个对象不能添加进来。
 *                                	②定制排序
 * Map
 */
public class TestSet {
	/**
	 *  无序性：元素在底层存储的位置是无序的。
	 *  不可重复性：当向set中添加重复的元素时，后面的添加不进去。(使用hashcode()方法存放)
	 *  
	 *  说明：要求添加进set中的元素所在的类一定要重些equals()和hashcode()方法
	 *  进而保证set元素的不可重复性！
	 *  
	 *  Set中的元素时如何存储的呢？使用哈希算法。
	 *  (以前的算法：一个一个通过equals比较，是否重复)
	 *  哈希算法：当对象存进内存时，先用当前的对象的hashcode()算出唯一的哈希值，
	 *  哈希值为内存的地址，然后根据地址分配内存。当后来的元素添加进来时，比较哈希值，如果哈希值一样，
	 *  再比较equals，一样则不给添加。这样保证了Set中的不可重复性
	 *  
	 *  要求：hashcode()和equals()要一致。
	 */
	@Test
	public void hashSet(){
		Set set = new HashSet();
		set.add(123);
		set.add("AA");
		set.add(null);
		Person p = new Person("狗", 22);
		Person p1 = new Person("狗", 22);
		set.add(p);
		set.add(p1);
		System.out.println(set);
	}
	
	@Test
	public void treeSet(){
		Set set = new TreeSet();
		Person p0 = new Person("A", 1);
		Person p1 = new Person("C", 22);
		Person p2 = new Person("B", 2);
		Person p3 = new Person("D", 222);
		set.add(p0);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		Iterator iterator= set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
