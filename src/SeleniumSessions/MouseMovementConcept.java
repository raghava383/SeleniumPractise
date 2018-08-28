package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] sush) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver.get("http://spicejet.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("MENU"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Tariffs")).click();
	}

}
