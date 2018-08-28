package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPractise {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
		driver.manage().window().fullscreen();
		
		//text fields
		driver.findElement(By.xpath("//*[@id='name_3_firstname']")).sendKeys("Raghavendra");
		driver.findElement(By.xpath("//*[@id='name_3_lastname']")).sendKeys("Gupta");
		
		//Radio button
		driver.findElement(By.xpath("//*[@id='pie_register']/li[2]/div/div/input[2]")).click();
		
		//Check Box
		driver.findElement(By.xpath("//*[@id='pie_register']/li[3]/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='pie_register']/li[3]/div/div/input[3]")).click();
		
		//Dropdown --> Country
		Select country = new Select(driver.findElement(By.id("dropdown_7")));
		country.selectByVisibleText("India");
		
		//Dropdown --? DOB
		Select month = new Select(driver.findElement(By.id("mm_date_8")));
		month.selectByValue("9");
		
		Select day = new Select(driver.findElement(By.id("dd_date_8")));
		day.selectByValue("12");

		Select year = new Select(driver.findElement(By.id("yy_date_8")));
		year.selectByValue("1987");
		
		//Phone number
		driver.findElement(By.xpath("//*[@id='phone_9']")).sendKeys("919845139946");
		
		//Username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("raghava38121312321");
		
		//Email
		driver.findElement(By.xpath("//*[@id='email_1']")).sendKeys("raghavendra.gupta123@gmail.com");
		
		//Profile pic
		driver.findElement(By.xpath("//*[@id='profile_pic_10']")).sendKeys("/Users/rgupta/Downloads/Picture 037.jpg");
		
		//Password
		driver.findElement(By.xpath("//*[@id='password_2']")).sendKeys("raghava123");
		driver.findElement(By.xpath("//*[@id='confirm_password_password_2']")).sendKeys("raghava123");
		
		//Submit
		driver.findElement(By.xpath("//*[@id='pie_register']/li[14]/div/input")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
