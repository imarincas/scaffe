package com.endava.screens;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchForProductScreen {
	WebDriver driver;
	
	@FindBy (how=How.XPATH,using=".//div[@id='search']/button[@class='btn btn-default btn-lg']/i")
	private WebElement searchButton;
	@FindBy(how=How.XPATH, using=".//*[@id='search']/input")
	private WebElement searchInputField;
	
	public FoundElement searchProduct(String produs){
		
		searchInputField.sendKeys(produs);
		searchButton.click();
		return new FoundElement(driver);
	}
	
	public SearchForProductScreen(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
