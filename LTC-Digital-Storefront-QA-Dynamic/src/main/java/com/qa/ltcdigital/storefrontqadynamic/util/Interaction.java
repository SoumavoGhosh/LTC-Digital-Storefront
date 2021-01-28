package com.qa.ltcdigital.storefrontqadynamic.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ltcdigital.storefrontqadynamic.base.DriverFactory;




public class Interaction {

	 Logger log = Logger.getLogger(Interaction.class);
	 WebDriver driver= null;
	 
	private Interaction() {
		driver = DriverFactory.getInstance().getDriver();
	}

	private static Interaction instance ;
	
	public static Interaction getInstance() {
		if (instance == null) {
			instance = new Interaction();
		}
		return instance;
	}

	public  boolean waitForElement(WebElement element) {
		
		WebElement elm = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		if (elm != null) {
			return true;
		} else {
			return false;
		}
	}

	public  boolean chooseAndClickElementFromList(List<WebElement> list, String text) throws InterruptedException{

		if (list.size() != 0) {
			for (WebElement elmnt : list) {
				if (elmnt.getText().trim().equalsIgnoreCase(text)) {
					return clickElement(elmnt);
				}
				/*
				 * else{ System.out.println("Element is :"+elmnt.getText()); }
				 */
			}
		} else {
			log.info("list is empty");
			return false;
		}
		return false;
	}

	public  boolean clickElement(WebElement element) throws InterruptedException {

		if (waitForElement(element)) {
			element.click();
			Thread.sleep(3000);
			return true;
		} else
			log.info("Couldnt click on " + element.getText());
		return false;
	}

	public  boolean setTextToElement(WebElement element, String text) {
		
		if (waitForElement(element)) {
			element.clear();
			element.sendKeys(text);
			return true;
		} else {
			log.info("Couldnt set value " + text);
			return false;
		}
	}
	
	public boolean verifyElementText(WebElement element,String text){
		if (waitForElement(element)) {
			if(element.getText().trim().equalsIgnoreCase(text)){
				return true;
			}else{
				log.info(element.getText()+" is not matching with " + text);
				return false;
			}
			
		} else {
			log.info("Element not found "+ text);
			return false;
		}
	}
	
	public boolean compareText(String text1,String text2){
		if(text1.equalsIgnoreCase(text2)){
			return true;
		}else{
			log.info(text1+" is not matching with "+text2);
			return false;
		}
	}
}
