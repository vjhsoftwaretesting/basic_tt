package test_Ng;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class SampleScripts {
	
	WebDriver driver;
	@Test
	public void myEntriesTable () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com ");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();	
		
		Thread.sleep(1000);
		
		//manage my entries page
		WebElement MangeMyEntriesButton = driver.findElement(By.xpath("//*[@title='Manage My Entries']"));
		MangeMyEntriesButton.click();
		
		List<WebElement> column = driver.findElements(By.tagName("td"));
		int columncount = column.size();
		System.out.println(columncount);
		
		List<WebElement> row = driver.findElements(By.tagName("tr"));
		int rowcount= row.size();
		System.out.println(rowcount);
	
	}
	}
			
					