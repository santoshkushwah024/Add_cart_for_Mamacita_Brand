package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants {
	public static Properties prop;
	static {
		prop = new Properties();
		FileInputStream sp;
		try {
			sp = new FileInputStream(
					"C:\\Users\\santosh\\eclipse-workspace\\addtocart\\src\\main\\java\\com\\clubkitchen\\addtocart\\config.properties");
			prop.load(sp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String Cdriverlocation = prop.getProperty("DriverLoc");
	public static WebDriver driver;
	public static WebDriverWait wait;
	
}
