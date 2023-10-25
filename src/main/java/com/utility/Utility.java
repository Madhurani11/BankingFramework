package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

public class Utility extends BaseClass
{
	
	public static void implicit_Wait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public Sheet read_Excel(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\kolek\\git\\BankingFramework\\src\\main\\resources\\data\\ORANGE_HRM.xlsx");
		
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
		
		return sh;
	}
	
	public Object getSingleStringData(int rowNum ,int cellNum,Sheet sh)
	{
		if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("String"))
			
		return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		else
			return sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		
			
	}
	
	public static Map<String, Object> getAllEcelData(Sheet sh)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		
	   for(int i=1;i<=sh.getLastRowNum();i++) {
		   int cellNum=sh.getRow(i).getLastCellNum();
		   for(int j=0;j<cellNum;j++){
			 
		  String key = sh.getRow(i).getCell(j).getStringCellValue().toString();
		  Object value=sh.getRow(i).getCell(++j).getNumericCellValue();
		  map.put(key, value);
		   }
		   
	   }
	   for(Map.Entry<String , Object> hm: map.entrySet()){
		   System.out.println(hm.getKey()+" "+hm.getValue());
		   
	   }
	   
	   return map;
	   
	}
	public Object[][] getData(Sheet sh) {

		int rowCount = sh.getLastRowNum();

		Map<Object, Object> finalData = new HashMap<Object, Object>();

		Object[][] excelData = new Object[rowCount][1];


		for(int i=0; i<rowCount; i++) {

			Map<Object, Object> data = new HashMap<Object, Object>();

			int colNum = sh.getRow(i).getLastCellNum();

			for(int j=0; j<colNum; j++) {

				if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric")){
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getNumericCellValue());
				}
				else {
					System.out.println("cell type not match..");
				}

			}

			excelData[i][0] = data;



			data.forEach(finalData::put);


		}

		return excelData;
	}

	public static void takeScreenShot(String fileName) throws IOException {
		String path = System.getProperty("user.dir")+"/screenshots/"+fileName+".jpeg";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(path));
	}

}


