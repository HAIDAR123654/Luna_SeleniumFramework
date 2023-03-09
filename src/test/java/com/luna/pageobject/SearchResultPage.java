package com.luna.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
	@FindBy(xpath = "(//span[text()='Add to Wish List'])[1]")
	WebElement addToWishList;
	
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
	
	public LoginPage addToWishList(WebDriver rdriver) {
		WebDriverWait wait = new WebDriverWait(rdriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addToWishList));
		addToWishList.click();
		return new LoginPage(rdriver);
	}
	
}
