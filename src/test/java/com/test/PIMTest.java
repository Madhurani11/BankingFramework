package com.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPom;

public class PIMTest extends BaseClass {
	
	    

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
}