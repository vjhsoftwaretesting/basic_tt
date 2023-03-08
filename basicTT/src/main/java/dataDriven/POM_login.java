package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM_login {
	WebDriver driver;
	 @Test(dataProvider = "loginData", dataProviderClass = POM_poi_dataprovider.class )
	 public void login(String username, String pword) {
	    System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys(username);
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(pword);
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();

}}
