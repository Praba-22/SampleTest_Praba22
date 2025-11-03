package com.project.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelWriter {

	public static String getCellData(String sheetName, int row, int col) {
        String data = "";
        try {
            String path = System.getProperty("user.dir") + "C://Users//Dell//git//SampleTest_Praba22//Automation_SampleCodes//src//test//resources//testdata//LoginData.xlsx";
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            data = sheet.getRow(row).getCell(col).getStringCellValue();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}