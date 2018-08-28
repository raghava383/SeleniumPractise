package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] rags) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("http://html.com/input-type-file/");
		driver.findElement(By.xpath("//*[@id='fileupload']"))
				.sendKeys(
						"/Users/rgupta/Downloads/UMASS MRDA ETL Statistics 20180715.pdf");
	}

}
