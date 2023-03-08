package com.luna.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver ldriver;

	public ProductDetailsPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css= "#option-label-size-143-item-168")
	WebElement size;
	
	@FindBy(css = "#option-label-color-93-item-56")
	WebElement color;
	
	@FindBy(css = "#qty")
	WebElement quantity;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@data-block=\"minicart\"]/a/span[2]")
	WebElement myCart;
	
	@FindBy(css = "#top-cart-btn-checkout")
	WebElement checkOut;
	
	public void productSize() {
		size.click();
	}
	
	public void productColor() {
		color.click();
	}
	
	public void productQuantity(String quant) {
		quantity.clear();
		quantity.sendKeys(quant);
	}
	
	public void finalAddToCart() {
		addToCart.click();
	}
	
	public void clickOnMyCart() {
		myCart.click();
	}
	
	public ShippingAddressPage clickOnProceedToCheckOut(WebDriver rdriver) {
		checkOut.click();
		return new ShippingAddressPage(rdriver);
	}
}
