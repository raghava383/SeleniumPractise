package SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverBasics {
	
	public static void main(String args[]){
/*
		// 1. Firefox browser
		// Gecko Driver
		System.setProperty("webdriver.gecko.driver", "/Users/rgupta/Desktop/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();*/
		
		//2. Chrome Browser
		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch Chrome
		driver.get("http://www.google.com"); // enter URL
		System.out.println("Browser Title: "+driver.getTitle());
		
		//validation point
		if(driver.getTitle().equals("Google")){
			System.out.println("Correct title");
		}else{
			System.out.println("In-correct title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
