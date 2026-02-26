package com.npoCommerce.StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nopCommerce.PageObject.NopCommerceLoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationForLoginPage {

	public WebDriver driver;
	public NopCommerceLoginPage loginPage;
	
	@Given("User Open Browser")
	public void user_open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("User Enter url As {string}.")
	public void user_enter_url_as(String applicationUrl) {
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	@When("User Enter Email As {string}")
	public void user_enter_email_as(String UserEmail) {
		loginPage = new NopCommerceLoginPage(driver);
		loginPage.enterUserEmail(UserEmail);
	}

	@When("Password As {string}.")
	public void password_as(String string) {
		loginPage.enterUserPassword(string);
	}

	@When("user Click On Login Button.")
	public void user_click_on_login_button() throws InterruptedException {
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
	}

	@Then("User Nevigate to Dashboard Page.")
	public void user_nevigate_to_dashboard_page() {
		String ActualText = loginPage.verifyUserNevigation();
		String ExpectedText = "Dashboard";
		
		if(ExpectedText.equals(ActualText)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}


}
