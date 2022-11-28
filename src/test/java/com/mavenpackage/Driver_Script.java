package com.mavenpackage;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.meda.automation.Utils.ActionClass;

public class Driver_Script extends ActionClass {
	public static String Actionvalue;
	public static String type;
	public static String sheetName;
	static Logger logger = Logger.getLogger(Driver_Script.class);

	public static ActionClass actionClass;
	public static Method method[];


	public Driver_Script() throws NoSuchMethodException, ClassNotFoundException {

		actionClass = new ActionClass();
		method = actionClass.getClass().getMethods();
	}

	public void TestCase() throws Exception {
		readExcel();

		// This is to start the Log4j logging in the test case
//		DOMConfigurator.configure("log4j.xml");

		Driver_Script startEngine = new Driver_Script();
		startEngine.execute_TestCase();
	}

	private void execute_TestCase() throws Exception {
		int iTotalTestCases = getRowCount(Sheet_TestCases);

		System.out.println("total testcases " + iTotalTestCases);

		for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
		result = true;
			sSno = getCellData(iTestcase, Col_Sno, Sheet_TestCases);
			System.out.println("sno is " + sSno);
			sSheetname = getCellData(iTestcase, Col_Sheetname, Sheet_TestCases);

			System.out.println("sheet name is " + sSheetname);

			sRunmode = getCellData(iTestcase, Col_RunMode, Sheet_TestCases);

			System.out.println("run mode is " + sRunmode);

			row = sheet.getRow(iTestcase);
			testcaseID_Cell0 = row.getCell(1);

			sSheetNames = getCellContentAsString(testcaseID_Cell0);

			System.out.println("Sheet names " + sSheetNames);

			try {
				
			if (sSheetname.equalsIgnoreCase(sSheetNames) && sRunmode.equalsIgnoreCase("Chrome")) {
			
				
				System.out.println("Executing - "+" Select the " +sRunmode + " browser");
				try {
					if (sRunmode.equalsIgnoreCase("Chrome")) {
						initChromeDriver(Runner.driverurl);
					}
				} catch (Exception e) {
					System.out.println("User not selected Chrome Broswer " + e.getMessage());
				}
			} else if (sSheetname.equalsIgnoreCase(sSheetNames) && sRunmode.equalsIgnoreCase("Firefox")) {
				try {
					if (sRunmode.equalsIgnoreCase("Firefox")) {
						initFirefoxDriver(Runner.driverurl);
					}
				} catch (Exception e) {
					System.out.println("User not selected Firefox Broswer " + e.getMessage());
				}
			} else if (sSheetname.equalsIgnoreCase(sSheetNames) && sRunmode.equalsIgnoreCase("Edge")) {
				try {
					if (sRunmode.equalsIgnoreCase("Edge")) {
						initEdge(Runner.driverurl);
					}
				} catch (Exception e) {
					System.out.println("User not selected Edge Broswer " + e.getMessage());
				}
			}
		}
		
		catch (Exception e) {
			System.out.println("test " + e.getMessage());
		}
		}

	}

	@Test
	public void mydriverscript() throws Throwable {
		TestCase();
	}

}
