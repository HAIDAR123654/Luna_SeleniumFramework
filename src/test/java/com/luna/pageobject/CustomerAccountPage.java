package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountPage {

	WebDriver ldriver;

	public CustomerAccountPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
	WebElement loggedInUser;
	
	public String CurreentloggedInUser() throws InterruptedException{
		Thread.sleep(5000);
		String curentLoggedInUser = loggedInUser.getText();
		return curentLoggedInUser;
	}
	
	
}
