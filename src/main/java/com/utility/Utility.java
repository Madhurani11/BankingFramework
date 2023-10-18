package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseClass;

public class Utility extends BaseClass
{
	
	public static void implicit_Wait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public Sheet read_Excel(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Tushar\\eclipse-workspace\\Project1\\BankingProject\\src\\main\\resources\\data\\OrangeHrm.xlsx");
		
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
		
		return sh;
	}
	
	public void getSingleStringData(int rowNum ,int cellNum,Sheet sh)
	{
		if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("String"))
			
		sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		else
			sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
			
	}
	
	public Map<String, Object> getAllEcelData(Sheet sh)
	{
		Map<String,Object> map=new HashMap<String,Object>();
	   for(int i=0;i<=sh.getLastRowNum();i++) {
		  String key = sh.getRow(i).getCell(0).getStringCellValue();
		  String value=sh.getRow(i).getCell(1).getStringCellValue();
		  
		  map.put(key, value);   
	   }
	   
	  return map;
	   
	}

}
