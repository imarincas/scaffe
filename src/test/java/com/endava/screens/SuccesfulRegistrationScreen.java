package com.endava.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SuccesfulRegistrationScreen {
	public WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='content'][@class='col-sm-12']/h1")
	private WebElement succesfulRegistrationText;

	public SuccesfulRegistrationScreen verifySuccesfulRegistrationMessageDisplayed() {
		Assert.assertTrue("Succesful registrration page should contain: " + succesfulRegistrationText.getText(),
				succesfulRegistrationText.getText().contains("Contul tau a fost creat!"));
return this;
	}

	public SuccesfulRegistrationScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
