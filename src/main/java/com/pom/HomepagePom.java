package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomepagePom extends BaseClass{
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement Admin;

	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIM;
	
	@FindBy(xpath="//span[text()='Leave']")
	private WebElement Leave;
	
	@FindBy(xpath="//span[text()='Time']")
	private WebElement Time;
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement Recruitment;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement MyInfo;
	
	@FindBy(xpath="//span[text()='Performance']")
	private WebElement Performance;
	
	@FindBy(xpath="//span[text()='//p[text()='Time at Work']']")
	private WebElement TimeAtWork;
	
	public HomepagePom()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String show_url() 
	{
		String url= driver.getCurrentUrl();
		return url;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public void click_on_admin()
	{
		Admin.click();
		
	}

	public PIMPom click_on_PIM()
	{
		PIM.click();
		return new com.pom.PIMPom();
	}
	public void click_on_leave()
	{
		Leave.click();
	}
	public void click_on_Time()
	{
		Time.click();
	}
	
	
	
	
	
	
	
	
}
