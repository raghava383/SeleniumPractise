package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropertiesFile {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();

		FileInputStream ip = new FileInputStream(
				"/Users/rgupta/eclipse-workspace/SeleniumPractise/src/SeleniumSessions/config.properties");

		prop.load(ip);

		System.out.println(prop.getProperty("name"));

		System.out.println(prop.getProperty("age"));

		String url = prop.getProperty("URL");

		System.out.println(url);

		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/rgupta/Desktop/Selenium/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/rgupta/Downloads/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.internetexplorer.driver",
					"/Users/rgupta/Downloads/geckodriver");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

		// login

		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(
				prop.getProperty("username"));

		driver.findElement(By.xpath(prop.getProperty("password_xpath")))
				.sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
	}

}
