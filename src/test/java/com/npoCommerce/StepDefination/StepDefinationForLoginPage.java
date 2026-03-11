package com.npoCommerce.StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nopCommerce.PageObject.NopCommerceAddNewCustomerPage;
import com.nopCommerce.PageObject.NopCommerceLoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationForLoginPage extends BaseClassForStepDefination {
	
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
	public void password_as(String password) {
		loginPage.enterUserPassword(password);
	}

	@When("user Click On Login Button.")
	public void user_click_on_login_button() throws InterruptedException {
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
	}

	@Then("User Nevigate to Dashboard Page and Close Browser.")
	public void user_nevigate_to_dashboard_page() {
		String ActualText = loginPage.verifyUserNevigation();
		String ExpectedText = "Dashboard";

		if(ExpectedText.equals(ActualText)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.close();
	}

	// Add New Customer//

	@When("User Click On Customer .")
	public void user_click_on_customer() {
		addCustomer = new NopCommerceAddNewCustomerPage(driver);
		addCustomer.clickOnCustomerTag();
		
	}

	@When("user Click On Customer Menu Iteam.")
	public void user_click_on_customer_menu_iteam() {
		addCustomer.clickOnCustomer();
	}

	@When("Click On Add New Button.")
	public void click_on_add_new_button() {
		addCustomer.clickOnAddNewButton();
	}

	@Then("User Can View Add New Customer Page.")
	public void user_can_view_add_new_customer_page() {
		String Actaul = addCustomer.verifyAddNewCustomerPage();
		String Expected = "back to customer list";
		if(Actaul.equals(Expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	@When("User Enter Customer Info.")
	public void user_enter_customer_info() throws InterruptedException {
		addCustomer.enterUserEmail(randomEmailgenerator()+"@billdesk.com");
		addCustomer.enterUserPassword("12345");
		addCustomer.enterUserFirstName("Test3");
		addCustomer.enterUserLastName("User");
		addCustomer.enterUserGender();
		addCustomer.enterUserCompanyName("Billdesk");
		addCustomer.addComment("Admin Comment");
	}

	@When("Click n Save Buttom.")
	public void click_n_save_buttom() {
		addCustomer.clickOnSaveButton();
	}

	@Then("User View Confirmation Massage {string}")
	public void user_view_confirmation_massage(String string) {
		String Actual = addCustomer.verifyAddedUser();
		String Expected = "The new customer has been added successfully.";
		if(Actual.equals(Expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	@Then("Close browser.")
	public void close_browser() {
		driver.close();
	}


}
