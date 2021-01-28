package com.qa.midtrans_pillow.testrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/featurefiles" }, 
glue = {"com.qa.midtrans_pillow.stepdefinitions" }, 
monochrome = false, 
dryRun = false, 
plugin = { "pretty", "summary",
		"html:target/cucumber-html-report", 
		"json:target/cucumber-reports/CucumberTestReport.json",
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
		/* "/reports/CustomEventListener" */
		/*"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"*/
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}, 
tags = "@Negative")  
public class TestRunner extends AbstractTestNGCucumberTests {
	
	/*@AfterClass
	public static void WriteExtentReport(){
		Reporter.loadXMLConfig(new File(TestBase.getReportConfigPath()));
	}*/

}
