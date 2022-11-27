package com.meda.automation.Utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.meda.automation.base.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ext extends BaseClass
{	
		protected ExtentTest test;
		ExtentReports report;
		@BeforeClass
		public void startTest()
		{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("Ext");
		}

		/*
		 * @Test public void extentReportsDemo() {
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\SubmittalExchange_TFS\\QA\\Automation\\3rdparty\\chrome\\chromedriver.exe"
		 * ); WebDriver driver = new ChromeDriver();
		 * driver.get("https://www.google.co.in");
		 * if(driver.getTitle().equals("Google")) { test.log(LogStatus.PASS,
		 * "Navigated to the specified URL"); } else { test.log(LogStatus.FAIL,
		 * "Test Failed"); } }
		 */
		@AfterClass
		public void endTest()
		{
		report.endTest(test);
		report.flush();
		}
		}


