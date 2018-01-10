package com.wuzhou.test18DynamicProxy;

//造衣服接口
interface ClothFactory{
	public void productCloth();
}

//被代理类
class NikeColthFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产衣服");
	}
	
}
//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	//创建代理类的对象时，实际传入的是被代理类的对象
	public ProxyFactory(ClothFactory cf) {
		this.cf=cf;
	}
	
	@Override
	public void productCloth() {
		System.out.println("代理类开始执行");
		cf.productCloth();
		System.out.println("代理类执行结束");
	}
	
}
public class TestClothProduct {
	public static void main(String[] args) {
		//创建被代理类对象
		NikeColthFactory ncf = new NikeColthFactory();
		//创建代理类对象      将被代理类对象通过代理类的构造器创建被代理类的实例 
		ProxyFactory pf = new ProxyFactory(ncf);
		pf.productCloth();
		
	}

}
