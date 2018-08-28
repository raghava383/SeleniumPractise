package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail&hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		//1. xpath:
		// absolute xpath should not be used --> /form/div[2]/div/div[2]/div[2]/div
		// only relative xpath should be used
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Tom");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Peter");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tom.peter");
		driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input")).sendKeys("tom123");
		driver.findElement(By.xpath("//*[@id='confirm-passwd']/div[1]/div/div[1]/input")).sendKeys("tom123");
		
/*		//2. id:
		driver.findElement(By.id("firstName")).sendKeys("Tom");
		driver.findElement(By.id("lastName")).sendKeys("Peter");
		
		//3. name:
		driver.findElement(By.name("firstName")).sendKeys("Tom");
		driver.findElement(By.name("lastName")).sendKeys("Peter");
		
		
		//4. linkText: this is only for links
		driver.findElement(By.linkText("Help")).click();
		
		//5. partialLinkText: not useful
		driver.findElement(By.partialLinkText("How to pick")).click();
		
		//6. CSSSelector: two ways, id is there --> #{id},
		 							class is there --? .{className}
		driver.findElement(By.cssSelector("#firstName")).sendKeys("467, VP Nagar");*/
		
		//7. className: not useful
		driver.findElement(By.className("Bgzgmd")).click();
	}

}
