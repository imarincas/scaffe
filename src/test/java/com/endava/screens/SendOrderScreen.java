package com.endava.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SendOrderScreen {
	WebDriver driver;
	@FindBy(how = How.ID, using = "link-cos")
	private WebElement shoppingCartButton;
	@FindBy(how = How.XPATH, using = ".//a[@href='http://www.scaffe.ro/index.php?route=checkout/checkout']")
	private WebElement finishOrderButton;
	@FindBy(how = How.ID, using = "button-payment-address")
	private WebElement paymentAddressButton;
	@FindBy(how = How.ID, using = "button-shipping-address")
	private WebElement shippingAddressButton;
	@FindBy(how = How.ID, using = "button-shipping-method")
	private WebElement shippingMethodButton;
	@FindBy(how = How.XPATH, using = ".//input[@value='bank_transfer'][@name='payment_method']")
	private WebElement paymentMethodButton;
	@FindBy(how = How.XPATH, using = ".//div[@class='pull-right']/input[@type='checkbox'][@name='agree']")
	private WebElement confirmcheckbox;
	@FindBy(how = How.ID, using = "button-payment-method")
	private WebElement sendOrderButton;
	@FindBy(how = How.ID, using = "button-confirm")
	private WebElement confirmOrderButton;
	@FindBy(how = How.XPATH, using = ".//*[@id='content']/h1")
	private WebElement succesMessage;
	@FindBy(how = How.ID, using = "cart-total")
	private WebElement shoppingCartProducts;

	
	

	public SendOrderScreen verifySuccesfulOrder() {
		Assert.assertTrue(driver.getTitle().contentEquals("Comanda a fost finalizata cu succes!")); 
		return this;
	}

	public SendOrderScreen clickOnSend() {
		sendOrderButton.click();
		return this;
	}

	public SendOrderScreen clickonConfirm() {
		confirmOrderButton.click();
		return this;
	}

	public void clickonShopping() {
		shoppingCartButton.click();

	}

	public SendOrderScreen clickConfirmBox() {
		confirmcheckbox.click();
		return this;
	}

	public SendOrderScreen clickPaymentMethod() {
		paymentMethodButton.click();
		return this;
	}

	public void clickonFinish() {
		finishOrderButton.click();
	}

	public SendOrderScreen clickonMethod() {
		shippingMethodButton.click();
		return this;
	}

	public SendOrderScreen clickOnshippingAddress() {
		shippingAddressButton.click();
		return this;
	}

	public SendOrderScreen clickOnPaymentAddress() {
		paymentAddressButton.click();
		return this;
	}

	public SendOrderScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
