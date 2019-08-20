package com.endava.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.screens.BuyAproduct;
import com.endava.screens.HomePageScreen;
import com.endava.screens.SendOrderScreen;
import com.endava.util.Constants;
import com.endava.util.Switch;

public class TC06SendOrderTest {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(Constants.baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test005SendOrder() {
		HomePageScreen homepage = new HomePageScreen(driver);
		SendOrderScreen sendorder = new SendOrderScreen(driver);
		BuyAproduct buyprod = new BuyAproduct(driver);
		homepage.clickOnCaffee();
		String parentWind = Switch.switchToChildWindow();
		buyprod.setQuantity(Constants.quantity).clickOnBuyButton().clickClose()
		.verifyProductShoppingonCart(Constants.quantity).clickonShopping().clickonFinish()
		.loginUser(Constants.email, Constants.password)
		.clickOnLogin()
		.clickOnPaymentAddress()
		.clickOnshippingAddress()
		.clickonMethod()
		.clickPaymentMethod()
		.clickConfirmBox()
		.clickOnSend()
		.clickonConfirm();
		new WebDriverWait(driver, 60).until(ExpectedConditions.titleContains("Comanda a fost finalizata cu succes!"));
		sendorder.verifySuccesfulOrder();
		Switch.switchBackToParentWindow(parentWind);

	}

	@After
	public void tearDown() {
		driver.close();

	}
}
