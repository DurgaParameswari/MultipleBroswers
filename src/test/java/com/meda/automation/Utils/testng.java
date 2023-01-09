package com.meda.automation.Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng {

	static WebDriver driver;

//	@Test(invocationCount = 2)
	@Test 
	
	public void executSessionOne() throws InterruptedException {
		// First session of WebDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("Driver 1");
		Thread.sleep(500);
		driver.close();
	}
	

}
