package com.wuzhou.test16Thread;

/**
 * 创建一个子线程，完成1-100之间自然数的输出。同样的，主线程
 * 创建多线程的第一种方式：继承Thread类，重写run方法
 *
 */
//1.创建继承于Thread的子类
class SubThread extends Thread{
	//2.重写Thread的run方法,方法内实现此线程要完成的功能
	public void run(){
		for(int i=1;i<101;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		//3.创建子类的对象
		SubThread st1 = new SubThread();
		SubThread st2 = new SubThread();
	
		//4.调用start方法： 启动此线程；调用相应的run方法
		//5.一个线程只能执行一次start()
		st1.start();
		st2.start();
		//st.start();//报错 因为此线程已经开启
		//st.run(); //不能通过Thread实现类对象的run方法启动一个线程
		
		for(int i=1;i<101;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}