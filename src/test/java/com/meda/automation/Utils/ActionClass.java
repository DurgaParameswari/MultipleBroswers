package com.meda.automation.Utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//-----------------------------------------
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.meda.automation.base.BaseClass;
import com.meda.automation.managers.ExtentTestManager;

import autoitx4java.AutoItX;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.response.Response;
/*import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;*/
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class ActionClass extends BaseClass {
	public static WebElement element;
	public static By by, locator;
	public static Select select;
	public static SoftAssert softAssert;
	public static WebDriverWait wait;
	public static Actions action;
	public static String actual;
	public static int i = 1, k = 1, lastRow, j;

	public static By by1, locator1;
	public static Select select1;
	public static Boolean flag;
	public static Alert alert;
	public static String Parent;
	public static Robot robot;
	public static int xOffset;
	private Duration STEP_DURATION = Duration.ofMillis(20);
	private Duration NO_TIME = Duration.ofMillis(0);
	private Origin VIEW = Origin.viewport();
	public static final String BASE_URL = "https://machintsolutions-test.appiancloud.com";
	public static String OTP;
	public static ResponseBody response;
	public static String value1, value2, value3;
	public static String leadID;
	public static String randomString;

	public static String timeStamp;

	static Logger logger = Logger.getLogger(ActionClass.class);

	public static WebElement fluentWait(final By locator1) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(20)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator1);
			}
		});
		return foo;
	};

	public static void mitaWebWrite() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaWebWritePass() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());	
			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
		}
	}

	public static void mitaWebWriteFail() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {

					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
		}
	}

	public static void mitaWebWriteWhenLocatorIsNotValid() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			// mita_writeFail();
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("Locator is not valid");
//			searchText2.setCellStyle(style);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {

					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			mita_Web_ScreenShot();
//			inputFile.close();
//			outFile.close();
//			k = lastRow + 1;
//			i = lastRow + 1;
//			driver.quit();
		}

		catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaWebPleasedoSpellcheck() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			// mita_writeFail();
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("Please do spell check");	
//			searchText2.setCellStyle(style);			

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaWebScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			mita_Web_ScreenShot();
//			inputFile.close();
//			outFile.close();
//			k = lastRow + 1;
//			i = lastRow + 1;
//			driver.quit();
		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaMobileWrite() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			// System.out.println("k value s" + k);
			try {
				if (Runner.browserType.equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (Runner.browserType.equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (Runner.browserType.equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaMobileWritePass() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("PASS");
//			searchText2.setCellStyle(style);
//
//			Cell ActualValue = sheet.getRow(k).createCell(3);
//			ActualValue.setCellValue(ActionClass.actual);

			try {
				if (Runner.browserType.equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (Runner.browserType.equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (Runner.browserType.equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Mobile_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			mita_Mobile_ScreenShot();
//			inputFile.close();
//			outFile.close();
		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();

		}
	}

	public static void mitaMobileWriteFail() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("FAIL");
//			searchText2.setCellStyle(style);
//
//			Cell ActualValue = sheet.getRow(k).createCell(3);
//			ActualValue.setCellValue(ActionClass.actual);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("FAIL");
					searchText2.setCellStyle(style);

					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(ActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			// new File(System.getProperty("user.dir") +
//			// "\\TestCasesinExcell\\testdatafolder\\Testdata.xlsx"));
//			workbook.write(outFile);
//			mita_Mobile_ScreenShot();
//			inputFile.close();
//			outFile.close();
		} catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaMobileWriteWhenLocatorIsNotValid() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			// mita_writeFail();
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//
//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("Locator is not valid");
//			searchText2.setCellStyle(style);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {

					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {

					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {

					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			mita_Mobile_ScreenShot();
//			inputFile.close();
//			outFile.close();
//			k = lastRow + 1;
//			i = lastRow + 1;
//			mobiledriver.quit();
		}

		catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaMobilePleaseDoSpellcheck() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			// mita_writeFail();
			inputFile = new FileInputStream(new File(Runner.filePath));

			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue("Please do spell check");
//			searchText2.setCellStyle(style);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {

					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}

			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {

					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {

					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			mita_Mobile_ScreenShot();
//			inputFile.close();
//			outFile.close();
//			k = lastRow + 1;
//			i = lastRow + 1;
//			mobiledriver.quit();
		}

		catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static By mitaWebLocator(String locatorType, String LocatorValue) {
		switch (locatorType) {
		case "id":
			by = By.id(LocatorValue);
			break;

		case "name":
			by = By.name(LocatorValue);
			break;

		case "className":
			by = By.className(LocatorValue);
			break;

		case "tagName":
			by = By.tagName(LocatorValue);
			break;

		case "xpath":
			by = By.xpath(LocatorValue);
			break;

		case "css":
			by = By.cssSelector(LocatorValue);
			break;

		case "linkText":
			by = By.linkText(LocatorValue);
			break;

		case "partialLinkText":
			by = By.partialLinkText(LocatorValue);
			break;

		default:
			by = null;
			break;
		}
		return by;
	}

	public static void mitaWebEnterTextKey(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.click();
			element.sendKeys(value);
			Thread.sleep(500);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextKey method \t" + e.getMessage());
		}
	}

	public static void mitaWebMobileNumberOTP(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - Mobile number OTP method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			RestAssured.baseURI = BASE_URL;
			RequestSpecification request = RestAssured.given();
			request.header("Appian-API-Key",
					"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkMjE4YjUxNi0wYzA5LTRhMTMtYTZiYi00YjQ2ZjQ2YmYwYjkifQ.S26NBlhpMuqVeo5gFl6gd5AiHDfP90rzWIc2k0g9vrU");
			request.header("Content-Type", "application/json");
			response = request.body("{\"phNumber\" : \"" + value + "\", \"flag\" : \"newUser\"}")
					.post("/suite/webapi/abank-generate-otp");
			String responseBody = ((ResponseOptions<Response>) response).getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			JSONObject jsonobject = new JSONObject(responseBody);
			int OTP = jsonobject.getInt("OTP");
			value = String.valueOf(OTP);

			// status code validation
			int statusCode = ((ResponseOptions<Response>) response).getStatusCode();
			// Assert.assertEquals(statusCode, 201);
			element.clear();
			element.sendKeys(value);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to handling the OTP \t" + e);
			logger.warn("Unable to execute handling otp method \t" + e.getMessage());
		}

	}

	public static void mita_Robot_uploadFile(String LocatorType, String LocatorValue, String value, String WaitType)
			throws AWTException, Exception {
		try {
			logger.info("Executing - Upload file method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.click();
			robot = new Robot();
			robot.setAutoDelay(1000);
			StringSelection selection = new StringSelection(value);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_Robot_uploadFile \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Upload file method \t" + e.getMessage());
		}
	}

	// Generate the Random Aadhar number
	public static void mitaWebGenerateRandomNumber(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - Mobile generateRandomNumber method");

			int number = Integer.parseInt(value);
			String randomNumber = mitaGenerateAadharNumber(number);
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the generaterandomnumber method \t" + e.getMessage());
		}
	}

	public static void mitaWebAutoSuggestionDropDown(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - AutoSuggestion_Dropdown method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			element.click();
			mitaWebWait(WaitType);
			// Thread.sleep(1000);
			element.sendKeys(value);
			Thread.sleep(1000);
			Actions act = new Actions(driver);
			// act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform AutoSuggestion_Dropdown \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Auto Suggestion dropdown method \t" + e.getMessage());
		}

	}

	public static void mitaWebEnterTextField(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			element.sendKeys(value);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextField method \t" + e.getMessage());

		}
	}

	public static void mitaWebClick(String LocatorType, String LocatorValue, String WaitType) throws Exception {
		try {
			logger.info("Executing - Click method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.click();
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the click method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR, "Unable to execute the click method \t" + e.getMessage());
		}

	}

	public static void mita_selectValue(String LocatorType, String LocatorValue, String text, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - selectValue method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			select = new Select(element);
			select.selectByValue(text);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectvalue method \t" + e.getMessage());

		}
	}

	public static void mitaSelectIndex(String LocatorType, String LocatorValue, int value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - selectIndex method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			select = new Select(element);
			select.selectByIndex(value);
			mitaWebWrite();
			// Thread.sleep(500);
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectIndex method \t" + e.getMessage());

		}
	}

	public static void mitaWebSelectVisibleText(String LocatorType, String LocatorValue, String text, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - selectVisibletext method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			select = new Select(element);
			select.selectByVisibleText(text);
			mitaWebWrite();
			// Thread.sleep(500);
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectVisibletext method \t" + e.getMessage());

		}
	}

	public static boolean mitaWebAcceptAlert() throws Exception {
		boolean boolFound = false;
		try {
			logger.info("Executing - acceptAlert method");

			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if (alert != null) {
				alert.accept();
				boolFound = true;
			}
			mitaWebWrite();
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the acceptAlert method \t" + e.getMessage());

		}
		return boolFound;
	}

	public static boolean mita_dismissAlert() {
		boolean boolFound = false;
		try {
			logger.info("Executing - dismissAlert method");

			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if (alert != null) {
				alert.dismiss();
				boolFound = true;
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the dismissAlert method \t" + e.getMessage());

		}
		return boolFound;
	}

	public static boolean mita_getAlertText() {
		boolean boolFound = false;
		try {
			logger.info("Executing - getAlertText method");

			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String AlertMsg = driver.switchTo().alert().getText();
			if (alert != null) {
				alert.accept();
				System.out.println(AlertMsg);
				boolFound = true;
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the getAlertText method \t" + e.getMessage());

		}
		return boolFound;
	}

	public static void mitaWebAssertTitle(String expected) throws IOException, Exception {
		try {
			logger.info("Executing - AssertTitle method");

			actual = driver.getTitle();
			Assert.assertEquals(actual, expected);
			if (actual.equalsIgnoreCase(expected)) {
				mitaWebWritePass();
			} else {
				mitaWebScreenShot();
				mitaWebWriteFail();
			}
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Asserttitle method \t" + e.getMessage());

		}
	}

	public static void mitaWebAssertEquals(String LocatorType, String LocatorValue, String expectedValue)
			throws IOException {
		try {
			logger.info("Executing - AssertEquals method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlightForValidation(element);
			String actualValue = driver.findElement(locator).getText();
			softAssert.assertEquals(actualValue, expectedValue);
			mitaWebWritePass();
		} catch (Exception e) {
			mitaWebWriteFail();
			logger.warn("Asserts are not equal \t" + e.getMessage());

		}
	}

	public static void mitaWebEqualsValidation(String LocatorType, String LocatorValue, String expected)
			throws IOException {
		try {
			logger.info("Executing - EqualsValidation method");

//			softAssert = new SoftAssert();
			locator = mitaWebLocator(LocatorType, LocatorValue);
			actual = driver.findElement(locator).getText();

			if (actual.equalsIgnoreCase(expected)) {
//				mita_JSHighlight(element);
				mitaWebScreenShot();
				mitaWebWritePass();
				ExtentTestManager.getTest().log(Status.PASS, actual + " " + expected + " Correct ");
			} else {
//				mita_JSHighlight_for_validation(element);
				mitaWebScreenShot();
				mitaWebWriteFail();
				ExtentTestManager.getTest().log(Status.FAIL, actual + " " + expected + " Incorrect ");
				ExtentTestManager.getTest().log(Status.FAIL,
						MarkupHelper.createLabel(Driver_Script.Actionvalue + " - Assertion Failed" + "expected is ["
								+ expected + "] but found  " + "[" + actual + "]", ExtentColor.RED));
			}
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Equals validation method\t" + e.getMessage());

		}
	}

	// Get the first value from WEB

	public static void mitaWebGetTheFirstValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GettheFirstValue method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			value1 = element.getText();
			mitaWebWrite();
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			mitaWebWriteWhenLocatorIsNotValid();
			// System.err.format("No Element Found to get the value \t" + e);
			logger.warn("Unable to execute the GetFirstValue method \t" + e.getMessage());

		}
	}

	// Set the first value
	public static void mitaWebSetTheFirstValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SettheFirstValue method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			mitaSendChar(element, value1);
			// element.sendKeys(value1);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the SetFirstValue method \t" + e.getMessage());
		}
	}

	public static void mitaWebGetTheSecondValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - gettheSecondValue method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			value2 = element.getText();
			mitaWebWait(WaitType);
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the gettheSecondValue method \t" + e.getMessage());

		}
	}

	public static void mitaWebSetTheSecondValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - settheSecondValue method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			mitaSendChar(element, value2);
			// element.sendKeys(value2);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the setSecondValue method \t" + e.getMessage());

		}
	}

	public static void mitaWebGetTheValueFromApp(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GetTheValueFromApp method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			value3 = element.getAttribute("value");
			System.out.println(value3 + "place holder");
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the getValuefromapp method \t" + e.getMessage());

		}
	}

	public static void mitaWebSetThtValueInApp(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SetThtValueInApp method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			mitaSendChar(element, value3);
			// element.sendKeys(value3);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the setSecondValue method \t" + e.getMessage());

		}
	}

	public static void mitaWebMouseOver(String LocatorValue) throws Exception {
		try {
			logger.info("Executing - mouseOver method");

			action = new Actions(driver);
			element = driver.findElement(By.xpath(LocatorValue));
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform mouse move \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the mousehower method \t" + e.getMessage());

		}
	}

	public static void mitaWebWait(String WaitType) throws Exception {
		switch (WaitType) {
		case "visibilityOf":
			mitaWebVisibilityOf();
			break;

		case "visibilityOfAllElements":
			mitaWebVisibilityOfAllElements();
			break;

		case "elementToBeClickable":
			mitaWebElementToBeClickable();
			break;

		case "elementToBeSelected":
			mitaWebElementToBeSelected();
			break;

		case "invisibilityOf":
			mitaWebInvisibilityOf();

		default:
			System.out.println(WaitType + " is invalid");
		}
	}

	public static void mitaWebVisibilityOf() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				element = wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (Exception e) {
//			System.err.format("No Element Found to mita_visibilityOf \t" + e);
			logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());

		}
	}

	public static void mitaWebVisibilityOfAllElements() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
			}
		} catch (Exception e) {
//			System.err.format("No Element Found to mita_visibilityOfAllElements \t" + e);
			logger.warn("Unable to execute the visibilityOfAllElements method \t" + e.getMessage());

		}
	}

	public static void mitaWebElementToBeClickable() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		} catch (Exception e) {
//			System.err.format("No Element Found to mita_elementToBeClickable \t" + e);
			logger.warn("Unable to execute the elementtobeClickable method \t" + e.getMessage());

		}
	}

	public static void mitaWebElementToBeSelected() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}
		} catch (Exception e) {
//			System.err.format("No Element Found to mita_elementToBeSelected \t" + e);
			logger.warn("Unable to execute the elementToBeSelected method \t" + e.getMessage());

		}
	}

	public static void mitaWebInvisibilityOf() throws Exception {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (by != null) {
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
		} catch (Exception e) {
//				System.err.format("No Element Found to Machint_invisibilityOf \t" + e);
			logger.warn("Unable to execute the invisibilityOf method \t" + e.getMessage());
		}
	}

	public static void mitaMobileScreenShot() {
		try {
			logger.info("Executing - Taking ScreenShot method");
			TakesScreenshot screenshot = (TakesScreenshot) mobiledriver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			System.out.println("Step Name is : " + Driver_Script.Actionvalue);
			FileUtils.copyFile(src, new File(Runner.mobileScreenshotPath + "\\ScreenShots\\" + Driver_Script.sheetName
					+ "_" + timestamp + "_" + Driver_Script.Actionvalue + ".png"));
//			System.out.println("Successfully captured a screenshot");
		} catch (Exception e) {
//			System.out.println("Exception while taking screenshot ");
			logger.warn("Unable to take the Mobile Screenshot \t");

		}
	}

	public static void mitaWebScreenShot() {
		try {
			logger.info("Executing - Taking ScreenShot method");
//			reporterLog("Executing - Taking ScreenShot method");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy-MM-dd--hh-mm-ss").format(new Date());
			System.out.println("Step Name is : " + Driver_Script.Actionvalue);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					FileUtils.copyFile(src,
							new File(Runner.webScreenshotPath + "\\ScreenShots\\Web\\" + bt[l] + "\\" + timeStamp + "\\"
									+ Driver_Script.sheetName + "_" + timestamp + "_" + Driver_Script.Actionvalue
									+ ".png"));
				}
			} catch (Exception e) {
				logger.warn("unable to take screenshot in chrome broswer " + e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					FileUtils.copyFile(src,
							new File(Runner.webScreenshotPath + "\\ScreenShots\\Web\\" + bt[l] + "\\" + timeStamp + "\\"
									+ Driver_Script.sheetName + "_" + timestamp + "_" + Driver_Script.Actionvalue
									+ ".png"));
				}
			} catch (Exception e) {
				logger.warn("unable to take screenshot in firefox broswer " + e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					FileUtils.copyFile(src,
							new File(Runner.webScreenshotPath + "\\ScreenShots\\Web\\" + bt[l] + "\\" + timeStamp + "\\"
									+ Driver_Script.sheetName + "_" + timestamp + "_" + Driver_Script.Actionvalue
									+ ".png"));
				}
			} catch (Exception e) {
				logger.warn("unable to take screenshot in edge broswer " + e.getMessage());

			}

//			FileUtils.copyFile(src, new File(Runner.webScreenshotPath + "\\ScreenShots\\" + Driver_Script.sheetName
//					+ "_" + timestamp + "_" + Driver_Script.Actionvalue + ".png"));
//			System.out.println("Successfully captured a screenshot");
		} catch (Exception e) {
//			System.out.println("Exception while taking screenshot ");
			logger.warn("Unable to take the Web Screenshot \t" + e.getMessage());

		}
	}

	public static void mitaWebJSHighlight(WebElement ele) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid yellow;');", ele);
		}
	}

	public static void mitaWebJSHighlightForValidation(WebElement ele) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid red;');", ele);
		}
	}

	public static void mitaWebFrameWebElement(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - MovetoFrame method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			driver.switchTo().frame(element);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform mita_Frame \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to handle the Frames \t" + e.getMessage());

		}
	}

	public static void mitaWebDefaultFrame() {
		try {
			logger.info("Executing - defaultFrame method");

			driver.switchTo().defaultContent();
			mitaWebWrite();
		} catch (Exception e) {
//			System.out.println("No frame unable mita_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the default Frame method \t" + e.getMessage());

		}
	}

	public static void mitaCleanTheResults() throws IOException {
		try {
//			 logger.info("Executing - Clean the Results method");
//			 reporterLog("Executing - Clean the Results method");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			Cell actualValue, result;
			int rowCount = getRowCount();
//			for (k = 1; k <= rowCount; k++) {
//				row = sheet.getRow(k);
//				actualValue = sheet.getRow(k).createCell(3);
//				actualValue.setCellValue("Not Applicable");
//				result = sheet.getRow(k).createCell(4);
//				result.setCellValue("Not Executed");
//			}

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					for (k = 1; k <= rowCount; k++) {
						row = sheet.getRow(k);
						actualValue = sheet.getRow(k).createCell(3);
						actualValue.setCellValue("Not Applicable");
						result = sheet.getRow(k).createCell(4);
						result.setCellValue("Not Executed");
					}
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					inputFile.close();
					outFile.close();
				}

			} catch (Exception e) {
				logger.info(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					for (k = 1; k <= rowCount; k++) {
						row = sheet.getRow(k);
						actualValue = sheet.getRow(k).createCell(3);
						actualValue.setCellValue("Not Applicable");
						result = sheet.getRow(k).createCell(5);
						result.setCellValue("Not Executed");
					}

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					for (k = 1; k <= rowCount; k++) {
						row = sheet.getRow(k);
						actualValue = sheet.getRow(k).createCell(3);
						actualValue.setCellValue("Not Applicable");
						result = sheet.getRow(k).createCell(6);
						result.setCellValue("Not Executed");
					}
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			inputFile.close();
//			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the CleanResults method \t" + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the CleanResults method \t" + e.getMessage());

		}
	}

	public static void mitaScenarioNumber(String name) throws IOException {
		try {
//			logger.info("Executing - scenarioNumber method");
//			reporterLog("Executing - scenarioNumber method");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIME.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(k).createCell(4);
//			searchText2.setCellValue(name);
//			searchText2.setCellStyle(style);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
//				
			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
//				
			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
//				
			}
//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			// mita_Web_ScreenShot();
//			inputFile.close();
//			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the scenarionumber method \t" + e.getMessage());
//			reporterLog("Unable to execute the scenarionumber method \t" + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the scenarionumber method \t" + e.getMessage());
//			reporterLog("Unable to execute the scenarionumber method \t" + e.getMessage());

		}
	}

	public static void mitaExecutionType(String name) throws IOException {
		try {
//			 logger.info("Executing - "+Driver_Script.type);
//			 reporterLog("Executing - "+Driver_Script.type);
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIME.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

//			Cell searchText2 = sheet.getRow(i).createCell(4);
//			searchText2.setCellValue(name);
//			searchText2.setCellStyle(style);
//			
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(i).createCell(4);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
//				logger.info(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(i).createCell(5);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());

			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(i).createCell(6);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);

					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
//					mita_Web_ScreenShot();
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());

			}

//			outFile = new FileOutputStream(new File(Runner.filePath));
//			workbook.write(outFile);
//			// mita_Web_ScreenShot();
//			inputFile.close();
//			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the " + Driver_Script.type + "script " + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the " + Driver_Script.type + "script " + e.getMessage());

		}
	}

	// Mobile methods
	// Starting--------------------------------------------------------------

	// Enter text using Keys.ENTER function
	public static void mitaMobileEnterTextKey(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");
//			reporterLog("Executing - EnterTextKey method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			element.sendKeys(value);
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
//			System.err.format("No Element Found to Machint_EnterTextKey \t" + e);
			logger.warn("Unable to execute the Entertextkey method \t" + e.getMessage());
//			reporterLog("Unable to execute the Entertextkey method \t" + e.getMessage());
		}
	}

	// Enter text without Keys.ENTER function
	public static void mitaMobileEnterTextField(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_Mobile_EnterTextField \t" + e);
			logger.warn("Unable to execute the Entertextfield method \t" + e.getMessage());
		}
	}

	// Click function
	public static void mitaMobileClick(String LocatorType, String LocatorValue, String WaitType) throws Exception {
		try {
			logger.info("Executing - Click method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			element.click();
			mitaWebWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Click \t" + e);
			logger.warn("Unable to execute the Click method \t" + e.getMessage());
		}
	}

	// Get the first value from mobile
	public static void mitaMobileGetTheFirstValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GetTheFirstValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			value1 = element.getText();
			mitaWebWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to get the value \t" + e);
			logger.warn("Unable to execute the GetFirstValue method \t" + e.getMessage());
		}
	}

	// Get the second value from mobile
	public static void mitaMobileGetTheSecondValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GetTheSecondValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			value2 = element.getText();
			mitaWebWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to get the value \t" + e);
			logger.warn("Unable to execute the GetSecondValue method \t" + e.getMessage());
		}
	}

	// Set the first value from mobile

	public static void mitaMobileSetTheFirstValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SetTheFirstValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value1);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to set the value \t" + e);
			logger.warn("Unable to execute the SetFirstValue method \t" + e.getMessage());
		}
	}

	// Set the first value from mobile

	public static void mitaMobileSetTheSecondValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SetTheSecondValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value2);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to set the value \t" + e);
			logger.warn("Unable to execute the SetSecondValue method \t" + e.getMessage());
		}
	}

	// Right Click function
	public static void Machint_Mobile_contextClick(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - Context click method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			action = new Actions(mobiledriver);
			action.contextClick(element).build().perform();
			Thread.sleep(1000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_DoubleClick \t" + e);
			logger.warn("Unable to execute the contextclick method \t" + e.getMessage());
		}
	}

	// Double Click function
	public static void Machint_Mobile_doubleClick(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - double click method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			action = new Actions(mobiledriver);
			action.moveToElement(element).doubleClick().build().perform();
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_DoubleClick \t" + e);
			logger.warn("Unable to execute the doubleclick method \t" + e.getMessage());
		}
	}

	// Drag and Drop by function
	public static Boolean Machint_Mobile_DragandDropby(String LocatorType, String LocatorValue, int x, int y)
			throws Exception {
		boolean flag = false;
		try {
			logger.info("Executing - DragandDrop method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			action = new Actions(mobiledriver);
			action.dragAndDropBy(element, x, y).build().perform();
			flag = true;
			mitaMobileWrite();
			return flag;

		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the DragandDrop method \t" + e.getMessage());
			return false;

		}
	}

	// Click and Hold function
	public static void Machint_Mobile_ClickAndHold(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - ClickAndHold method");
			action = new Actions(mobiledriver);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			action.clickAndHold(element).build().perform();
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			Thread.sleep(3000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_ClickAndHoldAction\t" + e);
			logger.warn("Unable to execute the ClickAndHold method \t" + e.getMessage());
		}
	}

	// Select by Value function in drop-down
	public static void mitaMobileSelectValue(String LocatorType, String LocatorValue, String text,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - selectValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.selectByValue(text);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_selectValue \t" + e);
			logger.warn("Unable to execute the selectValue method \t" + e.getMessage());
		}
	}

	// Select by Index function in drop-down
	public static void mitaMobileSelectIndex(String LocatorType, String LocatorValue, int value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - selectIndex method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.selectByIndex(value);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_selectIndex \t" + e);
			logger.warn("Unable to execute the selectIndex method \t" + e.getMessage());
		}
	}

	// Select by VisibleText function in drop-down
	public static void Machint_Mobile_selectVisibleText(String LocatorType, String LocatorValue, String text,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - selectVisibleText method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			System.out.println(locator);
			element = mobiledriver.findElement(locator);
			System.out.println(element);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			System.out.println(select);
			select.selectByVisibleText(text);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_selectVisibleText \t" + e);
			logger.warn("Unable to execute the selectVisibletext method \t" + e.getMessage());
		}
	}

	// Get Drop-down function
	public static void Machint_Mobile_getdropdownOptions(String LocatorType, String LocatorValue, String text,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - getdropdownOptions method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			List<WebElement> dropdownOptions = select.getOptions();
			System.out.println(dropdownOptions.size());
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_getdropdownOptions \t" + e);
			logger.warn("Unable to execute the getdropdownOptions method \t" + e.getMessage());
		}
	}

	// Deselect all function in drop-down
	public static void Machint_Mobile_deselectAll(String LocatorType, String LocatorValue, String text, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - deselectAll method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.deselectAll();
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_deselectAll \t" + e);
			logger.warn("Unable to execute the deselectAll method \t" + e.getMessage());
		}
	}

	// Different Explicit waits function
	public static void mitaMobileWaits(String WaitType) throws Exception {
		switch (WaitType) {
		case "visibilityOf":
			Machint_Mobile_visibilityOf();
			break;

		case "visibilityOfAllElements":
			Machint_visibilityOfAllElements();
			break;

		case "elementToBeClickable":
			Machint_elementToBeClickable();
			break;

		case "elementToBeSelected":
			Machint_elementToBeSelected();
			break;

		case "elementSelectionStateToBe":
			Machint_elementSelectionStateToBe();
			break;

		case "frameToBeAvailableAndSwitchToIt":
			Machint_frameToBeAvailableAndSwitchToIt();
			break;

		case "invisibilityOf":
			Machint_invisibilityOf();
			break;

		case "invisibilityOfAllElements":
			Machint_invisibilityOfAllElements();
			break;

		default:
			System.out.println(WaitType + " is invalid");
		}
	}

	public static void Machint_Mobile_visibilityOf() {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_visibilityOf \t" + e);
			logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static void Machint_visibilityOfAllElements() {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_visibilityOfAllElements \t" + e);
			logger.warn("Unable to execute the visibilityOfAllElements method \t" + e.getMessage());
		}
	}

	public static void Machint_elementToBeClickable() throws IOException {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_elementToBeClickable \t" + e);
			logger.warn("Unable to execute the elementToBeClickable method \t" + e.getMessage());
		}
	}

	public static void Machint_elementSelectionStateToBe() throws IOException {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementSelectionStateToBe(element, flag));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_elementSelectionStateToBe \t" + e);
			logger.warn("Unable to execute the elementSelectionStateToBe method \t" + e.getMessage());
		}
	}

	public static void Machint_elementToBeSelected() throws IOException {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_elementToBeSelected \t" + e);
			logger.warn("Unable to execute the elementToBeSelected method \t" + e.getMessage());
		}
	}

	public static void Machint_frameToBeAvailableAndSwitchToIt() {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_frameToBeAvailableAndSwitchToIt \t" + e);
			logger.warn("Unable to execute the frame handling method \t" + e.getMessage());
		}
	}

	public static void Machint_invisibilityOf() {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (by != null) {
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_invisibilityOf \t" + e);
			logger.warn("Unable to execute the invisibilityOf method \t" + e.getMessage());
		}
	}

	public static void Machint_invisibilityOfAllElements() {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.invisibilityOfAllElements(element));
			}
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_invisibilityOfAllElements \t" + e);
			logger.warn("Unable to execute the invisibilityOfAllElements method \t" + e.getMessage());
		}
	}

	// Highlight function
	public static void Machint_JSHighlight(WebElement ele) {
		if (mobiledriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) mobiledriver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid yellow;');", ele);
		}
	}

	// Accept alert function
	public static boolean mitaMobileAcceptAlert() throws IOException, InterruptedException {
		boolean boolFound = false;
		try {
			logger.info("Executing - acceptAlert method");
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = mobiledriver.switchTo().alert();
			if (alert != null) {
				alert.accept();
				boolFound = true;
				mitaWebWrite();
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the acceptAlert method \t" + e.getMessage());
		}
		return boolFound;
	}

	// Dismiss alert function
	public static boolean Machint_Mobile_dismissAlert() throws IOException, InterruptedException {
		boolean boolFound = false;
		try {
			logger.info("Executing - dismissAlert method");
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = mobiledriver.switchTo().alert();
			if (alert != null) {
				alert.dismiss();
				boolFound = true;
				mitaWebWrite();
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the dismissAlert method \t" + e.getMessage());
		}
		return boolFound;

	}

	// Text of the alert box message function
	public static boolean mitaMobileGetAlertText() throws IOException, InterruptedException {
		boolean boolFound = false;
		try {
			logger.info("Executing - getAlertText method");
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = mobiledriver.switchTo().alert();
			String AlertMsg = mobiledriver.switchTo().alert().getText();
			if (alert != null) {
				alert.accept();
				System.out.println(AlertMsg);
				boolFound = true;
				mitaWebWrite();
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the getAlertText method \t" + e.getMessage());
		}
		return boolFound;

	}

	// Title verification function
	public static void mitaMobileGetTitle(String Expected) throws IOException, InterruptedException {
		try {
			logger.info("Executing - getTitle method");
			String Title = mobiledriver.getTitle();
			Assert.assertEquals(Title, Expected);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to Machint_invisibilityOf \t" + e);
			logger.warn("Unable to execute the getTitle method \t" + e.getMessage());
		}
	}

	// AssertEquals function
	public static void mitaMobileAssertEquals(String LocatorType, String LocatorValue, String expectedValue)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - AssertEquals method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			System.out.println("locator " + locator);
			actualValue = mobiledriver.findElement(locator).getText();
			System.out.println("Actual Value is \t" + actualValue);
			Assert.assertEquals(actualValue, expectedValue);
			mitaMobileWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the AssertEquals method \t" + e.getMessage());
		}
	}

	public static void mitaMobileEqualsValidation(String LocatorType, String LocatorValue, String expected)
			throws IOException {
		try {
			logger.info("Executing - EqualsValidation method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			actual = mobiledriver.findElement(locator).getText();
			Assert.assertEquals(actual, expected);
			if (actual.equalsIgnoreCase(expected)) {
				Machint_JSHighlight(element);
				mitaMobileWritePass();
			} else {
				mitaWebJSHighlightForValidation(element);
				mitaMobileScreenShot();
				mitaMobileWriteFail();
			}
		} catch (Exception e) {

			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EqualsValidation method \t" + e.getMessage());
		}

	}

	// AssertNotEquals function
	public static boolean mitaMobileNotEqualsValidation(String LocatorType, String LocatorValue, String expected)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - NotEqualsValidation method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			String element = mobiledriver.findElement(locator).getText();
			flag = false;
			if (element != null) {
				Assert.assertNotEquals(element, expected);
				flag = true;
				mitaMobileWrite();
			} else {
				System.out.println("Actual Value and Expected Value Matched");
			}
		} catch (Exception e) {

			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the NotEqualsValidation method \t" + e.getMessage());
		}
		return flag;
	}

	// AssertTrue function
	public static void mitaMobileTrueValidation(String LocatorType, String LocatorValue)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - TrueValidation method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			boolean displayed = element.isDisplayed();
			Assert.assertTrue(displayed);
			if (displayed = true) {
				System.out.println("Element displayed");
				mitaMobileWrite();
			} else {
				System.out.println("Element not displayed");
			}
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the MobileTrueValidation method \t" + e.getMessage());
		}
	}

	// AssertFalse function
	public static void mitaMobileFalseValidation(String LocatorType, String LocatorValue)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - FalseValidation method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			boolean displayed = element.isDisplayed();
			Assert.assertFalse(displayed);
			if (displayed = false) {
				System.out.println("Element is not displayed");
				mitaMobileWrite();
			} else {
				System.out.println("Element is displayed");
			}
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the FalseValidation method \t" + e.getMessage());
		}
	}

	// Move to(Mouse Over) function
	public static void mitaMobileMouseHover(String LocatorValue) throws Exception {
		try {
			logger.info("Executing - MouseHover method");
			action = new Actions(mobiledriver);
			element = mobiledriver.findElement(By.xpath(LocatorValue));
			action.moveToElement(element).build().perform();
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the mouseHover method \t" + e.getMessage());
		}
	}

	// Frame Index function
	public static void mitaMobileFrameIndex(int index) throws IOException, InterruptedException {
		try {
			logger.info("Executing - FrameIndex method");
			mobiledriver.switchTo().frame(index);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the MobileFrameIndex method \t" + e.getMessage());
		}
	}

	// Frame Name or Id function
	public static void mitaFrameNameOrID(String nameOrId) throws IOException, InterruptedException {
		try {
			logger.info("Executing - Framename method");
			mobiledriver.switchTo().frame(nameOrId);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform ngvt_Click \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the FrameID method \t" + e.getMessage());
		}
	}

	// Frame WebElement function
	public static void mitaMobileFrameWebElement(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - FrameWebElement method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			mobiledriver.switchTo().frame(element);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Frame \t" + e);
			logger.warn("Unable to execute the handlingFrame method \t" + e.getMessage());
		}
	}

	// Parent frame to child frame move function
	public void mitaMobileSwitchToFrame(String ParentFrame, String ChildFrame) throws IOException {
		try {
			logger.info("Executing - switchToFrame method");
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			mitaWebWrite();
		} catch (NoSuchFrameException e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out
					.println("Unable to locate frame with id " + ParentFrame + " or " + ChildFrame + e.getStackTrace());
			logger.warn("Unable to execute the switchToFrame method \t" + e.getMessage());
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("Unable to navigate to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame + e.getStackTrace());
			logger.warn("Unable to execute the switchToFrame method \t" + e.getMessage());
		}

	}

	// Frame exit function
	public static void mitaMobileDefaultFrame() throws IOException {
		try {
			logger.info("Executing - defaultFrame method");
			driver.switchTo().defaultContent();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the defaultFrame method \t" + e.getMessage());
		}
	}

	// Move to child window function
	public static void mitaWebMoveToChildWindow() throws IOException, InterruptedException {
		try {
			logger.info("Executing - moveToChildWindow method");
			Parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!Parent.equals(child_window)) {
					driver.switchTo().window(child_window);
					mitaWebWrite();
				}
			}
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the moveToChildWindow method \t" + e.getMessage());
		}
	}

	// Move to parent window function
	public static void Machint_Mobile_moveToParentWindow() throws IOException, InterruptedException {
		try {
			logger.info("Executing - moveToParentWindow method");
			driver.switchTo().window(Parent);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the moveToParentWindow method \t" + e.getMessage());
		}
	}

	// Move to close window function
	public static void Machint_Mobile_closeWindow() throws IOException {
		try {
			logger.info("Executing - closetWindow method");
			Parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!Parent.equals(child_window)) {
					driver.close();
				}
			}
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the CloseWindow method \t" + e.getMessage());
		}
	}

	// Yesterday date function
	public static void Machint_Mobile_YesterdayDate() throws IOException {
		DateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		// Calendar today = Calendar.getInstance();
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		Date d = yesterday.getTime(); // get a Date object
		String yesDate = sdf.format(d); // toString for Calendars is mostly not really useful
		System.out.println("Yesterday Date is \t" + yesDate);
	}

	// Current date function
	public static void Machint_Mobile_CurrentDate() throws IOException {
		DateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		String Date = sdf.format(date);
		System.out.println("Current Date is\t" + Date);
	}

	// Future date function
	public static void Machint_Mobile_FutureDate() throws IOException {
		DateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		Calendar futureDate = Calendar.getInstance();
		futureDate.add(Calendar.DATE, 7);
		Date date = futureDate.getTime();
		String Date = sdf.format(date);
		System.out.println("Future Date is\t" + Date);
	}

	// Current month function
	public static void Machint_Mobile_CurrentMonth() throws IOException {
		int month;
		Calendar cal = Calendar.getInstance();
		month = cal.get(Calendar.MONTH);
		System.out.println("Current month is  " + month);
		month = month + 1;
		System.out.println("Current month is  " + month);
	}

	// Current year function
	public static void Machint_Mobile_CurrentYear() throws IOException {
		int year;
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		System.out.println("Current year is  " + year);
	}

	// Check box selected function
	public boolean isCheckBoxSelectedMobile(String LocatorType, String LocatorValue) throws Exception {
		boolean flag = false;

		try {
			logger.info("Executing - isCheckBoxSelectedMobile method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			if (mobiledriver.findElement(locator).isSelected()) {
				flag = true;
				mitaMobileWrite();
			}
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		}
	}

	// Screenshot function
	public static void Machint_Mobile_ScreenShot() {
		try {
			logger.info("Executing - Taking Screenshot method");
			TakesScreenshot screenshot = (TakesScreenshot) mobiledriver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			FileUtils.copyFile(src,
					new File(System.getProperty("user.dir") + "\\ScreenShotCucumber\\" + timestamp + ".png"));
			System.out.println("Successfully captured a screenshot");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot ");
			logger.warn("Unable to take the Screenshot \t");
		}
	}

	// GetText function
	public static void Machint_Mobile_getText(String LocatorType, String LocatorValue) throws IOException {
		try {
			logger.info("Executing - getText method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the getText method \t" + e.getMessage());
		}
	}

	// GetTagName function
	public static void Machint_Mobile_getTagName(String LocatorType, String LocatorValue) throws IOException {
		try {
			logger.info("Executing - getTagName method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			String tagName = element.getTagName();
			System.out.println(tagName);
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.out.println("No frame unable Machint_defaultframe \t" + e.getStackTrace());
			logger.warn("Unable to execute the getTagName method \t" + e.getMessage());
		}
	}

	// GetWebElement function
	public static WebElement Machint_Mobile_getWebElement(String LocatorType, String LocatorValue) throws Exception {
		try {
			logger.info("Executing - getWebElement method");
			Thread.sleep(1000);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			System.out.println("webelement is " + element);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			e.printStackTrace();
			System.out.print(e.toString());
			logger.warn("Unable to execute the getWebElement method \t" + e.getMessage());
		}

		return element;
	}

	// GetAttribute value function
	public static void Machint_Mobile_getAttribute_Value(String LocatorType, String LocatorValue, String sAttribute)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - getAttribute method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			String Attribute_Value = element.getAttribute(sAttribute);
			System.out.println("Attribute_Value is " + Attribute_Value);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the getAttributeValue method \t" + e.getMessage());
		}
	}

	// GetCSS value function
	public static void Machint_Mobile_getcssvalue(String LocatorType, String LocatorValue, String css_Attribute)
			throws IOException {
		try {
			logger.info("Executing - getcssValue method");
			Thread.sleep(1000);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			String cssValue = element.getCssValue(css_Attribute);
			System.out.println("cssValue is" + cssValue);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the getCSSValue method \t" + e.getMessage());
		}
	}

	public static void mitaMobileClock(String Locatortype, String Locatorvalue, String Locatorvalue1)
			throws IOException {
		try {
			logger.info("Executing - Clock method");
			locator = mitaMobilelocator(Locatortype, Locatorvalue);
			System.out.println(locator);
			AndroidElement FirstElement = mobiledriver.findElement(locator);
			System.out.println(FirstElement);
			locator1 = mitaMobilelocator(Locatortype, Locatorvalue1);
			System.out.println(locator1);
			AndroidElement SecondElement = mobiledriver.findElement(locator1);
			System.out.println(SecondElement);
			TouchAction t = new TouchAction(mobiledriver);
			// Swiping clock using long press options
			t.longPress(longPressOptions().withElement(element(FirstElement)).withDuration(Duration.ofSeconds(5)))
					.moveTo(element(SecondElement)).release().perform();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the Clock method \t" + e.getMessage());
		}

	}

	// keyboard actions
	public static void Machint_Mobile_KeyboardActions(String keyboardAction) throws Exception {
		switch (keyboardAction) {
		case "select_All":
			Machint_Mobile_select_All();
			break;

		case "Undo":
			Machint_Mobile_redo();
			break;

		case "Paste":
			Machint_Mobile_Paste();
			break;

		case "Copy":
			Machint_Mobile_Copy();
			break;

		case "redo":
			Machint_Mobile_redo();
			break;

		case "cut":
			Machint_Mobile_cut();
			break;

		case "Refresh_Page":
			Machint_Mobile_Refresh_Page();
			break;

		case "find":
			Machint_Mobile_find();
			break;

		case "Open_file":
			Machint_Mobile_OpenFile();
			break;

		case "save":
			Machint_Mobile_Save();
			break;

		default:
			System.out.println(keyboardAction + " is invalid");
		}
	}

	public static void Machint_Mobile_select_All() throws AWTException, IOException {
		try {
			logger.info("Executing - selectAll method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the selectAll method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Undo() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - Undo method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("z").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the Undo method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Paste() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - Paste method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the paste method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Copy() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - Copy method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the Copy method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_redo() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - redo method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("y").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the redo method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_cut() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - cut method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the cut method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Refresh_Page() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - RefreshPage method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the refreshPage method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_find() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - Mobilefind method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the find method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_OpenFile() throws AWTException, IOException, InterruptedException {
		try {
			logger.info("Executing - MobileOpenfile method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("o").keyUp(Keys.CONTROL).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the openFile method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Save() throws AWTException, IOException {
		try {
			logger.info("Executing - save method");
			action = new Actions(mobiledriver);
			action.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the Save method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Page_Down() throws InterruptedException, IOException {
		try {
			logger.info("Executing - PageDown method");
			action = new Actions(mobiledriver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the PageDown method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_Page_Up() throws IOException {
		try {
			logger.info("Executing - Pagup method");
			action = new Actions(mobiledriver);
			action.sendKeys(Keys.PAGE_UP).build().perform();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the PageUp method \t" + e.getMessage());
		}
	}

	// RGB to Hexa code
	public static void Machint_Mobile_RGBtoHexa(String LocatorType, String LocatorValue) throws IOException {
		try {
			logger.info("Executing - RgbtoHexa method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			String Color = element.getCssValue("color");
			System.out.println(Color);
			String hex = String.format("#%02x%02x%02x", 0, 0, 0);
			System.out.println(hex);
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Attribute found \t" + e);
			logger.warn("Unable to execute the RGBtoHexa method \t" + e.getMessage());
		}
	}

	// Sorting Orders
	public static boolean Machint_Mobile_isSorted(List<String> words, String sortOrder) throws IOException {
		ArrayList<String> actual = null;
		try {

			logger.info("Executing - Sorted method");
			actual = new ArrayList<String>(words);
			if (sortOrder.equals("ASC")) {
				Collections.sort(actual);
				System.out.println(actual);
				mitaWebWrite();
			} else {
				Collections.sort(actual, Collections.reverseOrder());
			}
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			e.printStackTrace();
			logger.warn("Unable to execute the sorting method \t" + e.getMessage());
		}
		return words.equals(actual);
	}

	// File upload using autoIT function
	public static void Machint_Mobile_autoIT_fileUpload(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception, IOException, InterruptedException {
		try {
			logger.info("Executing - FileUpload method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec(value);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_fileUpload \t" + e);
			logger.warn("Unable to execute the fileUpload method \t" + e.getMessage());
		}
	}

	// BotDetect CAPTCHA
	public static void Machint_Mobile_BotDetect_CAPTCHA(String LocatorType, String LocatorValue, String Value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - Captcha method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			String Captcha = element.getText();
			System.out.println(Captcha);
			mitaMobileWrite();
		}

		catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Click \t" + e);
			logger.warn("Unable to execute the Captcha method \t" + e.getMessage());
		}

	}

	// Tooltip validation
	public static void Machint_Mobile_getToolTip1(String LocatorType, String LocatorValue, String Value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - tooltip method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			System.out.println(element);
			element = mobiledriver.findElement(locator);
			System.out.println(element);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			// Get tooltip text
			String toolTipText = element.getAttribute("title");
			System.out.println("Tool tip text present :- " + toolTipText);

			// Compare toll tip text
			Assert.assertEquals(Value, toolTipText);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Click \t" + e);
			logger.warn("Unable to execute the tooltip method \t" + e.getMessage());
		}
	}

	public static void mitaMobileScrollIntoView(String LocatorType, String LocatorValue, String value)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - Scrollintoview method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			element.click();
			Thread.sleep(500);
			AndroidElement element1 = ((FindsByAndroidUIAutomator<AndroidElement>) mobiledriver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
									+ value + "\").instance(0))");
			element1.click();
			// Thread.sleep(500);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Scrollintoview \t" + e);
			logger.warn("Unable to execute the ScrollintoView method \t" + e.getMessage());
		}
	}

	public static void mitaMobileSingleTap(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SingleTap method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			AndroidElement element = mobiledriver.findElement(locator);
			new TouchAction((PerformsTouchActions) mobiledriver).tap(tapOptions().withElement(element(element)))
					.waitAction(waitOptions(Duration.ofMillis(250))).perform();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_SingleTap \t" + e);
			logger.warn("Unable to execute the Singletap method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_TapByCoordinate(int x, int y) throws Exception {
		try

		{
			logger.info("Executing - TapByCoordinate method");
			new TouchAction((PerformsTouchActions) mobiledriver).tap(point(x, y))
					.waitAction(waitOptions(Duration.ofMillis(250))).perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Tapcoordinate \t" + e);
			logger.warn("Unable to execute the tapByCorordinate method \t" + e.getMessage());
		}
	}

	public void Machint_Mobile_PressByElement(String LocatorType, String LocatorValue, long seconds)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - PressByElement method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			AndroidElement element = mobiledriver.findElement(locator);
			new TouchAction((PerformsTouchActions) mobiledriver).press(element(element))
					.waitAction(waitOptions(Duration.ofSeconds(seconds))).release().perform();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_PressByElement \t" + e);
			logger.warn("Unable to execute the PressByElement method \t" + e.getMessage());
		}

	}

	public void Machint_Mobile_PressByCoordinates(int x, int y, long seconds) throws IOException, InterruptedException {
		try {
			logger.info("Executing - PressByCoordinates method");
			new TouchAction((PerformsTouchActions) mobiledriver).press(point(x, y))
					.waitAction(waitOptions(Duration.ofSeconds(seconds))).release().perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_PressByCoordinates \t" + e);
			logger.warn("Unable to execute the PressByCoordinates method \t" + e.getMessage());
		}

	}

	// Horizontal Swipe by percentages
	public void Machint_Mobile_horizontalSwipeByPercentage(double startPercentage, double endPercentage,
			double anchorPercentage) throws IOException, InterruptedException {
		try {
			logger.info("Executing - horizontalSwipeByPercentage method");
			Dimension size = mobiledriver.manage().window().getSize();
			int anchor = (int) (size.height * anchorPercentage);
			int startPoint = (int) (size.width * startPercentage);
			int endPoint = (int) (size.width * endPercentage);

			new TouchAction((PerformsTouchActions) mobiledriver).press(point(startPoint, anchor))
					.waitAction(waitOptions(Duration.ofMillis(1000))).moveTo(point(endPoint, anchor)).release()
					.perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_verticalSwipeByPercentages \t" + e);
			logger.warn("Unable to execute the HorizontalSwipe method \t" + e.getMessage());
		}

	}

	// Vertical Swipe by percentages
	public void Machint_Mobile_verticalSwipeByPercentages(double startPercentage, double endPercentage,
			double anchorPercentage) throws IOException, InterruptedException {
		try {
			logger.info("Executing - verticalSwipeByPercentages method");
			Dimension size = mobiledriver.manage().window().getSize();
			int anchor = (int) (size.width * anchorPercentage);
			int startPoint = (int) (size.height * startPercentage);
			int endPoint = (int) (size.height * endPercentage);

			new TouchAction((PerformsTouchActions) mobiledriver).press(point(anchor, startPoint))
					.waitAction(waitOptions(Duration.ofMillis(1000))).moveTo(point(anchor, endPoint)).release()
					.perform();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_verticalSwipeByPercentages \t" + e);
			logger.warn("Unable to execute the VerticalSwipe method \t" + e.getMessage());
		}

	}

	public static void Machint_Mobile_getToolTip(String LocatorType, String LocatorValue, String Value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - getTooltip method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			Actions action = new Actions(mobiledriver);
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
			// Get tooltip text

			String toolTipText = element.getText();
			System.out.println("The Tooltip Text is: " + toolTipText);

			Assert.assertEquals(Value, toolTipText);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_getToolTip \t" + e);
			logger.warn("Unable to execute the getTooltip method \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_SeekBar(String LocatorType, String LocatorValue, Double x)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - Seekbar method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			WebElement seekBar = mobiledriver.findElement(locator);

			// Get start point of seekbar.
			int startX = seekBar.getLocation().getX();
			System.out.println(startX);

			// Get vertical location of seekbar.
			int startY = seekBar.getLocation().getY();
			System.out.println(startY);

			// Get end point of seekbar.
			int endX = (startX + seekBar.getSize().getWidth());
			System.out.println(endX);

			// Set seekbar move to position.
			// endX * 0.6 means at 60% of seek bar width.
			// endX * 0.9 means at 100% of seek bar width.
			int moveToXDirectionAt = (int) (endX * x);
			System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

			// Moving seekbar using TouchAction class.
			TouchAction act = new TouchAction((PerformsTouchActions) mobiledriver);
			act.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(moveToXDirectionAt, startY))
					.release().perform();
			mitaMobileWrite();
		}

		catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_SeekBar \t" + e);
			logger.warn("Unable to execute the seekbar method \t" + e.getMessage());
		}

	}

	public static void mitaMobileSign(String LocatorType, String LocatorValue)
			throws IOException, InterruptedException {

		try {
			logger.info("Executing - Sign method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			WebElement sign = mobiledriver.findElement(locator);
			Point SP = ((MobileElement) sign).getCenter();
			int x = SP.x;
			int y = SP.y;
			int newx = (SP.x + 5) / 2;
			int newy = (SP.y + 5) / 2;
			TouchAction builder = new TouchAction((PerformsTouchActions) mobiledriver);
			builder.press(PointOption.point(x, y)).moveTo(PointOption.point(newx, newy)).perform().release();
			mitaMobileWrite();
		}

		catch (Exception e1) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_sign \t" + e1);
			logger.warn("Unable to execute the Sign method \t" + e1.getMessage());
		}

	}

	public static void Machint_Mobile_DragandDrop(String Locatortype, String Locatorvalue, String LocatorType1,
			String LocatorValue1) throws Exception {
		try {
			logger.info("Executing - DragAndDrop method");
			locator = mitaMobilelocator(Locatortype, Locatorvalue);
			System.out.println(locator);
			WebElement From = mobiledriver.findElement(locator);
			System.out.println(From);
			locator1 = mitaMobileEndLocator(LocatorType1, LocatorValue1);
			System.out.println(locator1);
			WebElement To = mobiledriver.findElement(locator1);
			System.out.println(To);
			Actions act = new Actions(mobiledriver);

			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();

		} catch (Exception e1) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_sign \t" + e1);
			logger.warn("Unable to execute the dragandDrop method \t" + e1.getMessage());
		}

	}

	public static void mitaMobileDoubleTap(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - DoubleTap method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			AndroidElement Element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			TouchAction press = new TouchAction((PerformsTouchActions) mobiledriver).press(element(Element))
					.waitAction(waitOptions(Duration.ofSeconds(1))).release();

			new MultiTouchAction((PerformsTouchActions) mobiledriver).add(press).perform();
			mitaMobileWrite();
		} catch (Exception e) {
			System.out.println("not found");
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the doubleTap method \t" + e.getMessage());
		}
	}

	/*
	 * public void drawFace() { Point head = new Point(220, 450); Point leftEye =
	 * head.moveBy(-50, -50); Point rightEye = head.moveBy(50, -50); Point mouth =
	 * head.moveBy(0, 50);
	 * 
	 * drawCircle(mobiledriver, head, 150, 30); drawCircle(mobiledriver, leftEye,
	 * 20, 20); drawCircle(mobiledriver, rightEye, 20, 20); drawCircle(mobiledriver,
	 * mouth, 40, 20); }
	 */
	public void mitaMobileDrawFace() {
		logger.info("Executing - Drawface method");
		Point head = new Point(120, 250);
		Point leftEye = head.moveBy(-25, -25);
		Point rightEye = head.moveBy(25, -25);
		Point mouth = head.moveBy(0, 25);

		/*
		 * drawCircle(driver), mobiledriver, head, 75, 15); drawCircle(driver),
		 * mobiledriver, leftEye, 7, 7); drawCircle(driver), mobiledriver, rightEye, 7,
		 * 7); //drawCircle(mobiledriver, mouth, 20, 10);
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ign) {
			logger.warn("Unable to execute the drawFace method \t" + ign.getMessage());
		}
	}

	private Point mitaMobileGetPointOnCircle(int step, int totalSteps, Point origin, double radius) throws IOException {
		int x = 0, y = 0;
		try {
			logger.info("Executing - getPointOnCircle method");
			double theta = 2 * Math.PI * ((double) step / totalSteps);
			x = (int) Math.floor(Math.cos(theta) * radius);
			y = (int) Math.floor(Math.sin(theta) * radius);
		} catch (Exception e) {
			System.out.println("not found");
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the getPointCircle method \t" + e.getMessage());
		}
		return new Point(origin.x + x, origin.y + y);
	}

	private void mitaWebDrawCircle(Driver mobiledriver, Point origin, double radius, int steps) throws IOException {
		try {
			logger.info("Executing - drawCircle method");
			Point firstPoint = mitaMobileGetPointOnCircle(0, steps, origin, radius);

			PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
			Sequence circle = new Sequence(finger, 0);
			circle.addAction(finger.createPointerMove(NO_TIME, VIEW, firstPoint.x, firstPoint.y));
			circle.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));

			for (int i = 1; i < steps + 1; i++) {
				Point point = mitaMobileGetPointOnCircle(i, steps, origin, radius);
				circle.addAction(finger.createPointerMove(STEP_DURATION, VIEW, point.x, point.y));
			}

			circle.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
			((RemoteWebDriver) driver).perform(Arrays.asList(circle));
		} catch (Exception e) {
			System.out.println("not found");
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the DrawCircle method \t" + e.getMessage());
		}
	}

	public static void mitaMobileWaitTime(long sleepTime) throws InterruptedException, IOException {
		try {
			logger.info("Executing - Wait method");
			Thread.sleep(sleepTime);
			mitaWebWrite();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the Wait method \t" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mitaWebWaitTime(long sleepTime) throws InterruptedException, IOException {
		try {
			logger.info("Executing - Wait method");
//			ExtentTestManager.getTest().log(Status.INFO, Driver_Script.Actionvalue + " "+sleepTime+" Seconds");
			Thread.sleep(sleepTime);
			mitaWebWrite();
		} catch (Exception e) {
			logger.warn("Unable to execute the Wait method \t" + e.getMessage());
//			reporterLog("Unable to execute the Wait method \t" + e.getMessage());
		}
	}

	// Generate the Random Aadhar number
	public static void mitaMobileGenerateRandomNumber(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - generateRandomNumber method");
			int number = Integer.parseInt(value);
			String randomNumber = mitaGenerateAadharNumber(number);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_Mobile_EnterTextField \t" + e);
			logger.warn("Unable to execute the generaterandomnumber method \t" + e.getMessage());
		}
	}

	/*
	 * public static String generateAadharNumber1() { Date date = new Date();
	 * Timestamp ts = new Timestamp(date.getTime()); SimpleDateFormat formatter =
	 * new SimpleDateFormat("yyyyMMddHHss");
	 * System.out.println(formatter.format(ts)); String random =
	 * formatter.format(ts); System.out.println("Veeru " + random); return random; }
	 */

	public static String mitaGenerateAadharNumber(int length) {
		String chars = "0123456789";
		String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
				.collect(Collectors.joining());
		System.out.println(str);
		return str;
	}

	public static void mitaMobileSeekBar(String LocatorType, String LocatorValue, String number)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - Seekbar method");
			Double x = Double.valueOf(number);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			WebElement seekBar = mobiledriver.findElement(locator);

			// Get start point of seekbar.
			int startX = seekBar.getLocation().getX();
			// System.out.println(startX);

			// Get vertical location of seekbar.
			int startY = seekBar.getLocation().getY();
			// System.out.println(startY);

			// Get end point of seekbar.
			int endX = (startX + seekBar.getSize().getWidth());
			System.out.println(endX);

			// Set seekbar move to position.
			// endX * 0.6 means at 60% of seek bar width.
			// endX * 0.9 means at 100% of seek bar width.
			int moveToXDirectionAt = (int) (endX * x);
			System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");
			Thread.sleep(1000);
			// Moving seekbar using TouchAction class.
			TouchAction act = new TouchAction((PerformsTouchActions) mobiledriver);
			act.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(moveToXDirectionAt, startY))
					.release().perform();
			Thread.sleep(1000);
			mitaMobileWrite();
		}

		catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_SeekBar \t" + e);
			logger.warn("Unable to execute the seekbar method \t" + e.getMessage());
		}

	}

	public static void mitaMobileNumberOTP(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - Mobile number OTP method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			RestAssured.baseURI = BASE_URL;
			RequestSpecification request = RestAssured.given();
			request.header("Appian-API-Key",
					"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkMjE4YjUxNi0wYzA5LTRhMTMtYTZiYi00YjQ2ZjQ2YmYwYjkifQ.S26NBlhpMuqVeo5gFl6gd5AiHDfP90rzWIc2k0g9vrU");
			request.header("Content-Type", "application/json");
			response = request.body("{\"phNumber\" : \"" + value + "\", \"flag\" : \"newUser\"}")
					.post("/suite/webapi/abank-generate-otp");
			String responseBody = ((ResponseOptions<Response>) response).getBody().asString();
			System.out.println("Response Body is:" + responseBody);
			JSONObject jsonobject = new JSONObject(responseBody);
			int OTP = jsonobject.getInt("OTP");
			value = String.valueOf(OTP);

			// status code validation
			int statusCode = ((ResponseOptions<Response>) response).getStatusCode();
			// Assert.assertEquals(statusCode, 201);
			element.clear();
			element.sendKeys(value);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_Mobile_EnterTextField \t" + e);
			logger.warn("Unable to handling the OTP method \t" + e.getMessage());
		}
	}

	// Different type of locators function
	public static By mitaMobilelocator(String locatorType, String LocatorValue) {
		switch (locatorType) {
		case "id":
			by = By.id(LocatorValue);
			break;

		case "name":
			by = By.name(LocatorValue);
			break;

		case "className":
			by = By.className(LocatorValue);
			break;

		case "tagName":
			by = By.tagName(LocatorValue);
			break;

		case "xpath":
			by = By.xpath(LocatorValue);
			break;

		case "css":
			by = By.cssSelector(LocatorValue);
			break;

		case "linkText":
			by = By.linkText(LocatorValue);
			break;

		case "partialLinkText":
			by = By.partialLinkText(LocatorValue);
			break;

		default:
			by = null;
			break;
		}
		return by;
	}

	public static By mitaMobileEndLocator(String locatorType1, String LocatorValue1) {
		switch (locatorType1) {
		case "id":
			by = By.id(LocatorValue1);
			break;

		case "name":
			by = By.name(LocatorValue1);
			break;

		case "className":
			by = By.className(LocatorValue1);
			break;

		case "tagName":
			by = By.tagName(LocatorValue1);
			break;

		case "xpath":
			by = By.xpath(LocatorValue1);
			break;

		case "css":
			by = By.cssSelector(LocatorValue1);
			break;

		case "linkText":
			by = By.linkText(LocatorValue1);
			break;

		case "partialLinkText":
			by = By.partialLinkText(LocatorValue1);
			break;

		default:
			by = null;
			break;
		}
		return by;
	}

	public static void mitaMobileScrollUp(String Startnumber, String Endnumber)
			throws IOException, InterruptedException {
		try {
			logger.info("Executing - Scrollup method");
			// System.out.println("entered into the scroll up");
			double d = Double.valueOf(Startnumber);
			System.out.println("d value is" + d);
			double e = Double.valueOf(Endnumber);
			System.out.println("d value is" + e);
			Dimension dimension = mobiledriver.manage().window().getSize();
			int scrollend = (int) (dimension.getHeight() * d);
			int scrollstart = (int) (dimension.getHeight() * e);
			TouchAction action = new TouchAction(mobiledriver);
			action.press(PointOption.point(xOffset = 0, scrollend));
			action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
			action.moveTo(PointOption.point(xOffset = 0, scrollstart));
			action.release();
			action.perform();
			mitaWebWrite();

		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to scrollup \t" + e.getMessage());
			logger.warn("Unable to execute the ScrollUp method \t" + e.getMessage());
		}
	}

	/*
	 * public static void Machint_Mobile_calendarYear() throws IOException,
	 * InterruptedException { try { Dimension windowSize =
	 * mobiledriver.manage().window().getSize(); Map<String, Object> args = new
	 * HashMap<>(); args.put("command", "input"); args.put("args",
	 * Lists.newArrayList("swipe", windowSize.width / 2, windowSize.height / 2,
	 * windowSize.width / 2, windowSize.height)); while
	 * (mobiledriver.findElements(By.xpath("//android.widget.TextView[@text='1998']"
	 * )).size() == 0) { mobiledriver.executeScript("mobile: shell", args); }
	 * mobiledriver.findElement(By.xpath("//android.widget.TextView[@text='1998']"))
	 * .click();
	 * 
	 * } catch (Exception e) { mitaMobileWriteWhenLocatorIsNotValid();
	 * System.err.format("No Element Found to scrollup \t" + e.getMessage());
	 * logger.warn("Unable to execute the ScrollUp method \t" + e.getMessage()); } }
	 */

	public static void mitaMobileProgressBarWait(String locatorType, String locatorValue, String waitType)
			throws Exception {
		try {
			logger.info("Executing - ProgressBar method");
			locator = mitaMobilelocator(locatorType, locatorValue);
			// System.out.println("locator values"+ locator);
			element = mobiledriver.findElement(locator);
			// Thread.sleep(20000);
			System.out.println("element values" + element);
			mitaMobileWaits(waitType);
			System.out.println("waittype is" + waitType);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to machint_ProgressBar_wait \t" + e);
			logger.warn("Unable to execute the Progressbar method \t" + e.getMessage());
		}
	}

	/*
	 * public static void Machint_Mobile_scrollDown(String locatorid,String value)
	 * throws IOException, InterruptedException { try {
	 * logger.info("Executing - scrollDown method"); double d =
	 * Double.valueOf(Startnumber); double e = Double.valueOf(Endnumber);
	 * 
	 * Dimension dimension = mobiledriver.manage().window().getSize(); int
	 * scrollstart = (int) (dimension.getHeight() * d);
	 * 
	 * int scrollend = (int) (dimension.getHeight() * e);
	 * 
	 * TouchAction action = new TouchAction(mobiledriver);
	 * action.press(PointOption.point(xOffset = 0, scrollstart));
	 * 
	 * action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
	 * action.moveTo(PointOption.point(xOffset = 0, scrollend));
	 * 
	 * action.release(); action.perform();
	 * 
	 * 
	 * logger.info("Executing - Scrolldown method"); locator =
	 * mitaMobilelocator(locatorType, locatorValue); //
	 * System.out.println("locator values"+ locator); element =
	 * mobiledriver.findElement(locator);
	 * 
	 * TouchActions action = new TouchActions(mobiledriver); action.scroll(element,
	 * 10, 100); action.perform(); element.click();
	 * 
	 * String scrollElement =
	 * "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
	 * "scrollIntoView(new UiSelector().text(\"COVER ME\").instance(0))";
	 * 
	 * mobiledriver.findElementByAndroidUIAutomator(scrollElement).isDisplayed();
	 * 
	 * 
	 * 
	 * mitaMobileWrite(); } catch (Exception e) {
	 * System.err.format("No Element Found to perform Machint_Mobile_scrollDown \t"
	 * + e.getMessage()); logger.warn("Unable to execute the ScrollDown method \t" +
	 * e.getMessage()); }
	 * 
	 * }
	 */

	public static void mitaMobileScrollDown(String text) throws IOException, InterruptedException {
		try {
			logger.info("Executing - ScrollDown method");
			AndroidElement element = ((FindsByAndroidUIAutomator<AndroidElement>) mobiledriver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
									+ text + "\").instance(0))");
			element.isDisplayed();
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to perform Machint_Mobile_Scrollintoview \t" + e);
			logger.warn("Unable to execute the ScrollintoView method \t" + e.getMessage());
		}
	}

	public static void mitaWebScrollDown(String LocatorType, String LocatorValue) throws IOException, InterruptedException {
		try {
			logger.info("Executing - EnterTextKey method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(1000);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextKey method \t" + e.getMessage());
//			reporterLog("Unable to execute the EnterTextKey method \t" + e.getMessage());

		}
	}

	public static void mitaWebGetTheLeadID1(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GettheLeadId method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			leadID = element.getText();
			leadID = leadID.substring(9, 13);
			System.out.println(leadID);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}

	// Set the Lead id
	public static void mitaWebSetTheLeadID(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SettheLeadid method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			mitaSendChar(element, leadID);
			// element.sendKeys(leadID);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
//			reporterLog("Unable to set the value \t" + e.getMessage());
		}
	}

	public static void Machint_Mobile_GetTheLeadID1(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GettheLeadId method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			leadID = element.getText();
			leadID = leadID.substring(10, 14);
			System.out.println(leadID);
			mitaMobileWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}
	public static void mitaMobileSetTheLeadID(String locatorType, String locatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SettheFirstValue method");
			locator = mitaMobilelocator(locatorType, locatorValue);
			mitaMobileWaits(WaitType);
			element = mobiledriver.findElement(locator);
			element.clear();
			Thread.sleep(1000);
			mitaSendChar(element, leadID);
			// element.sendKeys(leadID);
			// Thread.sleep(500);
			mitaMobileWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform set the lead \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}

	public static void mitaSendChar(WebElement element, String value) throws InterruptedException {
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(500);
			element.sendKeys(s);
		}

	}

	public static void mitaWebGetTheLeadID(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GettheLeadId method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			leadID = element.getText();
			StringBuilder myNumbers = new StringBuilder();
			for (int i = 0; i < leadID.length(); i++) {
				if (Character.isDigit(leadID.charAt(i))) {
					myNumbers.append(leadID.charAt(i));
				}
			}
			leadID = myNumbers.toString();
			System.out.println(leadID);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
//			reporterLog("Unable to get the value \t" + e.getMessage());
		}
	}

	public static void mitaMobileGetTheLeadID(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - GettheLeadId method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			leadID = element.getText();
			StringBuilder myNumbers = new StringBuilder();
			for (int i = 0; i < leadID.length(); i++) {
				if (Character.isDigit(leadID.charAt(i))) {
					myNumbers.append(leadID.charAt(i));
				}
			}
			leadID = myNumbers.toString();
			mitaMobileWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}

	// Enter the char by char
	public static void mitaWebEnterCharacter(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - EnterCharacter method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			mitaSendChar(element, value);
			// element.sendKeys(leadID);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
		}
	}

	// Generate the Mobile number starts with zero
	public static void mitaWebZeroStartsNumber(String LocatorType, String LocatorValue, String value, String WaitType) throws Exception {
		try {
			logger.info("Executing - zeroStartsNumber method");

			int number = Integer.parseInt(value);
			String randomNumber = mitaGenerateNumber(number);
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
//			System.err.format("No Element Found to Machint_zeroStartsNumber \t" + e);
			logger.warn("Unable to execute the Machint_zeroStartsNumber method \t" + e.getMessage());
//			reporterLog("Unable to execute the Machint_zeroStartsNumber method \t" + e.getMessage());
		}
	}

	public static String mitaGenerateNumber(int length) {
		String chars = "0123456789";
		String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
				.collect(Collectors.joining());
		int number1 = Integer.parseInt(str);
		System.out.println(str);
		String str1 = String.format("%010d", number1);
		System.out.println(str1);
		return str1;
	}

	public static void mitaWebUploadSendkeys(String LocatorType, String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - uploadSendKEys method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
//			mitaWebWait(WaitType);
			Thread.sleep(1000);
			element.sendKeys(value);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform get the lead \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
//			reporterLog("Unable to set the value \t" + e.getMessage());
		}
	}

	public static void mitaWebAutoITFileUpload(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception, IOException, InterruptedException {
		try {
			logger.info("Executing - FileUpload method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec(value);
			Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to autoIT_fileUpload \t" + e);
			logger.warn("Unable to execute the fileUpload method \t" + e.getMessage());
		}
	}

	// Generate the Mobile number starts with zero
	public static void mitaMobileZeroStartsNumber(String LocatorType, String LocatorValue, String value,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - zeroStartsNumber method");
			int number = Integer.parseInt(value);
			String randomNumber = mitaGenerateNumber(number);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to Machint_Mobile_zeroStartsNumber \t" + e);
			logger.warn("Unable to execute the zeroStartsNumber method \t" + e.getMessage());
		}
	}

	// Set the Lead id
	public static void mitaWebSetTheOTP(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SettheLeadid method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			/*
			 * element = driver.findElement(locator); mita_JSHighlight(element);
			 * mitaWebWait(WaitType); element.clear();
			 */ Thread.sleep(1000);
			String otp[] = leadID.split("");
			driver.findElement(By.name("pin0")).sendKeys(otp[0]);
			driver.findElement(By.name("pin1")).sendKeys(otp[1]);
			driver.findElement(By.name("pin2")).sendKeys(otp[2]);
			driver.findElement(By.name("pin3")).sendKeys(otp[3]);
			driver.findElement(By.name("pin4")).sendKeys(otp[4]);
			driver.findElement(By.name("pin5")).sendKeys(otp[5]);
			// sendChar(element, leadID);
			// element.sendKeys(leadID);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform set the otp \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
//			reporterLog("Unable to set the value \t" + e.getMessage());
		}

	}

	/**
	 * @description: Adding the days for current day
	 * @param -data - To provide number of days
	 * @return Pass or Fail
	 */

	public static void mitaWebAddDates(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - WebAddDates method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);

			Date returnDate = new Date();
			Date date;
			int number = Integer.parseInt(value);
			date = addDays(returnDate, number);
			// date = offsetForWeekend(date);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr = sdf.format(date);
			System.out.println("In Main method  : " + dateStr);

			element.clear();
			// element.sendKeys(dateStr);
			mitaSendChar(element, dateStr);
			mitaWebWrite();
		} catch (Exception e) {
			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the WebAddDates method \t" + e.getMessage());

		}
	}

	public static void mitaMobileAddDates(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - MobileAddDates method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			Date returnDate = new Date();
			Date date;
			int number = Integer.parseInt(value);
			date = addDays(returnDate, number);
			// date = offsetForWeekend(date);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr = sdf.format(date);
			System.out.println("In Main method  : " + dateStr);

			element.clear();
			// element.sendKeys(dateStr);
			mitaSendChar(element, dateStr);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to MobileAddDates \t" + e);
			logger.warn("Unable to execute the MobileAddDates method \t" + e.getMessage());

		}
	}

	// Dependent method for addDates().............

	public static Date addDays(Date dateToAdd, int numberOfDay) {
		if (dateToAdd == null)
			throw new IllegalArgumentException("Date can't be null!");
		Calendar tempCal = Calendar.getInstance();
		tempCal.setTime(dateToAdd);
		tempCal.add(Calendar.DATE, numberOfDay);
		return tempCal.getTime();
	}

	// Dependent method for addDates().............

	public static Date offsetForWeekend(Date baseCal) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(baseCal);

		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return addDays(baseCal, 2);
		} else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return addDays(baseCal, 1);
		} else
			return baseCal;
	}

	public static void mitaWebDynamicString(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - WebDynamicString method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			String random = mitaDynamicString(Integer.parseInt(value));
			System.out.println(random);
			element.clear();
			element.sendKeys(random);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the WebDynamicString method \t" + e.getMessage());
//			reporterLog("Unable to execute the WebDynamicString method \t" + e.getMessage());

		}
	}

	public static String mitaDynamicString(int value) {
		randomString = RandomStringUtils.randomAlphabetic(value);
		System.out.println(randomString);
		return randomString;
	}

	public static void mitaMobileDynamicString(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - MobileDynamicString method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			String random = mitaDynamicString(Integer.parseInt(value));
			System.out.println(random);
			element.clear();
			element.sendKeys(random);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to MobileDynamicString \t" + e);
			logger.warn("Unable to execute the MobileDynamicString method \t" + e.getMessage());

		}
	}

	public static void mitaWebAppendText(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - WebAppendText method");

			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebJSHighlight(element);
			mitaWebWait(WaitType);
			element.click();
			value = mitaDynamicString(5) + value;
			element.sendKeys(value);
			Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the WebAppendText method \t" + e.getMessage());
//			reporterLog("Unable to execute the WebAppendText method \t" + e.getMessage());

		}
	}

	public static void mitaMobileAppendText(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			// Machint_JSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			value = mitaDynamicString(5) + value;
			element.sendKeys(value);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			System.err.format("No Element Found to MobileAppendText \t" + e);
			logger.warn("Unable to execute the MobileAppendText method \t" + e.getMessage());
		}

	}

	// Enter text using Keys.ENTER function to display the element

	public static void mitaWebElemenDisplay(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");

			try {
				if (element.isDisplayed())
					locator = mitaWebLocator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mitaWebJSHighlight(element);
				element.clear();
				element.sendKeys(value);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class=\"btn btn-primary text-uppercase btn-submit\"])[2]")).click();
				mitaWebWrite();
			} catch (Exception e) {
				mitaWebWrite();
			}
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
//			System.err.format("No Element Found to Machint_WebElemenDisplay \t" + e);
			logger.warn("Unable to execute the Machint_WebElemenDisplay method \t" + e.getMessage());
//			reporterLog("Unable to execute the Machint_WebElemenDisplay method \t" + e.getMessage());

		}
	}

	public static void mitaWebRefresh() {
		try {
			logger.info("Executing - Refresh method");
			driver.navigate().refresh();
			mitaWebWrite();
		} catch (Exception e) {
			logger.warn("Unable to refresh \t" + e.getMessage());
		}
	}

	public static String mitaGetCurrentTime() {
		timeStamp = DateTime.now().toString("yyyy-MM-dd--hh-mm-ss");
		return timeStamp;
	}

	public static void mitaWebResponse(String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue);
			// Get list of web-elements with tagName - a
			List<WebElement> allLinks = driver.findElements(By.tagName(LocatorValue));
			System.out.println("The number of links is " + allLinks.size());
			ExtentTestManager.getTest().log(Status.PASS, "The number of links is " + allLinks.size());

			int count = 0, count1 = 0;

			// Traversing through the list and printing its text along with link address
			for (WebElement link : allLinks) {

				String links = link.getText() + " - " + link.getAttribute(value);
				System.out.println(links);

				String baseUrl = driver.getCurrentUrl();

				// Specify the base URL to the RESTful web service
				RestAssured.baseURI = baseUrl;
				// Get the RequestSpecification of the request to be sent to the server
				RequestSpecification httpRequest = RestAssured.given();

				Response response = httpRequest.get("");

				// Get the status code of the request.
				// If request is successful, status code will be 200
				int statusCode = response.getStatusCode();

				System.out.println("status code " + statusCode);

				inputFile = new FileInputStream(new File(Runner.filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
				String sheetname = "Response";
				try {

					sheetname = sheetname.trim();

					if (sheetname.isEmpty()) {
						throw new Exception("Sheet name not specified..");
					}

					sheet = workbook.getSheet(sheetname);

					if (sheet != null) {
						throw new Exception("Sheet Already exist...");
					}

					sheet = workbook.createSheet(sheetname);

					workbook.createSheet(sheetname);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Row row = sheet.createRow(count);
				Cell searchText2 = row.createCell(0);
				searchText2.setCellValue(links);

				Cell searchText3 = row.createCell(1);
				searchText3.setCellValue(statusCode);

				outFile = new FileOutputStream(new File(Runner.filePath));
				workbook.write(outFile);
				inputFile.close();
				outFile.close();

				if (statusCode == 200) {
					count = count + 1;
				} else {
					count1 = count1 + 1;
				}
			}
			actual = "Status code 200 are: " + count + " and Incorrect status codes are: " + count1;
			ExtentTestManager.getTest().log(Status.PASS,
					"Status code 200 are: " + count + " and Incorrect status codes are: " + count1);
			mitaWebWritePass();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
		}
	}

	public static void mitaWebResponse1(String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue);
			// Get list of web-elements with tagName - a
			List<WebElement> allLinks = driver.findElements(By.tagName(LocatorValue));
			System.out.println("The number of links is " + allLinks.size());
			ExtentTestManager.getTest().log(Status.PASS, "The number of links is " + allLinks.size());

			int count = 0, count1 = 0;

			// Traversing through the list and printing its text along with link address
			for (WebElement link : allLinks) {

				String links = link.getText() + " - " + link.getAttribute(value);
				System.out.println(links);

				String baseUrl = driver.getCurrentUrl();

				// Specify the base URL to the RESTful web service
				RestAssured.baseURI = baseUrl;
				// Get the RequestSpecification of the request to be sent to the server
				RequestSpecification httpRequest = RestAssured.given();

				Response response = httpRequest.get("");

				// Get the status code of the request.
				// If request is successful, status code will be 200
				int statusCode = response.getStatusCode();

				System.out.println("status code " + statusCode);

				inputFile = new FileInputStream(new File(Runner.filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
				String sheetname = "Response";
				try {

					sheetname = sheetname.trim();

					if (sheetname.isEmpty()) {
						throw new Exception("Sheet name not specified..");
					}

					sheet = workbook.getSheet(sheetname);

					if (sheet != null) {
						throw new Exception("Sheet Already exist...");
					}

					sheet = workbook.createSheet(sheetname);

					workbook.createSheet(sheetname);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Row row = sheet.createRow(count);
				Cell searchText2 = row.createCell(0);
				searchText2.setCellValue(links);

				Cell searchText3 = row.createCell(1);
				searchText3.setCellValue(statusCode);

				outFile = new FileOutputStream(new File(Runner.filePath));
				workbook.write(outFile);
				inputFile.close();
				outFile.close();

				if (statusCode == 200) {
					count = count + 1;
				} else {
					count1 = count1 + 1;
				}
			}
			actual = "Status code 200 are: " + count + " and Incorrect status codes are: " + count1;
			ExtentTestManager.getTest().log(Status.PASS,
					"Status code 200 are: " + count + " and Incorrect status codes are: " + count1);
			mitaWebWritePass();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
		}
	}

	public static void mitaWebHeadingTags(String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");

			String tags = null, actual1 = null, actual2 = null;
			int count = 0, failCount = 0;
			List<WebElement> allLinks = driver.findElements(By.tagName(LocatorValue));
			ArrayList<String> hrefs = new ArrayList<String>();
			int linkCount = allLinks.size();

			System.out.println("Total number of page on the webpage: " + linkCount);

			String[] texts = new String[linkCount];

			int t = 0;
			for (WebElement text : allLinks) {
				texts[t] = text.getAttribute("href");
//				System.out.println(texts[t]);
				t++;
			}

			for (String clicks : texts) {

				driver.get(clicks);

				List<WebElement> allTags = driver.findElements(By.tagName(value));
				int tagCount = allTags.size();
				System.out.println("Total no of " + value + " are : " + tagCount);
//				ExtentTestManager.getTest().log(Status.PASS, "Total no of " + value + " are : " + tagCount);

				if (tagCount == 0) {
					System.out.println("Missing " + value + " tag");
					actual2 = "Missing " + value + " tag";
					ExtentTestManager.getTest().log(Status.ERROR, "Missing " + value + " tag");
					failCount = failCount + 1;
					hrefs.add(actual2);
				} else {
					for (WebElement tag : allTags) {
						tags = tag.getText();
						System.out.println(tags);
						hrefs.add(tags);
					}
				}

				inputFile = new FileInputStream(new File(Runner.filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
				String sheetname = "tags";
				try {
					sheetname = sheetname.trim();
					if (sheetname.isEmpty()) {
						throw new Exception("Sheet name not specified..");
					}
					sheet = workbook.getSheet(sheetname);
					if (sheet != null) {
						throw new Exception("Sheet Already exist...");
					}
					sheet = workbook.createSheet(sheetname);
					workbook.createSheet(sheetname);
				} catch (Exception e) {
					e.printStackTrace();
				}

				actual1 = "links is " + clicks;
				actual2 = value + " tag is " + hrefs;

				Row row = sheet.createRow(count);
				Cell searchText2 = row.createCell(0);
				searchText2.setCellValue(actual1);

				Cell searchText3 = row.createCell(1);
				searchText3.setCellValue(actual2);

				outFile = new FileOutputStream(new File(Runner.filePath));
				workbook.write(outFile);
				inputFile.close();
				outFile.close();
				hrefs.clear();
				count = count + 1;
			}

			actual = "Missing " + value + " tag count is:  " + failCount;
			ExtentTestManager.getTest().log(Status.PASS, "Missing " + value + "tag count is:  " + failCount);
			mitaWebWritePass();

		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the heading tags method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR,
					"Unable to execute the heading tags method \t" + e.getMessage());
		}
	}

	public static void mitaWebHeadingTags(String LocatorValue) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue + " " + LocatorValue);
			String tags = null;
			ArrayList<String> ar = new ArrayList<String>();
			List<WebElement> allH1 = driver.findElements(By.tagName(LocatorValue));
			int h1Count = allH1.size();
			System.out.println("Total no of h1 count: " + h1Count);
			ExtentTestManager.getTest().log(Status.PASS, "Total no of h1 count: " + h1Count);
			for (WebElement h1Tag : allH1) {
				tags = h1Tag.getText();
				System.out.println(tags);
				ar.add(tags);
			}
			actual = LocatorValue + " tags is  " + ar;
			ExtentTestManager.getTest().log(Status.PASS, LocatorValue + " tags is  " + ar);
			mitaWebWritePass();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the heading tags method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR,
					"Unable to execute the heading tags method \t" + e.getMessage());
		}
	}

//	public static void mita_metaTags(String LocatorType, String LocatorValue) throws Exception {
//		try {
//			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
//			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue + " " + LocatorValue);
//			locator = mitaMobilelocator(LocatorType, LocatorValue);
//			List<WebElement> allImg = driver.findElements(locator);
//
//			int imgsCount = allImg.size();
//			if (allImg.size() == 0) {
//				System.out.println("This page og:image not avialable");
//				actual = "This page og:image not avialable";
//				ExtentTestManager.getTest().log(Status.ERROR, "This page og:image not avialable");
//			} else {
//
//				System.out.println("Total no of og:image Available: " + imgsCount);
//				actual = "Total no of og:image Available: " + imgsCount;
//				ExtentTestManager.getTest().log(Status.PASS, "Total no of og:image Available: " + imgsCount);
//			}
//			mita_Web_writePass();
//		} catch (Exception e) {
////			System.err.format("No Element Found to perform entering the values \t" + e);
//			mitaWebWriteWhenLocatorIsNotValid()
//			logger.warn("Unable to execute the meta tags method \t" + e.getMessage());
//			ExtentTestManager.getTest().log(Status.ERROR, "Unable to execute the meta tags method \t" + e.getMessage());
//		}
//	}

	public static void mitaWebMetaTags(String LocatorType, String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue + " " + LocatorValue);

			String actual1 = null, actual2 = null;
			int count = 0, failCount = 0;
			List<WebElement> allLinks = driver.findElements(By.tagName(value));
			int linkCount = allLinks.size();

			System.out.println("Total number of page on the webpage: " + linkCount);

			String[] texts = new String[linkCount];

			int t = 0;
			for (WebElement text : allLinks) {
				texts[t] = text.getAttribute("href");
//				System.out.println(texts[t]);
				t++;
			}

			for (String clicks : texts) {

				driver.get(clicks);
				locator = mitaWebLocator(LocatorType, LocatorValue);
				List<WebElement> allImg = driver.findElements(locator);

				int imgsCount = allImg.size();
				if (allImg.size() == 0) {
					System.out.println("Meta is missing");
					actual2 = "Meta is missing";
//				ExtentTestManager.getTest().log(Status.ERROR, "This page og:image not avialable");
					failCount = failCount + 1;
				} else {
					System.out.println("Total no of og:image Available: " + imgsCount);
					actual2 = "Total no of og:image Available: " + imgsCount;
//				ExtentTestManager.getTest().log(Status.PASS, "Total no of og:image Available: " + imgsCount);
				}

				inputFile = new FileInputStream(new File(Runner.filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
				String sheetname = "image";
				try {
					sheetname = sheetname.trim();
					if (sheetname.isEmpty()) {
						throw new Exception("Sheet name not specified..");
					}
					sheet = workbook.getSheet(sheetname);
					if (sheet != null) {
						throw new Exception("Sheet Already exist...");
					}
					sheet = workbook.createSheet(sheetname);
					workbook.createSheet(sheetname);
				} catch (Exception e) {
					e.printStackTrace();
				}
				actual = "Missing meta count is:  " + failCount;
				actual1 = "links is " + clicks;
				System.out.println(actual1);
				System.out.println(actual2);

				Row row = sheet.createRow(count);
				Cell searchText2 = row.createCell(0);
				searchText2.setCellValue(actual1);

				Cell searchText3 = row.createCell(1);
				searchText3.setCellValue(actual2);

				outFile = new FileOutputStream(new File(Runner.filePath));
				workbook.write(outFile);
				inputFile.close();
				outFile.close();
//			hrefs.clear();
				count = count + 1;
			}

			mitaWebWritePass();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the meta tags method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR, "Unable to execute the meta tags method \t" + e.getMessage());
		}
	}

	public static void mitaWebBrokenLinks(String LocatorType, String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + " method");
			ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue);

			String actual1 = null, actual2 = null;
			int actual3 = 0;
			int count = 0, failCount = 0;
			List<WebElement> allLinks = driver.findElements(By.tagName(LocatorValue));
			int linkCount = allLinks.size();

			for (int i = 0; i < linkCount; i++) {
				WebElement element = allLinks.get(i);

				String url = element.getAttribute(value);

				// Sometimes we may face exception "java.net.MalformedURLException". Keep the
				// code in try catch block to continue the broken link analysis
				try {
					// Use URL Class - Create object of the URL Class and pass the urlLink as
					// parameter
					URL link = new URL(url);
					// Create a connection using URL object (i.e., link)
					HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
					// Set the timeout for 2 seconds
					httpConn.setConnectTimeout(2000);
					// connect using connect method
					httpConn.connect();
					// use getResponseCode() to get the response code.
					if (httpConn.getResponseCode() == 200) {
						System.out.println(
								url + " - " + httpConn.getResponseCode() + "-" + httpConn.getResponseMessage());
						actual1 = url;
						actual2 = httpConn.getResponseMessage();
						actual3 = httpConn.getResponseCode();
					} else {
						System.out.println(
								url + " - " + httpConn.getResponseCode() + "-" + httpConn.getResponseMessage());
						actual1 = url;
						actual2 = httpConn.getResponseMessage();
						actual3 = httpConn.getResponseCode();
						failCount = failCount + 1;
					}
				}
				// getResponseCode method returns = IOException - if an error occurred
				// connecting to the server.
				catch (Exception e) {
					e.printStackTrace();
				}

				inputFile = new FileInputStream(new File(Runner.filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
				String sheetname = "BrokenLinks";
				try {
					sheetname = sheetname.trim();
					if (sheetname.isEmpty()) {
						throw new Exception("Sheet name not specified..");
					}
					sheet = workbook.getSheet(sheetname);
					if (sheet != null) {
						throw new Exception("Sheet Already exist...");
					}
					sheet = workbook.createSheet(sheetname);
					workbook.createSheet(sheetname);
				} catch (Exception e) {
					e.printStackTrace();
				}
				actual = "Broken links count is :  " + failCount;
				System.out.println(actual1);

				Row row = sheet.createRow(count);
				Cell searchText2 = row.createCell(0);
				searchText2.setCellValue(actual1);

				Cell searchText3 = row.createCell(1);
				searchText3.setCellValue(actual2);

				Cell searchText4 = row.createCell(2);
				searchText4.setCellValue(actual3);

				outFile = new FileOutputStream(new File(Runner.filePath));
				workbook.write(outFile);
				inputFile.close();
				outFile.close();
				count = count + 1;
			}
			mitaWebWritePass();
		} catch (Exception e) {
//			System.err.format("No Element Found to perform entering the values \t" + e);
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the brokenLinks method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR,
					"Unable to execute the brokenLinks method \t" + e.getMessage());
		}
	}

	public static void mitaWebGetCurrentUrl(String expected) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue);

			actual = driver.getCurrentUrl();
			System.out.println(actual);
			if (actual.contains(expected)) {
				mitaWebWritePass();
			} else {
				actual = expected + " missing";
				mitaWebScreenShot();
				mitaWebWriteFail();
			}
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the getCurrentUrl method \t" + e.getMessage());
		}
	}

	public static void mitaWebConsoleLogs() throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue);
			ArrayList<String> ar = new ArrayList<String>();
			String log = null;
			LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
			List<LogEntry> logs = entry.getAll();
			for (LogEntry L : logs) {
				log = L.getMessage();
				System.out.println(L.getMessage());
				ar.add(log);
			}
			actual = log;
			mitaWebWritePass();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the consoleLogs method \t" + e.getMessage());
		}
	}
	
	
	public static void mitaWebListBox(String LocatorType, String LocatorValue, String value,String WaitType) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue);
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			element.click();
			
			List<WebElement> allLinks = driver.findElements(By.xpath("//li[@role='option']"));			
			for(int i=0;i<allLinks.size();i++)
	          {
//	            System.out.println(allLinks.get(i).getText());
	            if(allLinks.get(i).getText().equalsIgnoreCase(value))
	            {
	            	allLinks.get(i).click();
	                break;
	            }
	          }		
			mitaWebWritePass();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the listbox method \t" + e.getMessage());
		}
	}
}
