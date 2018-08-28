package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {

		// 1. alerts --> JavaScript pop up - Alert API (accept, dismiss)
		// 2. File upload pop up --> Browse button (type = file, sendKeys(path) )
		// 3. Browser Window pop up --> Advertisement pop up (windowHandler API - getWindowHandles() )
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		Thread.sleep(2000);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id: "+parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child window id: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		System.out.println("child window pop up title: "+driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println("parent window title: "+driver.getTitle());
	}

}
