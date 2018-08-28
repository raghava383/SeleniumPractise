package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total no.of rows: "+(rows.size()-1));
		int rownCount = rows.size();
		//*[@id='customers']/tbody/tr[2]/td[1]
		//*[@id='customers']/tbody/tr[3]/td[1]
		String beforeXpath_company = "//*[@id='customers']/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		
		//*[@id='customers']/tbody/tr[2]/td[2]
		//*[@id='customers']/tbody/tr[3]/td[2]
		String beforeXpath_contact = "//*[@id='customers']/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		//*[@id='customers']/tbody/tr[2]/td[3]
		//*[@id='customers']/tbody/tr[3]/td[3]
		String beforeXpath_country="//*[@id='customers']/tbody/tr[";
		String afterXpath_country="]/td[3]";
		
		Xls_Reader reader = new Xls_Reader("/Users/rgupta/eclipse-workspace/SeleniumPractise/src/testdata/EbayTestData.xlsx");
		if(!reader.isSheetExist("WebTableDemo")){
			reader.addSheet("WebTableDemo");
			reader.addColumn("WebTableDemo", "Company");
			reader.addColumn("WebTableDemo", "Contact");
			reader.addColumn("WebTableDemo", "Country");
		}
		
		for(int i=2; i<=rownCount; i++){
			String actualXpath_company = beforeXpath_company+i+afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);
			reader.setCellData("WebTableDemo", "Company", i, companyName);
			
			String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);
			reader.setCellData("WebTableDemo", "Contact", i, contactName);
			
			String actualXpath_country = beforeXpath_country+i+afterXpath_country;
			String countryName = driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println(countryName);
			reader.setCellData("WebTableDemo", "Country", i, countryName);

		}
	}

}
