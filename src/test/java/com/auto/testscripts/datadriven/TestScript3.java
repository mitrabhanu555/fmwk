package com.auto.testscripts.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript3 {
	
	@Test(dataProvider = "getTestdata")
	public void test(String userName,String password,String firstName,String lastName) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	@DataProvider(name = "getTestdata")
	public Object[][] getTestdata() throws Throwable{
		
		Object[][] data = null;
		 
		File file = new File("D:\\rajv.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(input);
		Sheet sheet = wb.getSheet("Sheet1");
		
		
		
		data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(1).getPhysicalNumberOfCells()];
		
	    for (int rowindex = 1; rowindex <= sheet.getLastRowNum(); rowindex++) {
	    	
	    	Row currentRow = sheet.getRow(rowindex);
	    	
	    	for (int colindex = currentRow.getFirstCellNum(); colindex <currentRow.getLastCellNum(); colindex++) {
	    		
	    	
	    		data[rowindex][colindex] = sheet.getRow(rowindex).getCell(colindex).toString();
	    		if (data[rowindex][colindex]== null) 
					continue;
	    		//data[rowindex][colindex] = sheet.getRow(rowindex).getCell(colindex).toString();
			}
			
		}
		
	     wb.close();
		return data;
	}

}
