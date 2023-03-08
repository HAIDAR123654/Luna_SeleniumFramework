package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {
	WebDriver ldriver;

	public OrderSuccessPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'Thank you for your purchase!']")
	WebElement success;
	
	public String getOrderSuccessMessage() {
		return success.getText();
	}
}
