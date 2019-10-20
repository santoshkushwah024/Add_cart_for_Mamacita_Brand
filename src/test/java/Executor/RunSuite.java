package Executor;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clubkitchen.addtocart.AddToCart;
import com.clubkitchen.addtocart.CheckOut;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.BrowserLaunch;
import com.utils.Constants;

public class RunSuite {

	@BeforeTest
	public void reports() throws FileNotFoundException {
		BrowserLaunch.reports();

	}

	@BeforeClass
	public void browser() {
		BrowserLaunch.setup();
	}

	@Test(priority = 1,enabled=true)
	public void addCart() throws Exception {
		AddToCart.homePage();
		AddToCart.cart();
		AddToCart.addFoodItems();
	}
	
	@Test(priority = 2,enabled=true)
	public void orderItems() throws Exception {
		CheckOut.checkOutOrder();
	}

	@AfterTest(enabled =true)
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		BrowserLaunch.report.endTest(BrowserLaunch.test);
		BrowserLaunch.report.flush();
		Constants.driver.quit();
		BrowserLaunch.test.log(LogStatus.PASS, "Browser Closed Successfully");
	}
}