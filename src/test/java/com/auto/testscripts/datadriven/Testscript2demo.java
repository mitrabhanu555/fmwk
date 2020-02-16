package com.auto.testscripts.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testscript2demo {
	
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
		
		Object [][] data = null;
		File file = new File("D:\\framewrkMQ\\TestData.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(input);
		Sheet sheet = workbook.getSheet("Sheet1");
	    data= new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		data[0][0] = sheet.getRow(0).getCell(0).toString();
		data[0][1]= sheet.getRow(0).getCell(1).toString();
		data[0][2]= sheet.getRow(0).getCell(2).toString();
		data[0][3]= sheet.getRow(0).getCell(3).toString();
		
		data[1][0]= sheet.getRow(1).getCell(0).toString();
		data[1][1]= sheet.getRow(1).getCell(1).toString();
		data[1][2]= sheet.getRow(1).getCell(2).toString();
		data[1][3]= sheet.getRow(1).getCell(3).toString();
	
		workbook.close();
      return data;		
		
		
	}
	

}
