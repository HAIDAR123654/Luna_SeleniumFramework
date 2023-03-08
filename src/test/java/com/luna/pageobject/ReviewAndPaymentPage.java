package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndPaymentPage {

	WebDriver ldriver;

	public ReviewAndPaymentPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement place;
	
	public OrderSuccessPage clickOnPlaceOrder(WebDriver rdriver) {
		place.click();
		return new OrderSuccessPage(rdriver);
	}
}
