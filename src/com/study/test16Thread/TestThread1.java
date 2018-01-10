package com.wuzhou.test16Thread;

/**
 * Thread的常用方法
 * 1.start()：启动线程 并执行相应的run方法
 * 2.run()：是Thread中的方法；子线程要执行的代码放入run中
 * 3.currentThread()：静态的，调取当前的线程
 * 4.getName():获取线程的名字
 * 5.setName()：设置此线程的名字
 * 6.yieId():调用此方法的线程，释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join()方法，表示，当执行到此方法，A线程停止执行，直至B线程执行完。A线从再继续执行 
 * 8.isAlive():判断当前线程是否存活
 * 9.sleep(long l):显式的让当前线程睡眠l毫秒 
 * 	  注意:被重写的方法，不能抛比父类大的异常。
 * 10.线程通信：wait() notify() notifyAll()
 * 
 * 设置线程的优先级
 * getPriority():返回线程优先值
 * setPriority(int newPriority):改变线程的优先级
 *
 */
class SubThread1 extends Thread{
	public void run(){
		for(int i=1;i<101;i++){
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		//子线程
		SubThread1 st1 = new SubThread1();
		st1.setName("子线程1");
		st1.start();
		st1.setPriority(10);
		st1.setPriority(Thread.MAX_PRIORITY);
		
		//主线程
		Thread.currentThread().setName("=====主线程======");
		for(int i=1;i<101;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
//			if(i%10==0){
//				Thread.currentThread().yield();
//			}
//			if(i==20){
//				try {
//					st1.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(st1.isAlive());
	}
}