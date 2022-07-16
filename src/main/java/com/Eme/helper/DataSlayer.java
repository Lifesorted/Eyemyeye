package com.Eme.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSlayer {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	static {
		File srcFile = new File("./TestData/Datafile.xlsx");
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(srcFile);
			try {
				workbook = new XSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

        //fetch test data
	public static String getData(int sheetnum, int row, int col) {
		sheet = workbook.getSheetAt(sheetnum);
		String dataString = sheet.getRow(row).getCell(col).getStringCellValue();
		return dataString;
	}

	/*
	 * public static void main(String args[]) { //DataSlayer dSlayer = new
	 * DataSlayer(); System.out.println(DataSlayer.getData(1, 0, 1)); }
	 */

}
