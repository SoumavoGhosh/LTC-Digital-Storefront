package com.qa.ltcdigital.storefrontqadynamic.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ltcdigital.storefrontqadynamic.base.DriverFactory;
import com.qa.ltcdigital.storefrontqadynamic.util.Interaction;

public class LoginPage {
	
	Logger log  = Logger.getLogger(LoginPage.class);
	
	WebDriver driver  =  null;
	Interaction intrct = null;
	
	@FindBy(id="userName")
	WebElement username;
	
	@FindBy(id="passwordField")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public LoginPage(){
		driver= DriverFactory.getInstance().getDriver();
		intrct= Interaction.getInstance();
		PageFactory.initElements(driver,this);
	}
	
	public boolean setUsername(String usernamevalue) throws InterruptedException{
		if(intrct.setTextToElement(username, usernamevalue)){
			log.info("Set value to username "+usernamevalue);
			return true;
		}else{
			log.info("Couldn't set value to username "+usernamevalue);
			return false;
		}
	}
	
	public boolean setPassword(String passwordvalue){
		if(intrct.setTextToElement(password, passwordvalue)){
			log.info("Set value to password "+passwordvalue);
			return true;
		}else{
			log.info("Couldn't set value to password "+passwordvalue);
			return false;
		}
	}
	
	
	public boolean clickLoginButton() throws InterruptedException{
		if(intrct.clickElement(loginBtn)){
			log.info("Clicked succesfully login button ");
			return true;
		} else{
			log.info("Couldn't click login button ");
			return false;
		}
	}
	
}
