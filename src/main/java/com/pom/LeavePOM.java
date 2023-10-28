package com.pom;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LeavePOM extends BaseClass{
	
	@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-item'])[4]")
	private WebElement AssignLeave;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	private WebElement LeaveType_Dropdown;
	
	@FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//i[1]")
	private WebElement From_Date;
	
	@FindBy(xpath="//div[@class='oxd-form-row']//div[2]//div[1]//div[2]//div[1]//div[1]//i[1]")
	private WebElement To_Date;
	
	@FindBy(xpath="//button[type='submit']")
	private WebElement AssignBtn;
	
	public LeavePOM()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void click_AssignLeave() 
	{
		AssignLeave.click();
	}
	
	public void EmployeeName()
	{
		EmployeeName.sendKeys("ABC");
		
	}

	public void LeaveType()
	{
		Actions act= new Actions(driver);

        act.clickAndHold(LeaveType_Dropdown).pause(Duration.ofSeconds(5)).build().perform();
        act.click(driver.findElement(By.xpath("//span[text()='Freelance']"))).build().perform();

		
	}
	
	public void select_Date() 
	{
		
	}
	
	public void click_assign() 
	{
		AssignBtn.click();
	}
	
	
	
	
	
	
	
	
	
}
