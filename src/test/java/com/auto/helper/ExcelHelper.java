package com.auto.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {
	
	public static Object[][] getTestdata() throws Throwable{
		Object[][] data = null;
		File file = new File("D:\\framewrkMQ\\TestData.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(input);
		Sheet sheet = wb.getSheet("Sheet1");
		data= new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		for (int rowindex = sheet.getFirstRowNum(); rowindex < sheet.getPhysicalNumberOfRows(); rowindex++) {
			
			for (int colindex = sheet.getRow(0).getFirstCellNum(); colindex < sheet.getRow(rowindex).getPhysicalNumberOfCells(); colindex++) {
				
				data[rowindex][colindex] = sheet.getRow(rowindex).getCell(colindex).toString();
				
			}
			
		}
		wb.close();
		return data;	
		
	}
	
	
	



}
