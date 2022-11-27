package com.meda.automation.base;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentDemo {
protected static ExtentTest test;
static ExtentReports report;


@BeforeClass
public static void startTest()
{
report = new ExtentReports(System.getProperty("D:\\WorkspaceD\\AutomationFramework\\EReorts")+"\\ExtentReportResults.html");
test = report.startTest("ExtentDemo");
}

/*
 * @Test public void extentReportsDemo() {
 * System.setProperty("webdriver.chrome.driver",
 * "D:\\SubmittalExchange_TFS\\QA\\Automation\\3rdparty\\chrome\\chromedriver.exe"
 * ); WebDriver driver = new ChromeDriver();
 * driver.get("https://www.google.co.in");
 * if(driver.getTitle().equals("Google")) { test.log(LogStatus.PASS,
 * "Navigated to the specified URL"); } else { test.log(LogStatus.FAIL,
 * "Test Failed"); }
 
}*/
@AfterClass
public static void endTest()
{
	
report.endTest(test);
report.flush();
}
}