package com.endava.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FoundElement {
	WebDriver driver;

	public FoundElement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public FoundElement verifySuccesfulSearch(String cautare){
		Assert.assertTrue(driver.getTitle().contains(cautare));
		return this;
	}
}
