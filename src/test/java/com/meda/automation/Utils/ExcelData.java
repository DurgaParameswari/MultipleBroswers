package com.meda.automation.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.meda.automation.managers.ExtentTestManager;

public class ExcelData extends ExtentTestManager {

	public static XSSFCell cell, cell0, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11,
			cell12, cell13, cell14;
	public static XSSFSheet sheet;
	public static XSSFWorkbook excelWorkbook;
	public static XSSFRow row, row1;
	public static String filePath = Runner.filePath;

	public static FileInputStream inputFile;
	public static FileOutputStream outFile;
	public static int rowcount;
	public static int i, l;
	public static String cellValue, celldata, description, LocatorId, Entervalue, SelectValue, actualValue,
			expectedValue, stepName;
	public static int waitTime;
	public static String[] sheetNames;
	public static boolean result;

	static Logger logger = Logger.getLogger(ExcelData.class);

	public static void readExcel() throws Exception {
		try {
			logger.info("Reading Excel file");
			FileInputStream inputStream = new FileInputStream(filePath);
			excelWorkbook = new XSSFWorkbook(inputStream);
			sheet = excelWorkbook.getSheetAt(0);
			System.out.println(excelWorkbook.getSheetName(0));
		} catch (Exception e) {
			logger.warn("Unable to read the excel file " + e.getMessage());
		}
	}

	public static void readExcelsheets() throws Exception {
		try {
			logger.info("Reading Excel file");
			FileInputStream inputStream = new FileInputStream(filePath);
			excelWorkbook = new XSSFWorkbook(inputStream);
			// System.out.println("test " +inputStream);
			sheetNames = Runner.sheetNames.split(",");
		} catch (Exception e) {
			logger.warn("Unable to read the excel file " + e.getMessage());
		}
	}

	public static int getRowCount() {
		rowcount = sheet.getLastRowNum();
		return rowcount;
	}

	public static int getColumnCount() {
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public static String getCellContentAsString(Cell cell) throws Exception {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			celldata = "";
			break;

		case Cell.CELL_TYPE_STRING:
			celldata = cell.getStringCellValue();
			break;

		case Cell.CELL_TYPE_NUMERIC:
			DataFormatter df = new DataFormatter();
			celldata = df.formatCellValue(cell);
			break;

		case Cell.CELL_TYPE_FORMULA:
			celldata = String.valueOf(cell.getNumericCellValue());
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			celldata = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			celldata = cell.getStringCellValue();
			break;
		}
		return celldata;
	}

	public static String getCellData(int rowcount, int ColNum) throws Exception {
		cell = sheet.getRow(rowcount).getCell(ColNum);
		celldata = getCellContentAsString(cell);
		return celldata;
	}

	public static String mita_TestDataFromExcel(String ColumnName) throws Exception {
		for (i = 1; i <= getRowCount(); i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			String Actionvalue = cell.getStringCellValue();
			if (Actionvalue.equalsIgnoreCase(ColumnName)) {
				cell = sheet.getRow(i).getCell(1);
				cellValue = getCellContentAsString(cell);
			}
		}
		return cellValue;
	}

	public static void mita_description_excelData() throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading Description from Excel data");
			cell0 = row.getCell(0);
			description = cell0.getStringCellValue();
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the description from excel data "
					+ e.getMessage());
		}
	}

	public static void mita_Enter_excelData() throws Exception {
		try {
			logger.info(
					"Executing - " + Driver_Script.Actionvalue + ": Reading locator value and test data from excel");
			cell2 = row.getCell(1);
			LocatorId = cell2.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
			cell3 = row.getCell(2);
			Entervalue = getCellContentAsString(cell3);
			logger.info("Test data is: " + Entervalue);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue
					+ ": Unable to read the locator value and test data from excel " + e.getMessage());
		}
	}

	public static void mita_Click_excelData() {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading locator value from excel");
			cell4 = row.getCell(1);
			LocatorId = cell4.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the locator value from excel "
					+ e.getMessage());
		}
	}

	public static void mita_Select_ExcelData() throws Exception {
		try {
			logger.info(
					"Executing - " + Driver_Script.Actionvalue + ": Reading locator value and test data from excel");
			cell5 = row.getCell(1);
			LocatorId = cell5.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
			cell6 = row.getCell(2);
			SelectValue = getCellContentAsString(cell6);
			logger.info("Test data is: " + SelectValue);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue
					+ ": Unable to read the locator value and test data from excel " + e.getMessage());
		}
	}

	public static void mita_Validate_ExcelData() throws Exception {
		try {
			logger.info(
					"Executing - " + Driver_Script.Actionvalue + ": Reading locator value and test data from excel");
			cell7 = row.getCell(1);
			actualValue = cell7.getStringCellValue();
			logger.info("Locator value is: " + actualValue);
			cell8 = row.getCell(2);
			expectedValue = getCellContentAsString(cell8);
			logger.info("Test data is: " + expectedValue);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue
					+ ": Unable to read the locator value and test data from excel " + e.getMessage());
		}
	}

	public static void mita_ValidateTitle() {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading test data from excel");
			cell9 = row.getCell(2);
			expectedValue = cell9.getStringCellValue();
			logger.info("Test data is: " + expectedValue);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the test data from excel "
					+ e.getMessage());
		}
	}

	public static void mita_Frame() {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading locator value from excel");
			cell10 = row.getCell(1);
			LocatorId = cell10.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the locator value from excel "
					+ e.getMessage());
		}
	}

	public static void mita_Wait() {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading wait time from excel");
			cell11 = row.getCell(2);
			waitTime = Integer.parseInt(cell11.getStringCellValue());
			logger.info("Test data is: " + waitTime);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the locator value from excel "
					+ e.getMessage());
		}
	}

	public static void mita_stepName() {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Reading description from excel");
			cell12 = row.getCell(0);
			stepName = cell12.getStringCellValue();
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to read the description from excel "
					+ e.getMessage());
		}
	}

	public static void mita_response() {
		try {
			logger.info(
					"Executing - " + Driver_Script.Actionvalue + ": Reading locator value and test data from excel");
			cell5 = row.getCell(1);
			LocatorId = cell5.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
			cell6 = row.getCell(2);
			Entervalue = getCellContentAsString(cell6);
			logger.info("Test data is: " + Entervalue);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue
					+ ": Unable to read the locator value and test data from excel " + e.getMessage());
		}
	}
	
	public static void mita_headingTags() {
		try {
			logger.info(
					"Executing - " + Driver_Script.Actionvalue + ": Reading locator value and test data from excel");
			cell5 = row.getCell(1);
			LocatorId = cell5.getStringCellValue();
			logger.info("Locator value is: " + LocatorId);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue
					+ ": Unable to read the locator value and test data from excel " + e.getMessage());
		}
	}
}
