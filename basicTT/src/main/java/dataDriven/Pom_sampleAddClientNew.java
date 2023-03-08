package dataDriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pom_sampleAddClientNew {

	 @Test(dataProvider = "loginData", dataProviderClass = POM_poi_dataprovider.class )
		public void AddCustomerPerson(String fName, String lName)  {
			
		 System.setProperty("webdriver.chrome.driver",
					"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		  WebDriver  driver = new ChromeDriver();
			driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
			driver.manage().window().maximize();
			
			WebElement userID = driver.findElement(By.id("txtEmail"));
			userID.sendKeys("andttb01@mailinator.com ");
			
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys("Test123");
			WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
			submitButton.click();
		 
		 
			WebElement customerButton = driver.findElement(By.id("mnu_client-home"));
			customerButton.click();
			
			WebElement addCustomer = driver.findElement(By.xpath("//*[@class=\'ctrl_btn orange large add-client\']"));
			addCustomer.click();
			
			WebElement firstName = driver.findElement(By.id("txtFirstName"));
			firstName.sendKeys(fName);
			
			WebElement lastName = driver.findElement(By.id("txtLastName"));
			lastName.sendKeys(lName);
			
			WebElement save = driver.findElement(By.xpath("//*[@title='save & close']"));
			save.click();
	

			WebElement logout = driver.findElement(By.id("signout"));
			logout.click();
			driver.close();
		}
}
