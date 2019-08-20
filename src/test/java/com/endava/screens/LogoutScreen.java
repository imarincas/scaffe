package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LogoutScreen {
WebDriver driver;
public LogoutScreen(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public LogoutScreen verifySuccesfulLogout() {
	Assert.assertTrue("Tittle page should be: " + driver.getTitle(),
			driver.getTitle().contains("Iesire din cont"));
	return this;
}
}
