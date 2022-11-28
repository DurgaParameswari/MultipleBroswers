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

import com.mavenpackage.Runner;

public class ExcelData {

	public static XSSFCell cell, cell0, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11,
			cell12, cell13, cell14, testcaseID_Cell0;
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
	static Logger logger = Logger.getLogger(ExcelData.class);

	public static String excelFilePath = "C:\\Users\\M0137\\git\\repository3\\MultipleBroswers\\TestCasesinExcell\\MagnifyB\\MagnifyB.xlsx";
	public static String Sheet_TestCases = "sheetnames";

	public static boolean result;

	public static String sSno;
	public static String sSheetname;
	public static String sRunmode;

	// New entry in Constant variable
	public static final int Col_Sno = 0;
	public static final int Col_Sheetname = 1;
	public static final int Col_RunMode = 2;
	
	public static String sSheetNames;

	public static void readExcel() throws Exception {
		try {
			FileInputStream inputStream = new FileInputStream(Runner.filePath);
			excelWorkbook = new XSSFWorkbook(inputStream);
			sheet = excelWorkbook.getSheet(Runner.sheetNames);
		} catch (Exception e) {
			System.out.println("Class Utils | Method readexcel | Exception desc : " + e.getMessage());
			result = false;
		}
	}

	public static int getRowCount() {
		rowcount = sheet.getLastRowNum();
		return rowcount;
	}

	public static int getRowCount(String SheetName) {
		sheet = excelWorkbook.getSheet(SheetName);
		rowcount = sheet.getLastRowNum() + 1;
		return rowcount;
	}

	// This method is to read the test data from the Excel cell
	// In this we are passing Arguments as Row Num, Col Num & Sheet Name
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		try {
			sheet = excelWorkbook.getSheet(SheetName);
			cell = sheet.getRow(RowNum).getCell(ColNum);
			String CellData = getCellContentAsString(cell);
			return CellData;
		} catch (Exception e) {
			System.out.println("Class ExcelUtils | Method getCellData | Exception desc : " + e.getMessage());
			result = false;
			return "";
		}
	}

	// This method is to get cell types used of the excel sheet
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
	
	// This method is to get the Row number of the test case
		// This methods takes three arguments(Test Case name , Column Number & Sheet
		// name)
		public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
			int iRowNum = 0;
			try {
				sheet = excelWorkbook.getSheet(SheetName);
				int rowCount = getRowCount(SheetName);
				for (; iRowNum < rowCount; iRowNum++) {
					if (getCellData(iRowNum, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
				result = false;
			}
			return iRowNum;
		}

}
