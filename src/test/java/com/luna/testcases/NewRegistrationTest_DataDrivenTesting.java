package com.luna.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.luna.pageobject.AccountCreationPage;
import com.luna.pageobject.CustomerAccountPage;
import com.luna.pageobject.IndexPage;
import com.luna.pageobject.LoginPage;
import com.luna.pageobject.UserHomePage;
import com.luna.utilities.ReadExcelFile;

public class NewRegistrationTest_DataDrivenTesting extends BaseClass{

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
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPass) throws IOException, InterruptedException {
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = indexPage.ClickOnSignIn(driver);
		logger.info("Clicked On signIn button");
		
		loginPage.enterEmail(userEmail);
		logger.info("entered email");
		
		loginPage.enterPassword(userPass);
		logger.info("entered password");
		
		UserHomePage userHomePage = loginPage.clickSignInButton(driver);
		logger.info("Clicked on signIn Button");
		
		String error = loginPage.getErrorMessage();
		
		if(!error.contains("The account sign-in was incorrect or your account is disabled temporarily")) {
			logger.info("Verify Login - passed");
			Thread.sleep(3000);
			userHomePage.logOutDrop();
			logger.info("clicked on log out drop down");
			userHomePage.logOut();
			logger.info("Clicked on log out element");
			Thread.sleep(6000);
			Assert.assertTrue(true);
		}
		else{
			logger.info("Verify Login - failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
			
		}
		
		
		
	}
	@DataProvider(name = "LoginDataProvider")
	public String[][] loginDataProvider(){
		String fileName = System.getProperty("user.dir") + "\\TestData\\LunaLoginTestData.xlsx";
		
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String[ttlRows-1][ttlColumns];
		
		for(int i = 1; i< ttlRows; i++) {
			for(int j = 0; j<ttlColumns; j++) {
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData",i, j);
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
