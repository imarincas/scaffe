package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class DisponibilityMachineScreen {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='supermenu']/ul/li[1]/a[2]")
	private WebElement aparateCafeaMouseOverButton;
	@FindBy(how = How.XPATH, using = ".//*[@class='withchildfo']/a[@href='http://www.scaffe.ro/aparate-cafea/home-office']")
	private WebElement homeAndOfficeButton;
	@FindBy(how = How.XPATH, using = ".//*[@class='produse-continut-wstech-efect']/a[@alt='Aparat Lavazza EP Mini']")
	private WebElement machineCaffeObjectLink;
	@FindBy(how = How.XPATH, using = ".//*[@id='product']/div/button")
	private WebElement checkAvailabilityButton;
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

	public DisponibilityMachineScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public void fillTheForm(String email, String number, String mesaj) {
		inputEmailField.sendKeys(email);
		phoneNumberField.sendKeys(number);
		messageField.sendKeys(mesaj);
	}

	public void sendForm() {
		sendFormButton.click();
	}

	

	public void selectItem() {
		machineCaffeObjectLink.click();
	}

	public void checkAvailable() {
		checkAvailabilityButton.click();
	}

	

}