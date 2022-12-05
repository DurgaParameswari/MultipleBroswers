package com.meda.automation.managers;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static String reportBaseDirectory;
	private static ExtentReports extent;
	public static final String OUTPUT_FOLDER_SCREENSHOTS = "/Screenshots/";
	public static final String REPORT_FILE_PATH = System.getProperty("user.dir") + "/Automation_Reports/";

	static String ts = timeStamp();

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static void createInstance() {
		ExtentManager.initDirectories();
		setReportBaseDirectory(REPORT_FILE_PATH);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				REPORT_FILE_PATH + "Test-Automaton-Report_" + ts + ".html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("$('.brand-logo').text('Automation');");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java", System.getProperty("java.specification.version"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
	}

	public synchronized static String getReportBaseDirectory() {
		return reportBaseDirectory;
	}

	public synchronized static void setReportBaseDirectory(String reportBaseDirectory) {
		ExtentManager.reportBaseDirectory = reportBaseDirectory;
	}

	public static void initDirectories() {
		try {
			createFolder(REPORT_FILE_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createFolder(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists())
			file.mkdirs();
	}

	// Get the time stamp
	public static String timeStamp() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HH-mm-ss");
//		System.out.println(formatter.format(ts));
		return formatter.format(ts);
	}

}
