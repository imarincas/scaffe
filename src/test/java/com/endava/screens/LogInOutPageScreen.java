package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LogInOutPageScreen {
	WebDriver driver;

	@FindBy(how = How.ID, using = "input-email")
	private WebElement emailField;
	@FindBy(how = How.ID, using = "input-password")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = ".//input[@class='btn btn-primary'][@value='Autentificare'][@type='submit']")
	private WebElement loginButton;
	@FindBy(how = How.ID, using = "button-login")
	private WebElement butonLogin;
	
	// @FindBy (how=How.ID,using="button-login")
	// private WebElement loginButton;

	public LogInOutPageScreen loginUser(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		return this;
	}
	public SendOrderScreen clickOnLogin(){
		butonLogin.click();
		return new SendOrderScreen(driver);
	}

	public MyAccountScreen clickOnLoginButton() {
		loginButton.click();
		return new MyAccountScreen(driver);
	}

	public LogInOutPageScreen verifySuccesfulLogout() {
		Assert.assertTrue("Tittle page should be: " + driver.getTitle(), driver.getTitle().contains("Iesire din cont"));
		return this;
	}

	public LogInOutPageScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
