package com.npoCommerce.StepDefination;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nopCommerce.PageObject.NopCommerceAddNewCustomerPage;
import com.nopCommerce.PageObject.NopCommerceLoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationForLoginPage extends BaseClassForStepDefination {
	
	private static final Logger logger = LogManager.getLogger(StepDefinationForLoginPage.class);
	
	@Given("User Open Browser")
	public void user_open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("Browser Open");
	}

	@Given("User Enter url As {string}.")
	public void user_enter_url_as(String applicationUrl) {
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		logger.info("user enter url");
	}

	@When("User Enter Email As {string}")
	public void user_enter_email_as(String UserEmail) throws InterruptedException {
		loginPage = new NopCommerceLoginPage(driver);
		Thread.sleep(3000);
		loginPage.enterUserEmail(UserEmail);
		logger.info("user enter email");
	}

	@When("Password As {string}.")
	public void password_as(String password) throws InterruptedException {
		Thread.sleep(3000);
		loginPage.enterUserPassword(password);
		logger.info("user enter password");
	}

	@When("user Click On Login Button.")
	public void user_click_on_login_button() throws InterruptedException {
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
		logger.info("user click on login button");
	}

	@Then("User Nevigate to Dashboard Page and Close Browser.")
	public void user_nevigate_to_dashboard_page() {
		String ActualText = loginPage.verifyUserNevigation();
		String ExpectedText = "Dashboard";

		if(ExpectedText.equals(ActualText)) {
			Assert.assertTrue(true);
			logger.info("user able to verify user");
		}
		else {
			Assert.assertTrue(false);
			logger.info("user not able to verify user");
		}
		driver.close();
	}

	// Add New Customer//

	@When("User Click On Customer .")
	public void user_click_on_customer() {
		addCustomer = new NopCommerceAddNewCustomerPage(driver);
		addCustomer.clickOnCustomerTag();
		logger.info("user click on customer");
	}

	@When("user Click On Customer Menu Iteam.")
	public void user_click_on_customer_menu_iteam() {
		addCustomer.clickOnCustomer();
		logger.info("user click on customer menu");
	}

	@When("Click On Add New Button.")
	public void click_on_add_new_button() {
		addCustomer.clickOnAddNewButton();
		logger.info("user click on new button");
	}

	@Then("User Can View Add New Customer Page.")
	public void user_can_view_add_new_customer_page() {
		String Actaul = addCustomer.verifyAddNewCustomerPage();
		String Expected = "back to customer list";
		if(Actaul.equals(Expected)) {
			Assert.assertTrue(true);
			logger.info("user able to view Add New Customer Page");
		}else {
			Assert.assertTrue(false);
			logger.info("user not able to view Add New Customer Page");
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
		logger.info("user enter customer info");
	}

	@When("Click n Save Buttom.")
	public void click_n_save_buttom() {
		addCustomer.clickOnSaveButton();
		logger.info("user click on save button");
	}

	@Then("User View Confirmation Massage {string}")
	public void user_view_confirmation_massage(String string) {
		String Actual = addCustomer.verifyAddedUser();
		String Expected = "The new customer has been added successfully.";
		if(Actual.equals(Expected)) {
			Assert.assertTrue(true);
			logger.info("user able to see confirmation massage");
		}else {
			Assert.assertTrue(false);
			logger.info("user not able to see confirmation massage");
		}
	}

	@Then("Close browser.")
	public void close_browser() {
		driver.close();
		logger.info("browser closed.");
	}


}  
