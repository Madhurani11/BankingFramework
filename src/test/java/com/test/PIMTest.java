package com.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPom;
import com.utility.Utility;

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
			LoginPom.setPassword(LoginPom.getPassword());
			
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
	    
	    @Test(dataProvider="AddEmpoyeeData")
	    public void validate_add_Employee(String firstName,String MiddleName,String LastName) throws InterruptedException 
	    {
	    	PIMPom.click_On_addEmpoyee();
	    	PIMPom.add_employee(firstName, MiddleName, LastName);
	    	Thread.sleep(5000);
	    	PIMPom.click_On_SaveButton();
	    	Thread.sleep(5000);
	    	
	    //	String Actual=PIMPom.SuccessfulMSG();
	    //	System.out.println(Actual);
	    	
	    //	String expected="";
	    }
	    
	    
	    @DataProvider
	    public Object[][] AddEmpoyeeData() 
	    {
	    	Object[][] data=Utility.getTestData("Sheet1");
	    	return data;
	    }
		
		@AfterClass
		public void tearDown() 
		{
			driver.quit();
		}
}