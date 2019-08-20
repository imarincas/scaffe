package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class MyAccountScreen {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='icon-admin-cont7']/a")
	private WebElement logoutButton;

	public MyAccountScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LogoutScreen logoutUser() {
		logoutButton.click();
		return new LogoutScreen(driver);
	}
	public MyAccountScreen verifySuccesfulLogin() {
		Assert.assertTrue("Tittle page should be: " + driver.getTitle(),
				driver.getTitle().contentEquals("Contul Meu"));
		return this;
	}
}
