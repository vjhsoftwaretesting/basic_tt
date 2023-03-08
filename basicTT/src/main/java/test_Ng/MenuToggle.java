package test_Ng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MenuToggle {

	
	@Test
	   public void login_logout() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver",
					"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
			driver.manage().window().maximize();
			
			WebElement userID = driver.findElement(By.id("txtEmail"));
			userID.sendKeys("andrewtest003@mailinator.com");
			
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys("Test123"+Keys.ENTER);
			System.out.println("login success");
			
			
			
			/*WebElement toggleButton = driver.findElement(By.id("mnuToggle"));
			if{*/
				
			
	
	
	
	}	
	
}
