package com.luna.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.luna.pageobject.IndexPage;
import com.luna.pageobject.LoginPage;
import com.luna.pageobject.SearchResultPage;
import com.luna.pageobject.UserHomePage;

public class VerifyProductTest extends BaseClass {


	@Test
	public void verifySearchProduct() throws IOException {
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
		String searchedProduct = searchResultPage.getProductName();
		
		if(searchedProduct.contains("Radiant Tee")) {
			logger.info("searched product test cae is passed");
			Assert.assertTrue(true);
			userHomePage.logOutDrop();
			logger.info("clicked on log out drop down");
			userHomePage.logOut();
			logger.info("Clicked on log out element");
		}
		else {
			logger.info("searched product test cae is failed");
			captureScreenShot(driver, "verifysearchProduct");
			Assert.assertTrue(false);
		}
	}
	
	
	
}
