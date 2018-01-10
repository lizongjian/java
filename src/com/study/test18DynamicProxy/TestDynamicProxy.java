package com.wuzhou.test18DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用
interface Subject{
	void action();
}

//被代理类
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("我是被代理类");
	}
}

//动态创建代理类
class MyInvocationHandler implements InvocationHandler{
	Object obj;//实现了接口的被代理类的对象的
	//①给被代理类的对象实例化 ②返回一个代理类的对象
	public Object blind(Object obj){
		this.obj=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	//当通过代理类的对象发起对被重写的方法调用时，都被转化为对如下的invoke方法的调用。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//method 这个方法的返回值
		Object returnValue = method.invoke(obj, args);
		return returnValue;
	}

	
	
}

public class TestDynamicProxy {
	public static void main(String[] args) {
		//1.创建被代理类对象
		RealSubject read = new RealSubject();
		//2.创建一个实现了InvocationHandler接口的类的对象
		MyInvocationHandler mih = new MyInvocationHandler();
		//3.调用bland方法 动态的返回一个同样实现了read所在类实现的接口Subject的代理类的对象。
		Object obj= mih.blind(read);
		Subject sub = (Subject)obj;//此时的sub就是代理类的对象
		
		sub.action();//转到对InvocationHandler接口的实现类的invoke方法的调用
		
		//再举一个例子
		NikeColthFactory ncf = new NikeColthFactory();
		ClothFactory cf = (ClothFactory)mih.blind(ncf);
		cf.productCloth();
	}
}
