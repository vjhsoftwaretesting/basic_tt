package z_successfulFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TTB_AddUserAdmin {
	
WebDriver driver;
	
    String [][] data=null;
	
	@DataProvider(name="userDetails")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	 public String[][] getexcelDATA() throws BiffException, IOException
	      {
		  FileInputStream excel = new FileInputStream("D:\\drive\\selenium excel files\\TTB client,organisation names.xls");
		  Workbook workbook = Workbook.getWorkbook(excel);	  	   
		  Sheet sheet = workbook.getSheet(4);
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
	
	
	@Test(dataProvider = "userDetails")
	   public void AddUserAdmin (String fName, String lName, String emailID) throws InterruptedException  {
					
			Thread.sleep(500);
			
			WebElement ManageUsesButton = driver.findElement(By.xpath("//*[@title='Manage Users']"));
			ManageUsesButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='addNewUser']")));
			 System.out.println("ManageUses Page Loaded Successfully");
			 
			WebElement addUserButton = driver.findElement(By.id("addNewUser"));
			addUserButton.click(); 
			
			WebElement firstName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_firstNameText_textBoxValue"));
			firstName.sendKeys(fName);
			
			WebElement lastName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lastNameTextBox_textBoxValue"));
			lastName.sendKeys(lName);
			
			WebElement email = driver.findElement(By.id("ctl00_ContentPlaceHolder1_emailTextBox_textBoxValue"));
			email.sendKeys(emailID);

			WebElement standBillRate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_standardRateTextBox_textBoxValue"));
			standBillRate.sendKeys("500");

			WebElement otBillRate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_overtimeRateTextBox_textBoxValue"));
			otBillRate.sendKeys("1000");
			
						
			WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_saveButton"));
			save.click();
			System.out.println("New Admin Added Successfully"); 
			  
			  }
			  
	@AfterTest public void logout() {
			  
			WebElement logout = driver.findElement(By.id("signout")); logout.click();
			driver.close();
			  }

}
