package com.qa.ltcdigital.storefrontqadynamic.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/resources/featurefiles"},
		glue={"com.qa.ltcdigital.storefrontqadynamic.stepdefintions"},
		monochrome=false,
		dryRun=false,
		plugin={"pretty", "summary",
				"html:target/cucumber-html-report", 
				"json:target/json-report/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		tags="@Home"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
	}
}

/*@Login or @Home or @Preference*/
