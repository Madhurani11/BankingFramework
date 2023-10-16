package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass {
	
	com.pom.LoginPom LoginPom = new com.pom.LoginPom();
	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		launchTheWeb();
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	@Test
	public void loginTest() 
	{  
		
		
		LoginPom.setUsername(LoginPom.getUsername().substring(11, 16));
		LoginPom.setPassword(LoginPom.getPassword().substring(11, 19));
		LoginPom.clickLogin();
		
	}


}
