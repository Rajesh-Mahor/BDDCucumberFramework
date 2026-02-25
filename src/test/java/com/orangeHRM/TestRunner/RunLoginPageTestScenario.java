package com.orangeHRM.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src\\test\\resources\\Features\\Login.feature",
		glue = {"com.orangeHRM.StepDefination"},
		dryRun = false,
		plugin = {"pretty","html:target/cucumber-reports.html"}
	)
public class RunLoginPageTestScenario {

}
