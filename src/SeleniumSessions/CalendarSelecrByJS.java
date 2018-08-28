package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelecrByJS {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().fullscreen(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//driver.get("http://spicejet.com/"); // enter URL
		driver.get("https://www.goindigo.in/");
		//WebElement date = driver.findElement(By.id("view_fulldate_id_1"));
		
		//WebElement date = driver.findElement(By.xpath("//*[@name='indiGoOneWaySearch.DepartureDate']"));
/*		WebElement date = driver.findElement(By.xpath("//input[@name='indiGoOneWaySearch.DepartureDate']"));

		String dateVal = "08 Aug 2018";
		
		selectDateByJS(driver, date, dateVal);*/
		//driver.findElement(By.xpath("//*[@id='oneWay']/form/div[1]/ul/li[2]/input[1]")).sendKeys("Pune");
		//Thread.sleep(3000);
		driver.findElement(
				By.xpath("//i[@class='fa fa-refresh fa-spin vanish']//parent::button[@type='submit']//parent::div[@class='submit_tab custom_search' and @style='outline: 0']"))
				.click();
		
		driver.close();
	}
	
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}
	
}	
