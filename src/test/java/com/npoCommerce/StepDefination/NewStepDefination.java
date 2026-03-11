package com.npoCommerce.StepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import com.nopCommerce.PageObject.NopCommerceLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewStepDefination extends BaseClassForStepDefination {
	
	@Before("@smoke")
	public void setUp() {
		System.out.println("This Method Invock before EveryScenario For Code Like DB Connection, Open Browser etc because of @Before Tag from Cucumber");
	}
	
	@Given("User opens the browser")
	public void user_opens_the_browser() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	}

	@Given("User enters URL as {string}")
	public void user_enters_url_as(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		loginPage = new NopCommerceLoginPage(driver);
		loginPage.enterUserEmail(email);
		Thread.sleep(3000);
		loginPage.enterUserPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("User navigates to Dashboard Page")
	public void user_navigates_to_dashboard_page() {
		String ActualText = loginPage.verifyUserNevigation();
		String ExpectedText = "Dashboard1";

		if(ExpectedText.equals(ActualText)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@Then("User closes the browser")
	public void user_closes_the_browser() {
	   driver.close();
	}
	
	@After("@smoke")
	public void tearDown(Scenario sc) throws IOException {
		System.out.println("This Method Invock after EveryScenario For Code Like DB disconnect, close Browser etc because of @After Tag from Cucumber");
		if(sc.isFailed()==true) {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File("D:\\eclipse-workspace\\Java Selenium Project\\BDDCucumberFramwork\\Screenshots\\FailedTestCase.png");
			FileUtils.copyFile(src, dest);
			System.out.println("ScreenShot capture Successfully.");
		}
	}

}
