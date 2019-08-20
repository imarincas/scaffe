package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class CheckAvalability {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//form[@method='post']/input[@name='adresa_email']")
	private WebElement inputEmailField;
	@FindBy(how = How.XPATH, using = ".//form[@method='post']/input[@name='telefon']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = ".//form[@method='post']/textarea[@name='mesaj']")
	private WebElement messageField;
	@FindBy(how = How.ID, using = "buton-cerere")
	private WebElement sendFormButton;
	@FindBy(how = How.XPATH, using = ".//div[@id='modal-5']/div[@class='md-content']/div[@class='success']")
	private WebElement succesTextField;
	@FindBy(how = How.XPATH, using = ".//*[@id='modal-5']/div/h3")
	private WebElement requestPageText;

	public CheckAvalability fillTheForm(String email, String number, String mesaj) {
		inputEmailField.sendKeys(email);
		phoneNumberField.sendKeys(number);
		messageField.sendKeys(mesaj);
		return this;
	}

	public CheckAvalability sendForm() {
		sendFormButton.click();
		return this;
	}

	public CheckAvalability(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public CheckAvalability verifyFormSent() {
		Assert.assertEquals("Mesajul a fost trimis cu succes!", succesTextField.getText());
		return this;
	}

	public CheckAvalability verifyAvailabilityRequestPopup() {
		Assert.assertEquals("SOLICITA OFERTA", requestPageText.getText());
		return this;
	}
}
