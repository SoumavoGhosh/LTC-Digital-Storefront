package com.qa.ltcdigital.storefrontqadynamic.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
	
	WebDriver driver = null;
	
	public WebDriver chooseBrowser(String browsername){
		
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions coptions= new ChromeOptions();
			coptions.addArguments("--disable-popup-blocking");
			coptions.addArguments("---disable-notifications");
			driver = new ChromeDriver(coptions);
		} else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addPreference("dom.disable_beforeunload", true);
			driver= new FirefoxDriver(foptions);
		}
		return driver;
	}
	

}
