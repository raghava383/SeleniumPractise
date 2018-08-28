package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException,
			IOException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestingmaterial.com");
		Thread.sleep(5000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyUrl(url);
		}

	}

	private static void verifyUrl(String url) throws IOException {

		try {
			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link
					.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();

			if (httpConn.getResponseCode() == 200) {
				System.out.println(url + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(url + " - " + httpConn.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
