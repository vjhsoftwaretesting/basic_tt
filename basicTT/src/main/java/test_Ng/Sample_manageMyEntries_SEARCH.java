package test_Ng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.testng.annotations.Test;

public class Sample_manageMyEntries_SEARCH {
	
	@Test
	public void timeEntry_approve_perbill () throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com ");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();	
		
		Thread.sleep(1000);
		
	//find the current entry process
			
		
		String cli = "Peter Parker";
		String pro = "Non-Project Related";
		String act = "Training";
		String date = "14/12/2022";
		
			WebElement MangeMyEntriesButton = driver.findElement(By.xpath("//*[@title='Manage My Entries']"));
			MangeMyEntriesButton.click();
			
			WebElement findButton = driver.findElement(By.xpath("//*[@class='ctrl_btn'][@value='Find']"));
			findButton.click();
			
			Thread.sleep(2000);
			//find client
			WebElement clientdrop = driver.findElement(By.xpath("//*[contains(@id,'ddlClients')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
			clientdrop.click();
			
			WebElement searchbox1 =driver.findElement(By.className("select2-search__field"));
			searchbox1.click();
			searchbox1.sendKeys(cli);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();
			
			// find project
			WebElement projectdrop = driver.findElement(By.xpath("//*[contains(@id,'ddlProjects')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
			projectdrop.click();
						
			WebElement searchbox2 =driver.findElement(By.className("select2-search__field"));
			searchbox2.click();
			searchbox2.sendKeys(pro);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();
			
			//find activity
			WebElement activitydrop = driver.findElement(By.xpath("//*[contains(@id,'ddlActivityType')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
			activitydrop.click();
			
			WebElement searchbox3 =driver.findElement(By.className("select2-search__field"));
			searchbox3.click();
			searchbox3.sendKeys(act);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();			
			
			//to date
			WebElement todate = driver.findElement(By.id("txtTo_DateRange"));
			todate.clear();
			todate.sendKeys(date);
			
			
			//from date
			WebElement fromdate = driver.findElement(By.id("txtFrom_DateRange"));
			fromdate.clear();
			fromdate.sendKeys(date);
						

			Thread.sleep(2000);
			//search button
			driver.findElement(By.id("grdMyEntries_Search")).click();
			
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@rowid='0']//child::input")));
			
			//WebElement pendingRowCheckBox = driver.findElement(By.xpath("//*[@rowid='0']//child::input"));
			//pendingRowCheckBox.click();
		
			//WebElement entrySubmitButton = driver.findElement(By.id("submitButton"));
			//entrySubmitButton.click();
			
	}
}
