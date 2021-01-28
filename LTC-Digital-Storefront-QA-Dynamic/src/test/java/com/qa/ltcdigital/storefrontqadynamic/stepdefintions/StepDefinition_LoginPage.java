package com.qa.ltcdigital.storefrontqadynamic.stepdefintions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.qa.ltcdigital.storefrontqadynamic.base.DriverFactory;
import com.qa.ltcdigital.storefrontqadynamic.base.TestBase;
import com.qa.ltcdigital.storefrontqadynamic.pageobjects.HomePage;
import com.qa.ltcdigital.storefrontqadynamic.pageobjects.LoginPage;
import com.qa.ltcdigital.storefrontqadynamic.util.TestUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinition_LoginPage {
	
	Logger log = Logger.getLogger(StepDefinition_LoginPage.class);
	
	 TestBase base;
	 TestUtil util;
	 LoginPage lpage;
	 HomePage  hpage;
	 
	@Before()
	public void setUp(){
		base  =  new TestBase();
		util  =  new TestUtil();
		base.launchBrowser();
		lpage =  new LoginPage();
		hpage =  new HomePage();
		log.info("Url is launched");
	}
	
	@Given("user is on Login Page and user fills  {string} value in the username field")
	public void user_is_on_login_page_and_user_fills_value_in_the_username_field(String username) throws InterruptedException {
	    Assert.assertTrue(lpage.setUsername(username));
	}

	@Then("user fills {string} value in the password field")
	public void user_fills_value_in_the_password_field(String password) {
	   Assert.assertTrue(lpage.setPassword(password));
	}

	@Then("user clicks login button")
	public void user_clicks_login_button() throws InterruptedException {
	   Assert.assertTrue(lpage.clickLoginButton());
	}
	
	@Then("user clicks logout button on Home Page")
	public void user_clicks_logout_button_on_home_page() throws InterruptedException {
	    Assert.assertTrue(hpage.clickLogoutButton());
	}
	
	@AfterStep()
	public void embeddScreenshot(Scenario scenario){
		if (scenario.isFailed()) {
	        byte[] screenshot = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", scenario.getName());
	    }
	}
	
	@After()
	public void tearDown(){
		base.closeBrowser();
		log.info(" Closing browser");
	}
	
}
