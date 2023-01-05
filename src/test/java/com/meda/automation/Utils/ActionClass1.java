package com.meda.automation.Utils;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.meda.automation.base.BaseClass;
import com.meda.automation.managers.ExtentTestManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class ActionClass1 extends BaseClass {

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

	// Web Methods

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

	public static void mita_Web_ScreenShot() {
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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

	public static void mita_Web_writePass() throws IOException {
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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

	public static void mita_Web_writeFail() throws IOException {
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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

	public static void mita_Web_write_when_Locator_isnotvalid() throws IOException {
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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

	public static void mita_Web_Please_do_Spellcheck() throws IOException {
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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
					mita_Web_ScreenShot();
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

	public static void mita_JSHighlight(WebElement ele) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid yellow;');", ele);
		}
	}

	public static By mita_locator(String locatorType, String LocatorValue) {
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

	public static void mita_Wait(String WaitType) throws Exception {
		switch (WaitType) {
		case "visibilityOf":
			mita_visibilityOf();
			break;

		case "visibilityOfAllElements":
			mita_visibilityOfAllElements();
			break;

		case "elementToBeClickable":
			mita_elementToBeClickable();
			break;

		case "elementToBeSelected":
			mita_elementToBeSelected();
			break;

		case "invisibilityOf":
			mita_invisibilityOf();

		default:
			System.out.println(WaitType + " is invalid");
		}
	}

	public static void mita_visibilityOf() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				element = wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (Exception e) {
			logger.warn("Unable to execute the visibilityOf method \t" + e.getMessage());
		}
	}

	public static void mita_visibilityOfAllElements() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
			}
		} catch (Exception e) {
			logger.warn("Unable to execute the visibilityOfAllElements method \t" + e.getMessage());
		}
	}

	public static void mita_elementToBeClickable() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		} catch (Exception e) {
			logger.warn("Unable to execute the elementtobeClickable method \t" + e.getMessage());
		}
	}

	public static void mita_elementToBeSelected() throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}
		} catch (Exception e) {
			logger.warn("Unable to execute the elementToBeSelected method \t" + e.getMessage());
		}
	}

	public static void mita_invisibilityOf() throws Exception {
		try {
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			if (by != null) {
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
		} catch (Exception e) {
			logger.warn("Unable to execute the invisibilityOf method \t" + e.getMessage());
		}
	}

	public static void mita_EnterTextField(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mita_locator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mita_JSHighlight(element);
			mita_Wait(WaitType);
			element.clear();
			element.sendKeys(value);
			// Thread.sleep(500);
			mitaWebWrite();
		} catch (Exception e) {
			mita_Web_write_when_Locator_isnotvalid();
			logger.warn("Unable to execute the EnterTextField method \t" + e.getMessage());
		}
	}

	public static void Machint_WebElemenDisplay(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");
			try {
				if (element.isDisplayed())
					locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				element.clear();
				element.sendKeys(value);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class=\"btn btn-primary text-uppercase btn-submit\"])[2]")).click();
				mitaWebWrite();
			} catch (Exception e) {
				mitaWebWrite();
			}
		} catch (Exception e) {
			mita_Web_write_when_Locator_isnotvalid();
			logger.warn("Unable to execute the Machint_WebElemenDisplay method \t" + e.getMessage());
		}
	}
	
	public static void mita_EnterTextKey(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");
			locator = mita_locator(LocatorType, LocatorValue);
			element = driver.findElement(locator);
			mita_JSHighlight(element);
			mita_Wait(WaitType);
			element.click();
			element.sendKeys(value);
			Thread.sleep(500);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			mitaWebWrite();
		} catch (Exception e) {
			mita_Web_write_when_Locator_isnotvalid();
			logger.warn("Unable to execute the EnterTextKey method \t" + e.getMessage());
		}
	}
	
	public static void sendChar(WebElement element, String value) throws InterruptedException {
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(500);
			element.sendKeys(s);
		}
	}
	
	// Enter the char by char
		public static void Machint_Web_EnterCharacter(String LocatorType, String LocatorValue, String value,
				String WaitType) throws Exception {
			try {
				logger.info("Executing - EnterCharacter method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
				element.clear();
				sendChar(element, value);
				mitaWebWrite();
			} catch (Exception e) {
				System.err.format("No Element Found to perform get the lead \t" + e);
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to set the value \t" + e.getMessage());
			}
		}

		public static void mita_Click(String LocatorType, String LocatorValue, String WaitType) throws Exception {
			try {
				logger.info("Executing - Click method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
				element.click();
				ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue);
				mitaWebWrite();
			} catch (Exception e) {
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the click method \t" + e.getMessage());
				ExtentTestManager.getTest().log(Status.ERROR, "Unable to execute the click method \t" + e.getMessage());
			}
		}
		
		public static void mita_selectVisibleText(String LocatorType, String LocatorValue, String text, String WaitType)
				throws Exception {
			try {
				logger.info("Executing - selectVisibletext method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
				select = new Select(element);
				select.selectByVisibleText(text);
				mitaWebWrite();
			} catch (Exception e) {
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the selectVisibletext method \t" + e.getMessage());
			}
		}
		
		public static void mita_AutoSuggestion_Dropdown(String LocatorType, String LocatorValue, String value,
				String WaitType) throws Exception {
			try {
				logger.info("Executing - AutoSuggestion_Dropdown method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				element.click();
				mita_Wait(WaitType);
				element.sendKeys(value);
				Thread.sleep(1000);
				Actions act = new Actions(driver);
				act.sendKeys(Keys.ENTER).perform();
				mitaWebWrite();
			} catch (Exception e) {
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the Auto Suggestion dropdown method \t" + e.getMessage());
			}
		}
		
		public static void mita_selectIndex(String LocatorType, String LocatorValue, int value, String WaitType)
				throws Exception {
			try {
				logger.info("Executing - selectIndex method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
				select = new Select(element);
				select.selectByIndex(value);
				mitaWebWrite();
			} catch (Exception e) {
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the selectIndex method \t" + e.getMessage());
			}
		}
		
		public static void mita_scenarioNumber(String name) throws IOException {
			try {
//				logger.info("Executing - scenarioNumber method");
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
		
		public static void machintWeb_Mobile_Number_OTP(String LocatorType, String LocatorValue, String value,
				String WaitType) throws Exception {
			try {
				logger.info("Executing - Mobile number OTP method");
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
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
				mita_Web_write_when_Locator_isnotvalid();
				System.err.format("No Element Found to handling the OTP \t" + e);
				logger.warn("Unable to execute handling otp method \t" + e.getMessage());
			}
		}
		
		public static String generateAadharNumber(int length) {
			String chars = "0123456789";
			String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
					.collect(Collectors.joining());
			System.out.println(str);
			return str;
		}
		
		// Generate the Random Aadhar number
		public static void Machint_Web_generateRandomNumber(String LocatorType, String LocatorValue, String value,
				String WaitType) throws Exception {
			try {
				logger.info("Executing - Mobile generateRandomNumber method");
				int number = Integer.parseInt(value);
				String randomNumber = generateAadharNumber(number);
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				mita_JSHighlight(element);
				mita_Wait(WaitType);
				element.clear();
				Thread.sleep(1000);
				element.sendKeys(randomNumber);
				// Thread.sleep(2000);
				mitaWebWrite();
			} catch (Exception e) {
				System.err.format("No Element Found to perform ngvt_Click \t" + e);
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the generaterandomnumber method \t" + e.getMessage());
			}
		}
		
		public static String generateNumber(int length) {
			String chars = "0123456789";
			String str = new Random().ints(length, 0, chars.length()).mapToObj(i -> "" + chars.charAt(i))
					.collect(Collectors.joining());
			int number1 = Integer.parseInt(str);
			System.out.println(str);
			String str1 = String.format("%010d", number1);
			System.out.println(str1);
			return str1;
		}

		// Generate the Mobile number starts with zero
		public static void Machint_zeroStartsNumber(String LocatorType, String LocatorValue, String value, String WaitType)
				throws Exception {
			try {
				logger.info("Executing - zeroStartsNumber method");

				int number = Integer.parseInt(value);
				String randomNumber = generateNumber(number);
				locator = mita_locator(LocatorType, LocatorValue);
				element = driver.findElement(locator);
				// Machint_JSHighlight(element);
				mita_Wait(WaitType);
				element.clear();
				Thread.sleep(1000);
				element.sendKeys(randomNumber);
				// Thread.sleep(2000);
				mitaWebWrite();
			} catch (Exception e) {
				mita_Web_write_when_Locator_isnotvalid();
				logger.warn("Unable to execute the Machint_zeroStartsNumber method \t" + e.getMessage());
			}
		}
}
