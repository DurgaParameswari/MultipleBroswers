package com.meda.automation.managers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportGenerator {
	ExtentTest childTest;
	ExtentTest parentTest;
	private static ExtentReports reporter = ExtentReportFactory.getReporter();

	public void parentReport(String methodName, String author) {
		// creates a test case with the value of received parameter ‘methodName’
		parentTest = reporter.createTest(methodName);
		// assigns the author
		parentTest.assignAuthor(author);
		// assigns n the category
		parentTest.assignCategory("Demo Test cases");
	}

	public void childReport(String methodName) {
		// creates a test step for the test case with the value of received ‘methodName’
		// parameter
		childTest = parentTest.createNode(methodName);
		// logs the test step status as pass
		childTest.log(Status.PASS, methodName);
	}

	public void flush() {
		// flushes the report
		reporter.flush();
	}

	public void logScreenshot(WebDriver screenDriver, String testCaseName, String res, Exception e) throws IOException {
		try {
			// take the screen print of the screenDriver
			File file = ((TakesScreenshot) screenDriver).getScreenshotAs(OutputType.FILE);
			File dir = new File("Report/screenshot/" + testCaseName);
			// make the directory with the name mentioned above
			dir.mkdirs();
			String fileName = "Report/screenshot/" + testCaseName + "/" + testCaseName + ".jpg";
			// copy the screen print into the path mentioned above
			FileUtils.copyFile(file, new File(fileName));
			// creates a new test step
			ExtentTest logger = this.childTest;
			// logs the test step status as fail with the exception as the description
			logger.fail(e);
			// logs the screen print taken
			logger.info("Attachedscreenshot")
					.addScreenCaptureFromPath("screenshot/" + testCaseName + "/" + testCaseName + ".jpg");
		} catch (Exception ex) {
			System.out.println("Exceptionwhiletakingscreenshot: " + ex);
		}
	}

	public void logSkipTest(WebDriver screenDriver, String testCaseName, String res) throws IOException {
		File file = ((TakesScreenshot) screenDriver).getScreenshotAs(OutputType.FILE);
		File dir = new File("Report/screenshot/" + testCaseName);
		dir.mkdirs();
		String fileName = "Report/screenshot/" + testCaseName + "/" + testCaseName + ".jpg";
		FileUtils.copyFile(file, new File(fileName));
		ExtentTest logger = this.childTest;
		// logs the test step status as skip and attaches the screenshot taken
		logger.skip("Attachedscreenshot")
				.addScreenCaptureFromPath("screenshot/" + testCaseName + "/" + testCaseName + ".jpg");
	}
}
