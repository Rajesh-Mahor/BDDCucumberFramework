package com.orangeHRM.Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyConfig {

	Properties prop;
	String path = "D:\\eclipse-workspace\\Java Selenium Project\\BDDCucumberFramwork\\Configuration\\Config.properties";

	public ReadPropertyConfig() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(path);
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String grtUrl() {
		String appUrl = prop.getProperty("url");
		if(appUrl != null) {
			return appUrl;
		}else {
			throw new RuntimeException("URL is not configered in config.properties.");
		}
	}

	public String grtBrowser() {
		String appBrowser = prop.getProperty("browser");
		if(appBrowser != null) {
			return appBrowser;
		}else {
			throw new RuntimeException("Browser is not configered in config.properties.");
		}
	}
	
}
