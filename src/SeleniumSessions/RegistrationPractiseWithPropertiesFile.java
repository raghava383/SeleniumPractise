package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPractiseWithPropertiesFile {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/registration/");

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/Users/rgupta/eclipse-workspace/SeleniumPractise/src/SeleniumSessions/config.properties");
		prop.load(ip);

		driver.findElement(By.xpath(prop.getProperty("firstName_xpath")))
				.sendKeys(prop.getProperty("firstName"));

		driver.findElement(By.xpath(prop.getProperty("lastName_xpath")))
				.sendKeys(prop.getProperty("lastName"));

		driver.findElement(By.xpath(prop.getProperty("MaritalStatus_xpath")))
				.click();

		driver.findElement(By.xpath(prop.getProperty("hobby1_xpath"))).click();

		driver.findElement(By.xpath(prop.getProperty("hobby2_xpath"))).click();

		Select country = new Select(driver.findElement(By.xpath(prop
				.getProperty("dropDown_xpath"))));
		country.selectByVisibleText(prop.getProperty("Country"));

		Select dob_month = new Select(driver.findElement(By.xpath(prop
				.getProperty("dob_month_xpath"))));
		dob_month.selectByValue(prop.getProperty("dob_month"));

		Select dob_day = new Select(driver.findElement(By.xpath(prop
				.getProperty("dob_day_xpath"))));
		dob_day.selectByValue(prop.getProperty("dob_day"));

		Select dob_year = new Select(driver.findElement(By.xpath(prop
				.getProperty("dob_year_xpath"))));
		dob_year.selectByValue(prop.getProperty("dob_year"));

		driver.findElement(By.xpath(prop.getProperty("phoneNumber_xpath")))
				.sendKeys(prop.getProperty("PhoneNumber"));

		driver.findElement(By.xpath(prop.getProperty("userName_xpath")))
				.sendKeys(prop.getProperty("userName"));

		driver.findElement(By.xpath(prop.getProperty("email_reg_xpath")))
				.sendKeys(prop.getProperty("email"));

		driver.findElement(By.xpath(prop.getProperty("profilePic_xpath")))
				.sendKeys(prop.getProperty("profilePic"));

		driver.findElement(By.xpath(prop.getProperty("description_xpath")))
				.sendKeys(prop.getProperty("description"));

		driver.findElement(By.xpath(prop.getProperty("password_reg_xpath")))
				.sendKeys(prop.getProperty("password_reg"));

		driver.findElement(
				By.xpath(prop.getProperty("confirm_password_reg_xpath")))
				.sendKeys(prop.getProperty("password_reg"));

		Thread.sleep(6000);

		driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();

		Thread.sleep(6000);

		driver.close();
	}

}
