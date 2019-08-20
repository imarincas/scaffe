package com.endava.screens;

import java.security.SecureRandom;
import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class RegisterPageScreen {
	private WebDriver driver;
	@FindBy(how = How.ID, using = "input-firstname")
	private WebElement firstNameField;
	@FindBy(how = How.ID, using = "input-lastname")
	private WebElement lastNameField;
	@FindBy(how = How.ID, using = "input-email")
	private WebElement emailField;
	@FindBy(how = How.ID, using = "input-telephone")
	private WebElement phoneNumberField;
	@FindBy(how = How.ID, using = "input-address-1")
	private WebElement addressField;
	@FindBy(how = How.ID, using = "input-city")
	private WebElement cityField;
	@FindBy(how = How.ID, using = "input-zone")
	private WebElement districtFieldDropdown;
	@FindBy(how = How.ID, using = "input-country")
	private WebElement countryFieldDropdown;
	@FindBy(how = How.ID, using = "input-password")
	private WebElement passwordField;
	@FindBy(how = How.ID, using = "input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(how = How.XPATH, using = ".//input[@name='agree']")
	private WebElement agreeCheckbox;
	@FindBy(how = How.XPATH, using = ".//input[@class='btn btn-primary'][@value='Continua'][@type='submit']")
	private WebElement submitButton;
	@FindBy(how = How.ID, using = "input-custom-field14")
	private WebElement cnpField;
	@FindBy(how = How.ID, using = "input-custom-field16")
	private WebElement identifierField;
	@FindBy (how=How.XPATH,using=".//label[@class='radio-inline']/input[@type='radio'][@value='1']")
	private WebElement yesNewsletterRadioButton;

	public RegisterPageScreen fillInForm(String city, String country, String phoneNumber, String address, String firstName,
			String lastName, String email, String password) {
		cnpField.sendKeys(randomString(13));
		identifierField.sendKeys(randomString(8));
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		phoneNumberField.sendKeys(phoneNumber);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		selectFromDropdown(districtFieldDropdown, city);
		selectFromDropdown(countryFieldDropdown, country);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		agreeCheckbox.click();
		yesNewsletterRadioButton.click();
return this;
	}

	public void selectFromDropdown(WebElement element, String option) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(option);

	}

	public RegisterPageScreen verifyCreateAcountTitlePage() {
		Assert.assertTrue("Tittle should contain: " + driver.getTitle(),
				driver.getTitle().contains("Inregistreaza un cont nou"));
		return this;
	}

	public SuccesfulRegistrationScreen submitRegistrationForm() {
		submitButton.click();
		return new SuccesfulRegistrationScreen(driver);
	}

	public RegisterPageScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String randomString(int length) {
		Random random = new SecureRandom();
		char[] result = new char[length];
		char[] CHARSET_AZ_09 = "0123456789".toCharArray();
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
			result[i] = CHARSET_AZ_09[randomCharIndex];

		}
		return new String(result);
	}

}
