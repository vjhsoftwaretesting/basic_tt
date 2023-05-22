package test_Ng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleScript_MoreAppsAndDownloads {
	
	WebDriver driver;

	@BeforeSuite
	public void login() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://secure.ebillity.com");
		driver.manage().window().maximize();

		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("vpcbmar@mailinator.com ");

		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	}

	@Test
	public void STE() throws InterruptedException, AWTException, UnsupportedFlavorException, IOException {

		WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();

		driver.getWindowHandle();

		WebElement timeEntryButton = driver.findElement(By.xpath("//div[@class='list']/child::a[1]"));
		timeEntryButton.click();

		Set<String> newWindow = driver.getWindowHandles();

		for (String newwindow : newWindow) { driver.switchTo().window(newwindow); }
				
		
		
		 
		//Select date
		/*
		 * try { String day = "20"; String month = "Apr"; String year = "2024"; int
		 * givenYear = Integer.parseInt(year);
		 * 
		 * 
		 * WebElement date = driver.findElement(By.id("calendarIcon")); date.click();
		 * 
		 * WebElement datepickerMiddle1 = driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::th[2]"
		 * )); datepickerMiddle1.click();
		 * 
		 * WebElement datepickerMiddle2 = driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']"
		 * )); String datepickerYear =datepickerMiddle2.getText(); int datepickerYearr =
		 * Integer.parseInt(datepickerYear);
		 * 
		 * if(datepickerYearr>givenYear) { while(true) { String yyear =
		 * driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']"
		 * )).getText();
		 * 
		 * if(yyear.equals(year)) { break; } else {
		 * 
		 * driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='prev']/i"
		 * )).click(); } } }
		 * 
		 * else if (datepickerYearr<givenYear) { while(true) { String yyearr =
		 * driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']"
		 * )).getText();
		 * 
		 * if(yyearr.equals(year)) { break; } else { driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='next']/i"
		 * )).click(); } } } else if (datepickerYear.equals(year)) {
		 * 
		 * }
		 * 
		 * driver.findElement(By.xpath(
		 * "//*[@class='datepicker-months']/table/tbody/tr/td/span[contains(@class,'')][text()='"
		 * +month+"']")).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"
		 * +day+")]")).click(); } catch (Exception e) {
		 * 
		 * }
		 */
		Thread.sleep(10000);
		driver.findElement(By.id("date")).click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Clipboard clipboard = toolkit.getSystemClipboard();    
	    String copiedDate = (String) clipboard.getData(DataFlavor.stringFlavor);
	    
	   
}}
