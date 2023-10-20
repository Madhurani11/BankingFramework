package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class HomepageTest extends BaseClass {
	com.pom.LoginPom LoginPom ;
	com.pom.HomepagePom HomepagePom ;
	
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
	@Test(priority=1)
	public void validate_url() 
	{
		LoginPom = new com.pom.LoginPom();
		HomepagePom = new com.pom.HomepagePom ();
		String actual=HomepagePom.show_url();
		String expected=prop.getProperty("HomeUrl");
		
		Assert.assertEquals(actual, expected);
	
	}
	
	@Test(priority=2)
	public void test() 
	{
		LoginPom = new com.pom.LoginPom();
		HomepagePom = new com.pom.HomepagePom ();
		HomepagePom.click_on_PIM();;
	}

}
