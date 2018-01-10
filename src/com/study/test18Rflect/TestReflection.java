package com.wuzhou.test18Rflect;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {
	//在没有反射之前，如何创建一个对象，并调用方法、属性。
	@Test
	public void test1(){
		Person p = new Person();
		p.setAge(12);
		p.setName("李");
		System.out.println(p);
	}
	
	//有反射之后，通过反射创建类的对象
	@Test
	public void test2() throws Exception{
		Class clazz= Person.class;
		
		//1.创建clazz对应的运行时类Person类的对象
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		//2.通过反射，获取运行时类中的结构（属性 方法）只能获取public的
		// getDeclaredField() 获取只要类声明的方法
		Field field1= clazz.getField("name");
		Field field2= clazz.getDeclaredField("age");
		field2.setAccessible(true);
		
		field1.set(p,"李宗键");
		field2.set(p,22);
		System.out.println(p);
		
		//3.通过反射，获取运行时类中的方法. 方法签名（方法名，参数列表）
		Method method = clazz.getMethod("show");
		method.invoke(p);
		
		Method method1 = clazz.getMethod("display", String.class);
		method1.invoke(p, "HK");
	}
	
	
	@Test
	public void test3(){
		Person p = new Person();
		Class clazz = p.getClass();//通过运行时类的对象，调用其getClass方法返回其运行时类。
		System.out.println(clazz);
	}
	
	/*
	 * java.lang.Class 它是反射源头
	 * 我们创建了一个类，通过编译（javac.exe），生成对应的.class文件，之后我们使用java.exe
	 * 加载（JVM类加载器完成的）此.class文件。此.class文件加载到内存以后，就是一个运行时类。存放
	 * 在缓存区。那么这个运行时类本身就是一个大的Class的实例！
	 * 1.每一个运行时类只加载一次!
	 * 2.有了Class的实例之后，我们才可以进行如下的操作：
	 * 		1）*创建对应的运行时类的对象
	 * 		2）可以获取对于的运行时类的完整结构（属性、方法、构造器、内部类、父类，所在包、异常、注解等）
	 * 		3）*调用对于的运行时指定的结构（属性、方法、构造器） 
	 * 		4）反射的应用：动态代理
	 */
	
	/*
	 * 如何获取Class类的实例   有 3种方式
	 */
	@Test
	public void test4() throws ClassNotFoundException{
		//方式1.调用运行时类本身的.class属性
		Class clazz= Person.class;
		System.out.println(clazz.getName());
		
		Class clazz1= String.class;
		System.out.println(clazz1.getName());
		
		//方式2.通过运行时类的对象获取
		Person p = new Person();
		Class clazz2= p.getClass();
		System.out.println(clazz2.getName());
		
		//方式3.通过Class中的静态方法 Class.forName(); 要求全类名
		Class clazz3=Class.forName("java.lang.String");
		System.out.println(clazz3.getName());
		
		System.out.println(clazz==clazz2);//true 	
		
		
		
		//4.（了解）通过类的加载器
		ClassLoader cl= this.getClass().getClassLoader();
		Class clazz4= cl.loadClass("java.lang.Object");
		System.out.println(clazz4.getName());
		
		
		
	}

	//关于类的加载器：Classloader
	@Test
	public void test5() throws IOException{
		//系统加载器
		ClassLoader cl1= ClassLoader.getSystemClassLoader();
		System.out.println(cl1);
		
		//扩展类加载器
		ClassLoader cl2= cl1.getParent();
		System.out.println(cl2);
		
		//引导类加载器 加载核心类库 不能直接获取
		ClassLoader cl3= cl2.getParent();
		System.out.println(cl3);
		
		
		//掌握如下 获取类加载器之后能干嘛
		System.out.println(this+"----------");
		ClassLoader cl=this.getClass().getClassLoader();
		InputStream is= cl.getResourceAsStream("com\\wuzhou\\test18Rflect\\jdbc.properties");
		Properties p = new Properties();
		p.load(is);
		String user = p.getProperty("user");
		System.out.println(user);
	}
		
		
		
}
