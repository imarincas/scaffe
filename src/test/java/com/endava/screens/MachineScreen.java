package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MachineScreen {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='product']/div/button")
	private WebElement checkAvailabilityButton;

	public MachineScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CheckAvalability checkAvailable() {
		checkAvailabilityButton.click();
		return new CheckAvalability(driver);
	}
}
