package com.npoCommerce.StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import com.nopCommerce.PageObject.NopCommerceAddNewCustomerPage;
import com.nopCommerce.PageObject.NopCommerceLoginPage;


// for Common methods
public class BaseClassForStepDefination {
		
	public WebDriver driver;
	public NopCommerceLoginPage loginPage;
	public NopCommerceAddNewCustomerPage addCustomer;
	
	@SuppressWarnings("deprecation")
	public static String randomEmailgenerator() {

		return (RandomStringUtils.randomAlphabetic(5));

	}
	

}
