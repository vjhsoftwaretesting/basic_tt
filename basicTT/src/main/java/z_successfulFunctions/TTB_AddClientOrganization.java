package z_successfulFunctions;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TTB_AddClientOrganization {
	
	WebDriver driver;
	String [][] data=null;
		
	@DataProvider(name="organizationName")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	  	  
	  public String[][] getexcelDATA() throws BiffException, IOException
	  {
		  FileInputStream excel = new FileInputStream("D:\\drive\\selenium excel files\\TTB client,organisation names.xls");
		  Workbook workbook = Workbook.getWorkbook(excel);
		  	   
		  Sheet sheet = workbook.getSheet(1);
		  int rowcount = sheet.getRows();
		  int columncount = sheet.getColumns();
		  
		  String testdata[][] = new String[rowcount-1][columncount];
		  
		  for (int i=1; i<rowcount; i++)
		  {
			  for (int j=0; j<columncount; j++)
			  {
				  testdata[i-1][j]=	sheet.getCell(j, i).getContents();
			  }
		  }
		  return testdata;
	  }
	 
	 @BeforeTest 
	 public void login() {
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
	 }
	  
	  
	
	@Test(dataProvider = "organizationName")
	public void AddCustomerPerson(String orgName) throws InterruptedException  {
		
		WebElement customerButton = driver.findElement(By.id("mnu_client-home"));
		customerButton.click();
		
		WebElement addCustomer = driver.findElement(By.xpath("//*[@class=\'ctrl_btn orange large add-client\']"));
		addCustomer.click();
		
		WebElement customerTypeDropDown = driver.findElement(By.xpath("//*[@id='select2-ddlClientType_Cd-container']/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
		customerTypeDropDown.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-ddlClientType_Cd-results']/child::li[contains(text(),'Organization')]")).click();
		
		//WebElement businessName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_clientBNameTextBoxWithValidator_textBoxValue"));
		//businessName.sendKeys(orgName);
		
		//WebElement save = driver.findElement(By.name("ctl00$ContentPlaceHolder1$saveClientImageButton"));
		//save.click();
	}
	
	//@AfterTest
	//public void logout() {

		
		//WebElement logout = driver.findElement(By.id("signout")); logout.click();
		//driver.close();
		
	//}
	}
	
