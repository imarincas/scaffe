package com.endava.tests;

import java.util.concurrent.TimeUnit;
import com.endava.screens.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.endava.screens.BuyAproduct;
import com.endava.util.Constants;
import com.endava.util.Switch;

public class TC04BuyLavazzaCoffeeTest {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(Constants.baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test004BuyLavazzaCoffee() {
		HomePageScreen homepage = new HomePageScreen(driver);
		BuyAproduct buy= new BuyAproduct(driver);
		homepage.clickOnProduct();
		String parentWind = Switch.switchToChildWindow();
		buy.setQuantity(Constants.quantity).clickOnBuyButton().verifySuccesfulShopping();
		Switch.switchBackToParentWindow(parentWind);

	}

	@After
	public void tearDown() {
		driver.close();

	}
}
