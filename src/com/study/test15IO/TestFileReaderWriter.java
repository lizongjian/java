package com.wuzhou.test15IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {
	@Test
	public void testFileReader(){
		File file = new File("reader.txt");
		FileReader fileReader = null;
		try {
			fileReader= new FileReader(file);
			char[] c = new char[5];//读取文件到字符数组
			int len;
			while((len=fileReader.read(c))!=-1){
				for(char ch : c){
					System.out.println(ch+"##");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fileReader!=null){
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//FileReader和FileWriter 实现文本文件的复制 
	public void testCopyFile1(){
		File file0 = new File("reader.txt");
		File file1 = new File("Writer.txt");
		FileReader fr =null;
		FileWriter fw=null;
		try {
			fr = new FileReader(file0);
			fw = new FileWriter(file1);
			char[] c = new char[24];
			int len;
			while((len=fr.read(c))!=-1){
				fw.write(c, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
