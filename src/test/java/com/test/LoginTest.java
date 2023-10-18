package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass {
	
	com.pom.LoginPom LoginPom ;
	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		launchTheWeb();
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		//driver.quit();
	}
	@Test
	public void loginTest() throws InterruptedException 
	{  
		LoginPom = new com.pom.LoginPom();
		
		LoginPom.setUsername(LoginPom.getUsername());
		Thread.sleep(3000);
		LoginPom.setPassword(LoginPom.getPassword());
		Thread.sleep(3000);
		LoginPom.clickLogin();
		
	}


}
