package org.example.Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXOperation {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// CreateRow
		// Add Cell 
	 // Set Cell datra
		
		FileOutputStream fos = new FileOutputStream(("C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Desktop\\CashFloApiAutomationPreMAster\\FileOperation\\src\\main\\resources"));
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
//		XSSFSheet sheet = 	workbook.getSheet("Demo");
		XSSFSheet  sheet  = workbook.createSheet("Demo2");
		
		for(int i =0; i<10;i++) {
			XSSFRow row = sheet.createRow(i);
			
			for (int j= 0; j<4; j++) {
				row.createCell(j).setCellValue("Added1"+j);

			}
		}
		
//		row.createCell(1).setCellValue("Added2");
		
		workbook.write(fos);
		
		System.out.println("WorkBook Created Successfully");
//		int num = sheet.getLastRowNum();
//		for(int i =0; i<sheet.getLastRowNum();i++) {
//			XSSFRow row = sheet.getRow(i);
//			for(int j=0; j<row.getLastCellNum();j++ ) {
//				System.out.println(row.getCell(j));
//			}
//		}
		
		workbook.close();
		
	}
}
