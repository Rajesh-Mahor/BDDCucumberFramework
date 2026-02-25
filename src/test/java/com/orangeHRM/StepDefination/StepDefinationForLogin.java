package com.orangeHRM.StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.orangeHRM.PageObject.LoginPage;
import com.orangeHRM.Utilities.ReadPropertyConfig;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationForLogin {

	public  WebDriver driver;
	public LoginPage loginPage;
	public ReadPropertyConfig config;
	
	@Given("User Is On Login Page")
	public void user_is_on_login_page() {
		
		config = new ReadPropertyConfig();
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(); 
	    driver.get(config.grtUrl());
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@When("Enter Valid Credential")
	public void enter_valid_credential() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin");
		loginPage.enterUserPassward("admin123");
		loginPage.clickLoginButton();
	}

	@Then("user Nevigate To Dashboard")
	public void user_nevigate_to_dashboard() {
	    String Expected = "Dashboard";
	   String Actuals = loginPage.verifyElement();
	   if(Expected.equals(Actuals)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	}


}
