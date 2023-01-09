package com.mavenpackage;

import org.testng.TestNG;
import com.mita.automation.managers.TestListener;

public class Runner {
	static TestNG testNg;

	public static String filePath;
	public static String sheetNames;
	public static String logPath;
	public static String browserType;
	public static String executionType;
	public static String driverurl;
	public static String webScreenshotPath;
	public static String apkPath;
	public static String deviceType;
	public static String deviceName;
	public static String apkPackageName;
	public static String mobileScreenshotPath;

	public static class runner {
		static TestNG testNg;

		public static void main(String[] args) {

//				Runner runner = new Runner();

			// Common Arguments
			filePath = args[0];
			System.out.println("TestCases Path: " + filePath);
			sheetNames = args[1];
			System.out.println("Sheet Names are :" + sheetNames);
			logPath = args[2];
			System.out.println("Log file path is : " + logPath);
//			logFile();

			// Web Arguments
			browserType = args[3];
			System.out.println("Browser Type : " + browserType);
			executionType = args[4];
			System.out.println("Execution Type : " + executionType);
			driverurl = args[5];
			System.out.println("URL is: " + driverurl);
			webScreenshotPath = args[6];
			System.out.println("Web ScreenShots Path: " + webScreenshotPath);

			// Mobile Arguments
			apkPath = args[7];
			System.out.println("ApkPath is: " + apkPath);
			deviceType = args[8];
			System.out.println("Mobile DeviceType: " + deviceType);
			deviceName = args[9];
			System.out.println("Mobile DeviceName: " + deviceName);
			apkPackageName = args[10];
			System.out.println("ApkPackage Name: " + apkPackageName);
			mobileScreenshotPath = args[11];
			System.out.println("Mobile ScreenShots Path: " + mobileScreenshotPath);

			TestListener listener = new TestListener();
			testNg = new TestNG();
			testNg.setTestClasses(new Class[] { Driver_Script.class });
			testNg.addListener(listener);
			testNg.run();
		}
	}
}
