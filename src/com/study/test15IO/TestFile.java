package com.wuzhou.test15IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/**
 * java.io.File类
 * 1.凡是与输入输出相关的类接口等都定义在java.io包下
 * 2.File是一个类 有构造器 创建对象.此对象对应着一个文件（.txt .doc .ppt）或者文件目录(D:/io...)。
 * 3.File类对象是与平台无关的。
 * 4.File中的方法，仅涉及到如何创建一个文件、如何删除，如何重命名。只要涉及文件内容的。File是操作不了的。
 *    	必须由IO流完成。
 * 5.File类的对象常作为io流的具体类的构造器的形参
 */
public class TestFile {
	/**
	 * 路径：
	 * 绝对路径：包括盘符在内的完整文件路径。
	 * 相对路径：在当前文件目录下的文件的路径
	 * 
	 * File类常用方法：
	 * 1.访问文件 getName(),getPath,getAbsoluteFile(),getAbsolutePath,
	 * 			getParent(),renameTo(File newName)
	 * 2.文件检测 exists(),canWrite(),canRead(),isFile(),isDirectory()
	 * 3.文件操作相关 createNewFile(),delete()
	 * 4.文件夹操作相关 mkDir(),mkDirs()当你创建的目录的上层目录不存在时则帮你创建。
	 * 				 list(),listFiles()
	 */
	@Test
	public void test1(){
		File f0 = new File("E:\\io\\hello.txt");
		File f1 = new File("hello.txt");
		
		//1.访问文件
		System.out.println(f0.getName());
		System.out.println(f0.getPath());
		System.out.println(f0.getAbsoluteFile());
		System.out.println(f0.getAbsolutePath());
		System.out.println(f0.getParent());
		System.out.println(f0.renameTo(new File("hello2.txt")));
		
	}
	@Test
	public void test2(){
		File f2 = new File("hello.txt");
		//2.文件检测
		System.out.println(f2.exists());
		System.out.println(f2.canWrite());
		System.out.println(f2.canRead());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		System.out.println(new Date(f2.lastModified()));
		System.out.println(f2.length()+"字节");
	}
	
	@Test
	public void test3(){
		File f3 = new File("hello.txt");
		//3.文件或文件夹操作
		System.out.println(f3.delete());
		try {
			System.out.println(f3.createNewFile());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		File f4 = new File("d:\\io2");
		//如果文件不存在 则执行 (！)
		if(!f4.exists()){
		f4.mkdir();
		}
		
		//列出D盘下的所有文件目录
		File f5 = new File("D:");
		String[] strings=f5.list();
		for(String str : strings){
			System.out.println(str);
		}
	}
}
