package com.qa.ltcdigital.storefrontqadynamic.pageobjects;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ltcdigital.storefrontqadynamic.base.DriverFactory;
import com.qa.ltcdigital.storefrontqadynamic.dataobjects.Policy;
import com.qa.ltcdigital.storefrontqadynamic.util.Interaction;

public class HomePage {
	
	Logger log = Logger.getLogger(HomePage.class);
	WebDriver driver= null;
	Interaction intrct= null;
	Policy policy =null;
	public  Properties polprop=null;
			
    @FindBy(xpath="//*[@type='button' and @value='Log Out']")
	WebElement logoutBtn;
    
    @FindBy(xpath="//*[@class='jh-nav']//div//a[@class='headerDropdown__btn']")
    WebElement fullnameLink;
    
    @FindBy(xpath="//*[@class='ui-widget']//div//h4")
    WebElement policyNumber;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]")
    WebElement productLabel;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]//parent::div//span")
    WebElement productText;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]//parent::div//following-sibling::div[1]//label")
    WebElement policystatusLabel;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]//parent::div//following-sibling::div[1]//label//parent::div//span")
    WebElement policystatusText;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]//parent::div//following-sibling::div[2]//label")
    WebElement clientnameLabel;
    
    @FindBy(xpath="//div[@class='slds-card__body']//div//label[contains(text(),'Product')]//parent::div//following-sibling::div[2]//label//parent::div//span")
    WebElement clientnameText;
    
    public HomePage(){
    	driver = DriverFactory.getInstance().getDriver();
    	intrct = Interaction.getInstance();
    	policy = new Policy();
    	try {
			polprop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\policyproperty.properties");
			polprop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	PageFactory.initElements(driver, this);
    }
    
    
    
    public boolean validatePolicyNumber(String value) throws Exception{
    	
    	String text1=null;
    	String text2=policy.verifyPolicyNumber(value);
    	
    	if(policy.Policy_Type.equalsIgnoreCase("retail")){
    		text1=polprop.getProperty("policy_number_retail");
    	}else if (policy.Policy_Type.equalsIgnoreCase("group")){
    	 text1=polprop.getProperty("policy_number_group");
    	}
    	String textval = text1+text2;
    	
    	if(intrct.verifyElementText(policyNumber,textval)){
    		log.info("Policy number matched ");
    		return true;
    	} else{
    		log.info("Policy number couldnt be matched");
			return false;
    	}
    }
    
    public boolean validateProductName(){
    	/*ArrayList<String> arlist = policy.verifyProductName();
    	String text1 = arlist.get(0);
    	String text2 = arlist.get(1);*/
    	
    	String text1=polprop.getProperty("policy_product");
    	String text2=policy.verifyProductName();
    	
    	/*if(policy.Policy_Type.equalsIgnoreCase("retail")){
    		text1=polprop.getProperty("policy_status_retail");
    	}else if (policy.Policy_Type.equalsIgnoreCase("group")){
    	 text1=polprop.getProperty("policy_status_group");
    	}*/
    	
    	if((intrct.verifyElementText(productLabel,text1)) && (intrct.verifyElementText(productText,text2))){
    		log.info("Product details are matched");
    		return true;
    	}else{
    		log.info("Product details are not matched");
    		return false;
    	}
    }
    
    public boolean validatePolicyStatus(){
    	/*ArrayList<String> arlist = policy.verifyPolicyStatus();
    	String text1 = arlist.get(0);
    	String text2 = arlist.get(1);*/
    	
    	String text1=null;
    	String text2=policy.verifyPolicyStatus();
    	
    	if(policy.Policy_Type.equalsIgnoreCase("retail")){
    		text1=polprop.getProperty("policy_status_retail");
    	}else if (policy.Policy_Type.equalsIgnoreCase("group")){
    	 text1=polprop.getProperty("policy_status_group");
    	}
    	
    	if((intrct.verifyElementText(policystatusLabel,text1)) && (intrct.verifyElementText(policystatusText,text2))){
    		log.info("Policy status details are matched");
    		return true;
    	}else{
    		log.info("Policy status detail are not matched");
    		return false;
    	}
    }
    
    public boolean validateClientName(){
    	/*ArrayList<String> arlist = policy.verifyClientName();
    	String text1 = arlist.get(0);
    	String text2 = arlist.get(1);*/
    	
    	String text1=null;
    	String text2=policy.verifyClientName();
    	
    	if(policy.Policy_Type.equalsIgnoreCase("group")){
    		text1=polprop.getProperty("policy_group_client_name");
    	}
    	
    	if((intrct.verifyElementText(clientnameLabel,text1)) && (intrct.verifyElementText(clientnameText,text2))){
    		log.info("Client name details are matched");
    		return true;
    	}else{
    		log.info("Client name details are not matched");
    		return false;
    	}
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
    
    public boolean clickFullName(String fullnamevalue) throws InterruptedException{
    	if(intrct.verifyElementText(fullnameLink, fullnamevalue)){
    		if(intrct.clickElement(fullnameLink)){
    			log.info("Clicked on fullname succesfully ");
    			return true;
    		}else{
    			log.info("Couldnt click on fullname ");
    			return false;
    		}
    	}else{
    		log.info("Element not found "+fullnamevalue);
    		return false;
    	}
    	
    	
    }
    
    public boolean verifyAndClickPreferences(String text) throws InterruptedException{
    	List<WebElement> elmlist = new ArrayList<WebElement>();
    	elmlist = driver.findElements(By.xpath("//*[@class='jh-nav']//div//*[@class='headerDropdown__content']//a"));
    	if(intrct.chooseAndClickElementFromList(elmlist, text)){
    		return true;
    	}else{
    		return false;
    	}
    }
}
