package com.clubkitchen.addtocart;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.BrowserLaunch;
import com.utils.Constants;

public class CheckOut {

	public static void checkOutOrder() {
		
		Select date=new Select(Constants.driver.findElement(By.id("order_delivery_date")));
		date.selectByIndex(0);
		BrowserLaunch.test.log(LogStatus.PASS, "Date Selected Successfully");
		Select time=new Select(Constants.driver.findElement(By.id("order_delivery_time")));
		time.selectByIndex(2);
		BrowserLaunch.test.log(LogStatus.PASS, "Time Selected Successfully");
		Constants.driver.findElement(By.id("cart-status")).click();
		BrowserLaunch.test.log(LogStatus.PASS, "Order Checkout is  Successfull");
	}

}
