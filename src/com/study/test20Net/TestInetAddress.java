package com.wuzhou.test20Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 网络通信第一要素：IP地址。通过IP地址 唯一的定位互联网上的一台主机
 * InetAddress ：位于java.net包下
 * 1.InetAddress 用来代表IP地址。 一个InetAddress对象就代表着一个IP地址
 * 2.如何创建InetAddress对象 通过静态方法InetAddress.getByName()
 * 3.获取IP地址对应的域名： getHostName()   获取IP地址：getHostAddress()
 * 
 * 网络通信第二要素：协议。
 * OSI七层：
 * 应用层：
 * 表示层：
 * 会话层：
 * 传输层：TCP传输控制协议 ：①建立TCP连接
 * 					   ②三次握手、可靠; 
 * 					   ③TCP通信的两个应用程序：客户端、服务端
 * 					   ④可以传输的数据大
 * 					   ⑤传输完毕，需要释放已建立的连接，效率低
 * 		 UDP用户数据报协议 ： ①把数据、源、目的封装成数据包，不需要建立连接
 * 						 ②每个数据报大小为64K
 * 						 ③不可靠
 * 						 ④发送结束时无需释放资源，速度快		
 * 网络层：IP 网络互联网协议
 * 数据链路层：
 * 物理层：
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet);
		//域名
		System.out.println(inet.getHostName());
		//ip地址
		System.out.println(inet.getHostAddress());
		
		//获取本机IP
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println(localhost);
	}
	
}
