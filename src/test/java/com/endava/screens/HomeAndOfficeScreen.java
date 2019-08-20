package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeAndOfficeScreen {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@class='produse-continut-wstech-efect']/a[@alt='Aparat Lavazza EP Mini']")
	private WebElement machineCaffeObjectLink;

	public MachineScreen selectItem() {
		machineCaffeObjectLink.click();
		return new MachineScreen(driver);
	}
	public HomeAndOfficeScreen(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
