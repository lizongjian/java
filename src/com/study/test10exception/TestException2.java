package com.wuzhou.test10exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestException2 {
	public static void main(String[] args) {
		try {
			method();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void method() throws IOException{
		FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b;
		while((b=fis.read())!=-1){
			System.out.println((char)b);
		}
		fis.close();
	}
}
