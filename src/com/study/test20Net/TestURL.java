package com.wuzhou.test20Net;

import java.net.MalformedURLException;
import java.net.URL;

//URL:统一资源定位符，一个URL对象表示互联网上的一个资源
public class TestURL {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.liudu.com/8/8120/index.html");
		System.out.println(url.getProtocol());
	}
}
