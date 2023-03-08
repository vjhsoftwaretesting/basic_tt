package z_successfulFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TTB_MTE_Billable {
	WebDriver driver;
	String [][] data=null;

	@DataProvider(name="clientName")
	  public String[][] loginProvider() throws BiffException, IOException 
	  {
		data = getexcelDATA();
		return data;
		  
	  } 
	 public String[][] getexcelDATA() throws BiffException, IOException
	      {
		  FileInputStream excel = new FileInputStream("D:\\drive\\selenium excel files\\TTB client,organisation names.xls");
		  Workbook workbook = Workbook.getWorkbook(excel);	  	   
		  Sheet sheet = workbook.getSheet(7);
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
	  
	 
	 
	 @BeforeSuite
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


	@Test(dataProvider = "clientName")
	   public void AddProject_projectID (String pro_Name, String cli_Name, String activity, String month, String day, String inTime, String outTime) throws InterruptedException  {
					

		Thread.sleep(1000);
		
			
	 	WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();
			
		String oldWindow = driver.getWindowHandle();
		
		WebElement timeEntryButton = driver.findElement(By.xpath("//*[@id='createList']/div/a[1]"));
		timeEntryButton.click();
			
		Set<String> newWindow = driver.getWindowHandles();
			  
		  for (String newwindow : newWindow) { driver.switchTo().window(newwindow); }
			 
		Thread.sleep(1000);
			  
			  
		WebElement clientDropDown = driver.findElement(By.xpath("//*[@id='s2id_select2_clients']"));
		clientDropDown.click();
					  
		WebElement clientsearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		clientsearchBox.sendKeys(pro_Name);
		
		Thread.sleep(300);
		    
		    List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='select2-results']"));
		    for (int i = 0; i <= allOptions.size(); i++) {
		    	Thread.sleep(1000);
					System.out.println(allOptions.get(i).getText());
			    if (allOptions.get(i).getText().contains(cli_Name)) {
					allOptions.get(i).click();
					break;
					}
			        }
		    
		    Thread.sleep(2000);
		    
		    WebElement activityDropDown = driver.findElement(By.xpath("//*[@id='s2id_select2_activities']"));
			activityDropDown.click();
				 
			WebElement activitySearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
			activitySearchBox.sendKeys(activity);
		    
			
			List<WebElement> activityOptions = driver.findElements(By.xpath("//*[@class='select2-results']")); 
			for (int i = 0;
				  i <= activityOptions.size(); i++) {
					  System.out.println(activityOptions.get(i).getText()); 
				  if(activityOptions.get(i).getText().contains(activity)) {
					  activityOptions.get(i).click();
				  break; } }
			
			//description
			WebElement description = driver.findElement(By.id("invoice_description"));
			description.sendKeys("Time Entry for '"+clientDropDown.getText()+"' is created using Selenium");
			
			
			//Date
			WebElement date1 = driver.findElement(By.id("imgDateFrom"));
			date1.click();
						
						
			
				while (true) {
					String month_year = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::th[2]")).getText();
					System.out.println("month is " + month_year);
					
					if (month_year.equals(month)) {
						break;
					}
									
					else {
						driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::th[1]")).click();
					}
					
				}
				
				driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"+day+")]")).click();
			
						
			//In Time
			WebElement timeIn = driver.findElement(By.xpath("//*[@id='time_from']/input[2]"));
			timeIn.clear();
			timeIn.sendKeys(inTime);
			
			//Out Time
			WebElement timeOut = driver.findElement(By.xpath("//*[@id='time_to']/input"));
			timeOut.sendKeys(outTime);
		    
			WebElement saveButton = driver.findElement(By.id("save"));
			saveButton.click();
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(oldWindow);
	}
			
			@AfterSuite 
			public void logout() {
				  
				  WebElement logout = driver.findElement(By.id("signout"));
				  logout.click();
				  driver.close();	  
			
			}
	}
