package com.pom;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPom extends BaseClass {
	
	
	
	
	@FindBy(xpath="//p[text()='Username : Admin']")
	private WebElement username;
	
	@FindBy(xpath="//p[text()='Password : admin123']")
	private WebElement password;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement inputUsername;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement inputPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotPassword;
	
	public LoginPom()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getUsername() 
	{
		
		 return username.getText();
	}
	
	public String getPassword() 
	{
		
		 return password.getText();
	}
	
	public void setUsername(String setUsername) 
	{
		inputUsername.sendKeys(setUsername);
	}
	
	public void setPassword(String setPassword) 
	{
		inputUsername.sendKeys(setPassword);
	}
	
	public void clickLogin() 
	{
		login.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
