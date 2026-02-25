package com.orangeHRM.StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.orangeHRM.PageObject.LoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_StepDefination {
	
	static LoginPage page;
	static WebDriver driver;

	@Given("Open browser")
	public void open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("Enter Application URL as {string}")
	public void enter_application_url_as(String URL) {
		
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User Enter Id As {string} and Password As {string}")
	public void user_enter_id_as_and_password_as(String UserName, String Password) {
		
		page = new LoginPage(driver);
		page.enterUserName(UserName);
		page.enterUserPassward(Password);
	}

	@When("Click On Login Button")
	public void click_on_login_button() {
		page.clickLoginButton();
	}

	@Then("User Nevigate To Dashboard and Close browser")
	public void user_nevigate_to_dashboard_and_close_browser() {
		
		String Actuals = page.verifyElement();
		String Expected = "Dashboard";
		if(Actuals.equals(Expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		driver.close();
	}

}
