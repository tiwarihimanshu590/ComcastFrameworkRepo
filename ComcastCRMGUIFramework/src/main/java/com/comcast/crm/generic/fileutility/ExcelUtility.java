package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int row,int cell) throws Exception
	{
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx"); // if we've multiple excels we can take this input also from user. 
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx"); 
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	public void setDataIntoExcel(String sheetName,int row,int cell, String data) throws Exception
	{
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx"); 
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell);
		
		FileOutputStream fos = new FileOutputStream("./testData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
