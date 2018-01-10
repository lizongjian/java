package com.wuzhou.test20Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

public class TestUDP1 {
	//发送端
	@Test
	public void send(){
		DatagramSocket ds=null;
		try {
			ds = new DatagramSocket();
			byte[] b ="发送的数据".getBytes();
			//创建一个数据报：每一个数据报不能大于64k 每一个都记录数据信息 发送端的IP 端口号，以及接收端的ip和端口
			DatagramPacket dp =new DatagramPacket(b,0,b.length,InetAddress.getByName("127.0.0.1"),9090);
			ds.send(dp);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ds.close();
		}
	}
	//接收端
	@Test
	public void rceive(){
		DatagramSocket ds=null;
		DatagramPacket dp=null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			dp = new DatagramPacket(b,0,b.length);
			ds.receive(dp);
			
			String str = new String(dp.getData(),0,dp.getLength());
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			ds.close();
		}
		
		
	}
}
