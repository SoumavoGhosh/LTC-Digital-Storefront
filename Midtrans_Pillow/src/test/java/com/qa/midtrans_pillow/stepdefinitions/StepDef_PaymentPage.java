package com.qa.midtrans_pillow.stepdefinitions;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.Assert;


import com.qa.midtrans_pillow.base.TestBase;

import com.qa.midtrans_pillow.pageobjects.PaymentPage;


import io.cucumber.java.After;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_PaymentPage {
	
	Logger  log = Logger.getLogger(StepDef_PaymentPage.class);
	
	TestBase testbase;
	PaymentPage paypage;
	int count =0;
	/*ExtentTest test;
    ExtentReports extent;
    
    @Before
    public void setUp(){
      extent= ExtentReporterNG.getReportObject();
    }*/
	
	
	@Given("user has launched browser and navigated to url")
	public void user_has_launched_browser_and_navigated_to_url() {
		//test = extent.createTest("user_has_launched_browser_and_navigated_to_url");
		testbase = new TestBase();
		testbase.initialization();
		log.info("URl Opened");
		//test.log(Status.INFO, "URL Opened");
		paypage= new PaymentPage();
	
		
	}

	@When("user clicks on Buy Now button")
	public void user_clicks_on_buy_now_button() {
		//test = extent.createTest("user_clicks_on_buy_now_button");
		Assert.assertEquals(paypage.clickBuyNow(), true);
		//test.log(Status.INFO, "Clicked on Buy Now button");
	}

	@Then("user sees an auto generated form and clicks on Checkout button")
	public void user_sees_an_auto_generated_form_and_clicks_on_checkout_button() {
		//test = extent.createTest("user_sees_an_auto_generated_form_and_clicks_on_checkout_button");
		Assert.assertEquals(paypage.clickCheckOut(), true);
		//test.log(Status.INFO, "Clicked on Checkout button");
	}

	@Then("user verifies header as {string}")
	public void user_verifies_header_as(String text) throws InterruptedException, AWTException {
		//test = extent.createTest("user_verifies_header");
			count+=1;
			
			if(count==1){
				if(testbase.switchToFrame()){
					Assert.assertEquals(testbase.verifyFrameElements(text), true);
					//test.log(Status.INFO, "Verified Header");
				}
			}
			else {
				Assert.assertEquals(testbase.verifyFrameElements(text), true);
				//test.log(Status.INFO, "Verified Header");
			}
		/*if(testbase.switchToFrame()){
			//paypage= new PaymentPage();
			System.out.println("abcd");
			Assert.assertEquals(testbase.verifyFrameElements(text), true);
		}*/		
	}

	@Then("user verifies label as {string}")
	public void user_verifies_label_as(String text) throws InterruptedException, AWTException {
		//Assert.assertEquals(paypage.verifyTextValue(text), true);
		//Assert.assertEquals(testbase.switchToFrame(text), true);
		//if(testbase.switchToFrame()){
			//test = extent.createTest("user_verifies_label_by_the_name_amount");
			Assert.assertEquals(testbase.verifyFrameElements(text), true);
			//test.log(Status.INFO, "Label Amount is present");
			//}
	}

	@Then("user verifies amount value as {string}")
	public void user_verifies_amount_value_as(String text) throws InterruptedException, AWTException {
		//Assert.assertEquals(paypage.verifyTextValue(text), true);
		//Assert.assertEquals(testbase.switchToFrame(text), true);
		//if(testbase.switchToFrame()){
		//test = extent.createTest("user_verifies_amount_value");
		Assert.assertEquals(testbase.verifyFrameElements(text), true);
		//test.log(Status.INFO, "Amount value is showing correctly");
		//}
	}

	@Then("user validates the below table and its contents")
	public void user_validates_the_below_table_and_its_contents() {
		//test = extent.createTest("user_validates_table_and_its_contents");
		Assert.assertEquals(paypage.verifyTableContents(),true);
		//test.log(Status.INFO, "Table values showing correctly");
	}

	@Then("user clicks on Continue button")
	public void user_clicks_on_continue_button() throws InterruptedException, AWTException {
		//test = extent.createTest("user_clicks_on_continue_button");
		this.paypage= testbase.ClickFrameElements();
		Assert.assertEquals(this.paypage.clickContinue(), true);
		//test.log(Status.INFO, "Clicked continue button");
	}

	@When("user chooses mode of payment as Credit\\/Debit Card")
	public void user_chooses_mode_of_payment_as_credit_debit_card() throws InterruptedException, AWTException {
		//test = extent.createTest("user_chooses_mode_of_payment");
		Assert.assertEquals(paypage.choosePaymentMode(), true);
		//test.log(Status.INFO, "Payment mode is selected");
	}

	@Then("user provides card number as {string}")
	public void user_provides_card_number_as(String text) {
		//test = extent.createTest("user_provides_card_number");
		Assert.assertEquals(paypage.setCardNumber(text),true);
		//test.log(Status.INFO, "User provides card number");
	}

	@Then("user provides card expiry as {string}")
	public void user_provides_card_expiry_as(String text) {
		//test = extent.createTest("user_provides_card_expiry_details");
		Assert.assertEquals(paypage.setCardExpiry(text), true);
		//test.log(Status.INFO, "Card Expiry details  provided");
	}

	@Then("user provides card cvv as {string}")
	public void user_provides_card_cvv_as(String text) {
		//test = extent.createTest("user_provides_card_cvv");
		Assert.assertEquals(paypage.setCardCVV(text), true);
		//test.log(Status.INFO, "Provided card CVV");
	}

	@Then("user clicks on Pay Now button")
	public void user_clicks_on_pay_now_button() {
		//test = extent.createTest("user_clicks_on_pay_now_button");
		Assert.assertEquals(paypage.clickPayNow(), true);
		//test.log(Status.INFO, "Clicked on Pay Now button");
	}

	@Then("user provides bank password as {string}")
	public void user_provides_bank_password_as(String text) throws InterruptedException, AWTException {
		//test = extent.createTest("user_provides_bank_password");
		if(this.paypage.switchNextFrame()){
		this.paypage= new PaymentPage();
		Assert.assertEquals(this.paypage.setPassword(text), true);
		//test.log(Status.INFO, "Provided bank password");
		}
		else{
			System.out.println("Frame  not swirched");
		}
	}

	@Then("user clicks on OK button")
	public void user_clicks_on_ok_button() throws InterruptedException {
		/*paypage.switchNextFrame();
		this.paypage= new PaymentPage();*/
		//test = extent.createTest("user_clicks_on_OK_button");
		Assert.assertEquals(this.paypage.clickSubmit(), true);
		//test.log(Status.INFO, "Clicked on OK button");
	}

	@Then("user validates successful transaction")
	public void user_validates_successful_transaction() throws InterruptedException {
		//test = extent.createTest("user_validates_succesful_transaction_message");
		//if(testbase.switchToFrame()){
		Assert.assertEquals(this.paypage.verifyTransactionCompletion(), true);
		//test.log(Status.INFO, "Succesful Transaction message confirmed and displayed");
		//}
	}
	
	/*@When("user closes browser")
	public void user_closes_browser() {
		test = extent.createTest("user_closes_browser");
		testbase.closeBrowser();
		test.log(Status.INFO, "Closed browser");
	}*/
	
	@Then("user validates unsuccessful transaction")
	public void user_validates_unsuccessful_transaction() {
		//test = extent.createTest("user_validates_unsuccesful_transaction_message");
		//if(testbase.switchToFrame()){
		Assert.assertEquals(this.paypage.verifyUnSuccesfulTransactionCompletion(), true);
		//test.log(Status.INFO, "UnSuccesful Transaction message confirmed and displayed");
	}
	
	@After
	public void tearDown(){
		//test = extent.createTest("user_closes_browser");
		log.info("Browser Closed");
		testbase.closeBrowser();
		//test.log(Status.INFO, "Closed browser");
		//extent.flush();
	}
}
