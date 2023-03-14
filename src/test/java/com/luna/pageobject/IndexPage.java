package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    WebDriver ldriver;

	public IndexPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
    
	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	WebElement signIn;
	
	@FindBy(id = "search")
	WebElement searchBox;
	
	@FindBy(css = "button[title = 'Search']")
	WebElement searchButton;
	
	public LoginPage ClickOnSignIn(WebDriver rdriver) {
		signIn.click();
		return new LoginPage(rdriver);
	}
	
	public void searchBox(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public SearchResultPage searchButton(WebDriver rdriver) {
		searchButton.click();
		return new SearchResultPage(rdriver);
	}
}
