package com.npoCommerce.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
	features = "src\\test\\resources\\Features\\Login Functionality For NopCommerce Application.feature",
	glue = {"com.npoCommerce.StepDefination"},
	dryRun = false,
	plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnerForStepDefinationForLoginPage {

	/* This class Should be Empty At Every Time*/
}
