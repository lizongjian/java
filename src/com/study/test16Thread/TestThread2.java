package com.wuzhou.test16Thread;

//创建两个子线程 一个输出1-100的偶数 一个输出1-100的奇数
public class TestThread2 {
	public static void main(String[] args) {
//			Even even = new Even();
//			Odd odd = new Odd();
//			even.start();
//			odd.start();
			
			//继承于Thread类的匿名类的对象
			new Thread(){
				public void run(){
					for(int i=1;i<=100;i++){
						if(i%2==0){
							Thread.currentThread().setName("偶数子线程");
							System.out.println(Thread.currentThread().getName()+":"+i);
						}
					}
				}
			}.start();
			
			//继承于Thread类的匿名类的对象
			new Thread(){
				public void run(){
					for(int i=1;i<=100;i++){
						if(i%2!=0){
							Thread.currentThread().setName("奇数子线程");
							System.out.println(Thread.currentThread().getName()+":"+i);
						}
					}
				}
			}.start();
	}
}

//输出偶数的子线程
//class Even extends Thread{
//	public void run(){
//		for(int i=1;i<=100;i++){
//			if(i%2==0){
//				Thread.currentThread().setName("偶数子线程");
//				System.out.println(Thread.currentThread().getName()+":"+i);
//			}
//		}
//	}
//}
//输出奇数的子线程
//class Odd extends Thread{
//	public void run(){
//		for(int i=0;i<=100;i++){
//			if(i%2!=0){
//				Thread.currentThread().setName("奇数子线程");
//				System.out.println(Thread.currentThread().getName()+":"+i);
//			}
//		}
//	}
//}