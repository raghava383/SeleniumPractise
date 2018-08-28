package datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.utility.TestUtil;

public class DemoqaTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/registration/");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void demoqaRegPage(String firstName, String lastName, String phoneNumber, String userName, String email, String password, String confirmPassword ){
		driver.findElement(By.xpath("//*[@id='name_3_firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='name_3_firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id='name_3_lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='name_3_lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//*[@id='phone_9']")).clear();
		driver.findElement(By.xpath("//*[@id='phone_9']")).sendKeys(phoneNumber);
		
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='email_1']")).clear();
		driver.findElement(By.xpath("//*[@id='email_1']")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='password_2']")).clear();
		driver.findElement(By.xpath("//*[@id='password_2']")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id='confirm_password_password_2']")).clear();
		driver.findElement(By.xpath("//*[@id='confirm_password_password_2']")).sendKeys(confirmPassword);

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
