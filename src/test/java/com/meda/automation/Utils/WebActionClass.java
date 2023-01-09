package com.meda.automation.Utils;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.meda.automation.base.BaseClass;
import com.meda.automation.managers.ExtentTestManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class WebActionClass extends BaseClass {

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

	static Logger logger = Logger.getLogger(WebActionClass.class);

	public static String mitaGetCurrentTime() {
		timeStamp = DateTime.now().toString("yyyy-MM-dd--hh-mm-ss");
		return timeStamp;
	}

	public static void mitaCleanTheResults() throws IOException {
		try {
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			Cell actualValue, result;
			int rowCount = getRowCount();
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the CleanResults method \t" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the CleanResults method \t" + e.getMessage());
		}
	}
	
	public static void mitaWebPleasedoSpellcheck() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Please do spell check");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
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
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
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

	public static void mitaWebScreenShot() {
		try {
			logger.info("Executing - Taking ScreenShot method");
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
		} catch (Exception e) {
			logger.warn("Unable to take the Web Screenshot \t" + e.getMessage());
		}
	}

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
			logger.warn("Unable to execute the invisibilityOf method \t" + e.getMessage());
		}
	}

	public static void mitaWebWriteWhenLocatorIsNotValid() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("Locator is not valid");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
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
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					driver.quit();
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextField method \t" + e.getMessage());
		}
	}

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
			logger.warn("Unable to execute the Machint_WebElemenDisplay method \t" + e.getMessage());
		}
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextKey method \t" + e.getMessage());
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

	// Enter the char by char
	public static void mitaWebEnterCharacter(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectVisibletext method \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Auto Suggestion dropdown method \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectIndex method \t" + e.getMessage());
		}
	}

	public static void mitaScenarioNumber(String name) throws IOException {
		try {
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIME.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
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
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
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
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue(name);
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					inputFile.close();
					outFile.close();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the scenarionumber method \t" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the scenarionumber method \t" + e.getMessage());
		}
	}

	public static void mitaWebMobileNumberOTP(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
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
			logger.warn("Unable to execute handling otp method \t" + e.getMessage());
		}
	}

	public static String mitaGenerateAadharNumber(int length) {
		String chars = "0123456789";
		String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
				.collect(Collectors.joining());
		System.out.println(str);
		return str;
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

	// Generate the Mobile number starts with zero
	public static void mitaWebZeroStartsNumber(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - zeroStartsNumber method");
			int number = Integer.parseInt(value);
			String randomNumber = mitaGenerateNumber(number);
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Machint_zeroStartsNumber method \t" + e.getMessage());
		}
	}

	public static String mitaDynamicString(int value) {
		randomString = RandomStringUtils.randomAlphabetic(value);
		System.out.println(randomString);
		return randomString;
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the WebDynamicString method \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the WebAppendText method \t" + e.getMessage());
		}
	}

	public static void mitaWebUploadSendkeys(String LocatorType, String LocatorValue, String value) throws Exception {
		try {
			logger.info("Executing - uploadSendKEys method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			Thread.sleep(1000);
			element.sendKeys(value);
			mitaWebWrite();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the setSecondValue method \t" + e.getMessage());
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
			mitaWebWriteWhenLocatorIsNotValid();
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the setSecondValue method \t" + e.getMessage());
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

	public static void mitaWebEqualsValidation(String LocatorType, String LocatorValue, String expected)
			throws IOException {
		try {
			logger.info("Executing - EqualsValidation method");
			locator = mitaWebLocator(LocatorType, LocatorValue);
			actual = driver.findElement(locator).getText();
			if (actual.equalsIgnoreCase(expected)) {
//					mita_JSHighlight(element);
				mitaWebScreenShot();
				mitaWebWritePass();
				ExtentTestManager.getTest().log(Status.PASS, actual + " " + expected + " Correct ");
			} else {
//					mita_JSHighlight_for_validation(element);
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to handle the Frames \t" + e.getMessage());
		}
	}

	public static void mitaWebScrollDown(String LocatorType, String LocatorValue)
			throws IOException, InterruptedException {
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EnterTextKey method \t" + e.getMessage());
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
		}
	}

	public static void mitaWebGetTheLeadID(String LocatorType, String LocatorValue, String WaitType) throws Exception {
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}

	// Set the Lead id
	public static void mitaWebSetTheLeadID(String LocatorType, String LocatorValue, String WaitType) throws Exception {
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
		}
	}

	public static void mitaWebMouseOver(String LocatorValue) throws Exception {
		try {
			logger.info("Executing - mouseOver method");
			action = new Actions(driver);
			element = driver.findElement(By.xpath(LocatorValue));
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the mousehower method \t" + e.getMessage());
		}
	}

	// Set the Lead id
	public static void mitaWebSetTheOTP(String LocatorType, String LocatorValue, String WaitType) throws Exception {
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to set the value \t" + e.getMessage());
		}
	}

	public static void mitaWebDefaultFrame() {
		try {
			logger.info("Executing - defaultFrame method");
			driver.switchTo().defaultContent();
			mitaWebWrite();
		} catch (Exception e) {
			logger.warn("Unable to execute the default Frame method \t" + e.getMessage());
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
			logger.warn("Unable to execute the response method \t" + e.getMessage());
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
				t++;
			}
			for (String clicks : texts) {
				driver.get(clicks);
				List<WebElement> allTags = driver.findElements(By.tagName(value));
				int tagCount = allTags.size();
				System.out.println("Total no of " + value + " are : " + tagCount);
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
			mitaWebWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the heading tags method \t" + e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR,
					"Unable to execute the heading tags method \t" + e.getMessage());
		}
	}

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
					failCount = failCount + 1;
				} else {
					System.out.println("Total no of og:image Available: " + imgsCount);
					actual2 = "Total no of og:image Available: " + imgsCount;
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
				count = count + 1;
			}
			mitaWebWritePass();
		} catch (Exception e) {
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

	public static void mitaWebListBox(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue);
			locator = mitaWebLocator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mitaWebWait(WaitType);
			element.click();
			List<WebElement> allLinks = driver.findElements(By.xpath("//li[@role='option']"));
			for (int i = 0; i < allLinks.size(); i++) {
				if (allLinks.get(i).getText().equalsIgnoreCase(value)) {
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
	
	// Dependent method for addDates().............
		public static Date mitaAddDays(Date dateToAdd, int numberOfDay) {
			if (dateToAdd == null)
				throw new IllegalArgumentException("Date can't be null!");
			Calendar tempCal = Calendar.getInstance();
			tempCal.setTime(dateToAdd);
			tempCal.add(Calendar.DATE, numberOfDay);
			return tempCal.getTime();
		}

		// Dependent method for addDates().............
		public static Date mitaOffsetForWeekend(Date baseCal) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(baseCal);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				return mitaAddDays(baseCal, 2);
			} else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				return mitaAddDays(baseCal, 1);
			} else
				return baseCal;
		}
}
