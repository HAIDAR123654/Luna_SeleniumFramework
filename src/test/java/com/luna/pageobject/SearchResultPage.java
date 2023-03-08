package com.luna.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Radiant Tee')]")
	WebElement productName;
	
	@FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
	WebElement addToCart;
//	@FindBy(xpath = "//a[contains(text(),'Radiant Tee')]//following::span[text()='Add to Cart'][1]")
//	WebElement addToCart;
	
	public void howerOnProduct(WebDriver rdriver) {
		Actions actions = new Actions(rdriver);
		actions.moveToElement(productName).perform();
	}
	public void scrollDownToTargetElement(WebDriver rdriver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) rdriver;
		jsExecutor.executeScript("window.scroll(0,600)");
	}
	public ProductDetailsPage addToCart(WebDriver rdriver) {
		addToCart.click();
		return new ProductDetailsPage(rdriver);
	}
	public String getProductName() {
		String p = productName.getText();
		return p;
	}
	
}
