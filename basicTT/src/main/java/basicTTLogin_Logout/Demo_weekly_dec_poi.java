package basicTTLogin_Logout;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_weekly_dec_poi {
	WebDriver driver;
	
	@BeforeTest
	public void login() {
		
		System.setProperty("webdriver.chrome.driver","D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);

		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	}
		
	
		
		
	@Test
	public void WeeklyTimeSheetsPage() throws InterruptedException, IOException {
		
	
	FileInputStream inputstream=new FileInputStream("D:\\drive\\selenium excel files\\excelPOI.xlsx");
		  
	XSSFWorkbook wb=new XSSFWorkbook(inputstream);
	XSSFSheet sheet=wb.getSheetAt(0);
	
	XSSFRow row = null;
	XSSFCell cell = null;
	String pro_Name =null;
	String activity =null;
	String sun_time =null;
	String sun_dec =null;
	String mon_time =null;
	String mon_dec =null;
	String tue_time =null;
	String tue_dec =null;
	String wed_time =null;
	String wed_dec =null;
	String thu_time =null;
	String thu_dec =null;
	String fri_time = null;
	String fri_dec =null;
	String sat_time =null;
	String sat_dec =null;
    
	
	for (int i=1;i<=sheet.getLastRowNum();i++)
	  {
		  row = sheet.getRow(i);
		  for(int j=0;j<row.getLastCellNum();j++)
		  {
			  cell = row.getCell(j);
			  if(j==0)
			  {
				  pro_Name = cell.getStringCellValue();  
			  }
			  
			  if(j==1)
			  {
				  activity = cell.getStringCellValue();
			  }
			  
			  if(j==2)
			  {
				  sun_time = cell.getStringCellValue();
			  }
			  
			  if(j==3)
			  {
				  sun_dec = cell.getStringCellValue();
			  }
			  
			  if(j==4)
			  {
				  mon_time = cell.getStringCellValue();
			  }
			  

			  if(j==5)
			  {
				  mon_dec = cell.getStringCellValue();
			  }
			  

			  if(j==6)
			  {
				  tue_time = cell.getStringCellValue();
			  }
			  

			  if(j==7)
			  {
				  tue_dec = cell.getStringCellValue();
			  }
			  

			  if(j==8)
			  {
				  wed_time = cell.getStringCellValue();
			  }
			  

			  if(j==9)
			  {
				  wed_dec = cell.getStringCellValue();
			  }
			  

			  if(j==10)
			  {
				  thu_time = cell.getStringCellValue();
			  }
			  

			  if(j==11)
			  {
				  thu_dec = cell.getStringCellValue();
			  }
			  

			  if(j==12)
			  {
				  fri_time = cell.getStringCellValue();
			  }
			  

			  if(j==13)
			  {
				  fri_dec = cell.getStringCellValue();
			  }
			  

			  if(j==14)
			  {
				  sat_time = cell.getStringCellValue();
			  }
			  

			  if(j==15)
			  {
				  sat_dec = cell.getStringCellValue();
			  }
		  }}
	
		Thread.sleep(500);
	//weekly timesheet
		WebElement WeeklyTimeSheetsButton = driver.findElement(By.xpath("//*[@title='Weekly Timesheets']"));
		WeeklyTimeSheetsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lnkViewWeek")));
		 System.out.println("WeeklyTimeSheets Page Loaded Successfully");
		 
	//client dropdown 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[1][not(@title)]")));
		WebElement clientDropDown = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[1][not(@title)]"));
		clientDropDown.click();
						  
		WebElement clientsearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		clientsearchBox.sendKeys(pro_Name);
			
		Thread.sleep(300);
			    
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='select2-results']"));
		    for (int i = 0; i <= allOptions.size(); i++) {
		    	System.out.println(allOptions.get(i).getText());
			    if (allOptions.get(i).getText().contains(pro_Name)) {
					allOptions.get(i).click();
				break;
					}
			        } 
		 
	//activity dropdown
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]")));
		WebElement activityDropDown = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]"));
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
		
	//sunday
		WebElement sunday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_0')]/input"));
		sunday_time.click();
		sunday_time.sendKeys(sun_time);
		
	//description
		WebElement description = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description.click();
		Thread.sleep(2000);
		if(description.isEnabled()) {description.sendKeys(sun_dec);
			}
		else {}
		
	//monday
		WebElement monday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_1')]/input"));
		monday_time.click();
		monday_time.sendKeys(mon_time);
		
	//description
		WebElement description1 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description1.click();
		Thread.sleep(2000);
		if(description1.isEnabled()) {description1.sendKeys(mon_dec);
		}
		else {}
		
	//tuesday
		WebElement tuesday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_2')]/input"));
		tuesday_time.click();
		tuesday_time.sendKeys(tue_time);
	
	//description
		WebElement description2 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description2.click();
		Thread.sleep(3000);
		if(description2.isEnabled()) {	description2.sendKeys(tue_dec);
		}
		else {}
		
	//wednesday
		WebElement wednesday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_3')]/input"));
		wednesday_time.click();
		wednesday_time.sendKeys(wed_time);
		
	//description
		WebElement description3 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description3.click();
		Thread.sleep(3000);
		if(description3.isEnabled()) {	description3.sendKeys(wed_dec);
		}
		else {}
															
	//thursday
		WebElement thursday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_4')]/input"));
		thursday_time.click();
		thursday_time.sendKeys(thu_time);
	
	//description
		WebElement description4 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description4.click();
		Thread.sleep(3000);
		if(description4.isEnabled()) {	description4.sendKeys(thu_dec);
		}
		else {}
					
	//friday
		WebElement friday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_5')]/input"));
		friday_time.click();
		friday_time.sendKeys(fri_time);
					
	//description
		WebElement description5 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description5.click();
		Thread.sleep(3000);
		if(description5.isEnabled()) {	description5.sendKeys(fri_dec);
		}
		else {}
				
	
	//saturday	
		WebElement saturday_time = driver.findElement(By.xpath("//*[@class='row-container']/child::*[@class='w-row hrow']/div[2][not(@title)]/following-sibling::*[contains(@class,'COL_INDEX_6')]/input"));
		saturday_time.click();
		saturday_time.sendKeys(sat_time);
	
	//description
		WebElement description6 = driver.findElement(By.xpath("//*[@maxlength='3000'][@class='weeklyNotes']"));
		description6.click();
		Thread.sleep(3000);
		if(description6.isEnabled()) {	description6.sendKeys(sat_dec);
		}
		else {}
	
		
	//click out to save
		driver.findElement(By.id("leftNotesPanel")).click();
	}


	 @AfterTest 
		public void logout() {
			  
		WebElement logout = driver.findElement(By.id("signout"));
		logout.click();
		driver.close();
		
	 }
}
