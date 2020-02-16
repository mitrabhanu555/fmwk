package com.auto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class A {
// rough programme
	public static void main(String[] args) throws Throwable, Throwable {
		
		
		File file = new File("D:\\rajv.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(input);
		Sheet sheet = wb.getSheet("Sheet1");
		
		
		
		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		
	    for (int rowindex = 1; rowindex <= sheet.getLastRowNum(); rowindex++) {
	    	
	    	    Row currentrow = sheet.getRow(rowindex);
	    	
	    	
	    	for (int colindex = currentrow.getFirstCellNum(); colindex <currentrow.getLastCellNum(); colindex++) {
	    		
	    	
	    		
	    		data[rowindex][colindex] = sheet.getRow(rowindex).getCell(colindex).toString();
	    		
	    		//System.out.print(sheet.getRow(rowindex ).getCell(colindex) + " \t ");
	    		System.out.print(data[rowindex][colindex]   + "       " );
			}
			System.out.println();
		}
		
	     wb.close();

	}

}
