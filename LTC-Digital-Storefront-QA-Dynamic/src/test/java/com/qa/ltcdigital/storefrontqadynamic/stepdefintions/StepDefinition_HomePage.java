package com.qa.ltcdigital.storefrontqadynamic.stepdefintions;

import org.testng.Assert;

import com.qa.ltcdigital.storefrontqadynamic.dataobjects.Policy;
import com.qa.ltcdigital.storefrontqadynamic.pageobjects.HomePage;
import com.qa.ltcdigital.storefrontqadynamic.pageobjects.PreferencePage;

import io.cucumber.java.en.Then;

public class StepDefinition_HomePage {
	
	HomePage hpage;
	PreferencePage ppage;
	//Policy policy;
	
	public StepDefinition_HomePage(){
		hpage = new HomePage();
		ppage = new PreferencePage();
		//policy = new Policy();
	}
	
	@Then("user lands on Home page and sees {string}")
	public void user_lands_on_home_page_and_sees(String pol_num) throws Exception {
		Assert.assertTrue(hpage.validatePolicyNumber(pol_num));
	}
	
	@Then("user sees {string} field as expected")
	public void user_sees_field_as_expected(String textval) {
	   if(textval.equalsIgnoreCase("PRODUCT")){
		   Assert.assertTrue(hpage.validateProductName());
	   } else if(textval.equalsIgnoreCase("POLICY_STATUS")){
		   Assert.assertTrue(hpage.validatePolicyStatus());
	   } else if (textval.equalsIgnoreCase("CLIENT_NAME")){
		   Assert.assertTrue(hpage.validateClientName());
	   }
	}
	
	@Then("user sees and clicks on {string}")
	public void user_sees_and_clicks_on(String fullname) throws InterruptedException {
		Assert.assertTrue(hpage.clickFullName(fullname));
	}
	
	@Then("user sees {string} in the dropdown and selects it")
	public void user_sees_in_the_dropdown_and_selects_it(String text) throws InterruptedException {
		Assert.assertTrue(hpage.verifyAndClickPreferences(text));
	}
	
	@Then("user clicks logout button on Preferences Page")
	public void user_clicks_logout_button_on_preferences_page() throws InterruptedException {
	   Assert.assertTrue(ppage.clickLogoutButton()); 
	}

}
