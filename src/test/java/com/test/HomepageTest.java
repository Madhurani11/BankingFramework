package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPom;

public class HomepageTest extends BaseClass {
	com.pom.LoginPom LoginPom ;
	com.pom.HomepagePom HomepagePom ;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		launchTheWeb();
		LoginPom = new com.pom.LoginPom();
		LoginPom.setUsername(LoginPom.getUsername());
		LoginPom.setPassword(LoginPom.getPassword());
		HomepagePom = LoginPom.clickLogin();
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void validate_url() throws InterruptedException 
	{
		LoginPom = new com.pom.LoginPom();
		
		String actual=HomepagePom.show_url();
		System.out.println(actual);
		String expected=prop.getProperty("HomeUrl");
		System.out.println(expected);
		
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
