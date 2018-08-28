package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		// HtmlUnitDriver is not available in Selenium 3.x version
		// HtmlUnitDriver -- to use this concept we need to download HtmlUnitDriver jar file
		
		//advantages:  1. Testing is happening behind the scene - no browser is launched
					// 2. Very fast : execution of test cases -- very fast -- performance of the script
					// 3. not suitable for Action class - user actions - mouse movement, doubleClick, drag and drop
					// 4. Ghost Driver -- Headless Browser:
							// HtmlUnitDriver -- Java
							// PhantomJS - JavaScript
		
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		System.out.println("Before login, title is: "+driver.getTitle());
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("After login, title is: "+driver.getTitle());
	}

}
