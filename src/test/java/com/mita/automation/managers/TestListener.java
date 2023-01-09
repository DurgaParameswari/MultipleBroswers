package com.mita.automation.managers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.mita.automation.base.BaseClass;

public class TestListener extends BaseClass implements ITestListener 
{
	
	public void onStart(ITestContext context) 
	{
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context)
	{
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
	
	/*
	 * @Override public void onTestFailure(ITestResult result) {
	 * System.out.println("***** Error "+result.getName()+" test has failed *****");
	 * String methodName=result.getName().toString().trim(); ITestContext context =
	 * result.getTestContext(); WebDriver driver =
	 * (WebDriver)context.getAttribute("driver"); takeScreenShot(methodName,
	 * driver); }
	 * 
	 * public void takeScreenShot(String methodName, WebDriver driver) { File
	 * scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //The
	 * below method will save the screen shot in d drive with test method name try {
	 * FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
	 * System.out.println("***Placed screen shot in "+filePath+" ***"); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */
		
		  public void onTestFailure(ITestResult result) 
		  {
			  System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
				 ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
				 try
				 {
					  TakesScreenshot screenshot=(TakesScreenshot)driver;
					  File src=screenshot.getScreenshotAs(OutputType.FILE);
					  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
					//  String test="veeru";
					//  FileUtils.copyFile(src, new File("\\RamRithvik\\"+result.getName()+timestamp+".png"));
					  FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\ScreenShotCucumber\\"+result.getName()+timestamp+".png"));
					  System.out.println("Successfully captured a screenshot");
				 }
				 catch (Exception e)
				 {
					 System.out.println("Exception while taking screenshot "+e.getMessage());
				 }
		  }
		 
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}