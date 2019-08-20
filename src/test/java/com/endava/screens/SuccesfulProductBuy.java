package com.endava.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SuccesfulProductBuy {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//button[@class='close'][@data-dismiss='alert']")
	private WebElement closePopupAlertButton;
	@FindBy(how = How.XPATH, using = ".//*[@class='alert alert-success']")
	private WebElement succesfulShopingmessage;

	public SuccesfulProductBuy clickOnClose() {
		closePopupAlertButton.click();
		return this;

	}
	public BuyAproduct clickClose(){
		closePopupAlertButton.click();
		return new BuyAproduct(driver);
	}

	public SuccesfulProductBuy verifySuccesfulShopping() {
		Assert.assertTrue("Succesful shopping" + succesfulShopingmessage.getText(),
				succesfulShopingmessage.getText().contains("Succes: Ai adaugat Capsule Blue Espresso Crema Dolce"));
		return this;
	}

	public SuccesfulProductBuy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
