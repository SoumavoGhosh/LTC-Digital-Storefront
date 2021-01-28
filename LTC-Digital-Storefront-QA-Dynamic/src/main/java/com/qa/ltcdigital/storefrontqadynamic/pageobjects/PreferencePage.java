package com.qa.ltcdigital.storefrontqadynamic.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ltcdigital.storefrontqadynamic.base.DriverFactory;
import com.qa.ltcdigital.storefrontqadynamic.util.Interaction;
import com.qa.ltcdigital.storefrontqadynamic.util.TestUtil;

public class PreferencePage {
	
	Logger log = Logger.getLogger(HomePage.class);
	WebDriver driver= null;
	Interaction intrct= null;
	TestUtil util = null;
	
	@FindBy(xpath="//*[@type='button' and @value='Log Out']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//input[@name='smsPref']//parent::span//label")//*[@id='checkbox-47']/parent::span//*[@class='slds-checkbox__label']
	WebElement textmessageCheckBoxOption;
	
	@FindBy(xpath="//input[@name='emailPref']//parent::span//label")//*[@id='checkbox-46']/parent::span//*[@class='slds-checkbox__label']
	WebElement emailCheckBoxOption;
	
	@FindBy(xpath="//*[@type='button' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//*[@data-id='modal']//div//h2")
	WebElement acknowledgementText;
	
	@FindBy(xpath="//*[@data-id='modal']//div//h2//parent::div//following-sibling::div//strong")
	WebElement acknowledgementheaderText;
	
	@FindBy(xpath="//*[@data-id='modal']//div//h2//parent::div//following-sibling::div//p")
	WebElement acknowledgementbodyContent;
	
	@FindBy(xpath="//*[@data-id='confirmCheckbox']//parent::div//div//label")//*[@id='checkbox-51']//parent::span//label
	WebElement acknowledgmentcheckboxOption;
	
	@FindBy(xpath="//*[@type='button' and @value='Confirm']")
	WebElement confirmBtn;
	
	@FindBy(xpath="//*[@class='panel ']//div//strong")
	WebElement preferencessavedHeaderMessage;
	
	@FindBy(xpath="//*[@class='panel ']//div//span")
	WebElement preferencessavedBodyMessage;
	
	@FindBy(xpath="//div[@data-region-name='header']//div[@class='ui-widget']//h1//span")
	WebElement preferencepageHeaderText;
	
	@FindBy(xpath="//*[@class='ui-widget']//div//h5")
	WebElement preferencepageBodyHeaderText;
	
	@FindBy(xpath="//*[@class='ui-widget']//div[@class='slds-p-top_small slds-p-bottom_small']")
	WebElement bodyheaderdetailstext1;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::span[1]")
	WebElement emaildetails;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::span[2]")
	WebElement phonenumberdetails;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::div[2]//div//span[@class='demiBold']")
	WebElement claimnotificationheader;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::div[2]//div//span[@class='demiBold']//parent::div//div")
	WebElement claimnotificationdetails;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::div[3]//div//span[@class='demiBold']")
	WebElement whatsnewheader;
	
	@FindBy(xpath="//*[@class='ui-widget']//a[@class='profileLink']//parent::div//following-sibling::div[3]//div//span[@class='demiBold']//following-sibling::div")
	WebElement whatsnewbody;
	
	public PreferencePage(){
		driver=DriverFactory.getInstance().getDriver();
		intrct=Interaction.getInstance();
		util= new TestUtil();
		PageFactory.initElements(driver, this);
	}
	
	 public boolean clickLogoutButton() throws InterruptedException{
			if(intrct.clickElement(logoutBtn)){
				log.info("Clicked log out button succesfully ");
				return true;
			} else{
				log.info("Couldn't click on log out button ");
				return false;
			}
		}
	 
	 public boolean checkTextMessageOption() throws InterruptedException{
		 System.out.println("xxxx");
		 if(intrct.clickElement(textmessageCheckBoxOption)){
			 System.out.println("yyyy");
				log.info("Clicked text message check box option succesfully ");
				return true;
			} else{
				log.info("Couldn't click on text message check box option ");
				return false;
			}
	 }
	 
	 public boolean checkEmailOption() throws InterruptedException{
		 if(intrct.clickElement(emailCheckBoxOption)){
				log.info("Clicked email option succesfully ");
				return true;
			} else{
				log.info("Couldn't click on email option ");
				return false;
			}
	 }
	 
	 public boolean clickSaveButton() throws InterruptedException{
		 if(intrct.clickElement(saveBtn)){
				log.info("Clicked on save button  succesfully ");
				return true;
			} else{
				log.info("Couldn't click on save button ");
				return false;
			}
	 }
	 
	 public boolean verifyPopupOpened(String text){
		 if(intrct.verifyElementText(acknowledgementText,text)){
			 log.info("Pop up opened succesfully");
			 return true;
		 }else{
			 log.info("Pop up didnt open");
			 return false ;
		 }
	 }
	 
	 public boolean verifyPopupContent() throws Exception{
		 String path = "C:\\Eclipse Workspace\\Workspace007\\LTC-Digital-Storefront-QA-Dynamic\\src\\test\\resources\\data-excel\\PreferencePageData.xlsx";
		 String headervalue = util.readExcelData(path,1,0);
		 if(intrct.verifyElementText(acknowledgementheaderText,headervalue)){
			 log.info("Pop up header text is present and matching");
			 String contentvalue = util.readExcelData(path,2,0);
			 	if(intrct.verifyElementText(acknowledgementbodyContent,contentvalue)){
			 		log.info("Pop up content is present and matching");
			 		return true;
			 	}else{
			 		log.info("Pop up content is not matching");
			 		return false;
			 	}	 
		 }else{
			 log.info("Pop up header text is not matching");
			 return false ;
		 }
	 }
	 
	 public boolean clickOnAcknowledgmentConfirmationCheckBox() throws InterruptedException{
		 if(intrct.clickElement(acknowledgmentcheckboxOption)){
				log.info("Clicked on acknowledgment checkbox confirmation option ");
				return true;
			} else{
				log.info("Couldn't click on acknowledgment checkbox confirmation option ");
				return false;
			}
	 }
	 
	 public boolean clickConfirmButton() throws InterruptedException{
		 if(intrct.clickElement(confirmBtn)){
				log.info("Clicked on confirm button  succesfully ");
				return true;
			} else{
				log.info("Couldn't click on confirm button ");
				return false;
			}
	 }
	 
	 public boolean verifyPreferencesSavedMessage(String text) throws Exception{
		 String path = "C:\\Eclipse Workspace\\Workspace007\\LTC-Digital-Storefront-QA-Dynamic\\src\\test\\resources\\data-excel\\PreferencePageData.xlsx";
		 if(intrct.verifyElementText(preferencessavedHeaderMessage,text)){
		 		log.info("Preferences saved header text is present and matching");
		 		String bodyMessage = util.readExcelData(path,3,0);
		 				if(intrct.verifyElementText(preferencessavedBodyMessage,bodyMessage)){
		 					log.info("Preferences saved body message text is present and matching");
		 					return true;
		 				}else{
		 					log.info("Preferences saved body message text is not matching");
		 					return false;
		 				}
		 	}else{
		 		log.info("Preferences saved header text is not matching");
		 		return false;
		 	}	 
	 }
	 
	 public boolean verifyPreferencePageHederText(String text){
		 if(intrct.verifyElementText(preferencepageHeaderText,text)){
			 log.info("Preference page header text verified successfully");
			 return true;
		 }else{
			 log.info("Preference page header text couldnt be verified");
			 return false ;
		 }
	 }
	 
	 public boolean verifyPreferencePageBodyContents() throws Exception{
		 String path = "C:\\Eclipse Workspace\\Workspace007\\LTC-Digital-Storefront-QA-Dynamic\\src\\test\\resources\\data-excel\\PreferencePageData.xlsx";
		 ArrayList<String> status = new ArrayList<>();
		 System.out.println("abc");
		 String bodyheader = util.readExcelData(path,4,0);
		 System.out.println("def");
		 if(intrct.verifyElementText(preferencepageBodyHeaderText, bodyheader)){
			 System.out.println("ghi");
			 status.add("true");
			 log.info("Preference page body header text verified ");
		 }else{
			 System.out.println("jkl");
			 status.add("false");
			 log.info("Preference page body header text couldnt be verified ");
		 }
		 
		 System.out.println("mno");
		 String bodyheaderDetails=util.readExcelData(path,5,0);
		 System.out.println("pqr");
		 if(intrct.verifyElementText(bodyheaderdetailstext1, bodyheaderDetails)){
			 System.out.println("tuv");
			 status.add("true");
			 log.info("Preference page body header details text verified ");
		 }else{
			 System.out.println("xyz");
			 status.add("false");
			 log.info("Preference page body header text couldnt be verified ");
		 }
		 
		 System.out.println("123");
		 String emailid=util.readExcelData(path,6,0);
		 String phonenum=util.readExcelData(path,7,0);
		 System.out.println("456");
		 if((intrct.verifyElementText(emaildetails, emailid))&&(intrct.verifyElementText(phonenumberdetails,phonenum))){
			 System.out.println("789");
			 status.add("true");
			 log.info("Email and Phone Number is matching and verified");
		 }else{
			 System.out.println("101112");
			 status.add("false");
			 log.info("Email and Phone Number are not matching or verified");
		 }
		 
		 System.out.println("131415");
		 String claimnotifctnheadr=util.readExcelData(path,8,0);
		 String claimnotifctndtls =util.readExcelData(path,9,0);
		 System.out.println("161718");
		 if((intrct.verifyElementText(claimnotificationheader, claimnotifctnheadr))&&(intrct.verifyElementText(claimnotificationdetails,claimnotifctndtls))){
			 System.out.println("192021");
			 status.add("true");
			 log.info("Claim notification header and details are matching and verified");
		 }else{
			 System.out.println("222324");
			 status.add("false");
			 log.info("Claim notification header and details are not matching or verified");
		 }
		 
		 System.out.println("252627");
		 String whatsnwhdr=util.readExcelData(path,10,0);
		 String whatsnwdtls=util.readExcelData(path,11,0);
		 System.out.println("282930");
		 if((intrct.verifyElementText(whatsnewheader, whatsnwhdr))&&(intrct.verifyElementText(whatsnewbody,whatsnwdtls))){
			 System.out.println("3132333");
			 status.add("true");
			 log.info("What's New header and details are matching and verified");
		 }else{
			 System.out.println("343536");
			 status.add("false");
			 log.info("What's New header and details are not matching or verified");
		 }
		 
		 System.out.println("373839");
		 if(!status.contains("false")){
			 return true;
		 }else{
			 return false;
		 }
	 }
}
