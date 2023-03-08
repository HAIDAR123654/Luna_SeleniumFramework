package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

	WebDriver ldriver;

	public AccountCreationPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement passwordConfirm;
	
	@FindBy(css = "button[title='Create an Account'] span")
	WebElement clickOnCreate;
	
	public void enterFirstName(String firstN) {
		firstName.sendKeys(firstN);
	}
	
	public void enterLastName(String lastN) {
		lastName.sendKeys(lastN);
	}
	
	public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		passwordConfirm.sendKeys(confirmPass);
	}
	
	public CustomerAccountPage clickOnCreateAnAccount(WebDriver rdriver) {
		clickOnCreate.click();
		return new CustomerAccountPage(rdriver);
	}

}
