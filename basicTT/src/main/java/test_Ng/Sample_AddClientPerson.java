package test_Ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataDriven.POM_poi_dataprovider;

public class Sample_AddClientPerson {

	WebDriver driver;
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
	 
	 @Test (dataProvider = "loginData", dataProviderClass = POM_poi_dataprovider.class)
		public void AddCustomerPerson(String fName, String mName, String lName)  {
			
			WebElement customerButton = driver.findElement(By.id("mnu_client-home"));
			customerButton.click();
			
			WebElement addCustomer = driver.findElement(By.xpath("//*[@class=\'ctrl_btn orange large add-client\']"));
			addCustomer.click();
			
			WebElement firstName = driver.findElement(By.id("txtFirstName"));
			firstName.sendKeys(fName);
			
			WebElement middleName = driver.findElement(By.id("txtMiddleName"));
			middleName.sendKeys(mName);
			
			WebElement lastName = driver.findElement(By.id("txtLastName"));
			lastName.sendKeys(lName);
			
			WebElement save = driver.findElement(By.xpath("//*[@title='save & close']"));
			save.click();
			
		}
		
		@AfterTest
		public void logout() {

			WebElement logout = driver.findElement(By.id("signout"));
			logout.click();
			driver.close();
		}
}
