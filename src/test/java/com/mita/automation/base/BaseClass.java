package com.mita.automation.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.Status;
import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.mita.automation.Utils.ExcelData;
import com.mita.automation.managers.ExtentTestManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExcelData

{
	public static WebDriver driver;
	public static AndroidDriver mobiledriver;
	public static AppiumDriverLocalService service;
	static Logger logger = Logger.getLogger(BaseClass.class);

	public static String[] bt;

	public static WebDriver launchBrowser(String browserType, String appURL) throws Exception {
		try {
			logger.info("Select the " + browserType + "browser");
			ExtentTestManager.getTest().log(Status.PASS, "Select the " + browserType + " browser");
			switch (browserType) {
			case "Chrome":
				initChromeDriver(appURL);
				break;
			case "Firefox":
				initFirefoxDriver(appURL);
				break;
			case "Edge":
				initEdgeDriver(appURL);
				break;
			default:
				System.out.println("browser : " + browserType + " is invalid");
				logger.warn("browser : " + browserType + " is invalid");
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to select the " + browserType
					+ "browser " + e.getMessage());
		}
		return driver;
	}

	public static WebDriver launchBrowsers(String browserType, String appURL) throws Exception {
		try {
			logger.info("Select the " + browserType + " browser");
			ExtentTestManager.getTest().log(Status.PASS, "Select the " + browserType + " browser");
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					initChromeDriver(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Chrome Broswer " + e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					initFirefoxDriver(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Firefox Broswer " + e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					initEdgeDriver(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Edge Broswer " + e.getMessage());
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to select the " + bt[l] + " browser "
					+ e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR, "Executing - " + Driver_Script.Actionvalue
					+ ": Unable to select the " + bt[l] + " browser " + e.getMessage());
		}
		return driver;
	}

	public static void initChromeDriver(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching google chrome browser..");
			ExtentTestManager.getTest().log(Status.PASS, "Launching google chrome browser..");
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			String executionType = Runner.executionType;
			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				ExtentTestManager.getTest().log(Status.PASS, "Execution Type is " + executionType);
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
				// maximize window
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Navigate URL method
				driver.get(appURL);
				ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue + " " + appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				ExtentTestManager.getTest().log(Status.PASS, "Execution Type is " + executionType);
				driver = new ChromeDriver(chromeOptions);
				// maximize window
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Navigate URL method
				driver.get(appURL);
				ExtentTestManager.getTest().log(Status.PASS, Driver_Script.Actionvalue + " " + appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			}
			Map<String, Object> prefs = new HashMap<String, Object>();

			// SET CHROME OPTIONS

			// 0 - Default, 1 - Allow, 2 - Block

			prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
			prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
			prefs.put("profile.default_content_setting_values.notifications", 1);
			prefs.put("profile.default_content_setting_values.geolocation", 1);
			chromeOptions.setExperimentalOption("prefs", prefs);
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Chrome browser "
					+ e.getMessage());
			ExtentTestManager.getTest().log(Status.ERROR, "Executing - " + Driver_Script.Actionvalue
					+ ": Unable to launch the Chrome browser " + e.getMessage());
		}
	}

	public static void initFirefoxDriver(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Firefox browser..");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			String executionType = Runner.executionType;
			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				firefoxOptions.addArguments("--window-size=1920,1080");
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
				// maximize window
				driver.manage().window().maximize();
				// Navigate URL method
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				driver = new FirefoxDriver(firefoxOptions);
				// maximize window
				driver.manage().window().maximize();
				// Navigate URL method
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Firefox browser"
					+ e.getMessage());

		}
	}

	public static void initEdgeDriver(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Edge browser..");
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			String executionType = Runner.executionType;
			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				edgeOptions.addArguments("--window-size=1920,1080");
				edgeOptions.addArguments("headless");
				driver = new EdgeDriver(edgeOptions);
				// maximize window
				driver.manage().window().maximize();
				// Navigate URL method
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				driver = new EdgeDriver(edgeOptions);
				// maximize window
				driver.manage().window().maximize();
				// Navigate URL method
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Edge browser"
					+ e.getMessage());
		}
	}

//	@AfterSuite
//	public void Close() {
//		try {
//			logger.info("Closing the browser");
//			driver.quit();
//		} catch (Exception e) {
//			logger.error("Not able to Close the Browser --- " + e.getMessage());
//		}
//	}

	public static AndroidDriver setup(String device) throws MalformedURLException {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Android driver");
			DesiredCapabilities cap = new DesiredCapabilities();
			File f = new File(Runner.apkPath);
			if (device.equalsIgnoreCase("Emulator")) {
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, Runner.deviceName);
			} else if (device.equalsIgnoreCase("Real")) {
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, Runner.deviceName);
			}

			cap.setCapability("platformName", "Android");
			cap.setCapability("appPackage", Runner.apkPackageName);
			cap.setCapability("automationName", "UiAutomator2");
			cap.setCapability("autoGrantPermissions", "true");
			cap.setCapability("noRest", true);
//			cap.setCapability("noSign", true);

			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			mobiledriver = new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"), cap);
			mobiledriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} catch (NullPointerException e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Andriod driver "
					+ e.getMessage());
		}
		return mobiledriver;
	}

}