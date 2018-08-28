package datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {

		//webdriver code
		System.setProperty("webdriver.chrome.driver",
				"/Users/rgupta/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&co_partnerId=0&UsingSSL=1&rv4=1&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1");
		
		driver.get("http://demoqa.com/registration/");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Data Driven approach(Parameterization) -- used to create data driven framework, driving the data from excel
		//get data from excel
		Xls_Reader reader = new Xls_Reader(
				"/Users/rgupta/eclipse-workspace/SeleniumPractise/src/testdata/EbayTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "status");

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("===============");
			String firstname = reader
					.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);

			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);

			String email = reader.getCellData("RegTestData", "email", rowNum);
			System.out.println(email);

			String password = reader.getCellData("RegTestData", "password", rowNum);
			System.out.println(password);

/*			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(
					firstname);

			driver.findElement(By.xpath("//*[@id='lastname']")).clear();
			driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(
					lastname);

			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
					email);

			driver.findElement(By.xpath("//*[@id='PASSWORD']")).clear();
			driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys(
					password);*/
			
			driver.findElement(By.xpath("//*[@id='name_3_firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='name_3_firstname']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//*[@id='name_3_lastname']")).clear();
			driver.findElement(By.xpath("//*[@id='name_3_lastname']")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//*[@id='email_1']")).clear();
			driver.findElement(By.xpath("//*[@id='email_1']")).sendKeys(email);
			
			driver.findElement(By.xpath("//*[@id='password_2']")).clear();
			driver.findElement(By.xpath("//*[@id='password_2']")).sendKeys(password);
			
			boolean status = reader.setCellData("RegTestData", "status", rowNum, "Fail"); //write data into excel sheet
			System.out.println(status);
		}
		driver.quit();
	}
}
