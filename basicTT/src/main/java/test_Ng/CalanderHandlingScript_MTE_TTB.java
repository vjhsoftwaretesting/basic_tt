package test_Ng;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalanderHandlingScript_MTE_TTB {
	
	WebDriver driver;
	@Test
	public void timeEntry_approve_perbill () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
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
			 
		Thread.sleep(8000);
		
		
	//calander
		
		String day = "02";	
		String monthh = "Oct";
		String yearr = "1996";
			int givenYear = Integer.parseInt(yearr);

			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("calendarIcon")));
			WebElement date = driver.findElement(By.id("calendarIcon"));
			date.click();

			Thread.sleep(2000);
			
			WebElement datepickerMiddle1 = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::th[2]"));
			datepickerMiddle1.click();
			
			WebElement datepickerMiddle2 = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']"));
			String datepickerYear =datepickerMiddle2.getText();
			int datepickerYearr = Integer.parseInt(datepickerYear);
			
			if(datepickerYearr>givenYear) {
				while(true) {
					String yyear = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']")).getText();
									
					if(yyear.equals(yearr)) {
						break;
					}
					else {
						
					driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='prev']/i")).click();
					}
				}
			}
			
			else if (datepickerYearr<givenYear) {
				while(true) {
					String yyearr = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']")).getText();
					
					if(yyearr.equals(yearr)) {
						break;
					}
					else {
						driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='next']/i")).click();
					}
				}
			}
			else if (datepickerYear.equals(yearr))  {
					
				}
					
			driver.findElement(By.xpath("//*[@class='datepicker-months']/table/tbody/tr/td/span[contains(@class,'')][text()='"+monthh+"']")).click();
			
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"+day+")]")).click();
			

			
		
		}

		
}
