package com.luna.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.luna.pageobject.AccountCreationPage;
import com.luna.pageobject.CustomerAccountPage;
import com.luna.pageobject.IndexPage;
import com.luna.pageobject.LoginPage;

public class NewRegistrationTest extends BaseClass{

	@Test(enabled = false)
	public void verifyRegistration() throws InterruptedException {
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		
		AccountCreationPage accountCreationDetailsPage = loginPage.createAnAccount(driver);
		logger.info("Clicked On Create Account button to open create account details page");
		
		accountCreationDetailsPage.enterFirstName("Haidar");
		accountCreationDetailsPage.enterLastName("Ali");
		accountCreationDetailsPage.enterEmail("Haidar.ali32@gmail.com");
		accountCreationDetailsPage.enterPassword("HAIDAR@a123");
		accountCreationDetailsPage.enterConfirmPassword("HAIDAR@a123");
		logger.info("Entered Account creation details");
		
		CustomerAccountPage customerAccountPage = accountCreationDetailsPage.clickOnCreateAnAccount(driver);
		logger.info("Clicked On Create Account button to create new account");
        String user = customerAccountPage.CurreentloggedInUser();
		Assert.assertEquals("Welcome, Haidar Ali!",user);
		logger.info("Registation User successfully verified");
		
	}
	
	@Test
	public void verifyLogin() throws InterruptedException, IOException {
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		
		loginPage.enterEmail("Haidar.ali32@gmail.com");
		logger.info("entered email");
		
		loginPage.enterPassword("HAIDAR@a123");
		logger.info("entered password");
		
		loginPage.clickSignInButton(driver);
		logger.info("Clicked on signIn Button");
		
		String error = loginPage.getErrorMessage();
		
		if(error.contains("The account sign-in was incorrect or your account is disabled temporarily")) {
			logger.info("Verify Login - failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		else{
			logger.info("Verify Login - passed");
			Assert.assertTrue(true);
		}
		
	}
}
