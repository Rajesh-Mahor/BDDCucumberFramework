package com.orangeHRM.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src\\test\\resources\\Features\\LoginFunctionality.feature",
	    glue = {"StepDefination"},
	    dryRun = true,
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)
public class LoginRun {
/* Class Will Be Empty*/
}
