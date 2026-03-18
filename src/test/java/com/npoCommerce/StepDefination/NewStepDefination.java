package com.npoCommerce.StepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.nopCommerce.PageObject.NopCommerceLoginPage;
import com.nopCommerce.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewStepDefination extends BaseClassForStepDefination {

	private static final Logger logger = LogManager.getLogger(NewStepDefination.class);
	public ReadConfig readConfig;

	@Before("@smoke")
	public void setUp() {
		logger.info("This Method Invock before EveryScenario For Code Like DB Connection, Open Browser etc because of @Before Tag from Cucumber");
		
		readConfig = new ReadConfig();
		String myBrowser = readConfig.getBrowser();

		switch (myBrowser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}

	}

	@Given("User opens the browser")
	public void user_opens_the_browser() {
		logger.info("Browser Open");
	}

	@Given("User enters URL as {string}")
	public void user_enters_url_as(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		logger.info("uesr enter URL");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		loginPage = new NopCommerceLoginPage(driver);
		loginPage.enterUserEmail(email);
		Thread.sleep(3000);
		loginPage.enterUserPassword(password);
		logger.info("user enter email and password");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
		logger.info("user click on login button");
	}

	@Then("User navigates to Dashboard Page")
	public void user_navigates_to_dashboard_page() {
		String ActualText = loginPage.verifyUserNevigation();
		String ExpectedText = "Dashboard1";

		if(ExpectedText.equals(ActualText)) {
			Assert.assertTrue(true);
			logger.info("user able to Verify User");
		}
		else {
			Assert.assertTrue(false);
			logger.info("user not able to Verify User");
		}
	}

	@Then("User closes the browser")
	public void user_closes_the_browser() {
		driver.close();
		logger.info("Browser Closed");
	}

	@After("@smoke")
	public void tearDown(Scenario sc) throws IOException {
		logger.info("This Method Invock after EveryScenario For Code Like DB disconnect, close Browser etc because of @After Tag from Cucumber");
		if(sc.isFailed()==true) {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File("D:\\eclipse-workspace\\Java Selenium Project\\BDDCucumberFramwork\\Screenshots\\FailedTestCase.png");
			FileUtils.copyFile(src, dest);
			logger.info("ScreenShot capture Successfully.");
		}
	}

}
