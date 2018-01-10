package com.wuzhou.test20Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

//客户端给服务端发送信息。服务端输出此信息到控制台
//网络编程实际上就是socket编程
public class TestTCP1 {
	//客户端  IP+端口号 组成套接字
	@Test
	public void client(){
		Socket socket =null;
		OutputStream os=null;	
		try {
			//1.创建一个socket对象，通过构造器指明服务端的ip和端口
			socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
			//2.getOutputStream()发送数据，方法返回outputStream对象
			os = socket.getOutputStream();
			//3.具体的输出过程
			os.write("我是客户端".getBytes());
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			//4.关闭流和socket
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//服务端
	@Test
	public void server(){
		ServerSocket serverSocket =null;
		Socket socket=null;
		InputStream is=null;
		try {
			//1.创建serversocket对象，通过构造器指明自身的端口。不用指明IP IP为服务端程序所在的主机IP
			serverSocket = new ServerSocket(9090);
			//2.调用其accept方法，返回一个socket对象。
			socket = serverSocket.accept();
			//3.调用socket对象的getInputStream()方法，获取一个从客户端发送过来的输入流
			is = socket.getInputStream();
			//4.获取流的操作
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.println(str);
			}
			System.out.println("来自"+socket.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
