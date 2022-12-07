package com.meda.automation.managers;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportFactory {
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports reporter;

	public static synchronized ExtentReports getReporter() {
		String fileName = "src/test/resources/extent_config.xml";
		File file = new File(fileName);
		if (reporter == null) {
			htmlReporter = new ExtentHtmlReporter("Report/report.html");
			htmlReporter.loadXMLConfig(fileName);
			reporter = new ExtentReports();
			reporter.attachReporter(htmlReporter);
			reporter.setSystemInfo("Author", "MST QA Automation");
			reporter.setSystemInfo("User Name", "Automation");
			reporter.setSystemInfo("Environment", "QA");
			reporter.setSystemInfo("Selenium Version", "3.4.0");
		}
		return reporter;

	}
}