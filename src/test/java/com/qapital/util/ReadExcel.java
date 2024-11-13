package com.qapital.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    public static String path =  "C:\\Users\\Qapitol\\Desktop\\Book.xlsx";
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public static Object [][] getData() throws IOException {
        System.out.println("Entered in to getData");
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheetAt(0);
        Object[][] data = null;

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount-1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell =  row.getCell(j);
                if(cell != null){
                    switch (cell.getCellType()){
                        case STRING :
                            data[i][j] = cell.getStringCellValue();
                            System.out.println(data[i][j]);
                    }

                }
            }
        }
        return data;

    }

    public static void main(String[] args) throws IOException {
        ReadExcel readExcel = new ReadExcel();
        readExcel.getData();
    }
    public static Object[][] getHardData(){
        Object[][] data = {
                {"asnvbsd","dvwd"},
                {"dvwfe","dvefe"},
                {"asnvbsd","dvwd"},
                {"dvwfe","dvefe"}
        };
        return data;
    }
}
