package com.nopCommerce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NopCommerceLoginPage {

	@FindBy(xpath = "//input[@name='Email']") private WebElement userEmail;
	@FindBy(xpath = "//input[@name='Password']") private WebElement userPassword;
	@FindBy(xpath = "//button[text()='Log in']") private WebElement logiButton;
	@FindBy(xpath = "//div[@class='content-header']") private WebElement verificationText;

	public NopCommerceLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUserEmail(String email) {
		userEmail.clear();
		userEmail.sendKeys(email);
	}

	public void enterUserPassword(String password) {
		userPassword.clear();
		userPassword.sendKeys(password);
	}

	public void clickOnLoginButton() {
		logiButton.click();
	}

	public String verifyUserNevigation() {
		String VerifyText = verificationText.getText();
		return VerifyText;
	}
}
