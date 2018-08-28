package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPathConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		//absolute xpath: //*[@id='nav-search']/form/div[2]/div/input --> not recommended
		// dis advantages of absolute xpath: 1. Performance issue
										   //2. Not reliable
										   //3. Can be changed at any time in future 
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java");
		
		//driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Java");
		
		//driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextb')]")).sendKeys("Java");
		
		//dynamic id
		//id=test_456
		//By.id("test_456")
//		driver.findElement(By.xpath("//input[contains(@id,'test_']")).sendKeys("Test");
		
		//starts-with
		//id=test_789
		//id=test_123
		//id=test_test_789_test
//		driver.findElement(By.xpath("//input[starts-with(@id, 'test_')]")).sendKeys("Test");
		
		//ends-with
		//id=123_test_t
		//id=456_test_t
		//id=test_34_test_t
//		driver.findElement(By.xpath("//input[ends-with(@id, '_test_t']")).sendKeys("Test");
		
		//for links: custom xpath
		//all the links are represented by <a> html tag:
		driver.findElement(By.xpath("//a[contains(text(), 'Sell')]")).click();
		
		
	}

}
