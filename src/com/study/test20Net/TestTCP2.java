package com.wuzhou.test20Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

//客户端给服务端发送信息，服务端将信息打印到控制台，发送“已收到”给客户端
public class TestTCP2 {
	//客户端
	@Test
	public void client(){
		Socket s=null;
		OutputStream os=null;
		InputStream is=null;
		try {
			s = new Socket(InetAddress.getByName("127.0.0.1"),9098);
			os = s.getOutputStream();
			os.write("我是客户端".getBytes());
			
			//显式告诉服务端 数据已经发完 shutdownOutput()
			s.shutdownOutput();
			
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				String str = new String(b,0,len);
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//服务端
	@Test
	public void server(){
		ServerSocket ss=null;
		Socket s=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			ss = new ServerSocket(9098);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				String str = new String(b,0,len);
				System.out.println(str);
			}
			
			os = s.getOutputStream();
			os.write("已收到".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
				is.close();
				s.close();
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
