package test_Ng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TTB_CreateProject {
	
	 @Test
	   public void login_logout_break() throws InterruptedException, AWTException {
			
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


			WebElement project = driver.findElement(By.id("mnu_project-home"));
			project.click();
			
			WebElement addProjectButton=driver.findElement(By.xpath("//*[@id=\'vertical-wrapper\']/main/div[1]/div[2]/div[1]/a"));
			addProjectButton.click();
			
			WebElement clientDropDown=driver.findElement(By.id("s2id_ctl00_ContentPlaceHolder1_clientListBox_Select2Hidden"));
			clientDropDown.click();
			
		
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_J);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyRelease(KeyEvent.VK_E);			
			/*
			 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
			 */
			
			
			
			
			
			
			
			
}}
