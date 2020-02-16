package com.auto.testscripts.hybrid;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.core.FrameworkScript;
import com.auto.helper.ExcelHelper;
import com.auto.screens.EmployeeScreen2;
import com.auto.screens.Loginscreen1;
import com.auto.screens.LogoutScreen3;

public class Testscript extends FrameworkScript{
	
	
	@Test(dataProvider = "getTestdata")
	public void test(String userName, String password, String firstName, String lastName)throws Throwable {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Loginscreen1 loginscreen = new Loginscreen1(driver);
		loginscreen.login(userName, password);
		
		EmployeeScreen2 employeescreen = new EmployeeScreen2(driver);
		employeescreen.createEmpolyee(firstName, lastName);
		
		LogoutScreen3 logoutscreen = new LogoutScreen3(driver);
		logoutscreen.logout();
		
	}
	
	@DataProvider(name = "getTestdata")
	public Object[][] getTestdata() throws Throwable{
		
		Object[][] data = null;
		data = ExcelHelper.getTestdata();
		
		return data;
		
	}
	
	
}
