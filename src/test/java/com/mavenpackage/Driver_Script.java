package com.mavenpackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.meda.automation.Utils.ActionClass;
import com.meda.automation.Utils.MobileActionClass;

public class Driver_Script extends MobileActionClass {
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
					mitaGetCurrentTime();

					for (j = 0; j < sheetNames.length; j++) {
						sheet = excelWorkbook.getSheet(sheetNames[j]);
						mitaCleanTheResults();
						sheet = excelWorkbook.getSheet(sheetNames[j]);
						mitaCleanTheResults();
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
								mitaExecutionType(type);
								mobileMethods();
							} else {
								logger.info("WEB Execution Starting:");
								mitaExecutionType(type);
								webMethods();
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

	public static void mobileMethods() throws Exception {
		try {
			for (k = i + 1; k <= lastRow; k++) {
				row = sheet.getRow(k);
				cell0 = row.getCell(0);
				Actionvalue = getCellContentAsString(cell0);
				if (Actionvalue.toLowerCase().contains("apk")) {
					setup(Runner.deviceType);
					mitaMobileWrite();
				} else if (Actionvalue.toLowerCase().contains("enter") || Actionvalue.toLowerCase().contains("insert")
						|| Actionvalue.toLowerCase().contains("inserting")
						|| Actionvalue.toLowerCase().contains("entering") || Actionvalue.toLowerCase().contains("input")
						|| Actionvalue.toLowerCase().contains("editing") || Actionvalue.toLowerCase().contains("put")) {
					mitaEnterExcelData();
					mitaMobileEnterTextField("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("keys")
						|| Actionvalue.toLowerCase().contains("keyvalue")) {
					mitaEnterExcelData();
					mitaMobileEnterTextKey("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("click") || Actionvalue.toLowerCase().contains("hit")
						|| Actionvalue.toLowerCase().contains("clicking")
						|| Actionvalue.toLowerCase().contains("submit")
						|| Actionvalue.toLowerCase().contains("submiting")
						|| Actionvalue.toLowerCase().contains("accept")
						|| Actionvalue.toLowerCase().contains("dismis")) {
					mitaClickExcelData();
					mitaMobileClick("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("select")
						|| Actionvalue.toLowerCase().contains("select with text")
						|| Actionvalue.toLowerCase().contains("selecting")) {
					mitaSelectExcelData();
					mitaMobileSelectValue("xpath", LocatorId, SelectValue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("index")) {
					mitaSelectExcelData();
					mitaMobileSelectIndex("xpath", LocatorId, 1, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scenario")) {
					mitaStepName();
					mitaScenarioNumber(Actionvalue);
				} else if (Actionvalue.toLowerCase().contains("switch")) {
					mitaSelectExcelData();
					mitaMobileAcceptAlert();
				} else if (Actionvalue.toLowerCase().contains("clock")
						|| Actionvalue.toLowerCase().contains("clocks")) {
					mitaEnterExcelData();
					mitaMobileClock("xpath", LocatorId, SelectValue);
				} else if (Actionvalue.toLowerCase().contains("getthefirstvalue")
						|| Actionvalue.toLowerCase().contains("get the first value")
						|| Actionvalue.toLowerCase().contains("getfirstvalue")
						|| Actionvalue.toLowerCase().contains("getvalueone")
						|| Actionvalue.toLowerCase().contains("getvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstgetvalue")) {
					mitaClickExcelData();
					mitaMobileGetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthefirstvalue")
						|| Actionvalue.toLowerCase().contains("set the first value")
						|| Actionvalue.toLowerCase().contains("setfirstvalue")
						|| Actionvalue.toLowerCase().contains("setvalueone")
						|| Actionvalue.toLowerCase().contains("setvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstsetvalue")) {
					mitaClickExcelData();
					mitaMobileSetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthesecondvalue")
						|| Actionvalue.toLowerCase().contains("get the second value")
						|| Actionvalue.toLowerCase().contains("getsecondvalue")
						|| Actionvalue.toLowerCase().contains("getvaluetwo")
						|| Actionvalue.toLowerCase().contains("getvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondgetvalue")) {
					mitaClickExcelData();
					mitaMobileGetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthesecondvalue")
						|| Actionvalue.toLowerCase().contains("set the second value")
						|| Actionvalue.toLowerCase().contains("setsecondvalue")
						|| Actionvalue.toLowerCase().contains("setvaluesecond")
						|| Actionvalue.toLowerCase().contains("setvaluetwo")
						|| Actionvalue.toLowerCase().contains("secondsetvalue")) {
					mitaClickExcelData();
					mitaMobileSetTheSecondValue("xpath", LocatorId, "visibilityOf");
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
					mitaValidateExcelData();
					mitaMobileEqualsValidation("xpath", actualValue, expectedValue);
				} else if (Actionvalue.toLowerCase().contains("title")) {
					mitaValidateTitle();
					mitaMobileGetTitle(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("dropdown")
						|| Actionvalue.toLowerCase().contains("drop down")) {
					mitaEnterExcelData();
					mitaMobileScrollIntoView("xpath", LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("alertText")) {
					mitaClickExcelData();
					mitaMobileGetAlertText();
					// mita_Click_excelData();
					// mita_getAlertText();
					// mita_acceptAlert();
				} else if (Actionvalue.toLowerCase().contains("loading")
						|| Actionvalue.toLowerCase().contains("load")) {
					mitaClickExcelData();
					mitaMobileProgressBarWait("xpath", LocatorId, "invisibilityOf");
				} else if (Actionvalue.toLowerCase().contains("random")) {
					mitaEnterExcelData();
					mitaMobileGenerateRandomNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("zero")) {
					mitaEnterExcelData();
					mitaMobileZeroStartsNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("add dates")
						|| Actionvalue.toLowerCase().contains("adddates")
						|| Actionvalue.toLowerCase().contains("adding dates")
						|| Actionvalue.toLowerCase().contains("addingdates")) {
					mitaEnterExcelData();
					mitaMobileAddDates("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("dynamic string")
						|| Actionvalue.toLowerCase().contains("dynamicstring")
						|| Actionvalue.toLowerCase().contains("dynamic")
						|| Actionvalue.toLowerCase().contains("string dynamic")
						|| Actionvalue.toLowerCase().contains("stringdynamic")) {
					mitaEnterExcelData();
					mitaMobileDynamicString("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("append") || Actionvalue.toLowerCase().contains("prefix")
						|| Actionvalue.toLowerCase().contains("pre fix")
						|| Actionvalue.toLowerCase().contains("pre-fix") || Actionvalue.toLowerCase().contains("affix")
						|| Actionvalue.toLowerCase().contains("join")) {
					mitaEnterExcelData();
					mitaMobileAppendText("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("handling")) {
					mitaEnterExcelData();
					mitaMobileNumberOTP("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scrollup")) {
					mitaEnterExcelData();
					mitaMobileScrollUp(LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("scrolldown")) {
					// mita_Enter_excelData();
					mitaValidateTitle();
					mitaMobileScrollDown(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("singletap")) {
					mitaClickExcelData();
					mitaMobileSingleTap("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("Doubletap")) {
					mitaClickExcelData();
					mitaMobileDoubleTap("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("Progressbar")) {
					mitaClickExcelData();
					mitaMobileProgressBarWait("xpath", LocatorId, "invisibilityOf");
				} else if (Actionvalue.toLowerCase().contains("digital signature")) {
					mitaClickExcelData();
					mitaMobileSign("xpath", LocatorId);
				} else if (Actionvalue.toLowerCase().contains("drag")) {
					mitaEnterExcelData();
					mitaMobileSeekBar("xpath", LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("frame")) {
					mitaFrame();
					mitaMobileFrameWebElement("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("wait") || Actionvalue.toLowerCase().contains("standby")
						|| Actionvalue.toLowerCase().contains("holdback") || Actionvalue.toLowerCase().contains("pause")
						|| Actionvalue.toLowerCase().contains("halt")
						|| Actionvalue.toLowerCase().contains("give a break")
						|| Actionvalue.toLowerCase().contains("delay") || Actionvalue.toLowerCase().contains("hold on")
						|| Actionvalue.toLowerCase().contains("intermission")) {
					mitaWait();
					mitaMobileWaitTime(waitTime);
				} else if (Actionvalue.toLowerCase().contains("gettheleadid")
						|| Actionvalue.toLowerCase().contains("get the lead id")
						|| Actionvalue.toLowerCase().contains("getleadid")) {
					mitaClickExcelData();
					mitaMobileGetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("settheleadid")
						|| Actionvalue.toLowerCase().contains("set the lead id")
						|| Actionvalue.toLowerCase().contains("setleadid")) {
					mitaClickExcelData();
					mitaMobileSetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("closeframe")
						|| Actionvalue.toLowerCase().contains("close frame")
						|| Actionvalue.toLowerCase().contains("close the frame")
						|| Actionvalue.toLowerCase().contains("closing frame")
						|| Actionvalue.toLowerCase().contains("final frame")
						|| Actionvalue.toLowerCase().contains("finalise frame")
						|| Actionvalue.toLowerCase().contains(" frame")
						|| Actionvalue.toLowerCase().contains("come out of frame")
						|| Actionvalue.toLowerCase().contains("iframe")) {
					mitaMobileDefaultFrame();
				} else if (Actionvalue.toLowerCase().contains("testcase")
						|| Actionvalue.toLowerCase().contains("test case")
						|| Actionvalue.toLowerCase().contains("finish")
						|| Actionvalue.toLowerCase().contains("finishing")
						|| Actionvalue.toLowerCase().contains("finished")
						|| Actionvalue.toLowerCase().contains("complete")
						|| Actionvalue.toLowerCase().contains("completing")
						|| Actionvalue.toLowerCase().contains("completed")) {
					mitaMobileWrite();
					mobiledriver.quit();
				} else if (Actionvalue.toLowerCase().contains("end")) {
					mitaStepName();
					mitaScenarioNumber(Actionvalue);
					i = k + 1;
					mobiledriver.quit();
					break;
				} else if (Actionvalue.toLowerCase().contains("")) {
					mitaMobilePleaseDoSpellcheck();
				}
			}

		} catch (NoSuchElementException e) {
			logger.info("Mobile-Please do spell ckeck");
			mitaMobilePleaseDoSpellcheck();

		}
	}

	public static void webMethods() throws Exception {
		try {
			for (k = i + 1; k <= lastRow; k++) {
				row = sheet.getRow(k);
				cell0 = row.getCell(0);
				Actionvalue = getCellContentAsString(cell0);
				if (Actionvalue.toLowerCase().contains("url")) {
					launchBrowsers(bt[l], Runner.driverurl);
					mitaWebWrite();
				} else if (Actionvalue.toLowerCase().contains("enter") || Actionvalue.toLowerCase().contains("insert")
						|| Actionvalue.toLowerCase().contains("inserting")
						|| Actionvalue.toLowerCase().contains("entering") || Actionvalue.toLowerCase().contains("input")
						|| Actionvalue.toLowerCase().contains("editing") || Actionvalue.toLowerCase().contains("put")
						|| Actionvalue.toLowerCase().contains("write")) {
					mitaEnterExcelData();
					mitaWebEnterTextField("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("display")) {
					mitaEnterExcelData();
					mitaWebElemenDisplay("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("keys") || Actionvalue.toLowerCase().contains("keyvalue")
						|| Actionvalue.toLowerCase().contains("keyText")
						|| Actionvalue.toLowerCase().contains("drop down")
						|| Actionvalue.toLowerCase().contains("dropdown")) {
					mitaEnterExcelData();
					mitaWebEnterTextKey("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("char")
						|| Actionvalue.toLowerCase().contains("character")) {
					mitaEnterExcelData();
					mitaWebEnterCharacter("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("click") || Actionvalue.toLowerCase().contains("hit")
						|| Actionvalue.toLowerCase().contains("clicking")
						|| Actionvalue.toLowerCase().contains("submit")
						|| Actionvalue.toLowerCase().contains("submiting")
						|| Actionvalue.toLowerCase().contains("accept")
						|| Actionvalue.toLowerCase().contains("dismis")) {
					mitaClickExcelData();
					mitaWebClick("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("select")
						|| Actionvalue.toLowerCase().contains("select with text")
						|| Actionvalue.toLowerCase().contains("selecting")) {
					mitaSelectExcelData();
					mitaWebSelectVisibleText("xpath", LocatorId, SelectValue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("auto suggestion")
						|| Actionvalue.toLowerCase().contains("autosuggestion")
						|| Actionvalue.toLowerCase().contains("autolist")
						|| Actionvalue.toLowerCase().contains("auto list")
						|| Actionvalue.toLowerCase().contains("autocomplete")
						|| Actionvalue.toLowerCase().contains("auto complete")) {
					mitaEnterExcelData();
					mitaWebAutoSuggestionDropDown("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("index")) {
					mitaSelectExcelData();
					mitaSelectIndex("xpath", LocatorId, 1, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scenario")) {
					mitaStepName();
					mitaScenarioNumber(Actionvalue);
				} else if (Actionvalue.toLowerCase().contains("handling")) {
					mitaEnterExcelData();
					mitaWebMobileNumberOTP("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("random")) {
					mitaEnterExcelData();
					mitaWebGenerateRandomNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("zero")) {
					mitaEnterExcelData();
					mitaWebZeroStartsNumber("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("dynamic string")
						|| Actionvalue.toLowerCase().contains("dynamicstring")
						|| Actionvalue.toLowerCase().contains("dynamic")
						|| Actionvalue.toLowerCase().contains("string dynamic")
						|| Actionvalue.toLowerCase().contains("stringdynamic")) {
					mitaEnterExcelData();
					mitaWebDynamicString("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("append") || Actionvalue.toLowerCase().contains("prefix")
						|| Actionvalue.toLowerCase().contains("pre fix")
						|| Actionvalue.toLowerCase().contains("pre-fix") || Actionvalue.toLowerCase().contains("affix")
						|| Actionvalue.toLowerCase().contains("join")) {
					mitaEnterExcelData();
					mitaWebAppendText("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("upload")
						|| Actionvalue.toLowerCase().contains("uploading")
						|| Actionvalue.toLowerCase().contains("browsing")
						|| Actionvalue.toLowerCase().contains("browse")) {
					mitaEnterExcelData();
					mitaWebUploadSendkeys("xpath", LocatorId, Entervalue);
					// mita_Enter_excelData();
//					mita_Robot_uploadFile("xpath", LocatorId, Entervalue, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("switch")) {
					mitaSelectExcelData();
					mitaWebAcceptAlert();
				} else if (Actionvalue.toLowerCase().contains("getvaluefromapp")) {
					mitaClickExcelData();
					mitaWebGetTheValueFromApp("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setvalueinapp")) {
					mitaClickExcelData();
					mitaWebSetThtValueInApp("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthefirstvalue")
						|| Actionvalue.toLowerCase().contains("get the first value")
						|| Actionvalue.toLowerCase().contains("getfirstvalue")
						|| Actionvalue.toLowerCase().contains("getvalueone")
						|| Actionvalue.toLowerCase().contains("getvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstgetvalue")) {
					mitaClickExcelData();
					mitaWebGetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthefirstvalue")
						|| Actionvalue.toLowerCase().contains("set the first value")
						|| Actionvalue.toLowerCase().contains("setfirstvalue")
						|| Actionvalue.toLowerCase().contains("setvalueone")
						|| Actionvalue.toLowerCase().contains("setvaluefirst")
						|| Actionvalue.toLowerCase().contains("firstsetvalue")) {
					mitaClickExcelData();
					mitaWebSetTheFirstValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("getthesecondvalue")
						|| Actionvalue.toLowerCase().contains("get the second value")
						|| Actionvalue.toLowerCase().contains("getsecondvalue")
						|| Actionvalue.toLowerCase().contains("getvaluetwo")
						|| Actionvalue.toLowerCase().contains("getvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondgetvalue")) {
					mitaClickExcelData();
					mitaWebGetTheSecondValue("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("setthesecondvalue")
						|| Actionvalue.toLowerCase().contains("set the second value")
						|| Actionvalue.toLowerCase().contains("setsecondvalue")
						|| Actionvalue.toLowerCase().contains("setvaluetwo")
						|| Actionvalue.toLowerCase().contains("setvaluesecond")
						|| Actionvalue.toLowerCase().contains("secondsetvalue")) {
					mitaClickExcelData();
					mitaWebSetTheSecondValue("xpath", LocatorId, "visibilityOf");
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
					mitaValidateExcelData();
					mitaWebEqualsValidation("xpath", actualValue, expectedValue);
				} else if (Actionvalue.toLowerCase().contains("title")) {
					mitaValidateTitle();
					mitaWebAssertTitle(expectedValue);
				} else if (Actionvalue.toLowerCase().contains("frame")) {
					mitaFrame();
					mitaWebFrameWebElement("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("scrolldown")) {
					mitaClickExcelData();
					mitaWebScrollDown("xpath", LocatorId);
				} else if (Actionvalue.toLowerCase().contains("wait") || Actionvalue.toLowerCase().contains("standby")
						|| Actionvalue.toLowerCase().contains("holdback") || Actionvalue.toLowerCase().contains("pause")
						|| Actionvalue.toLowerCase().contains("halt")
						|| Actionvalue.toLowerCase().contains("give a break")
						|| Actionvalue.toLowerCase().contains("delay") || Actionvalue.toLowerCase().contains("hold on")
						|| Actionvalue.toLowerCase().contains("intermission")) {
					mitaWait();
					mitaWebWaitTime(waitTime);
				} else if (Actionvalue.toLowerCase().contains("gettheleadid")
						|| Actionvalue.toLowerCase().contains("get the lead id")
						|| Actionvalue.toLowerCase().contains("getleadid")) {
					mitaClickExcelData();
					mitaWebGetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("settheleadid")
						|| Actionvalue.toLowerCase().contains("set the lead id")
						|| Actionvalue.toLowerCase().contains("setleadid")) {
					mitaClickExcelData();
					mitaWebSetTheLeadID("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("mouseover")
						|| Actionvalue.toLowerCase().contains("mousehower")
						|| Actionvalue.toLowerCase().contains("mouse hower")
						|| Actionvalue.toLowerCase().contains("mouse over")) {
					mitaClickExcelData();
					mitaWebMouseOver(LocatorId);
				} else if (Actionvalue.toLowerCase().contains("settheotp")
						|| Actionvalue.toLowerCase().contains("set the otp id")
						|| Actionvalue.toLowerCase().contains("setotp")) {
					mitaClickExcelData();
					mitaWebSetTheOTP("xpath", LocatorId, "visibilityOf");
				} else if (Actionvalue.toLowerCase().contains("closeframe")
						|| Actionvalue.toLowerCase().contains("close frame")
						|| Actionvalue.toLowerCase().contains("close the frame")
						|| Actionvalue.toLowerCase().contains("closing frame")
						|| Actionvalue.toLowerCase().contains("come out of frame")
						|| Actionvalue.toLowerCase().contains("iframe")) {
					mitaWebDefaultFrame();
				} else if (Actionvalue.toLowerCase().contains("refresh")) {
					mitaWebRefresh();
				} else if (Actionvalue.toLowerCase().contains("open")) {
					mitaResponse();
					mitaWebResponse(LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("heading tag")
						|| Actionvalue.toLowerCase().contains("h1 tag") || Actionvalue.toLowerCase().contains("h2 tag")
						|| Actionvalue.toLowerCase().contains("h3 tag") || Actionvalue.toLowerCase().contains("h4 tag")
						|| Actionvalue.toLowerCase().contains("h5 tag")) {
					mitaHeadingTags();
					mitaWebHeadingTags(LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("image")) {
					mitaMetaTags();
					mitaWebMetaTags("xpath", LocatorId, Entervalue);
				} else if (Actionvalue.toLowerCase().contains("dead link")
						|| Actionvalue.toLowerCase().contains("broken hyperlink")
						||Actionvalue.toLowerCase().contains("broken links")) {
					mitaBrokenLinks();
					mitaWebBrokenLinks("xpath", LocatorId, Entervalue);
				} 
				else if (Actionvalue.toLowerCase().contains("uri")) {
					mitaGetCurrentUrl();
					mitaWebGetCurrentUrl(expectedValue);
				} 	else if (Actionvalue.toLowerCase().contains("child window")) {
					mitaWebMoveToChildWindow();
				} 
				else if (Actionvalue.toLowerCase().contains("console logs")) {
					mitaWebConsoleLogs();
				} 
				else if(Actionvalue.toLowerCase().contains("listbox")) {
					mitaListBox();
					mitaWebListBox("xpath", LocatorId, SelectValue, "visibilityOf");
				} 
				else if (Actionvalue.toLowerCase().contains("close")
						|| Actionvalue.toLowerCase().contains("test case")
						|| Actionvalue.toLowerCase().contains("finish")
						|| Actionvalue.toLowerCase().contains("finishing")
						|| Actionvalue.toLowerCase().contains("finished")
						|| Actionvalue.toLowerCase().contains("complete")
						|| Actionvalue.toLowerCase().contains("completing")
						|| Actionvalue.toLowerCase().contains("completed")) {
					driver.quit();
				} else if (Actionvalue.toLowerCase().contains("end")) {
					mitaStepName();
					mitaScenarioNumber(Actionvalue);
					i = k + 1;
					driver.close();
					break;
				} else if (Actionvalue.toLowerCase().contains("")) {
					mitaWebPleasedoSpellcheck();
					logger.info("Entered keyword is not available in the script");
				}
			}

		} catch (NoSuchElementException e) {
			mitaWebPleasedoSpellcheck();
			logger.info("WEB-Please do spell ckeck");
		}
	}

	@Test
	public void mydriverscript() throws Throwable {
		ReadExcel();
	}
}
