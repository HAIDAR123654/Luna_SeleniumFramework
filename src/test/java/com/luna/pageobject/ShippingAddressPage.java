package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {

	WebDriver ldriver;

	public ShippingAddressPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "input[name='street[0]']")
	WebElement street;
	
	@FindBy(css = "input[name='city']")
	WebElement city;
	
	@FindBy(css = "select[name='region_id']")
	WebElement stateDropDown;
	
	@FindBy(css = "select[name='region_id']")
	WebElement countryDropDown;
	
	@FindBy(css = "input[name='telephone']")
	WebElement telephone;
	
	@FindBy(css = "input[name='ko_unique_3']")
	WebElement shippingMethod;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;
	
	@FindBy(css = "input[name='postcode']")
	WebElement zipCode;
	
	public void enterStreetAdress(String streetAddress) {
		street.sendKeys(streetAddress);
	}
	
	public void enterCityAdress(String cityAddress) {
		city.sendKeys(cityAddress);
	}
	
	public WebElement clickOnStateDropDown() {
		return stateDropDown;
	}
	public WebElement clickOnCountryDropDown() {
		return countryDropDown;
	}
	
	public void enterPhone(String tele) {
		telephone.sendKeys(tele);
	}
	
	public void selectShippingMethod() {
		shippingMethod.click();
	}
	
	public ReviewAndPaymentPage clickOnNext(WebDriver rdriver) {
		next.click();
		return new ReviewAndPaymentPage(rdriver);
	}
	
	public void enterZip(String code) {
		zipCode.sendKeys(code);
	}
}
