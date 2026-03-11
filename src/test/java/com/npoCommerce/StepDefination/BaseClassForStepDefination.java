package com.npoCommerce.StepDefination;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.nopCommerce.PageObject.NopCommerceAddNewCustomerPage;
import com.nopCommerce.PageObject.NopCommerceLoginPage;


// for Common methods
public class BaseClassForStepDefination {

	private static final Logger logger = LogManager.getLogger(BaseClassForStepDefination.class);
	
	public WebDriver driver;
	public NopCommerceLoginPage loginPage;
	public NopCommerceAddNewCustomerPage addCustomer;
	
	@SuppressWarnings("deprecation")
	public static String randomEmailgenerator() {
		logger.info("Random Email Charecter generated.");
		return (RandomStringUtils.randomAlphabetic(5));
	}
	

}
