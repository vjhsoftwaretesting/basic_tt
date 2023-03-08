package test_Ng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeEntryBill {

	@Test
	public void loginLogoutActivity() throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");

		driver.findElement(By.id("txtEmail")).sendKeys("andttb04@mailinator.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Test123" + Keys.ENTER);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		Thread.sleep(2000);

		driver.switchTo().frame("myIframe");

		System.out.println("shifted to frame");

		
		
		/*
		 * WebElement
		 * clientDropdown=driver.findElement(By.id("select2-clientsSelect2-container"));
		 * clientDropdown.click();
		 * 
		 * System.out.println("cdd selected");
		 * 
		 * WebElement clientSearchBox = driver.findElement(By.xpath(
		 * "/html/body/span/span/span[1]/input"));
		 * clientSearchBox.sendKeys("Jane Froster");
		 * 
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		  
		
		
		/*
		 * WebElement activityDropdown=driver.findElement(By.id(
		 * "select2-activitiesSelect2-container")); activityDropdown.click();
		 * 
		 * System.out.println("add selected");
		 * 
		 * WebElement clientSearchBox = driver.findElement(By.xpath(
		 * "/html/body/span/span/span[1]/input")); clientSearchBox.sendKeys("Design");
		 * 
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		
		 driver.findElement(By.id("select2-activitiesSelect2-container")).click(); 
		 		
		
		
			/*
			 * Thread.sleep(1000); WebElement activityDropdown=driver.findElement(By.xpath(
			 * "//*[@id=\'clientActivitySelector\']/div[2]/span[2]/span[1]/span/span[2]"));
			 * activityDropdown.click(); WebElement
			 * activitySearchBox=driver.findElement(By.xpath(
			 * "/html/body/span/span/span[1]/input"));
			 * activitySearchBox.sendKeys("meeting"+Keys.ENTER);
			 */


		

		/*
		 * WebElement clockIn = driver.findElement(By.id("btnClockIn"));
		 * clockIn.click();
		 * 
		 * Thread.sleep(100000);
		 * 
		 * WebElement clockOut = driver.findElement(By.id("btnClockOut"));
		 * clockOut.click();
		 * 
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * WebElement logout =driver.findElement(By.id("signout")); logout.click();
		 * System.out.println("logout success");
		 */
		// driver.close();

	}

}
