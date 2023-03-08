package ttb_AllPage;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AallPagesLoading {
	WebDriver driver;
	
	@BeforeSuite
	public void login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
		driver.manage().window().maximize();
		
		WebElement userID = driver.findElement(By.id("txtEmail"));
		userID.sendKeys("andttb01@mailinator.com");
	
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Test123"+Keys.ENTER);
		
		Thread.sleep(500);
		
		try {driver.findElement(By.xpath("//*[@class='nav-bar-collapsed']")).click();	
		}
		catch (NoSuchElementException e) {
		
		}
		
	}
		
	@Test (priority=0,groups= {"Home"})
	public void OnTheClock() throws InterruptedException {
		
        String oldWindow = driver.getWindowHandle();
		
		WebElement OnTheClockButton = driver.findElement(By.xpath("//*[@title='On the Clock']"));
		OnTheClockButton.click();
						
		Set<String> alertWindow = driver.getWindowHandles();
		
		for (String newwindow : alertWindow) {
			driver.switchTo().window(newwindow);
			}
		
		WebElement stopWalkThrough = driver.findElement(By.xpath("//*[@title='Stop Walk-thru']"));
		stopWalkThrough.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("All")));
		 System.out.println("OnTheClock Page Loaded Successfully");	
	}
	
	
	@Test (priority=1, groups= {"Home"})
	public void Reports() throws InterruptedException {
		
	WebElement ReportsButton = driver.findElement(By.xpath("//*[@title='Reports']"));
	ReportsButton.click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_Label3")));
	 System.out.println("Reports Page Loaded Successfully");	
	}
	
	
	@Test (priority=2, groups= {"Home"})
	public void Contacts() throws InterruptedException {
		
		WebElement ContactsButton = driver.findElement(By.xpath("//*[@title='Contacts']"));
		ContactsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ctrl_btn orange large add-contact']")));
		 System.out.println("Contacts Page Loaded Successfully");
	}
	
	
	@Test (priority=3, groups= {"Entries"})
	public void WeeklyTimeSheets() throws InterruptedException {
		
		WebElement WeeklyTimeSheetsButton = driver.findElement(By.xpath("//*[@title='Weekly Timesheets']"));
		WeeklyTimeSheetsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lnkViewWeek")));
		 System.out.println("WeeklyTimeSheets Page Loaded Successfully");
		
	}
	
	@Test (priority=4, groups= {"Entries"})
	public void MangeMyEntries() throws InterruptedException {
		
		WebElement MangeMyEntriesButton = driver.findElement(By.xpath("//*[@title='Manage My Entries']"));
		MangeMyEntriesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("MangeMyEntries Page Loaded Successfully");
	}
	
	@Test (priority=5, groups= {"Entries"})
	public void ManageTeamEntries() throws InterruptedException {
		
		WebElement ManageTeamEntriesButton = driver.findElement(By.xpath("//*[@title='Manage Team Entries']"));
		ManageTeamEntriesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timetab")));
		 System.out.println("ManageTeamEntries Page Loaded Successfully");
	}
	
	@Test (priority=6, groups= {"Entries"})
	public void RecurringExpenses() throws InterruptedException {
		
		WebElement RecurringExpensesButton = driver.findElement(By.xpath("//*[@title='Recurring Expenses']"));
		RecurringExpensesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addAutoExpLinkButton")));
		 System.out.println("RecurringExpenses Page Loaded Successfully");
	}
	
	@Test (priority=7, groups= {"Entries"})
	public void TimeOff() throws InterruptedException {
		
		WebElement TimeOffButton = driver.findElement(By.xpath("//*[@title='Time Off']"));
		TimeOffButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addTimeOff")));
		 System.out.println("TimeOff Page Loaded Successfully");
	}
	
	@Test (priority=8, groups= {"Entries"})
	public void Approvals() throws InterruptedException {
		
		WebElement ApprovalsButton = driver.findElement(By.xpath("//*[@title='Approvals']"));
		ApprovalsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_lblMainTitle")));
		 System.out.println("Approvals Page Loaded Successfully");
	}
	
	@Test (priority=9, groups= {"Entries"})
	public void LockTimePeriod() throws InterruptedException {
		
		WebElement LockTimePeriodButton = driver.findElement(By.xpath("//*[@title='Lock Time Periods']"));
		LockTimePeriodButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mt-1']")));
		 System.out.println("LockTimePeriod Page Loaded Successfully");
	}
	
	@Test (priority=10, groups= {"Entries"})
	public void Notes() throws InterruptedException {
		
		WebElement NotesButton = driver.findElement(By.xpath("//*[@title='Notes']"));
		NotesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_lblMainTitle")));
		 System.out.println("Notes Page Loaded Successfully");
	}
	
	
	@Test (priority=11, groups= {"Project"})
	public void Projects() throws InterruptedException {
		
		WebElement ProjectsButton = driver.findElement(By.id("mnu_project-home"));
		ProjectsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("Projects Page Loaded Successfully");
	}
	
	@Test (priority=12, groups= {"Client"})
	public void Clients() throws InterruptedException {
		
		WebElement ClientsButton = driver.findElement(By.id("mnu_client-home"));
		ClientsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ctrl_btn orange large add-client']")));
		 System.out.println("Clients Page Loaded Successfully");
	}
	
	@Test (priority=13, groups= {"Billing"})
	public void History() throws InterruptedException {
		
		WebElement HistoryButton = driver.findElement(By.xpath("//*[@title='History']"));
		HistoryButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("History Page Loaded Successfully");
	}
	
	@Test (priority=14, groups= {"Billing"})
	public void Invoices() throws InterruptedException {
		
		WebElement InvoicesButton = driver.findElement(By.xpath("//*[@title='Invoices']"));
		InvoicesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("Invoices Page Loaded Successfully");
	}
	
	@Test (priority=15, groups= {"Billing"})
	public void ClientPayments() throws InterruptedException {
		
		WebElement ClientPaymentsButton = driver.findElement(By.xpath("//*[@title='Client Payments']"));
		ClientPaymentsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ctrl_btn orange large add-payment']")));
		 System.out.println("ClientPayments Page Loaded Successfully");
	}
	
	@Test (priority=16, groups= {"Billing"})
	public void Adjustments() throws InterruptedException {
		
		WebElement AdjustmentsButton = driver.findElement(By.xpath("//*[@title='Adjustments']"));
		AdjustmentsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ctrl_btn orange large add-adjustment']")));
		 System.out.println("Adjustments Page Loaded Successfully");
	}
	
	@Test (priority=17, groups= {"Billing"})
	public void Statements() throws InterruptedException {
		
		WebElement StatementsButton = driver.findElement(By.xpath("//*[@title='Statements\']"));
		StatementsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("Statements Page Loaded Successfully");
	}
	
	@Test (priority=18, groups= {"Schedule"})
	public void Schedule() throws InterruptedException {
		
		WebElement ScheduleButton = driver.findElement(By.id("mnu_schedule-home"));
		ScheduleButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnExport']")));
		 System.out.println("Schedule Page Loaded Successfully");

	}
	
	@Test (priority=19, groups= {"Admin"})
	public void Settings() throws InterruptedException {
		
		WebElement SettingsButton = driver.findElement(By.xpath("//*[@title='Settings']"));
		SettingsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));
		 System.out.println("Settings Page Loaded Successfully");
	}
	
	@Test (priority=20, groups= {"Admin"})
	public void ManageUses() throws InterruptedException {
		
		WebElement ManageUsesButton = driver.findElement(By.xpath("//*[@title='Manage Users']"));
		ManageUsesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='addNewUser']")));
		 System.out.println("ManageUses Page Loaded Successfully");
	}
	
	@Test (priority=21, groups= {"Admin"})
	public void ScreenAnnouncmentsQuestions() throws InterruptedException {
		
		WebElement ScreenAnnouncmentsQuestionsButton = driver.findElement(By.xpath("//*[@title='Screen Announcements & Questions']"));
		ScreenAnnouncmentsQuestionsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lblMainTitle']")));
		 System.out.println("ScreenAnnouncmentsQuestions Page Loaded Successfully");
	}
	
	@Test (priority=22, groups= {"Admin"})
	public void UserAcheivements() throws InterruptedException {
		
		WebElement UserAcheivementsButton = driver.findElement(By.xpath("//*[@title='User Achievements']"));
		UserAcheivementsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnAchievementsAdd']")));
		 System.out.println("UserAcheivements Page Loaded Successfully");	 
	}
	
	@Test (priority=23, groups= {"Admin"})
	public void Clientportal() throws InterruptedException {
		
		WebElement ClientportalButton = driver.findElement(By.xpath("//*[@title='Client Portal']"));
		ClientportalButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_SaveButton\']")));
		 System.out.println("Clientportal Page Loaded Successfully");
	}
	
	@Test (priority=24, groups= {"Admin"})
	public void FlatFiles() throws InterruptedException {
		
		WebElement FlatFilesButton = driver.findElement(By.xpath("//*[@title='Flat Files']"));
		FlatFilesButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnEnableADP']")));
		 System.out.println("FlatFiles Page Loaded Successfully");
	}
	
	@Test(enabled = true, priority = 25, groups = { "More" })
	public void MoreMenuPage() throws InterruptedException {
	
		try {driver.findElement(By.xpath("//*[@class='dropdown-toggle collapsed']")).click();	
		}
		catch (NoSuchElementException e) {}
		
		WebElement IntegrationsButton = driver.findElement(By.xpath("//*[@title='Integrations']"));
		IntegrationsButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='accounting-integrati'][1]")));
		System.out.println("Integrations Page Loaded Successfully");

		WebElement AppsAndDownloadsButton = driver.findElement(By.id("mnu_sub_Downloads-home"));
		AppsAndDownloadsButton.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='inner-container']")));
		System.out.println("AppsAndDownloads Page Loaded Successfully");

		WebElement APIButton = driver.findElement(By.id("mnu_sub_API"));
		APIButton.click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnAPISave']")));
		System.out.println("API Page Loaded Successfully");

	}
	
	@AfterSuite
	public void logout() {

		WebElement logout = driver.findElement(By.id("signout"));
		logout.click();
		driver.close();
		
	}

}
