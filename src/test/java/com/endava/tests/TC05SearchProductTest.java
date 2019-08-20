package com.endava.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.endava.screens.SearchForProductScreen;
import com.endava.util.Constants;

public class TC05SearchProductTest {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(Constants.baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test004SearchProduct() {
		SearchForProductScreen search = new SearchForProductScreen(driver);
		search.searchProduct(Constants.produs).verifySuccesfulSearch(Constants.produs);
	}

	@After
	public void tearDown() {
		driver.close();

	}
}
