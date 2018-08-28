package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		driver.manage().deleteAllCookies();
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[2]/a")).click();
		
		String date = "10-September-2018";
		String dateArray[] = date.split("-"); // {25,February,2018}
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];
		
		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);
		
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[6]/td[7]
		
		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		//3-1 3-2 3-3 3-4 3-5 3-6 3-7
		final int totalWeekDays = 7;
		boolean flag = false;
		String dayVal = null;
		
		for(int rowNum=2; rowNum<7; rowNum++){
			for(int colNum=1; colNum<=totalWeekDays; colNum++){
				try{
					dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText().trim();
				}catch(NoSuchElementException e){
					System.out.println("Please enter a correct date ");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.length()>2){		
					if(dayVal.substring(0, 2).equals(day)){
						driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
						flag = true;
						break;
					}
				}else if(dayVal.equals(day)){
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		//driver.close();
	}

}
