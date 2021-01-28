package com.qa.ltcdigital.storefrontqadynamic.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelReader {

	ArrayList<String> arrlist = new ArrayList<String>();

	public ArrayList<String> readXcelData(String pathofFile, String valueToBeMatched, String columnName) {

		try {

			File src = new File(pathofFile);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook xsf = new XSSFWorkbook(fis);
			XSSFSheet sheet = xsf.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			int colNum = row.getLastCellNum();
			int rowNum = sheet.getLastRowNum() + 1;
			int requiredColumnIndex = 0;
			int requiredRowIndex = 0;

			/* Selecting Column */

			for (int i = 0; i < colNum; i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
					requiredColumnIndex = i;
					break;
				}
			}

			/*
			 * Selecting row by matching column value in the previously found
			 * column
			 */

			for (int i = 1; i < rowNum; i++) {
				if (sheet.getRow(i).getCell(requiredColumnIndex).getStringCellValue()
						.equalsIgnoreCase(valueToBeMatched)) {
					requiredRowIndex = i;
					break;
				}
			}

			/* Putting the row data into an arraylist */

			for (int i = 0; i < colNum; i++) {
				arrlist.add(sheet.getRow(requiredRowIndex).getCell(i).getStringCellValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrlist;
	}

}
