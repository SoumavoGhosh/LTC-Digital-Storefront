package com.qa.midtrans_pillow.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.midtrans_pillow.base.TestBase;



public  class Interaction extends TestBase {
		
	//public static WebDriver driver = TestBase.driver;
	/*private static WebDriver driver;
	
	public Interaction(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public static  boolean waitForElement(WebElement element){
		
		WebElement elm =  new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
		if(elm!=null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static  boolean clickWebElement(WebElement element){
	
		if (waitForElement(element)) {
			if (element.isEnabled()) {
				element.click();
				return true;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public static void takeSnapshot() {

		String screenshotPath = "C:\\Eclipse Workspace\\Workspace007\\Midtrans_Pillow\\target\\Snapshots" +"PaymentPage"+ ".png";
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(screenshotPath);
			FileUtils.copyFile(sourcePath, destinationPath);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static boolean verifyTextForWebElement(WebElement element,String text){
		
		if(waitForElement(element))
		{
			if(element.getText().equalsIgnoreCase(text)){
				return true;
			}
			else {
			return false;
			}
		}else{
			return false;
		}
	}
	
	
	public static boolean setTextElement(WebElement element, String textToSet) {
		
		if (waitForElement(element)) {
			element.sendKeys(textToSet);
			return true;
		}
		return false;
	}

}
