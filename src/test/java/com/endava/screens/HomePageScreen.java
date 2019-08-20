
package com.endava.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageScreen {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//div[@id='cont-nou']/a")
	private WebElement iconUserButton;
	@FindBy(how = How.XPATH, using = "//*[@class='modul2-img2']/a[@target='_blank']")
	private WebElement cafeaIcsButton;
	@FindBy(how = How.XPATH, using = "//*[@class='modul1-img2']/a[@target='_blank']")
	private WebElement buyLavazzaButton;
	@FindBy(how = How.XPATH, using = ".//li[@class='tlli mkids lad']/a[@class='tll']")
	private WebElement myAccountButton;
	@FindBy(how = How.XPATH, using = ".//*[@id='supermenu']/ul/li[1]/a[2]")
	private WebElement aparateCafeaMouseOverButton;
	@FindBy(how = How.XPATH, using = ".//*[@class='withchildfo']/a[@href='http://www.scaffe.ro/aparate-cafea/home-office']")
	private WebElement homeAndOfficeButton;
	
	public HomePageScreen menuIsDisplayed() {
		Actions action = new Actions(driver);
		action.moveToElement(aparateCafeaMouseOverButton).build().perform();
		return this;
	}
	public HomeAndOfficeScreen selectHomeAndOffice() {
		homeAndOfficeButton.click();
		return new HomeAndOfficeScreen(driver);
	}

	public HomePageScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public BuyAproduct clickOnProduct(){
		buyLavazzaButton.click();
		return new BuyAproduct(driver);
	}
	public LogInOutPageScreen clickOnMyAccountButton(){
		myAccountButton.click();
		return new LogInOutPageScreen(driver);
	}

	public BuyAproduct clickOnCaffee() {
		cafeaIcsButton.click();
		return new BuyAproduct(driver);
	}

	public RegisterPageScreen accesAcount() {
		iconUserButton.click();
		return new RegisterPageScreen(driver);
		
	}
}