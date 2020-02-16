package com.auto.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkScript {
	protected WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
	}

}
