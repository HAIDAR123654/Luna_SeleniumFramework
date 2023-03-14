package com.luna.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.luna.pageobject.AccountCreationPage;
import com.luna.pageobject.CustomerAccountPage;
import com.luna.pageobject.IndexPage;
import com.luna.pageobject.LoginPage;
import com.luna.pageobject.UserHomePage;

public class NewRegistrationTest extends BaseClass{
	
	@Test
	public void verifyRegistration() throws InterruptedException {
		WebDriver driver = getDriver();
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		System.out.println("thread id " + Thread.currentThread().getId());
		AccountCreationPage accountCreationDetailsPage = loginPage.createAnAccount(driver);
		logger.info("Clicked On Create Account button to open create account details page");
		
		accountCreationDetailsPage.enterFirstName("Haidar");
		accountCreationDetailsPage.enterLastName("Ali");
		accountCreationDetailsPage.enterEmail("Haidar.ali35@gmail.com");
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
		WebDriver driver = getDriver();
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		System.out.println("thread id for login test  -> " + Thread.currentThread().getId());
		loginPage.enterEmail("pankaj.kumar@gmail.com");
		logger.info("entered email");
		
		loginPage.enterPassword("PANKAJ@k123");
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
	
	@Test
	public void logOutTest() throws IOException {
		WebDriver driver = getDriver();
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		System.out.println("thread id for logout test -> " + Thread.currentThread().getId());
		loginPage.enterEmail("pankaj.kumar@gmail.com");
		logger.info("entered email");
		
		loginPage.enterPassword("PANKAJ@k123");
		logger.info("entered password");
		
		UserHomePage userHomePage = loginPage.clickSignInButton(driver);
		logger.info("Clicked on signIn Button to login.");
		
		String loginedHomeTitle = driver.getTitle();
		userHomePage.logOutDrop();
		userHomePage.logOut();
		
		String logedOutHomeTitle = driver.getTitle();
		
		if(logedOutHomeTitle != loginedHomeTitle) {
			logger.info("log out test case passed");
			Assert.assertTrue(true);
		}
		else{
			captureScreenShot(driver, "logOutTest");
			logger.info("log out test case failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
