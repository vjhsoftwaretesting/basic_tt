package basicTTLogin_Logout;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLoginLogout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		
		
		driver.findElement(By.id("txtEmail")).sendKeys("andttb04@mailinator.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Test123"+Keys.ENTER);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("myIframe");
		
			System.out.println("shifted to frame");	
			WebElement clientDropDown = driver.findElement(By.xpath("//*[@class='select2-selection__arrow']"));
			Select pick1 = new Select(clientDropDown);
			pick1.selectByIndex(6);
			
			
			WebElement activityDropDown = driver.findElement(By.xpath("//*[@class='select2-selection__arrow']"));
			Select pick2 = new Select(activityDropDown);
			pick2.selectByIndex(5);
			
			
		  WebElement clockIn = driver.findElement(By.xpath("//*[@id=\"btnClockIn\"]"));
		  clockIn.click();
		  
		  Thread.sleep(100000);
		  
		 WebElement clockOut = driver.findElement(By.id("btnClockOut"));
		 clockOut.click();
		  
		  driver.switchTo().defaultContent(); Thread.sleep(2000); 
		  
		  WebElement logout =driver.findElement(By.id("signout")); logout.click();
		  System.out.println("logout success");
		  
		  driver.close();
		
	}

}
