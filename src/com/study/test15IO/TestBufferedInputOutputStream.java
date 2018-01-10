package com.wuzhou.test15IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/* *
* 抽象基类 					节点流(文件流) 				缓冲流(处理流)加速节点流处理效率
* InputStream				FileInputStrem  			BufferedInputStream
* OutputStream				FileOutputStream			BufferedOutputStream	(flush)
* Reader					FileReader					BufferedReader	一次读一行(readerLine)
* Writer					FileWriter					BufferedWriter		(flush)
**/
public class TestBufferedInputOutputStream {
	
	//使用BufferedInputStream和BufferedOutputStream实现非文本文件的复制
	@Test
	public void testBuffered(){
	
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			//1.提供读入，写出的文件
			File file0 = new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
			File file1 = new File("C:\\Users\\Administrator\\Desktop\\2.jpg");
			//2.先创建相应的节点流FileInputStream、FileOutputStream
			FileInputStream fis = new FileInputStream(file0);
			FileOutputStream fos = new FileOutputStream(file1);
			//3.将创建的节点流的对象作为参数传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//4.具体的实现文件复制的操作
			byte[] b = new byte[20];
			int len;
			while((len=bis.read(b))!=-1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	@Test
	public void testBufferedReaderWriter() throws Exception{
		File file0 = new File("hello.txt");
		File file1 = new File("hello3.txt");
		
		FileReader fr = new FileReader(file0);
		FileWriter fw = new FileWriter(file1);
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String str=null;
		while((str=br.readLine()) != null){
			System.out.println(str);
		}
	}

}
