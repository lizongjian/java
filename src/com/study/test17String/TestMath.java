package com.wuzhou.test17String;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class TestMath {

	@Test
	public void test(){
		BigInteger bi = new BigInteger("1234354654776");
		BigInteger bi1 = new BigInteger("1234354654776545435345");
		BigDecimal bd = new BigDecimal("12342342.5454"); 
		System.out.println(bi.add(bi1));
	}
}
