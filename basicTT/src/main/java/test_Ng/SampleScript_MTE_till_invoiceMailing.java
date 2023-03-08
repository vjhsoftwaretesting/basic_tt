package test_Ng;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleScript_MTE_till_invoiceMailing {
	
	WebDriver driver;
	@Test
	public void timeEntry_approve_perbill () throws InterruptedException {
		
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
		
		Thread.sleep(1000);
		
		
	 	WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();
			
		String oldWindow = driver.getWindowHandle();
		
		WebElement timeEntryButton = driver.findElement(By.xpath("//*[@id='createList']/div/a[1]"));
		timeEntryButton.click();
			
		Set<String> timeEntryWindow = driver.getWindowHandles();
			  
		  for (String newwindow : timeEntryWindow) { driver.switchTo().window(newwindow); }
			 
		Thread.sleep(5000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-choice select2-default']")));
			  
		WebElement clientDropDown = driver.findElement(By.xpath("//*[@class='select2-choice select2-default']"));
		clientDropDown.click();
					  
		WebElement clientsearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		clientsearchBox.sendKeys("Non-Project Related");
		
		Thread.sleep(1000);
			 
			List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='select2-results']"));
		    for (int i = 0; i <= allOptions.size(); i++) {
		    	Thread.sleep(1000);
					System.out.println(allOptions.get(i).getText());
			    if (allOptions.get(i).getText().contains("Ocean Network Corporation")) {
					allOptions.get(i).click();
					break;
					}
			        }
		    
		    Thread.sleep(2000);
		    
		    WebElement activityDropDown = driver.findElement(By.xpath("//*[@id='s2id_select2_activities']"));
			activityDropDown.click();
				 
			WebElement activitySearchBox = driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
			activitySearchBox.sendKeys("Meeting");
			
			Thread.sleep(1000);
		    
			List<WebElement> activityOptions = driver.findElements(By.xpath("//*[@class='select2-results']")); 
			for (int i = 0;
				  i <= activityOptions.size(); i++) {
					  System.out.println(activityOptions.get(i).getText()); 
				  if(activityOptions.get(i).getText().contains("Documentation")) {
					  activityOptions.get(i).click();
				  break; } }
			
			WebElement timeEntryDescription = driver.findElement(By.id("invoice_description"));
			timeEntryDescription.sendKeys("Time Entry for '"+clientDropDown.getText()+"' is created using Selenium");
				    			    
			WebElement timeIn = driver.findElement(By.xpath("//*[@id='time_from']/input[2]"));
			timeIn.clear();
			timeIn.sendKeys("06:30 AM");
			  
			WebElement timeOut = driver.findElement(By.xpath("//*[@id='time_to']/input"));
			timeOut.sendKeys("07:30 AM");
		    
			WebElement saveButton = driver.findElement(By.id("save"));
			saveButton.click();
			Thread.sleep(3000);
			
			driver.switchTo().window(oldWindow);
			
			//submit the current entry process
			
			WebElement MangeMyEntriesButton = driver.findElement(By.xpath("//*[@title='Manage My Entries']"));
			MangeMyEntriesButton.click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@rowid='0']//child::input")));
			
			WebElement pendingRowCheckBox = driver.findElement(By.xpath("//*[@rowid='0']//child::input"));
			pendingRowCheckBox.click();
		
			WebElement entrySubmitButton = driver.findElement(By.id("submitButton"));
			entrySubmitButton.click();
			
			//approve the curent entry process
			
			WebElement entrySubmitPage = driver.findElement(By.id("btnPending2"));
			entrySubmitPage.click();
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@rowid='0']//child::input")));
			
			WebElement submitedRowCheckBox = driver.findElement(By.xpath("//*[@rowid='0']//child::input"));
			submitedRowCheckBox.click();
		
			WebElement entryApproveButton = driver.findElement(By.id("approveButton"));
			entryApproveButton.click();
			
			
			//invoicepage
			
			WebElement InvoicesButton = driver.findElement(By.xpath("//*[@title='Invoices']"));
			InvoicesButton.click();
			
			WebElement addInvoiceButton = driver.findElement(By.xpath("//*[@title='Add Invoice']"));
			addInvoiceButton.click();
			
			WebElement clientButton = driver.findElement(By.xpath("//*[@class='select2-choice select2-default']"));
			clientButton.click();
			
			driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Jane Froster");
			
			Thread.sleep(1000);
			 
			List<WebElement> allOptions1 = driver.findElements(By.xpath("//*[@class='select2-results']"));
		    for (int i = 0; i <= allOptions1.size(); i++) {
					System.out.println(allOptions1.get(i).getText());
			    if (allOptions1.get(i).getText().contains("Jane Froster")) {
					allOptions1.get(i).click();
					break;
					}
			        }
		    
	        Thread.sleep(2000);
		    
		    WebElement invoiceDescription = driver.findElement(By.id("ctl00_ContentPlaceHolder1_invoiceDescriptionTextBox_textBoxValue"));
		    invoiceDescription.sendKeys(" is created using selenium");
		    
		    WebElement savePreBillButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSavePrebill"));
		    savePreBillButton.click();
			
		    Set<String> preBillWindow = driver.getWindowHandles();
			  
			  for (String newwindow : preBillWindow) { driver.switchTo().window(newwindow); }
				 
			  Thread.sleep(2000);
			  
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl01_ContentPlaceHolder1_finalizeImageButton"))); 
			WebElement finalizeButton = driver.findElement(By.id("ctl01_ContentPlaceHolder1_finalizeImageButton"));
			finalizeButton.click();
			
			Thread.sleep(2000);
			
			WebElement email = driver.findElement(By.xpath("//*[@title='Email']"));
			email.click();
			
			Set<String> emailWindow = driver.getWindowHandles();
			  
			  for (String newwindow : emailWindow) { driver.switchTo().window(newwindow); }
				 
			  Thread.sleep(2000);
			
			WebElement mailAddress = driver.findElement(By.id("toTextBox_textBoxValue"));
			mailAddress.sendKeys("andrewtestttb001@mailinator.com");
			
			WebElement mailSendButton = driver.findElement(By.id("sendButton"));
			mailSendButton.click();
			  
			driver.quit();  
	}

}
