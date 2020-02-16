package com.auto.testscripts.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.core.FrameworkScript;
import com.auto.helper.ExcelHelper;



public class Testscript5Fnl extends FrameworkScript {
	

	@Test(dataProvider = "getTestdata")
	public void test(String userName,String password,String firstName,String lastName) throws Throwable {
		
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
		
	    }
	
	@DataProvider(name = "getTestdata")
	public Object[][] getTestdata() throws Throwable{
		Object[][] data = null;
		data = ExcelHelper.getTestdata();
		
		return data;
	

     }

}
