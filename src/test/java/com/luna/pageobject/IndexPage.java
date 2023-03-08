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
    
	@FindBy(linkText = "Sign In")
	WebElement signIn;
	
	public LoginPage ClickOnSignIn(WebDriver rdriver) {
		signIn.click();
		return new LoginPage(rdriver);
	}
    
}
