package com.qa.ltcdigital.storefrontqadynamic.base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private DriverFactory(){}
	
	private static DriverFactory instance;
	
	public static DriverFactory getInstance(){
		if(instance==null){
			instance  = new DriverFactory();
		}
		return instance;
	}

	public WebDriver getDriver(){
		return driver.get();
	}
	
	public void setDriver(WebDriver driverparam){
		driver.set(driverparam);
	}

	public void closeDriver(){
		if(driver!=null){
			driver.get().close();
			driver.remove();
		}
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

}
