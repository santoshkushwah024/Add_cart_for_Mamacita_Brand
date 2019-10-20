package com.clubkitchen.addtocart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.BrowserLaunch;
import com.utils.Constants;

public class AddToCart {
	public static String title;

	public static void homePage() throws IOException {

		// Open the Home Page
		Constants.driver.get(Constants.prop.getProperty("URL"));
		title = Constants.driver.getTitle();
		BrowserLaunch.test.log(LogStatus.PASS, "Fetched Url Successfully");
		Assert.assertEquals(Constants.prop.getProperty("TITLE"), title);
		BrowserLaunch.test.log(LogStatus.PASS, title + " : " + "Page Title Verified Successfully");
	}

	public static void cart() throws Exception {
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("COOKIE"))).click();
		BrowserLaunch.test.log(LogStatus.PASS, "Cookie Accepted successfull ");
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("BRAND"))).click();
		BrowserLaunch.test.log(LogStatus.PASS, "Mamacita Menu Selected successfully");
		Constants.driver.findElement(By.id(Constants.prop.getProperty("Address")))
				.sendKeys(Constants.prop.getProperty("Location"));
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("SubAddr"))).click();
		BrowserLaunch.test.log(LogStatus.PASS, "Address Added successfully ");
		Thread.sleep(5000);
	}

	public static void addFoodItems() throws InterruptedException {
		
		WebElement element = Constants.driver.findElement(By.xpath(Constants.prop.getProperty("Menu")));
		Actions actions = new Actions(Constants.driver);
		actions.moveToElement(element).click().perform();
		//Constants.driver.findElement(By.xpath(Constants.prop.getProperty("Menu"))).click();
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("Dish"))).click();
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("ExtraTopin"))).click();
		Constants.driver.findElement(By.xpath(Constants.prop.getProperty("SubmitTopin"))).click();
		BrowserLaunch.test.log(LogStatus.PASS, " Cheesy Pork Burrito Added successfully ");
	}

}
