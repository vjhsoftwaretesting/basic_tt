package dataDriven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class User_STE_submit {
	
	WebDriver driver;

	@BeforeSuite
	public void login() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
	    co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://secure.ebillity.com");
		driver.manage().window().maximize();

		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("vpclmar2@mailinator.com ");

		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	}

	@Test
	public void STE() throws InterruptedException, AWTException, UnsupportedFlavorException, IOException {

		WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();

		String oldWindow = driver.getWindowHandle();

		WebElement timeEntryButton = driver.findElement(By.xpath("//div[@class='list']/child::a[1]"));
		timeEntryButton.click();

		Set<String> newWindow = driver.getWindowHandles();

		for (String newwindow : newWindow) { driver.switchTo().window(newwindow); }
				
		Thread.sleep(2000);
		//select client-project
		
		String client = "Client POLO";
		String project = "pro 01";
			
		    Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='s2id_select2_clients']")).click();
			driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(project);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='select2-drop']/descendant::div[contains(@class,'select2-result-label')][not(contains(text(),'Select'))][contains(text(),'"+client+"')]")).click();
			
		//select activity
			
		String activity = "Review";
		    
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='s2id_select2_activities']")).click();
		    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']/descendant::ul[@class='select2-results']")));
			driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(activity);
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id='select2-drop']/descendant::div[contains(@class,'select2-result-label')]")).click();
			    
		//description
			    
		String dec = "Time entry for " + client+project;   
			    
			WebElement desBox = driver.findElement(By.id("invoice_description"));
			desBox.click();
			desBox.sendKeys(dec);
			
		//billable type
		String h_f = "H";
		String type = "S";
		
			if(h_f.equals("H")){
				driver.findElement(By.xpath("//*[@name='bittable_type'][@value='1']")).click();
				if(type.equals("S")) {
					driver.findElement(By.xpath("//*[@name='time_type'][@value='standard']")).click();
				}
				else if(type.equals("O")){
					driver.findElement(By.xpath("//*[@name='time_type'][@value='overtime']")).click();
				}
			}
			else if(h_f.equals("F")) {
				
				driver.findElement(By.xpath("//*[@name='bittable_type'][@value='2']")).click();
					
		 	}
		 
		//Select date
		try {	
		String day = "";	
		String month = "";
		String year = "";
			int givenYear = Integer.parseInt(year);


			WebElement date = driver.findElement(By.id("calendarIcon"));
			date.click();

			WebElement datepickerMiddle1 = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::th[2]"));
			datepickerMiddle1.click();
				
			WebElement datepickerMiddle2 = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']"));
			String datepickerYear =datepickerMiddle2.getText();
			int datepickerYearr = Integer.parseInt(datepickerYear);
				
				if(datepickerYearr>givenYear) {
					while(true) {
						String yyear = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']")).getText();
										
						if(yyear.equals(year)) {
							break;
						}
						else {
							
						driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='prev']/i")).click();
						}
					}
				}
				
				else if (datepickerYearr<givenYear) {
					while(true) {
						String yyearr = driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='switch']")).getText();
						
						if(yyearr.equals(year)) {
							break;
						}
						else {
							driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/descendant::div[@class='datepicker-months']/descendant::th[@class='next']/i")).click();
						}
					}
				}
				else if (datepickerYear.equals(year))  {
						
					}
						
		driver.findElement(By.xpath("//*[@class='datepicker-months']/table/tbody/tr/td/span[contains(@class,'')][text()='"+month+"']")).click();
				
		driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"+day+")]")).click();
		}		
	catch (Exception e) {
		
	}
		Thread.sleep(2000);
        driver.findElement(By.id("date")).click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Clipboard clipboard = toolkit.getSystemClipboard();    
	    String copiedDate = (String) clipboard.getData(DataFlavor.stringFlavor);
	    
		
		//From time
			    
	String from = "02:30 PM";
			
		WebElement fromTime = driver.findElement(By.xpath("//*[@id='time_from']/input"));
		fromTime.clear();
		fromTime.sendKeys(from);
			    
		//To time
			    
	String to = "03:00 PM";
				
		WebElement toTime = driver.findElement(By.xpath("//*[@id='time_to']/input"));
		toTime.sendKeys(to);
			    
		//Over Ride	
	String overRideRate = "";
	String rs = "100";
	
	    WebElement overRide_Checkbox = driver.findElement(By.id("rate_hourly_override"));
	    
	    if(overRideRate.equals("Y")) {
	    	overRide_Checkbox.click();
	    	new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("rateOver")));
	    	driver.findElement(By.id("rateOver")).sendKeys(rs);
	    }
		
	    //Billable checkbox
	String bill_Status = "N";
		
	    WebElement billable_Checkbox = driver.findElement(By.xpath("//*[@id='billableInv']/div[1]/input"));
	    	    
		  if(bill_Status.equals("Y")) {
			  if(!(billable_Checkbox.isSelected())) {
		  billable_Checkbox.click(); } 
			  else { }
			  }
		  
		  else if(bill_Status.equals("N")) {
			  if(billable_Checkbox.isSelected()) {
		  billable_Checkbox.click(); }
			  else { }
			  }
		  else {}
		 
		//invoice checkbox
	String invoice_Status = "Y";
				
		WebElement invoice_Checkbox = driver.findElement(By.xpath("//*[@id='billableInv']/div[2]/input"));
			    	    
		 if(invoice_Status.equals("Y")) {
				if(!(invoice_Checkbox.isSelected())) {
					invoice_Checkbox.click(); } 
				else { }
				}
				  
		  else if(invoice_Status.equals("N")) {
				if(invoice_Checkbox.isSelected()) {
					invoice_Checkbox.click(); }
				else { }
				}
		  else {}
		 
		 //save
		 driver.findElement(By.id("save")).click();
		 
		 //close STE
		 Thread.sleep(2000);

		 
	//submit the STE
		 driver.switchTo().window(oldWindow); 
		try {
			driver.findElement(By.xpath("//a[@id='mnu_entries-home'][@aria-expanded='false']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//a[@title='Manage My Entries']")).click();
		
		WebElement findButton = driver.findElement(By.xpath("//*[@class='ctrl_btn'][@value='Find']"));
		findButton.click();
		
		Thread.sleep(2000);
		//find client
		WebElement clientdrop = driver.findElement(By.xpath("//*[contains(@id,'ddlClients')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
		clientdrop.click();
		
		WebElement searchbox1 =driver.findElement(By.className("select2-search__field"));
		searchbox1.click();
		searchbox1.sendKeys(client);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();
		
		// find project
		WebElement projectdrop = driver.findElement(By.xpath("//*[contains(@id,'ddlProjects')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
		projectdrop.click();
					
		WebElement searchbox2 =driver.findElement(By.className("select2-search__field"));
		searchbox2.click();
		searchbox2.sendKeys(project);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();
		
		//find activity
		WebElement activitydrop = driver.findElement(By.xpath("//*[contains(@id,'ddlActivityType')]/following::span[@class='select2-selection__arrow'][@role='presentation'][1]"));
		activitydrop.click();
		
		WebElement searchbox3 =driver.findElement(By.className("select2-search__field"));
		searchbox3.click();
		searchbox3.sendKeys(activity);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='select2-results__option multi-checkboxes_wrap']")).click();
		
		//to date
		WebElement todate = driver.findElement(By.id("txtTo_DateRange"));
		todate.clear();
		todate.sendKeys(copiedDate);
		
		
		//from date
		WebElement fromdate = driver.findElement(By.id("txtFrom_DateRange"));
		fromdate.clear();
		fromdate.sendKeys(copiedDate);
		
		Thread.sleep(2000);
		//search button
		driver.findElement(By.id("grdMyEntries_Search")).click();
		
		WebElement pendingRowCheckBox = driver.findElement(By.xpath("//*[@rowid='0']//child::input"));
		pendingRowCheckBox.click();
	
		WebElement entrySubmitButton = driver.findElement(By.id("submitButton"));
		entrySubmitButton.click();
					
		
}
}
