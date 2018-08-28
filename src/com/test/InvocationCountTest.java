package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount=10)
	public void sum(){
		int a=10, b=20, c;
		c=a+b;
		System.out.println("sum of a, b is: "+c);
	}
}
