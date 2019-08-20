package com.endava.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.endava.screens.HomePageScreen;
import com.endava.util.Constants;

public class TC03CheckDisponibilityTest {
	WebDriver driver;
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(Constants.baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void test003CheckDisponibility() {
		HomePageScreen homepage=new HomePageScreen(driver);
		homepage.menuIsDisplayed().selectHomeAndOffice().selectItem().checkAvailable().verifyAvailabilityRequestPopup()
		.fillTheForm(Constants.email, Constants.phoneNumber, Constants.message).sendForm().verifyFormSent();
		

	}

	@After
	public void tearDown() {
		driver.close();

	}
}
