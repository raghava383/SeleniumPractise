package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click(); //click on Go button
		Thread.sleep(1000);
		//Handle popup alerts
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());	
		String text = alert.getText();
		if(text.equals("Please enter a valid user name")){
			System.out.println("Correct alert message");
		}else{
			System.out.println("In-correct alert message");
		}
		alert.accept(); // click on OK button
		//alert.dismiss(); // click on Cancel button
	}

}
