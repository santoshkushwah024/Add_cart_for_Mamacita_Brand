package com.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserLaunch {
	public static ExtentTest test;
	public static ExtentReports report;

	
	public static  void reports() throws FileNotFoundException {
		report = new ExtentReports(System.getProperty("user.dir") + "\\AddtoCartReport.html", true);
		test = report.startTest("Add To Cart Case");
		test.log(LogStatus.PASS, "Report File Created Successfully ");
	}
	
	public static void setup()  {
	
		Constants.driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", Constants.Cdriverlocation);
		Constants.driver.manage().window().maximize();
		Constants.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Constants.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Browser Launched Successfully");
	}

}
