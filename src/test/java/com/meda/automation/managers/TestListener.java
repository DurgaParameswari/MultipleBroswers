package com.meda.automation.managers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.meda.automation.Utils.ActionClass;

public class TestListener extends ActionClass implements ITestListener {
	private static long endTime;

	private static void setStartTime(long startTime) {
	}

	private static void setEndTime(long endTime) {
		TestListener.endTime = endTime;
	}

	@Override
	public synchronized void onStart(ITestContext context) {
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		setStartTime(context.getStartDate().getTime());
		setEndTime(context.getEndDate().getTime());
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("--------- Executing :- " + getSimpleMethodName(result) + " ---------");
		ExtentTestManager.createTest(result.getName(), result.getMethod().getDescription());
		ExtentTestManager.setCategoryName(getSimpleClassName(result));
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
		addExtentLabelToTest(result);
		ExtentTestManager.endTest();
	}

	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
		ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" + result.getThrowable());
		try {
			ExtentTestManager.getTest().fail("<br><font color= red>" + "Screenshot of Web" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot(getSimpleMethodName(result)))
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		addExtentLabelToTest(result);
		ExtentTestManager.endTest();

	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" + result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	private synchronized String getSimpleClassName(ITestResult result) {
		return result.getMethod().getRealClass().getSimpleName();
	}

	private synchronized String getSimpleMethodName(ITestResult result) {
		return result.getName();
	}

	private synchronized void addExtentLabelToTest(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
		else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		} else
			ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
	}
	
	private static synchronized String takeScreenshot(String methodName) {
        DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        String dateName = dateFormat.format(date);
        String filePathExtent = ExtentManager.OUTPUT_FOLDER_SCREENSHOTS + "extent_"+ sheetNames + "_" + dateName + ".png";
        String filePath = ExtentManager.getReportBaseDirectory() + filePathExtent;
        String scrBase64 = null;
        try {
        	// Take a ScreenShot
    		scrBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    		// convert the BASE64 to File type
    		File file = OutputType.FILE.convertFromBase64Png(scrBase64);
    		// store the converted file as Image on D driver
    		FileUtils.copyFile(file, new File(filePath), true);
        	
        }catch (IOException e){
            e.getStackTrace();
            Reporter.log("Failed To Take screenshot " + e, true);
        }
        return scrBase64;
    }

}
