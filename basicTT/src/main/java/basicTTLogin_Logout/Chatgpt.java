package basicTTLogin_Logout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Chatgpt {
	
	

	 public static void main(String[] args) throws IOException, InterruptedException 
	 {
	 	 	  
	  System.setProperty("webdriver.chrome.driver",
				"D:\\drive\\automation prerequisite\\selenium drivers\\chromedriver.exe");
	   // WebDriver driver = new ChromeDriver();
		//driver.get("https://secure.ebillity.com/Firm4.0/Login.aspx?ReturnUrl=%2fFirm4.0%2fDashboard%2fDashboard3.aspx");
	 
		 FileInputStream inputstream=new FileInputStream("D:\\drive\\selenium excel files\\excelPOI.xlsx");
		  
		  XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		  XSSFSheet sheet=wb.getSheetAt(0);
		 
		  //getting column name
		  //XSSFRow row=sheet.getRow(0);

		 // int column_count = row.getLastCellNum();
		 // System.out.println(column_count);
		  
		 // XSSFCell  cell = null;
		  
		 // for (int i=0; i<column_count;i++)
		 // { 
			//  cell = row.getCell(i);
			//  String column_Name = cell.getStringCellValue();
			 // System.out.println(column_Name);
		 // }
		
		  
		  
		//printing all values from row and columns  
		 // XSSFRow row = null;
		 // XSSFCell cell = null;
		 // for (int i=0;i<=sheet.getLastRowNum();i++) 
		 // {
		//	  row = sheet.getRow(i);
		//	  for(int j=0;j<row.getLastCellNum();j++)
		//	  {
		//		  cell = row.getCell(j);
		//		  String my_Cell_Value = cell.getStringCellValue();
		//		  System.out.println(my_Cell_Value);
		//	  }
		 // }
		  
		  
		  // storing values into variables
		  
		  XSSFRow row = null;
		  XSSFCell cell = null;
		  String userName = null;
		  String passWord = null;
		  
		  for (int i=0;i<=sheet.getLastRowNum();i++)
		  {
			  row = sheet.getRow(i);
			  for(int j=0;j<row.getLastCellNum();j++)
			  {
				  cell = row.getCell(j);
				  if(j==0)
				  {
					  userName = cell.getStringCellValue();  
				  }
				  
				  if(j==1)
				  {
					  passWord = cell.getStringCellValue();
				  }  
			  
			  
			  }
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		 // XSSFCell cell=row.getCell(0); // Get 1st username 
		 // 
		//  String username=cell.getStringCellValue();
		 // System.out.println("User Name is : " + username );
		  
		 // cell=row.getCell(1);
		  
		//  String password=cell.getStringCellValue();
		 // System.out.println("Password  is : " + password );
		  
}}