package com.luna.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.luna.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String emailAddress = readConfig.getEmail();
	public String password = readConfig.getPassword();
	public Logger logger;

	protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

//	@BeforeClass
	@BeforeMethod
	public void setup() {
		String url = readConfig.getBaseUrl();
		String browser = readConfig.getBrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			threadDriver.set(new ChromeDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			threadDriver.set(new EdgeDriver());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			threadDriver.set(new FirefoxDriver());
			break;
		default:
			threadDriver.set(new ChromeDriver());
			break;
		}
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger = LogManager.getLogger("SeleniumFramework");
		driver.get(url);
		logger.info("url opend");
		driver.manage().window().maximize();
		logger.info("window maximized");

	}

	public WebDriver getDriver() {
		return threadDriver.get();

	}

//	@AfterClass
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
