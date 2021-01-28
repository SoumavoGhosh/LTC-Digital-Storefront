package com.qa.ltcdigital.storefrontqadynamic.stepdefintions;

import org.testng.Assert;

import com.qa.ltcdigital.storefrontqadynamic.pageobjects.PreferencePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_PreferencePage {
	
	PreferencePage ppage;
	
	public StepDefinition_PreferencePage(){
		ppage = new PreferencePage();
	}
	
	@When("user selects Text message option")
	public void user_selects_text_message_option() throws InterruptedException {
	  Assert.assertTrue(ppage.checkTextMessageOption());
	}

	@When("user selects Email option")
	public void user_selects_email_option() throws InterruptedException {
	   Assert.assertTrue(ppage.checkEmailOption()); 
	}
	
	@When("user clicks Save button")
	public void user_clicks_save_button() throws InterruptedException {
		Assert.assertTrue(ppage.clickSaveButton());
	}
	
	@Then("user sees an {string} pop up")
	public void user_sees_an_pop_up(String text) {
	  Assert.assertTrue(ppage.verifyPopupOpened(text));
	}
	
	@Then("user verifies the header and content of the popup")
	public void user_verifies_the_header_and_content_of_the_popup() throws Exception {
	    Assert.assertTrue(ppage.verifyPopupContent());
	}
	
	@Then("user selects the acknowledgment agreement confirmation option")
	public void user_selects_the_acknowledgment_agreement_confirmation_option() throws InterruptedException {
	   Assert.assertTrue(ppage.clickOnAcknowledgmentConfirmationCheckBox());
	}
	
	@Then("user clicks on the confirm button")
	public void user_clicks_on_the_confirm_button() throws InterruptedException {
	    Assert.assertTrue(ppage.clickConfirmButton());
	}
	
	@Then("user verifies {string} message")
	public void user_verifies_message(String text) throws Exception {
	   Assert.assertTrue(ppage.verifyPreferencesSavedMessage(text));
	}
	
	@Then("user lands on preferences page and sees page header as {string}")
	public void user_lands_on_preferences_page_and_sees_page_header_as(String text) {
	 Assert.assertTrue(ppage.verifyPreferencePageHederText(text));
	}

	@Then("user verifies preferences page body and contents")
	public void user_verifies_preferences_page_body_and_contents() throws Exception {
	    Assert.assertTrue(ppage.verifyPreferencePageBodyContents());
	}
}
