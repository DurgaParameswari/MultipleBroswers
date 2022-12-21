package com.mavenpackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.meda.automation.Utils.ActionClass;

public class Driver_Script extends ActionClass {
	public static String Actionvalue;
	public static String type;
	public static String sheetName;
	static Logger logger = Logger.getLogger(Driver_Script.class);

	public static void ReadExcel() throws Throwable {
		try {
			readExcelsheets();

			if (Runner.browserType.contains(",") || Runner.browserType != " ") {
				bt = Runner.browserType.split(",");
				for (l = 0; l < bt.length; l++) {
					logger.info("Broswer type is " + bt[l]);
					getCurrentTime();

					for (j = 0; j < sheetNames.length; j++) {
						sheet = excelWorkbook.getSheet(sheetNames[j]);
						mita_cleanTheResults();
						sheet = excelWorkbook.getSheet(sheetNames[j]);
						mita_cleanTheResults();
						sheetName = sheet.getSheetName();
						lastRow = sheet.getLastRowNum();
						logger.info("Executing - " + sheetName + " and Row count is: " + lastRow);

						i = 1;
						while (i <= lastRow) {
							row = sheet.getRow(i);
							cell0 = row.getCell(0);
							type = getCellContentAsString(cell0);
							if (type.equalsIgnoreCase("Mobile")) {
								logger.info("Mobile Execution Starting:");
								mita_executionType(type);
								mobile_methods();
							} else {
								logger.info("WEB Execution Starting:");
								mita_executionType(type);
								web_methods();
							}
						}
					}
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			logger.warn(e.getMessage());
		}
	}

	public static void mobile_methods() throws Exception {
		try {
			for (k = i + 1; k <= lastRow; k++) {
				row = sheet.getRow(k);
				cell0 = row.getCell(0);
				Actionvalue = getCellContentAsString(cell0);
				if (Actionvalue.toLowerCase().contains("apk")) {
					setup(Runner.deviceType);
					mita_Mobile_write();
				} else if (Actionvalue.toLowerCase().contains("enter") || Actionvalue.toLowerCase().contains("insert")
						|| Actionvalue.toLowerCase().contains("inserting")
						|| Actionvalue.toLowerCase().contains("entering") || Actionvalue.toLowerCase().contains("input")
						|| Actionvalue.toLowerCase().contains("editing") || Actionvalue.toLowerCase().contains("put")) {
					mita_Enter_excelData();
					Machint_Mobile_EnterTextField("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("keys")
						|| Actionvalue.toLowerCase().contains("keyvalue")) {
					mita_Enter_excelData();
					Machint_Mobile_EnterTextKey("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("click") || Actionvalue.toLowerCase().contains("hit")
						|| Actionvalue.toLowerCase().contains("clicking")
						|| Actionvalue.toLowerCase().contains("submit")
						|| Actionvalue.toLowerCase().contains("submiting")
						|| Actionvalue.toLowerCase().contains("accept")
						|| Actionvalue.toLowerCase().contains("dismis")) {
					mita_Click_excelData();
					Machint_Mobile_Click("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("select")
						|| Actionvalue.toLowerCase().contains("select with text")
						|| Actionvalue.toLowerCase().contains("selecting")) {
					mita_Select_ExcelData();
					Machint__Mobile_selectValue("xpath", LocatorId, SelectValue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("index")) {
					mita_Select_ExcelData();
					Machint_Mobile_selectIndex("xpath", LocatorId, 1, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scenario")) {
					mita_stepName();
					mita_scenarioNumber(Actionvalue);
				} else if (Actionvalue.toLowerCase().contains("switch")) {
					mita_Select_ExcelData();
					Machint_Mobile_acceptAlert();
				} else if (Actionvalue.toLowerCase().contains("clock")
						|| Actionvalue.toLowerCase().contains("clocks")) {
					mita_Enter_excelData();
					Machint_Mobile_Clock("xpath", LocatorId, SelectValue);
				} else if (Actionvalue.toLowerCase().contains("getthefirstvalue")
						|| Actionvalue.toLowerCase().contains("get the first value")
						|| Actionvalue.toLowerCase().contains("getfirstvalue")
						|| Actionvalue.toLowerCase().contains("getvalueone")
						|| Actionvalue.toLowerCase().contains("getvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstgetvalue")) {
					mita_Click_excelData();
					Machint_Mobile_GetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthefirstvalue")
						|| Actionvalue.toLowerCase().contains("set the first value")
						|| Actionvalue.toLowerCase().contains("setfirstvalue")
						|| Actionvalue.toLowerCase().contains("setvalueone")
						|| Actionvalue.toLowerCase().contains("setvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstsetvalue")) {
					mita_Click_excelData();
					Machint_Mobile_SetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthesecondvalue")
						|| Actionvalue.toLowerCase().contains("get the second value")
						|| Actionvalue.toLowerCase().contains("getsecondvalue")
						|| Actionvalue.toLowerCase().contains("getvaluetwo")
						|| Actionvalue.toLowerCase().contains("getvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondgetvalue")) {
					mita_Click_excelData();
					Machint_Mobile_GetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthesecondvalue")
						|| Actionvalue.toLowerCase().contains("set the second value")
						|| Actionvalue.toLowerCase().contains("setsecondvalue")
						|| Actionvalue.toLowerCase().contains("setvaluesecond")
						|| Actionvalue.toLowerCase().contains("setvaluetwo")
						|| Actionvalue.toLowerCase().contains("secondsetvalue")) {
					mita_Click_excelData();
					Machint_Mobile_SetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("validate")
						|| Actionvalue.toLowerCase().contains("validating")
						|| Actionvalue.toLowerCase().contains("compare")
						|| Actionvalue.toLowerCase().contains("comparing")
						|| Actionvalue.toLowerCase().contains("assert")
						|| Actionvalue.toLowerCase().contains("asserting")
						|| Actionvalue.toLowerCase().contains("assertequals")
						|| Actionvalue.toLowerCase().contains("check") || Actionvalue.toLowerCase().contains("checking")
						|| Actionvalue.toLowerCase().contains("find") || Actionvalue.toLowerCase().contains("finding")
						|| Actionvalue.toLowerCase().contains("equal to")) {
					mita_Validate_ExcelData();
					Machint_Mobile_Equals_Validation("xpath", actualValue, expectedValue);
				} else if (Actionvalue.toLowerCase().contains("title")) {
					mita_ValidateTitle();
					Machint_Mobile_getTitle(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("dropdown")
						|| Actionvalue.toLowerCase().contains("drop down")) {
					mita_Enter_excelData();
					Machint_Mobile_Scrollintoview("xpath", LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("alertText")) {
					mita_Click_excelData();
					Machint_Mobile_getAlertText();
					// mita_Click_excelData();
					// mita_getAlertText();
					// mita_acceptAlert();
				} else if (Actionvalue.toLowerCase().contains("loading")
						|| Actionvalue.toLowerCase().contains("load")) {
					mita_Click_excelData();
					machint_Mobile_ProgressBar_wait("xpath", LocatorId, "invisibilityOf");
				} else if (Actionvalue.toLowerCase().contains("random")) {
					mita_Enter_excelData();
					Machint_Mobile_generateRandomNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("zero")) {
					mita_Enter_excelData();
					Machint_Mobile_zeroStartsNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("add dates")
						|| Actionvalue.toLowerCase().contains("adddates")
						|| Actionvalue.toLowerCase().contains("adding dates")
						|| Actionvalue.toLowerCase().contains("addingdates")) {
					mita_Enter_excelData();
					mita_MobileAddDates("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("dynamic string")
						|| Actionvalue.toLowerCase().contains("dynamicstring")
						|| Actionvalue.toLowerCase().contains("dynamic")
						|| Actionvalue.toLowerCase().contains("string dynamic")
						|| Actionvalue.toLowerCase().contains("stringdynamic")) {
					mita_Enter_excelData();
					mita_MobileDynamicString("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("append") || Actionvalue.toLowerCase().contains("prefix")
						|| Actionvalue.toLowerCase().contains("pre fix")
						|| Actionvalue.toLowerCase().contains("pre-fix") || Actionvalue.toLowerCase().contains("affix")
						|| Actionvalue.toLowerCase().contains("join")) {
					mita_Enter_excelData();
					mita_MobileAppendText("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("handling")) {
					mita_Enter_excelData();
					Machint_Mobile_Number_OTP("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scrollup")) {
					mita_Enter_excelData();
					Machint_Mobile_scrollup(LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("scrolldown")) {
					// mita_Enter_excelData();
					mita_ValidateTitle();
					Machint_Mobile_scrollDown(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("singletap")) {
					mita_Click_excelData();
					Machint_Mobile_SingleTap("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("Doubletap")) {
					mita_Click_excelData();
					Machint_Mobile_DoubleTap("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("Progressbar")) {
					mita_Click_excelData();
					machint_Mobile_ProgressBar_wait("xpath", LocatorId, "invisibilityOf");
				} else if (Actionvalue.toLowerCase().contains("digital signature")) {
					mita_Click_excelData();
					Machint_Mobile_sign("xpath", LocatorId);
				} else if (Actionvalue.toLowerCase().contains("drag")) {
					mita_Enter_excelData();
					Machint_Mobile_SeekBar("xpath", LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("frame")) {
					mita_Frame();
					mita_Frame_webElement("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("wait") || Actionvalue.toLowerCase().contains("standby")
						|| Actionvalue.toLowerCase().contains("holdback") || Actionvalue.toLowerCase().contains("pause")
						|| Actionvalue.toLowerCase().contains("halt")
						|| Actionvalue.toLowerCase().contains("give a break")
						|| Actionvalue.toLowerCase().contains("delay") || Actionvalue.toLowerCase().contains("hold on")
						|| Actionvalue.toLowerCase().contains("intermission")) {
					mita_Wait();
					mita_Mobile_wait_time(waitTime);
				} else if (Actionvalue.toLowerCase().contains("gettheleadid")
						|| Actionvalue.toLowerCase().contains("get the lead id")
						|| Actionvalue.toLowerCase().contains("getleadid")) {
					mita_Click_excelData();
					Machint_Mobile_GetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("settheleadid")
						|| Actionvalue.toLowerCase().contains("set the lead id")
						|| Actionvalue.toLowerCase().contains("setleadid")) {
					mita_Click_excelData();
					Machint_Mobile_SetTheLeadId("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("closeframe")
						|| Actionvalue.toLowerCase().contains("close frame")
						|| Actionvalue.toLowerCase().contains("close the frame")
						|| Actionvalue.toLowerCase().contains("closing frame")
						|| Actionvalue.toLowerCase().contains("final frame")
						|| Actionvalue.toLowerCase().contains("finalise frame")
						|| Actionvalue.toLowerCase().contains(" frame")
						|| Actionvalue.toLowerCase().contains("come out of frame")
						|| Actionvalue.toLowerCase().contains("iframe")) {
					mita_defaultFrame();
				} else if (Actionvalue.toLowerCase().contains("testcase")
						|| Actionvalue.toLowerCase().contains("test case")
						|| Actionvalue.toLowerCase().contains("finish")
						|| Actionvalue.toLowerCase().contains("finishing")
						|| Actionvalue.toLowerCase().contains("finished")
						|| Actionvalue.toLowerCase().contains("complete")
						|| Actionvalue.toLowerCase().contains("completing")
						|| Actionvalue.toLowerCase().contains("completed")) {
					mita_Mobile_write();
					mobiledriver.quit();
				} else if (Actionvalue.toLowerCase().contains("end")) {
					mita_stepName();
					mita_scenarioNumber(Actionvalue);
					i = k + 1;
					mobiledriver.quit();
					break;
				} else if (Actionvalue.toLowerCase().contains("")) {
					mita_Mobile_Please_do_Spellcheck();
				}
			}

		} catch (NoSuchElementException e) {
//		System.out.println("Mobile-Please do spell check");
			logger.info("Mobile-Please do spell ckeck");
			mita_Mobile_Please_do_Spellcheck();

		}
	}

	public static void web_methods() throws Exception {
		try {
			for (k = i + 1; k <= lastRow; k++) {
				row = sheet.getRow(k);
				cell0 = row.getCell(0);
				Actionvalue = getCellContentAsString(cell0);
				if (Actionvalue.toLowerCase().contains("url")) {
					launchBrowsers(bt[l], Runner.driverurl);
					mita_Web_write();
				} else if (Actionvalue.toLowerCase().contains("enter") || Actionvalue.toLowerCase().contains("insert")
						|| Actionvalue.toLowerCase().contains("inserting")
						|| Actionvalue.toLowerCase().contains("entering") || Actionvalue.toLowerCase().contains("input")
						|| Actionvalue.toLowerCase().contains("editing") || Actionvalue.toLowerCase().contains("put")
						|| Actionvalue.toLowerCase().contains("write")) {
					mita_Enter_excelData();
					mita_EnterTextField("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("display")) {
					mita_Enter_excelData();
					Machint_WebElemenDisplay("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("keys") || Actionvalue.toLowerCase().contains("keyvalue")
						|| Actionvalue.toLowerCase().contains("keyText")
						|| Actionvalue.toLowerCase().contains("drop down")
						|| Actionvalue.toLowerCase().contains("dropdown")) {
					mita_Enter_excelData();
					mita_EnterTextKey("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("char")
						|| Actionvalue.toLowerCase().contains("character")) {
					mita_Enter_excelData();
					Machint_Web_EnterCharacter("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("click") || Actionvalue.toLowerCase().contains("hit")
						|| Actionvalue.toLowerCase().contains("clicking")
						|| Actionvalue.toLowerCase().contains("submit")
						|| Actionvalue.toLowerCase().contains("submiting")
						|| Actionvalue.toLowerCase().contains("accept")
						|| Actionvalue.toLowerCase().contains("dismis")) {
					mita_Click_excelData();
					mita_Click("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("select")
						|| Actionvalue.toLowerCase().contains("select with text")
						|| Actionvalue.toLowerCase().contains("selecting")) {
					mita_Select_ExcelData();
					mita_selectVisibleText("xpath", LocatorId, SelectValue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("auto suggestion")
						|| Actionvalue.toLowerCase().contains("autosuggestion")
						|| Actionvalue.toLowerCase().contains("autolist")
						|| Actionvalue.toLowerCase().contains("auto list")
						|| Actionvalue.toLowerCase().contains("autocomplete")
						|| Actionvalue.toLowerCase().contains("auto complete")) {
					mita_Enter_excelData();
					mita_AutoSuggestion_Dropdown("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("index")) {
					mita_Select_ExcelData();
					mita_selectIndex("xpath", LocatorId, 1, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scenario")) {
					mita_stepName();
					mita_scenarioNumber(Actionvalue);
				} else if (Actionvalue.toLowerCase().contains("handling")) {
					mita_Enter_excelData();
					machintWeb_Mobile_Number_OTP("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("random")) {
					mita_Enter_excelData();
					Machint_Web_generateRandomNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("zero")) {
					mita_Enter_excelData();
					Machint_zeroStartsNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("dynamic string")
						|| Actionvalue.toLowerCase().contains("dynamicstring")
						|| Actionvalue.toLowerCase().contains("dynamic")
						|| Actionvalue.toLowerCase().contains("string dynamic")
						|| Actionvalue.toLowerCase().contains("stringdynamic")) {
					mita_Enter_excelData();
					mita_WebDynamicString("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("append") || Actionvalue.toLowerCase().contains("prefix")
						|| Actionvalue.toLowerCase().contains("pre fix")
						|| Actionvalue.toLowerCase().contains("pre-fix") || Actionvalue.toLowerCase().contains("affix")
						|| Actionvalue.toLowerCase().contains("join")) {
					mita_Enter_excelData();
					mita_WebAppendText("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("upload")
						|| Actionvalue.toLowerCase().contains("uploading")
						|| Actionvalue.toLowerCase().contains("browsing")
						|| Actionvalue.toLowerCase().contains("browse")) {
					mita_Enter_excelData();
					mita_uploadsendkeys("xpath", LocatorId, Entervalue);
					// mita_Enter_excelData();
//					mita_Robot_uploadFile("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("switch")) {
					mita_Select_ExcelData();
					mita_acceptAlert();
				} else if (Actionvalue.toLowerCase().contains("getvaluefromapp")) {
					mita_Click_excelData();
					Machint_Web_GetTheValueFromApp("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setvalueinapp")) {
					mita_Click_excelData();
					Machint_Web_SetThtValueInApp("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthefirstvalue")
						|| Actionvalue.toLowerCase().contains("get the first value")
						|| Actionvalue.toLowerCase().contains("getfirstvalue")
						|| Actionvalue.toLowerCase().contains("getvalueone")
						|| Actionvalue.toLowerCase().contains("getvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstgetvalue")) {
					mita_Click_excelData();
					Machint_Web_GetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthefirstvalue")
						|| Actionvalue.toLowerCase().contains("set the first value")
						|| Actionvalue.toLowerCase().contains("setfirstvalue")
						|| Actionvalue.toLowerCase().contains("setvalueone")
						|| Actionvalue.toLowerCase().contains("setvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstsetvalue")) {
					mita_Click_excelData();
					Machint_Web_SetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthesecondvalue")
						|| Actionvalue.toLowerCase().contains("get the second value")
						|| Actionvalue.toLowerCase().contains("getsecondvalue")
						|| Actionvalue.toLowerCase().contains("getvaluetwo")
						|| Actionvalue.toLowerCase().contains("getvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondgetvalue")) {
					mita_Click_excelData();
					Machint_Web_GetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthesecondvalue")
						|| Actionvalue.toLowerCase().contains("set the second value")
						|| Actionvalue.toLowerCase().contains("setsecondvalue")
						|| Actionvalue.toLowerCase().contains("setvaluetwo")
						|| Actionvalue.toLowerCase().contains("setvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondsetvalue")) {
					mita_Click_excelData();
					Machint_Web_SetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("validate")
						|| Actionvalue.toLowerCase().contains("validating")
						|| Actionvalue.toLowerCase().contains("compare")
						|| Actionvalue.toLowerCase().contains("comparing")
						|| Actionvalue.toLowerCase().contains("assert")
						|| Actionvalue.toLowerCase().contains("asserting")
						|| Actionvalue.toLowerCase().contains("assertequals")
						|| Actionvalue.toLowerCase().contains("check") || Actionvalue.toLowerCase().contains("checking")
						|| Actionvalue.toLowerCase().contains("find") || Actionvalue.toLowerCase().contains("finding")
						|| Actionvalue.toLowerCase().contains("equal to")) {
					mita_Validate_ExcelData();
					mita_Equals_Validation("xpath", actualValue, expectedValue);
				} else if (Actionvalue.toLowerCase().contains("title")) {
					mita_ValidateTitle();
					mita_AssertTitle(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("frame")) {
					mita_Frame();
					mita_Frame_webElement("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scrolldown")) {
					mita_Click_excelData();
					scrollDown("xpath", LocatorId);
				} else if (Actionvalue.toLowerCase().contains("wait") || Actionvalue.toLowerCase().contains("standby")
						|| Actionvalue.toLowerCase().contains("holdback") || Actionvalue.toLowerCase().contains("pause")
						|| Actionvalue.toLowerCase().contains("halt")
						|| Actionvalue.toLowerCase().contains("give a break")
						|| Actionvalue.toLowerCase().contains("delay") || Actionvalue.toLowerCase().contains("hold on")
						|| Actionvalue.toLowerCase().contains("intermission")) {
					mita_Wait();
					mita_Web_wait_time(waitTime);
				} else if (Actionvalue.toLowerCase().contains("gettheleadid")
						|| Actionvalue.toLowerCase().contains("get the lead id")
						|| Actionvalue.toLowerCase().contains("getleadid")) {
					mita_Click_excelData();
					Machint_Web_GetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("settheleadid")
						|| Actionvalue.toLowerCase().contains("set the lead id")
						|| Actionvalue.toLowerCase().contains("setleadid")) {
					mita_Click_excelData();
					Machint_Web_SetTheLeadId("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("mouseover")
						|| Actionvalue.toLowerCase().contains("mousehower")
						|| Actionvalue.toLowerCase().contains("mouse hower")
						|| Actionvalue.toLowerCase().contains("mouse over")) {
					mita_Click_excelData();
					mita_mouseOver(LocatorId);
				} else if (Actionvalue.toLowerCase().contains("settheotp")
						|| Actionvalue.toLowerCase().contains("set the otp id")
						|| Actionvalue.toLowerCase().contains("setotp")) {
					mita_Click_excelData();
					Machint_Web_SetTheOTP("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("closeframe")
						|| Actionvalue.toLowerCase().contains("close frame")
						|| Actionvalue.toLowerCase().contains("close the frame")
						|| Actionvalue.toLowerCase().contains("closing frame")
						|| Actionvalue.toLowerCase().contains("come out of frame")
						|| Actionvalue.toLowerCase().contains("iframe")) {
					mita_defaultFrame();
				} else if (Actionvalue.toLowerCase().contains("refresh")) {
					mita_refresh();
				} else if (Actionvalue.toLowerCase().contains("close")
						|| Actionvalue.toLowerCase().contains("test case")
						|| Actionvalue.toLowerCase().contains("finish")
						|| Actionvalue.toLowerCase().contains("finishing")
						|| Actionvalue.toLowerCase().contains("finished")
						|| Actionvalue.toLowerCase().contains("complete")
						|| Actionvalue.toLowerCase().contains("completing")
						|| Actionvalue.toLowerCase().contains("completed")) {
					driver.quit();
				} else if (Actionvalue.toLowerCase().contains("end")) {
					mita_stepName();
					mita_scenarioNumber(Actionvalue);
					i = k + 1;
					driver.close();
					break;
				} else if (Actionvalue.toLowerCase().contains("")) {
					mita_Web_Please_do_Spellcheck();
					logger.info("Entered keyword is not available in the script");
				}
			}

		} catch (NoSuchElementException e) {
			mita_Web_Please_do_Spellcheck();
			logger.info("WEB-Please do spell ckeck");
		}
	}

	@Test
	public void mydriverscript() throws Throwable {
		ReadExcel();
	}
}
