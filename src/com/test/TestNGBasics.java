package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
/*	@BeforeSuite - setup system property for chrome -- I
	@BeforeTest - launch chrome browser -- II
	@BeforeClass - login to app -- III
	
	@BeforeMethod - enter URL -- 4
	@Test - google logo test
	@AfterMethod - logout from app
	
	@BeforeMethod - enter URL
	@Test - Google title test
	@AfterMethod - logout from app
	
	@BeforeMethod - enter URL
	@Test - search test
	@AfterMethod - logout from app
	
	@AfterClass - close browser
	@AfterTest - delete All cookies
*/

	//pre-conditions annotations -- starting with @Before
	@BeforeSuite //1
	public void setUp(){
		System.out.println("@BeforeSuite - setup system property for chrome");
	}

	
	@BeforeTest //2
	public void launchBrowser(){
		System.out.println("@BeforeTest - launch chrome browser");
	}
	
	
	@BeforeClass //3
	public void login(){
		System.out.println("@BeforeClass - login to app");
	}

	
	@BeforeMethod //4
	public void enterURL(){
		System.out.println("@BeforeMethod - enter URL");
	}
	/*
	@BeforeMethod
	@Test -1
	@AfterMethod
	
	@BeforeMethod
	@Test -2
	@AfterMethod
	
	@BeforeMethod
	@Test -3
	@AfterMethod
	*/
	
	
	//test cases -- starting with @Test
	@Test //5
	public void googleTitleTest(){
		System.out.println("@Test - Google title test");
	}
	
	@Test
	public void searchTest(){
		System.out.println("@Test - search test");
	}
	
	@Test
	public void googleLogoTest(){
		System.out.println("@Test - google logo test");
	}
	
	//post conditions -- starting with @After
	@AfterMethod //6
	public void logOut(){
		System.out.println("@AfterMethod - logout from app");
	}
	
	@AfterClass //7
	public void closeBrowser(){
		System.out.println("@AfterClass - close browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies(){
		System.out.println("@AfterTest - delete All cookies");
	}
}
