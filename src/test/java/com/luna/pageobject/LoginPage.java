package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement errorMessage;
	
	@FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
	WebElement signInButton;
	
	@FindBy(css = "a[class='action create primary'] span")
	WebElement createAnAccountButton;
	
	@FindBy(xpath = "//div[text()='You must login or register to add items to your wishlist.']")
	WebElement errorMessageOfAddToWishList;
	
	public String geterrorMessageOfAddToWishList() {
		return errorMessageOfAddToWishList.getText();
	}
	public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public UserHomePage clickSignInButton(WebDriver rdriver) {
		signInButton.click();
		return new UserHomePage(rdriver);
	}
	
	public AccountCreationPage createAnAccount(WebDriver rdriver) {
		createAnAccountButton.click();
		return new AccountCreationPage(rdriver);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
