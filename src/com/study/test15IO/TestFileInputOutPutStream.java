package com.wuzhou.test15IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件----》程序 ：输入流 程序----》文件 ：输出流
 * 
 * 1.流的分类： 
 * 按照流向的不同 ： 输入流 输出流
 * 按照处理数据的单位的不同：字节流（视频、音频。。。） 字符流（处理文本文件）
 * 按照角色的不同：节点流（直接作用于文件）、处理流（包装在节点流之上）
 * 
 * 2.IO的体系 
 * 抽象基类 					节点流(文件流) 				缓冲流(处理流)加速节点流处理
 * InputStream				FileInputStrem  			BufferedInputStream
 * OutputStream				FileOutputStream			BufferedOutputStream	
 * Reader					FileReader					BufferedReader
 * Writer					FileWriter					BufferedWriter
 * 				 
 * 						
 * 
 *
 */

public class TestFileInputOutPutStream {
	// 从硬盘中存在的一个文件中读取其内容到程序中。使用FileInputStream
	@Test
	public void testFileInputStream1() throws IOException {
		// 1.创建一个File类的对象。
		File file = new File("hello.txt");
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用它的方法 实现file文件的读取
		/**
		 * read():读取文件的一个字节。当执行到文件结尾时 返回-1。
		 */
		// int b=fis.read();
		// while(b!=-1){
		// System.out.print((char)b);
		// b=fis.read();
		// }
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		// 4.关闭字节流
		fis.close();
	}

	@Test
	public void testFileInputStream2() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testFileInputStream3() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];// 要读取的数据要写入的数组
			int len;// 每次读入到byte中的字节的长度
			while ((len = fis.read(b)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.println((char) b[i]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testOutputStream() {
		// 1.创建一个File对象，表明要写入的文件位置。(输出的物理文件可以不存在 程序会自动创建，若存在，会覆盖原有内容)
		File file = new File("hello2.txt");
		// 2.创建一个FileOutputStream对象 ，将file对象作为形参传递给FileOutputStream构造器中
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// 3.写入的操作
			fos.write(new byte[] { 97 });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					// 4.关闭输出流
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// 从硬盘读取一个文件，写到另一个位置。（文件复制）
	@Test
	public void testInputOutputStream() {
		// 1.提供读入、写出的文件
		File file = new File("hello.txt");
		File file2 = new File("hello2.txt");
		// 2.提供相应的流的对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[5];
			int len;// 每次读了几个
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); 错误的
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 实现文件的复制
	@Test
	public void copyFile(String src, String dest) {
		// 1.提供读入、写出的文件
		File file = new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
		File file2 = new File("C:\\Users\\Administrator\\Desktop\\2.jpg");
		// 2.提供相应的流的对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[20];
			int len;// 每次读了几个
			while ((len = fis.read(b)) != -1) {
				// fos.write(b); 错误的
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testCopyFile(){
		long start=System.currentTimeMillis();
		String src="C:\\Users\\Administrator\\Desktop\\1.jpg";
		String dest="C:\\Users\\Administrator\\Desktop\\2.jpg";
		copyFile(src,dest);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}
