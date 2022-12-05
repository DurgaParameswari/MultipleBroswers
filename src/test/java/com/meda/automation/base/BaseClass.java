package com.meda.automation.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import com.mavenpackage.Driver_Script;
import com.mavenpackage.Runner;
import com.meda.automation.Utils.ExcelData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExcelData

{
	public static WebDriver driver;
	public static AndroidDriver<AndroidElement> mobiledriver;
	static Logger logger = Logger.getLogger(BaseClass.class);

	public static String[] bt;

	public static WebDriver launchBrowser(String browserType, String appURL) throws Exception {
		try {
			reporterLog("Select the " + browserType + "browser");
			logger.info("Select the " + browserType + "browser");
			switch (browserType) {
			case "Chrome":
				initChromeDriver(appURL);
				break;

			case "Firefox":
				initFirefoxDriver(appURL);
				break;

			case "Edge":
				initEdge(appURL);
				break;

			default:
				System.out.println("browser : " + browserType + " is invalid");
				logger.warn("browser : " + browserType + " is invalid");
				reporterLog("browser : " + browserType + " is invalid");
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to select the " + browserType
					+ "browser " + e.getMessage());
			reporterLog(Driver_Script.Actionvalue + ": Unable to select the " + browserType
					+ "browser " + e.getMessage());
		}
		return driver;
	}

	public static WebDriver launchBrowsers(String browserType, String appURL) throws Exception {
		try {
			reporterLog("Select the " + browserType + " browser");
			logger.info("Select the " + browserType + " browser");
			try {
				if (bt[l].equalsIgnoreCase("Chrome")) {
					initChromeDriver(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Chrome Broswer " + e.getMessage());
				reporterLog("User not selected Chrome Broswer " + e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Firefox")) {
					initFirefoxDriver(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Firefox Broswer " + e.getMessage());
				reporterLog("User not selected Firefox Broswer " + e.getMessage());
			}
			try {
				if (bt[l].equalsIgnoreCase("Edge")) {
					initEdge(appURL);
				}
			} catch (Exception e) {
				logger.info("User not selected Edge Broswer " + e.getMessage());
				reporterLog("User not selected Edge Broswer " + e.getMessage());
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to select the " + bt[l] + " browser "
					+ e.getMessage());
			reporterLog(Driver_Script.Actionvalue + ": Unable to select the " + bt[l] + " browser "
					+ e.getMessage());
		}
		return driver;
	}
	
	public static void initChromeDriver(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching google chrome browser..");
			reporterLog(Driver_Script.Actionvalue + ": Launching google chrome browser..");
			ChromeOptions options = new ChromeOptions();
//			WebDriverManager.chromedriver().driverVersion("107.0.5304.107").setup();
			WebDriverManager.chromedriver().setup();
			String executionType = Runner.executionType;

			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--start-maximized");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				driver = new ChromeDriver(options);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			}
			Map<String, Object> prefs = new HashMap<String, Object>();

			// SET CHROME OPTIONS

			// 0 - Default, 1 - Allow, 2 - Block

			prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
			prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
			prefs.put("profile.default_content_setting_values.notifications", 1);
			prefs.put("profile.default_content_setting_values.geolocation", 1);
			options.setExperimentalOption("prefs", prefs);

		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Chrome browser "
					+ e.getMessage());

			reporterLog(Driver_Script.Actionvalue + ": Unable to launch the Chrome browser "
					+ e.getMessage());
		}
	}

	public static void initFirefoxDriver(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Firefox browser..");
			reporterLog(Driver_Script.Actionvalue + ": Launching Firefox browser..");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			WebDriverManager.firefoxdriver().driverVersion("107.0").setup();
			WebDriverManager.firefoxdriver().setup();
			String executionType = Runner.executionType;

			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				driver = new FirefoxDriver(firefoxOptions);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Firefox browser"
					+ e.getMessage());

			reporterLog(Driver_Script.Actionvalue + ": Unable to launch the Firefox browser"
					+ e.getMessage());
		}
	}

	public static void initEdge(String appURL) throws Exception {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Edge browser..");
			reporterLog(Driver_Script.Actionvalue + ": Launching Edge browser..");
			EdgeOptions edgeOptions = new EdgeOptions();
//			WebDriverManager.edgedriver().driverVersion("107.0.1418.56").setup();
			WebDriverManager.edgedriver().setup();
			String executionType = Runner.executionType;

			if (executionType.equalsIgnoreCase("Headless")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				edgeOptions.setCapability("UseChromium", true);
				edgeOptions.setCapability("headless", true);
				driver = new EdgeDriver(edgeOptions);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} else if (executionType.equalsIgnoreCase("Head")) {
				logger.info("Execution Type is " + executionType);
				reporterLog("Execution Type is " + executionType);
				driver = new EdgeDriver(edgeOptions);
				// maximize window
				reporterLog("Maximize Window");
				driver.manage().window().maximize();
				// Navigate URL method
				reporterLog("Navigates to URL is " + appURL);
				driver.get(appURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Edge browser"
					+ e.getMessage());

			reporterLog("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Edge browser"
					+ e.getMessage());
		}
	}

	@AfterSuite
	public void Close() {
		try {
			logger.info("Closing the browser");
			reporterLog(Driver_Script.Actionvalue);
			driver.quit();
		} catch (Exception e) {
			logger.error("Not able to Close the Browser --- " + e.getMessage());
			reporterLog("Not able to Close the Browser --- " + e.getMessage());
		}
	}

	public static AndroidDriver<AndroidElement> setup(String device) throws MalformedURLException {
		try {
			logger.info("Executing - " + Driver_Script.Actionvalue + ": Launching Android driver");
			reporterLog(Driver_Script.Actionvalue + ": Launching Android driver");
			File f = new File(Runner.apkPath);
			DesiredCapabilities cap = new DesiredCapabilities();

			if (device.equalsIgnoreCase("Emulator")) {
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, Runner.deviceName);
			} else if (device.equalsIgnoreCase("Real")) {
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, Runner.deviceName);
			}
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			cap.setCapability("appPackage", Runner.apkPackageName);
			// "com.machint.vgro"
			cap.setCapability("noReset", true);
			cap.setCapability("noSign", true);
			mobiledriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			mobiledriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// mita_acceptAlert();
		} catch (Exception e) {
			logger.warn("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Andriod driver "
					+ e.getMessage());
			reporterLog("Executing - " + Driver_Script.Actionvalue + ": Unable to launch the Andriod driver "
					+ e.getMessage());
		}
		return mobiledriver;
	}

	
}
