package com.qa.ltcdigital.storefrontqadynamic.util;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	public static int IMPLICIT_WAIT= 30;
	public static int PAGE_LOAD_TIMEOUT=40;
	
	public String readExcelData(String pathOfFile, int rowVal, int colVal) throws Exception{
		File src = new File(pathOfFile);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String textvalue = sheet.getRow(rowVal).getCell(colVal).getStringCellValue();
		xsf.close();
		return textvalue;
	}
}
