package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandle1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
/*		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		driver.findElement(By.xpath("//button[contains(text(),'Dropdown button')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Another action")){
				list.get(i).click();
				break;
			}
		}*/
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail&hl=af&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.findElement(By.xpath("//div[@id='lang-chooser']//div//div//div//content")).click();
//		driver.findElement(By.xpath("//div//content[contains(text(),'‪azərbaycan‬')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@jsname='LgbsSe' and @role='presentation']//div//div//div"));
		System.out.println(list.size());

		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Italiano")){
				list.get(i).click();
				break;
			}
		}
	}

}
