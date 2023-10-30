package com.listener;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;



public class ExtentManager {

	private static ExtentReports extent;
	
	public static String fileName;
	
	

	    public static ExtentReports createInstance(String fileName) {
	    	
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Organization","Insight Infy");
	        extent.setSystemInfo("Project", "Insight Infy Project");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Browser", "Chrome");
	        extent.setSystemInfo("Regression Date", "28 october 2023");
	        extent.setSystemInfo("Test Run", "After Publish");
	        extent.setSystemInfo("Automation Tester", "Madhu");
	        
	        
	        return extent;
	    }

	    
		public static void captureScreenshot() throws IOException {
			
			Date d = new Date();
			 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			File screeshot = ((TakesScreenshot)  BaseClass.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//extentReports//"+fileName));
		}
		
		

		public static void captureElementScreenshot(WebElement element) throws IOException {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//screenshot//"+"Element_"+fileName));
		}

	


	}

