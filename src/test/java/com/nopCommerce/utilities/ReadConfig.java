package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.npoCommerce.StepDefination.BaseClassForStepDefination;

public class ReadConfig {
	
	private static final Logger logger = LogManager.getLogger(ReadConfig.class);

	public String filePath = "D:\\eclipse-workspace\\Java Selenium Project\\BDDCucumberFramwork\\ConfigFolder\\config.properties";
	public Properties prop;

	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			logger.info("File Load Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String getBrowser() {
		String appBrowser = prop.getProperty("browser");
		if (appBrowser != null) {
			logger.info("Getting Browser Name From Config File");
			return prop.getProperty("browser");
		} else {
			throw new RuntimeException("Browser is not configered in config.properties.");
		}
	}

}
