package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SampleDataDrivenLogin {
	WebDriver driver;
	String [][] data=null;
		
	@DataProvider(name="loginData")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	  
	  
	  public String[][] getexcelDATA() throws BiffException, IOException
	  {
		  FileInputStream excel = new FileInputStream("D:\\drive\\selenium excel files\\TTB login datas.xls");
		  Workbook workbook = Workbook.getWorkbook(excel)
	;	  	   
		  Sheet sheet = workbook.getSheet(0);
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
	 
	  
	  
	  @Test(dataProvider = "loginData")
	  public void Loginpage(String userName, String passWord) 
	  {
		  System.setProperty("webdriver.chrome.driver",
					"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		  	driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx");
		  	
		  	WebElement userID = driver.findElement(By.id("txtEmail"));
			userID.sendKeys(userName);
		
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys(passWord);
			
			WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
			submitButton.click();
	  }
}
