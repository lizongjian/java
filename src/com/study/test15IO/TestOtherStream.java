package com.wuzhou.test15IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 转换流 :InputStreamReader、OutputStreamWriter
 * 编码：字符流转换为字节数组
 * 解码：字节数组转为字符串
 */
public class TestOtherStream {
	@Test
	public void test1(){
		//解码
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader bis=null;
		try {
			File file0 = new File("reader.txt");
			fis = new FileInputStream(file0);
			isr = new InputStreamReader(fis,"utf-8");
			bis = new BufferedReader(isr);
			String str;
			while((str=bis.readLine())!=null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 标准的输入输出流：
	 * 标准的输出流：System.out
	 * 标准的输入流：system.in
	 */
	@Test
	public void test2(){
		Scanner s = new Scanner(System.in);
		String str;
		String uc=null;
		
		while(true){
			str=s.next();
			uc=str.toUpperCase();
			/*if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
				break;
			}*/
			System.out.print(uc);
			}
		}
		
	}
	
	
