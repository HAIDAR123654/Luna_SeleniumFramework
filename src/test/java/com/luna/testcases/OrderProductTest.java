package com.luna.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.luna.pageobject.IndexPage;
import com.luna.pageobject.LoginPage;
import com.luna.pageobject.OrderSuccessPage;
import com.luna.pageobject.ProductDetailsPage;
import com.luna.pageobject.ReviewAndPaymentPage;
import com.luna.pageobject.SearchResultPage;
import com.luna.pageobject.ShippingAddressPage;
import com.luna.pageobject.UserHomePage;

public class OrderProductTest extends BaseClass {

	@Test
	public void verifyOrderProduct() throws IOException, InterruptedException {
		String searchKey = "t-shirt";
		logger.info("Test Case search product started....");

		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");

		loginPage.enterEmail(emailAddress);
		logger.info("entered email");

		loginPage.enterPassword(password);
		logger.info("entered password");

		UserHomePage userHomePage = loginPage.clickSignInButton(driver);
		logger.info("Clicked on signIn Button");

		userHomePage.searchBox(searchKey);

		SearchResultPage searchResultPage = userHomePage.searchButton(driver);
		searchResultPage.scrollDownToTargetElement(driver);
		searchResultPage.howerOnProduct(driver);
		ProductDetailsPage productDetailsPage = searchResultPage.addToCart(driver);
		Thread.sleep(3000);

		productDetailsPage.productSize();
		productDetailsPage.productColor();
		productDetailsPage.productQuantity("3");
		productDetailsPage.finalAddToCart();
		logger.info("product added to cart");
		Thread.sleep(3000);
		productDetailsPage.clickOnMyCart();
		Thread.sleep(3000);
		productDetailsPage.switchToCheckOutWindow(driver);
		logger.info("driver got switch to check out window..");
		
		ShippingAddressPage shippingAddressPage = productDetailsPage.clickOnProceedToCheckOut(driver);
		Thread.sleep(3000);
        logger.info("Now shipping address details will be filled..");
        
		shippingAddressPage.enterStreetAdress("Ashiyana");
		shippingAddressPage.enterCityAdress("Lucknow");

		Select dropDownState = new Select(shippingAddressPage.clickOnStateDropDown());
		dropDownState.selectByIndex(1);

		shippingAddressPage.enterZip("12345-1234");
		Select dropDownCountry = new Select(shippingAddressPage.clickOnCountryDropDown());
		dropDownCountry.selectByIndex(1);

		shippingAddressPage.enterPhone("1234567899");
		shippingAddressPage.selectShippingMethod();
		logger.info("Now shipping address details filling end");
		ReviewAndPaymentPage reviewAndPaymentPage = shippingAddressPage.clickOnNext(driver);
		logger.info("click on next button..");
		Thread.sleep(5000);

		OrderSuccessPage orderSuccessPage = reviewAndPaymentPage.clickOnPlaceOrder(driver);
		String successOrder = orderSuccessPage.getOrderSuccessMessage();

		if (successOrder.contains("")) {
			logger.info("order test passed");
			Assert.assertTrue(true);
		}

		else {
			logger.info("order test passed");
			captureScreenShot(driver,"verifyOrderProduct");
			Assert.assertTrue(false);
		}
	}

}
