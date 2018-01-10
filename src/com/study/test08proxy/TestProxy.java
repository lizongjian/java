package com.wuzhou.test08proxy;
//接口应用--代理模式(静态代理)
//我买房子     中介
public class TestProxy {
	public static void main(String[] args) {
		Object object = new ProxyObject();
		object.action();
	}
}
//买房子
interface Object{
	void action();
}
//代理类  ----》  中介 （帮你买房子）
class ProxyObject implements Object{
	Object obj;
	public ProxyObject() {
		System.out.println("代理类创建成功");
		obj=new ObjectImpl();
	}
	public void action() {
		System.out.println("代理类开始执行");
		obj.action();
		System.out.println("代理类执行结束");
	}
}
//被代理类  -----》 我 实现 买房子的接口
class ObjectImpl implements Object{
	public void action() {
		System.out.println("被代理类开始执行");
		System.out.println("操作一");
		System.out.println("操作二");
	}
	
}