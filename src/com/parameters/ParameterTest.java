package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;
	
	@Test
	@Parameters({"browser","url","emailId"})
	public void yahooLoginTest(String browser, String url, String emailId){
		if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
			driver = new ChromeDriver();
		}else if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/rgupta/Desktop/Selenium/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id='login-username']")).clear();
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailId);
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
		
	}
}
