package com.auto.testscripts.pom;
	import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.auto.core.FrameworkScript;
import com.auto.screens.EmployeeScreen2;
import com.auto.screens.Loginscreen1;
import com.auto.screens.LogoutScreen3;

	public class Testscript extends FrameworkScript {
		
		
		@Test
		public void test() throws Throwable {
			
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			Loginscreen1 loginscreen = new Loginscreen1(driver);
			loginscreen.login("Admin", "admin123");
			
			EmployeeScreen2 employeescreen = new EmployeeScreen2(driver);
			employeescreen.createEmpolyee("pinku", "babu");
			
			LogoutScreen3 logoutscreen = new LogoutScreen3(driver);
			logoutscreen.logout();
			

		}
		
		

}
