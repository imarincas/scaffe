package com.endava.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.endava.screens.HomePageScreen;

import com.endava.util.Constants;

public class TC02LoginLogoutTest {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(Constants.baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomePageScreen homepage = new HomePageScreen(driver);
		homepage.accesAcount().verifyCreateAcountTitlePage()
				.fillInForm(Constants.city, Constants.country, Constants.phoneNumber, Constants.address,
						Constants.firstName, Constants.lastName, Constants.email, Constants.password)
				.submitRegistrationForm().verifySuccesfulRegistrationMessageDisplayed();
	}

	@Test
	public void test002LoginUser() {
		HomePageScreen logUser = new HomePageScreen(driver);
		logUser.clickOnMyAccountButton().loginUser(Constants.email, Constants.password).clickOnLoginButton()
				.verifySuccesfulLogin().logoutUser().verifySuccesfulLogout();
	}

	@After
	public void tearDown() {
		driver.close();

	}
}
