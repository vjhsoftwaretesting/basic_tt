package test_Ng;

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

public class Sample1 {
	
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
		userID.sendKeys("andttb01@mailinator.com ");

		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123");
		WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
		submitButton.click();
	}

	@Test
	public void STE() throws InterruptedException {

		WebElement createButton = driver.findElement(By.id("createTitle"));
		createButton.click();

		driver.getWindowHandle();

		WebElement timeEntryButton = driver.findElement(By.xpath("//div[@class='list']/child::a[1]"));
		timeEntryButton.click();

		Set<String> newWindow = driver.getWindowHandles();

		for (String newwindow : newWindow) { driver.switchTo().window(newwindow); }

		
		//select client-project
		
	String client_Project = "Curtis Connors  :  Lizard Serum";
						
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='s2id_select2_clients']")));
	
	    driver.findElement(By.xpath("//*[@id='s2id_select2_clients']")).click();
		
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(client_Project);
		
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id='select2-drop']/descendant::div[contains(@class,'select2-result-label')][2]")).click();
		
		
		//select activity
		
	String Activity = "Design";
	
	    Thread.sleep(800);
	    driver.findElement(By.xpath("//*[@id='s2id_select2_activities']")).click();
	
	    driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Activity);
	
	    driver.findElement(By.xpath("//*[@id='select2-drop']/descendant::div[contains(@class,'select2-result-label')]")).click();
	    
	    //description
	    
	String dec = "Automated by SE";   
	    
	    WebElement decBox = driver.findElement(By.id("invoice_description"));
	    decBox.click();
	    decBox.sendKeys(dec);
	    		

		//Select date
	String day = "15";	
	String month = "Mar";
	String year = "2023";
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
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),"+day+")]")).click();
		
		
	    //From time
	    
	String from = "02:30 PM";
	
	    WebElement fromTime = driver.findElement(By.xpath("//*[@id='time_from']/input"));
	    fromTime.clear();
	    fromTime.sendKeys(from);
	    
	    //To time
	    
	String to = "03:00 PM";
		
	    WebElement toTime = driver.findElement(By.xpath("//*[@id='time_to']/input"));
	    toTime.sendKeys(to);
	    
	    //save
	
	}
}