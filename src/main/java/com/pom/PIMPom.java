package com.pom;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PIMPom extends BaseClass {
	
	 @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	  private WebElement employeeName;
			 
	 @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
		private WebElement employeeID;

	 @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	    private WebElement employeeStatus_dropdown;

	 @FindBy(xpath = "((//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	    private WebElement include_dropdown;
	 
	 @FindBy(xpath = ("//input[@placeholder='Type for hints...'])[2]"))
	    private WebElement superviserName;
	 
	 @FindBy(xpath = ("(//div[@class='oxd-select-text oxd-select-text--active'])[3]"))
	    private WebElement job_title;
	 
	 @FindBy(xpath = ("(//div[@class='oxd-select-text oxd-select-text--active'])[4]"))
	    private WebElement sub_unit;
	 
	 @FindBy(xpath = ("//button[@type='reset']"))
	    private WebElement reset_btn;
	 
	 @FindBy(xpath = ("//button[@type='submit']"))
	    private WebElement Search_btn;
	 
	 @FindBy(xpath = ("(//a[@class='oxd-topbar-body-nav-tab-item'])[2]"))
	    private WebElement Add_Empoyee;
	 
	 @FindBy(xpath = ("(//a[@class='oxd-topbar-body-nav-tab-item'])[3]"))
	    private WebElement Reports;

	 @FindBy(xpath = ("//a[text()='Add Employee']"))
	    private WebElement AddEmployee;
	 
	 @FindBy(xpath = ("//input[@placeholder='First Name']"))
	    private WebElement FirstName;
	 
	 @FindBy(xpath = ("//input[@placeholder='Middle Name']"))
	    private WebElement MiddleName;
	 
	 @FindBy(xpath = ("//input[@placeholder='Last Name']"))
	    private WebElement LastName;
	 
	 @FindBy(xpath = ("//button[@type='submit']"))
	    private WebElement Savebtn;



	    

	    public PIMPom()
	    {
	        PageFactory.initElements(driver, this);
	    }
	    
	    public String show_url() 
		{
			String url= driver.getCurrentUrl();
			return url;
		}
	    
	    
	    public void click_On_addEmpoyee() 
	    {
	    	AddEmployee.click();
	    }
	   
	    public void add_employee(String fName, String MName,String LName) 
	    {
	    	FirstName.sendKeys(fName);
	    	MiddleName.sendKeys(MName);
	    	LastName.sendKeys(LName);
	    	
	    }
	    public void click_On_SaveButton() 
	    {
	    	Savebtn.click();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	   
	}


