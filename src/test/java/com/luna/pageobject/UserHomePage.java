package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	WebDriver ldriver;

	public UserHomePage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "div[class='panel header'] button[data-action='customer-menu-toggle']")
	WebElement logoutDropdown;
	
	@FindBy(xpath = "(//a[contains(text(),'Sign Out')])[1]")
	WebElement logout;
	
	@FindBy(id = "search")
	WebElement searchBox;
	
	@FindBy(css = "button[title = 'Search']")
	WebElement searchButton;
	
	public void searchBox(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public SearchResultPage searchButton(WebDriver rdriver) {
		searchButton.click();
		return new SearchResultPage(rdriver);
	}
	public void logOutDrop() {
		logoutDropdown.click();
	}
	
	public void logOut() {
		logout.click();
	}

}
