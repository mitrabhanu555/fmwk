package com.auto.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutScreen3 {
	
	@FindBy(id = "welcome")
	private WebElement welcome = null;
	
	@FindBy(linkText = "Logout")
	private WebElement Logout = null;
	
	public LogoutScreen3(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void logout() throws Throwable {
		
		welcome.click();
		Thread.sleep(2000);
		Logout.click();
		Thread.sleep(2000);
		
	}

}
