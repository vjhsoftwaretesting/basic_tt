package test_Ng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Sample1 {
	
	WebDriver driver;
	@Test
	public void timeEntry_approve_perbill () throws InterruptedException {
		
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
		
		
	 	WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();
			
		String oldWindow = driver.getWindowHandle();
		
		WebElement timeEntryButton = driver.findElement(By.xpath("//*[@id='createList']/div/a[1]"));
		timeEntryButton.click();
			
		Set<String> timeEntryWindow = driver.getWindowHandles();
			  
		  for (String newwindow : timeEntryWindow) { driver.switchTo().window(newwindow); }
			 
		Thread.sleep(5000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-choice select2-default']")));
			  
	//calander
		
		String month = "October 2020";
		String day = "2";
		
		
			WebElement date1 = driver.findElement(By.id("imgDateFrom"));
			date1.click();
			
			WebElement dateheader1 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[21]/div[1]/table/thead/tr[1]/th[2]"));
			
			
			WebElement dateheader2 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[20]/div[1]/table/thead/tr[1]/th[2]"));
			
			if(dateheader1.isDisplayed()) {
				dateheader1.click();
			}
			
			else {
				dateheader2.click();
			}
			
			List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//*[@id=\"body\"]/div[20]/div[2]/table/tbody/tr/td"));
	        
	        System.out.println(list_AllMonthToBook);
	        
			
			
	}}
			
			
			/*			
			while (true) {
				String month_year = driver
						.findElement(By.xpath("//*[@id=\"body\"]/div[20]/div[1]/table/thead/tr[1]/th[2]")).getText();
				System.out.println("month is " + month_year);
				
				if (month_year.equals(month)) {
					break;
				}
				else {
					driver.findElement(By.xpath("//*[@id=\"body\"]/div[20]/div[1]/table/thead/tr[1]/th[1]/i")).click();
				}
				
			}
			
			driver.findElement(By.xpath("//*[@id=\"body\"]/div[20]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"+day+")]")).click();
						
	}*/
	
	
	

