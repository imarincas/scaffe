package com.endava.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BuyAproduct {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@class='modul1-img2']/a[contains(@target,'_blank')]")
	private WebElement buyLavazzaButton;
	@FindBy(how = How.ID, using = "htop")
	private WebElement quantityField;
	@FindBy(how = How.ID, using = "button-cart")
	private WebElement buyButton;
	@FindBy(how = How.ID, using = "link-cos")
	private WebElement shoppingCartButton;
	@FindBy(how = How.XPATH, using = ".//a[@href='http://www.scaffe.ro/index.php?route=checkout/checkout']")
	private WebElement finishOrderButton;

	public SuccesfulProductBuy clickOnBuyButton() {
		buyButton.click();
		return new SuccesfulProductBuy(driver);
	}
	public BuyAproduct verifyProductShoppingonCart(String quantity) {
		Assert.assertTrue("Un produs in cos: " + shoppingCartButton.getText(),
				shoppingCartButton.getText().contains(quantity+" produs"));
		return this;
	}
	public BuyAproduct clickonShopping() {
		shoppingCartButton.click();
		return this;

	}
	public LogInOutPageScreen clickonFinish() {
		finishOrderButton.click();
		return new LogInOutPageScreen(driver);
	}
	

	public BuyAproduct setQuantity(String quantity) {
		quantityField.clear();
		quantityField.sendKeys(quantity);
		return this;
	}

	public BuyAproduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
