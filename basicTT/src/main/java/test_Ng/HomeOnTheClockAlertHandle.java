package test_Ng;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeOnTheClockAlertHandle {
	
	@Test
	   public void onTheClockAlert () throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver",
					"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
			driver.manage().window().maximize();
			
			WebElement userID = driver.findElement(By.id("txtEmail"));
			userID.sendKeys("andttb01@mailinator.com");
			
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys("Test123"+Keys.ENTER);
			System.out.println("login success");
			
			String oldWindow = driver.getWindowHandle();
			
			WebElement OnTheClockButton = driver.findElement(By.xpath("//*[@title='On the Clock']"));
			OnTheClockButton.click();
			
			
			
			Set<String> alertWindow = driver.getWindowHandles();
			
			for (String newwindow : alertWindow) {
				driver.switchTo().window(newwindow);
				}
			
			
			WebElement next = driver.findElement(By.xpath("//*[@title='Stop Walk-thru']"));
			next.click();

			WebElement ReportsButton = driver.findElement(By.xpath("//*[@title='Reports']"));
			ReportsButton.click();
			//Thread.sleep(2000);

}
	
}
