package com.nopCommerce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NopCommerceAddNewCustomerPage {

	@FindBy(xpath = "//i[@class='nav-icon far fa-user']") private WebElement customerTag;
	@FindBy(xpath = "//p[text()=' Customers']") private WebElement customer;
	@FindBy(xpath = "//a[@class='btn btn-primary']") private WebElement addNewButton;
	@FindBy(xpath = "//a[text()='back to customer list']") private WebElement pageVerificationText;
	@FindBy(xpath = "//input[@name='Email']") private WebElement userEmail;
	@FindBy(xpath = "//input[@name='Password']") private WebElement userPassword;
	@FindBy(xpath = "//input[@name='FirstName']") private WebElement userFirstName;
	@FindBy(xpath = "//input[@name='LastName']") private WebElement userLastName;
	@FindBy(xpath = "//input[@name='Gender']") private WebElement userGender;
	@FindBy(xpath = "//input[@name='Company']") private WebElement userComapanyName;
	@FindBy(xpath = "//textarea[@name='AdminComment']") private WebElement commentSection;
	@FindBy(xpath = "//button[@name='save']") private WebElement saveButton;
	@FindBy(xpath = "//span[text()='The new customer has been added successfully.']") private WebElement verifyUserAddedSuccessfully;

	public NopCommerceAddNewCustomerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clickOnCustomerTag() {
		customerTag.click();
	}
	public void clickOnCustomer() {
		customer.click();
	}
	public void clickOnAddNewButton() {
		addNewButton.click();
	}
	public String verifyAddNewCustomerPage() {
		return pageVerificationText.getText();
	}
	public void enterUserEmail(String email) {
		userEmail.sendKeys(email);
	}
	public void enterUserPassword(String password) {
		userPassword.sendKeys(password);
	}
	public void enterUserFirstName(String firstName) {
		userFirstName.sendKeys(firstName);
	}
	public void enterUserLastName(String lastName) {
		userLastName.sendKeys(lastName);
	}
	public void enterUserGender() {
		userGender.click();
	}
	public void enterUserCompanyName(String company) {
		userComapanyName.sendKeys(company);
	}
	public void addComment(String comment) {
		commentSection.sendKeys(comment);
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public String verifyAddedUser() {
		return verifyUserAddedSuccessfully.getText();
	}
}
