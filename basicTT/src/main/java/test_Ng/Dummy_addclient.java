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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class Dummy_addclient {
	WebDriver driver;
	
	String [][] data=null;
	
	@DataProvider(name="clientName")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	
	 public String[][] getexcelDATA() throws IOException {
		 
		 FileInputStream fis = new FileInputStream("D:\\drive\\selenium excel files\\excelPOI.xlsx"); 
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet = wb.getSheetAt(0);
		 int rowCount = sheet.getLastRowNum();
		 for (int i = 0; i <= rowCount; i++) {
			 XSSFRow row = sheet.getRow(i);
			 int cellCount = row.getLastCellNum();
			 for (int j = 0; j < cellCount; j++) {
				 XSSFCell cell = row.getCell(j);
				 DataFormatter formatter = new DataFormatter();
				 String cellValue = formatter.formatCellValue(cell);				 
			 }
		 }
		 return cellValue; 
	 }
	
	
	@BeforeTest
	 public void login() {
	    System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com ");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	 }
	
	
	@Test
	public void AddCustomerPerson()  {
		
		WebElement customerButton = driver.findElement(By.id("mnu_client-home"));
		customerButton.click();
		
		WebElement addCustomer = driver.findElement(By.id("addClient"));
		addCustomer.click();
		
		WebElement firstName = driver.findElement(By.id("txtFirstName"));
		firstName.sendKeys("fName");
		
		WebElement middleName = driver.findElement(By.id("txtMiddleName"));
		middleName.sendKeys("mName");
		
		WebElement lastName = driver.findElement(By.id("txtLastName"));
		lastName.sendKeys("lName");
		
		//WebElement save = driver.findElement(By.name("ctl00$ContentPlaceHolder1$saveClientImageButton"));
		//save.click();
		
	}

}
