package com.mita.automation.Utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;

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
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class MobileActionClass extends WebActionClass {
	
	static Logger logger = Logger.getLogger(MobileActionClass.class);

	public static void mitaMobileWrite() throws IOException {
		try {
			logger.info(Driver_Script.Actionvalue + ": Updating the result in excel");
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			try {
				if (Runner.browserType.equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
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
				if (Runner.browserType.equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
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
				if (Runner.browserType.equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
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

	public static void mitaMobileWriteWhenLocatorIsNotValid() throws IOException {
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
					inputFile.close();
					outFile.close();
					k = lastRow + 1;
					i = lastRow + 1;
					mobiledriver.quit();
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
			try {
				if (Runner.browserType.equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(k).createCell(4);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(MobileActionClass.actual);
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
				if (Runner.browserType.equalsIgnoreCase("Firefox")) {
					Cell searchText2 = sheet.getRow(k).createCell(5);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(MobileActionClass.actual);
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
				if (Runner.browserType.equalsIgnoreCase("Edge")) {
					Cell searchText2 = sheet.getRow(k).createCell(6);
					searchText2.setCellValue("PASS");
					searchText2.setCellStyle(style);
					Cell ActualValue = sheet.getRow(k).createCell(3);
					ActualValue.setCellValue(MobileActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
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

	public static void mitaMobileWriteFail() throws IOException {
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
					ActualValue.setCellValue(MobileActionClass.actual);
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
					ActualValue.setCellValue(MobileActionClass.actual);
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
					ActualValue.setCellValue(MobileActionClass.actual);
					outFile = new FileOutputStream(new File(Runner.filePath));
					workbook.write(outFile);
					mitaMobileScreenShot();
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

	public static void mitaExecutionType(String name) throws IOException {
		try {
			inputFile = new FileInputStream(new File(Runner.filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
			sheet = workbook.getSheet(sheetNames[j]);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIME.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					Cell searchText2 = sheet.getRow(i).createCell(4);
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
					Cell searchText2 = sheet.getRow(i).createCell(5);
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
					Cell searchText2 = sheet.getRow(i).createCell(6);
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
			logger.warn("Unable to execute the " + Driver_Script.type + "script " + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the " + Driver_Script.type + "script " + e.getMessage());
		}
	}

	public static void mitaMobilePleaseDoSpellcheck() throws IOException {
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
		}
		catch (FileNotFoundException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn(Driver_Script.Actionvalue + ": Unable to update the result in excel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void mitaMobileScreenShot() {
		try {
			logger.info("Executing - Taking ScreenShot method");
			TakesScreenshot screenshot = (TakesScreenshot) mobiledriver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			System.out.println("Step Name is : " + Driver_Script.Actionvalue);
//			FileUtils.copyFile(src, new File(Runner.mobileScreenshotPath + "\\ScreenShots\\Mobile\\" + Driver_Script.sheetName
//					+ "_" + timestamp + "_" + Driver_Script.Actionvalue + ".png"));
//			
			FileUtils.copyFile(src,
					new File(Runner.webScreenshotPath + "\\ScreenShots\\Mobile\\"+ timeStamp + "\\"
							+ Driver_Script.sheetName + "_" + timestamp + "_" + Driver_Script.Actionvalue
							+ ".png"));
		} catch (Exception e) {
			logger.warn("Unable to take the Mobile Screenshot \t");
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

	// Different Explicit waits function
	public static void mitaMobileWaits(String WaitType) throws Exception {
		switch (WaitType) {
		case "visibilityOf":
			mitaMobileVisibilityOf();
			break;

		case "visibilityOfAllElements":
			mitaMobileVisibilityOfAllElements();
			break;

		case "elementToBeClickable":
			mitaMobileElementToBeClickable();
			break;

		case "elementToBeSelected":
			mitaMobileElementToBeSelected();
			break;

		case "elementSelectionStateToBe":
			mitaMobileElementSelectionStateToBe();
			break;

		case "frameToBeAvailableAndSwitchToIt":
			mitaMobileFrameToBeAvailableAndSwitchToIt();
			break;

		case "invisibilityOf":
			mitaMobileInVisibilityOf();
			break;

		case "invisibilityOfAllElements":
			mitaMobileInVisibilityOfAllElements();
			break;

		default:
			System.out.println(WaitType + " is invalid");
		}
	}

	public static void mitaMobileVisibilityOf() {
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

	public static void mitaMobileVisibilityOfAllElements() {
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

	public static void mitaMobileElementToBeClickable() throws IOException {
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

	public static void mitaMobileElementSelectionStateToBe() throws IOException {
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

	public static void mitaMobileElementToBeSelected() throws IOException {
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

	public static void mitaMobileFrameToBeAvailableAndSwitchToIt() {
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

	public static void mitaMobileInVisibilityOf() {
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

	public static void mitaMobileInVisibilityOfAllElements() {
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
	public static void mitaMobileJSHighlight(WebElement ele) {
		if (mobiledriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) mobiledriver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid yellow;');", ele);
		}
	}

	public static void mitaMobileJSHighlightForValidation(WebElement ele) {
		if (mobiledriver instanceof JavascriptExecutor) {
			((JavascriptExecutor) mobiledriver).executeScript(
					"arguments[0].setAttribute('style', 'background: skyblue; border: 2px solid red;');", ele);
		}
	}

	// Enter text without Keys.ENTER function
	public static void mitaMobileEnterTextField(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Entertextfield method \t" + e.getMessage());
		}
	}

	// Enter text using Keys.ENTER function
	public static void mitaMobileEnterTextKey(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextKey method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
//			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			element.sendKeys(value);
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Entertextkey method \t" + e.getMessage());
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
			mitaMobileWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Click method \t" + e.getMessage());
		}
	}

	// Select by Value function in drop-down
	public static void mitaMobileSelectValue(String LocatorType, String LocatorValue, String text, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - selectValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.selectByValue(text);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
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
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.selectByIndex(value);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectIndex method \t" + e.getMessage());
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
				mitaMobileWrite();
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
	public static boolean mitaMobileDismissAlert() throws IOException, InterruptedException {
		boolean boolFound = false;
		try {
			logger.info("Executing - dismissAlert method");
			wait = new WebDriverWait(mobiledriver, Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = mobiledriver.switchTo().alert();
			if (alert != null) {
				alert.dismiss();
				boolFound = true;
				mitaMobileWrite();
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the dismissAlert method \t" + e.getMessage());
		}
		return boolFound;

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
			logger.warn("Unable to execute the Clock method \t" + e.getMessage());
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
			mitaMobileWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the GetFirstValue method \t" + e.getMessage());
		}
	}

	// Set the first value from mobile
	public static void mitaMobileSetTheFirstValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SetTheFirstValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value1);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the SetFirstValue method \t" + e.getMessage());
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
			mitaMobileWrite();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the GetSecondValue method \t" + e.getMessage());
		}
	}

	// Set the first value from mobile
	public static void mitaMobileSetTheSecondValue(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - SetTheSecondValue method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			element.clear();
			element.sendKeys(value2);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the SetSecondValue method \t" + e.getMessage());
		}
	}

	public static void mitaMobileEqualsValidation(String LocatorType, String LocatorValue, String expected)
			throws IOException {
		try {
			logger.info("Executing - EqualsValidation method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			actual = mobiledriver.findElement(locator).getText();
//			Assert.assertEquals(actual, expected);
			if (actual.equalsIgnoreCase(expected)) {
				//mitaMobileJSHighlight(element);
				mitaMobileWritePass();
			} else {
//				mitaMobileJSHighlightForValidation(element);
				mitaMobileScreenShot();
				mitaMobileWriteFail();
			}
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the EqualsValidation method \t" + e.getMessage());
		}
	}

	// Title verification function
	public static void mitaMobileGetTitle(String Expected) throws IOException, InterruptedException {
		try {
			logger.info("Executing - getTitle method");
			String Title = mobiledriver.getTitle();
			Assert.assertEquals(Title, Expected);
			mitaMobileWrite();
		} catch (Exception e) {
			logger.warn("Unable to execute the getTitle method \t" + e.getMessage());
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
			logger.warn("Unable to execute the ScrollintoView method \t" + e.getMessage());
		}
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
				mitaMobileWrite();
			}
		} catch (Exception e) {
			boolFound = false;
			e.printStackTrace();
			logger.warn("Unable to execute the getAlertText method \t" + e.getMessage());
		}
		return boolFound;
	}

	public static void mitaMobileProgressBarWait(String locatorType, String locatorValue, String waitType)
			throws Exception {
		try {
			logger.info("Executing - ProgressBar method");
			locator = mitaMobilelocator(locatorType, locatorValue);
			element = mobiledriver.findElement(locator);
			// Thread.sleep(20000);
			mitaMobileWaits(waitType);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Progressbar method \t" + e.getMessage());
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
			mitaMobileWaits(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the generaterandomnumber method \t" + e.getMessage());
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
			mitaMobileWaits(WaitType);
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(randomNumber);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the zeroStartsNumber method \t" + e.getMessage());
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
			date = mitaAddDays(returnDate, number);
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
			logger.warn("Unable to execute the MobileAddDates method \t" + e.getMessage());
		}
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
			logger.warn("Unable to execute the MobileDynamicString method \t" + e.getMessage());
		}
	}

	public static void mitaMobileAppendText(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - EnterTextField method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			element.clear();
			value = mitaDynamicString(5) + value;
			element.sendKeys(value);
			// Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the MobileAppendText method \t" + e.getMessage());
		}
	}

	public static void mitaMobileNumberOTP(String LocatorType, String LocatorValue, String value, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - Mobile number OTP method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
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
			logger.warn("Unable to handling the OTP method \t" + e.getMessage());
		}
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
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the ScrollUp method \t" + e.getMessage());
		}
	}

	public static void mitaMobileScrollDown(String text) throws IOException, InterruptedException {
		try {
			logger.info("Executing - ScrollDown method");
			AndroidElement element = ((FindsByAndroidUIAutomator<AndroidElement>) mobiledriver)
					.findElementByAndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
									+ text + "\").instance(0))");
			element.isDisplayed();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the ScrollintoView method \t" + e.getMessage());
		}
	}

	public static void mitaMobileSingleTap(String LocatorType, String LocatorValue, String WaitType) throws Exception {
		try {
			logger.info("Executing - SingleTap method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			AndroidElement element = mobiledriver.findElement(locator);
			new TouchAction((PerformsTouchActions) mobiledriver).tap(tapOptions().withElement(element(element)))
					.waitAction(waitOptions(Duration.ofMillis(250))).perform();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Singletap method \t" + e.getMessage());
		}
	}

	public static void mitaMobileDoubleTap(String LocatorType, String LocatorValue, String WaitType) throws Exception {
		try {
			logger.info("Executing - DoubleTap method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			AndroidElement Element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			TouchAction press = new TouchAction((PerformsTouchActions) mobiledriver).press(element(Element))
					.waitAction(waitOptions(Duration.ofSeconds(1))).release();

			new MultiTouchAction((PerformsTouchActions) mobiledriver).add(press).perform();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the doubleTap method \t" + e.getMessage());
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
		} catch (Exception e1) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the Sign method \t" + e1.getMessage());
		}
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
			// Get vertical location of seekbar.
			int startY = seekBar.getLocation().getY();
			// Get end point of seekbar.
			int endX = (startX + seekBar.getSize().getWidth());
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
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the seekbar method \t" + e.getMessage());
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
			logger.warn("Unable to execute the handlingFrame method \t" + e.getMessage());
		}
	}

	public static void mitaMobileWaitTime(long sleepTime) throws Exception {
		try {
			logger.info("Executing - Wait method");
			Thread.sleep(sleepTime);
			mitaMobileWrite();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.warn("Unable to execute the Wait method \t" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
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
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to get the value \t" + e.getMessage());
		}
	}

	// Frame exit function
	public static void mitaMobileDefaultFrame() throws IOException {
		try {
			logger.info("Executing - defaultFrame method");
			driver.switchTo().defaultContent();
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the defaultFrame method \t" + e.getMessage());
		}
	}

	public Point mitaMobileGetPointOnCircle(int step, int totalSteps, Point origin, double radius) throws IOException {
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

	public void mitaMobileDrawCircle(Point origin, double radius, int steps) throws IOException {
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
			((RemoteWebDriver) mobiledriver).perform(Arrays.asList(circle));
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the DrawCircle method \t" + e.getMessage());
		}
	}

	// Right Click function
	public static void mitaMobileContextClick(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - Context click method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			action = new Actions(mobiledriver);
			action.contextClick(element).build().perform();
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the contextclick method \t" + e.getMessage());
		}
	}

	// Double Click function
	public static void mitaMobileDoubleClick(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - double click method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			action = new Actions(mobiledriver);
			action.moveToElement(element).doubleClick().build().perform();
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the doubleclick method \t" + e.getMessage());
		}
	}

	// Drag and Drop by function
	public static Boolean mitaMobileDragandDropby(String LocatorType, String LocatorValue, int x, int y)
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
	public static void mitaMobileClickAndHold(String LocatorType, String LocatorValue, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - ClickAndHold method");
			action = new Actions(mobiledriver);
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			action.clickAndHold(element).build().perform();
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			element.click();
			Thread.sleep(3000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the ClickAndHold method \t" + e.getMessage());
		}
	}

	// Select by VisibleText function in drop-down
	public static void mitaMobileSelectVisibleText(String LocatorType, String LocatorValue, String text,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - selectVisibleText method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			System.out.println(locator);
			element = mobiledriver.findElement(locator);
			System.out.println(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			System.out.println(select);
			select.selectByVisibleText(text);
			Thread.sleep(2000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the selectVisibletext method \t" + e.getMessage());
		}
	}

	// Get Drop-down function
	public static void mitaMobileGetDropdownOptions(String LocatorType, String LocatorValue, String text,
			String WaitType) throws Exception {
		try {
			logger.info("Executing - getdropdownOptions method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			List<WebElement> dropdownOptions = select.getOptions();
			System.out.println(dropdownOptions.size());
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the getdropdownOptions method \t" + e.getMessage());
		}
	}

	// Deselect all function in drop-down
	public static void mitaMobileDeselectAll(String LocatorType, String LocatorValue, String text, String WaitType)
			throws Exception {
		try {
			logger.info("Executing - deselectAll method");
			locator = mitaMobilelocator(LocatorType, LocatorValue);
			element = mobiledriver.findElement(locator);
			//mitaMobileJSHighlight(element);
			mitaMobileWaits(WaitType);
			select = new Select(element);
			select.deselectAll();
			Thread.sleep(1000);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the deselectAll method \t" + e.getMessage());
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
			Assert.assertEquals(actualValue, expectedValue);
			mitaMobileWrite();
		} catch (Exception e) {
			mitaMobileWriteWhenLocatorIsNotValid();
			logger.warn("Unable to execute the AssertEquals method \t" + e.getMessage());
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
				mitaMobileWrite();
			} catch (Exception e) {
				mitaMobileWriteWhenLocatorIsNotValid();
				logger.warn("Unable to execute the mouseHover method \t" + e.getMessage());
			}
		}
		
		// Frame Index function
		public static void mitaMobileFrameIndex(int index) throws IOException, InterruptedException {
			try {
				logger.info("Executing - FrameIndex method");
				mobiledriver.switchTo().frame(index);
				mitaMobileWrite();
			} catch (Exception e) {
				mitaMobileWriteWhenLocatorIsNotValid();
				logger.warn("Unable to execute the MobileFrameIndex method \t" + e.getMessage());
			}
		}
		
		// Frame Name or Id function
		public static void mitaFrameNameOrID(String nameOrId) throws IOException, InterruptedException {
			try {
				logger.info("Executing - Framename method");
				mobiledriver.switchTo().frame(nameOrId);
				mitaMobileWrite();
			} catch (Exception e) {
				mitaMobileWriteWhenLocatorIsNotValid();
				logger.warn("Unable to execute the FrameID method \t" + e.getMessage());
			}
		}
		
		// Parent frame to child frame move function
		public void mitaMobileSwitchToFrame(String ParentFrame, String ChildFrame) throws IOException {
			try {
				logger.info("Executing - switchToFrame method");
				mobiledriver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
				mitaMobileWrite();
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
		
		public static void mitaMobileGetTheLeadID1(String LocatorType, String LocatorValue, String WaitType)
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
				mitaMobileWriteWhenLocatorIsNotValid();
				logger.warn("Unable to get the value \t" + e.getMessage());
			}
		}
		
		
		
}
