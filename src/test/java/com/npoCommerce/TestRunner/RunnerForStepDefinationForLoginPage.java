package com.npoCommerce.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		// to run single feature file
		//features = "src\\test\\resources\\Features\\New Login Feature File.feature",
		// to run All feature file 
		features = {"src\\test\\resources\\Features"},
		// to run perticuler feature file
		//features = {"src\\test\\resources\\Features\\Login Functionality For NopCommerce Application.feature",
		//"src\\test\\resources\\Features\\New Login Feature File.feature"},
		
		// to run all step definition file
		glue = {"com.npoCommerce.StepDefination"},
		// to run specific step definition file.
		//glue = {"path of 1st step definition class","path of 2ed step definition class"},
		// to run single step definition file.
		//glue = {"src\test\java\com\npoCommerce\StepDefination\StepDefinationForLoginPage.java"},
		dryRun = false,        // to check all methods implementation
		monochrome = true,     // For Better readability
		tags = "@smoke",
		plugin = {"pretty", "html:target/cucumber-reports.html"}
		)
public class RunnerForStepDefinationForLoginPage {

	/* This class Should be Empty At Every Time*/
}
