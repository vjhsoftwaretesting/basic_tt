package test_Ng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Dummy_addclient {
	WebDriver driver;
	 @BeforeTest
	 public void login() {
	    System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://secure.ebillity.com/web/Session/New");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	 }
		  
	
	@Test
	public void AddCustomerPerson() throws InterruptedException  {
		
		String p_o = "O";
		
		try {driver.findElement(By.xpath("//*[@class='nav-bar-collapsed']")).click();	
		}
		catch (NoSuchElementException e) {
		
		}
		
		WebElement customerButton = driver.findElement(By.id("mnu_client-home"));
		customerButton.click();
		
		WebElement addCustomer = driver.findElement(By.xpath("//*[@class=\'ctrl_btn orange large add-client\']"));
		addCustomer.click();
		
		WebElement customerTypeDropDown = driver.findElement(By.xpath("//*[@id='select2-ddlClientType_Cd-container']/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
		customerTypeDropDown.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-ddlClientType_Cd-results']/child::li[contains(text(),'"+p_o+"')]")).click();
		
		
	}
	
	/*
	 * @AfterTest public void logout() {
	 * 
	 * WebElement logout = driver.findElement(By.id("signout")); logout.click();
	 * driver.close(); }
	 */
}
