package com.wuzhou.test11Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

/*
 * 操作集合（Collection以及Map）的工具类：Collections
 * 
 * Collections中的方法：
 * reverse(List):反转List中的元素顺序
 * shuffle(List):对List集合元素进行随机排序
 * sort(List):根据元素的自然排序对指定的List集合元素按升序排序
 * sort(List,Comparator):根据指定的Coparator产生的顺序对List集合元素进行排序
 * swap(List,int,int):将指定List中的i处元素和j处元素交换
 */
public class TestCollections {
	@Test
	public void test(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(789);
		list.add(12);
		list.add(12);
		
		//反转
		Collections.reverse(list);
			System.out.println(list);
		
			//随机排序
		Collections.shuffle(list);	
		System.out.println(list);
		
		//交换
		Collections.swap(list, 0, 1);
		System.out.println(list);
		
		//获取Collection中最大值
		Object object=Collections.max(list);
		System.out.println(object);
		
		//Collection中某元素出现的次数
		int i=Collections.frequency(list, 12);
		System.out.println(i);
		
		//void copy(list dest,list src):将src的内容复制到dest中
		//List list2 = new ArrayList(); indexOutofboundsException：因为原来的长度为0
		List list2 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list2,list);
		System.out.println(list2);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List list = new ArrayList();
		int count=0;
		System.out.println("输入十个数字");
		for(int i =0;i<10;i++){
			count=scanner.nextInt();
			list.add(count);
		}
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}
	
	
	
	
}
