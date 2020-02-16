package com.auto.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeScreen2 {
	
	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement menu_pim_viewPimModule = null;
	
	@FindBy(id = "menu_pim_addEmployee")
	private WebElement menu_pim_addEmployee = null;
	
	@FindBy(id = "firstName")
	private WebElement firstName = null;
	
	@FindBy(id = "lastName")
	private WebElement lastName = null;
	
	@FindBy(id = "btnSave")
	private WebElement btnSave = null;
	
	public EmployeeScreen2(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void createEmpolyee(String firstname, String lastname) {
		
		menu_pim_viewPimModule.click();
		menu_pim_addEmployee.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		btnSave.click();
		
		
	}
	
	

}
