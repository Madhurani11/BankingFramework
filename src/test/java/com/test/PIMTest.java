package com.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPom;

public class PIMTest extends BaseClass {
	
	     LoginPom LoginPom ;
	     com.pom.HomepagePom HomepagePom;
	     com.pom.PIMPom PIMPom;

	    @BeforeClass
		public void setUp() throws InterruptedException
		{
			launchTheWeb();
			LoginPom = new com.pom.LoginPom();
			
			LoginPom.setUsername(LoginPom.getUsername());
			Thread.sleep(3000);
			
			LoginPom.setPassword(LoginPom.getPassword());
			Thread.sleep(3000);
			HomepagePom = LoginPom.clickLogin();
			
			PIMPom=HomepagePom.click_on_PIM();
			
		}
	    @Test
	    public void validate_url() throws InterruptedException 
		{
			PIMPom = new com.pom.PIMPom();
			
			String actual=PIMPom.show_url();
			System.out.println(actual);
			String expected=prop.getProperty("PIMurl");
			System.out.println(expected);
			
			Assert.assertEquals(actual, expected);
		
		}
	    
	    @Test
	    public void pimTest() 
	    {
	    	
	    }
		
		@AfterClass
		public void tearDown() 
		{
			driver.quit();
		}
}