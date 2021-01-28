package com.qa.ltcdigital.storefrontqadynamic.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.ltcdigital.storefrontqadynamic.util.TestUtil;

public class TestBase {
	
	public  Properties prop;
	public WebDriver driver;
		
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void launchBrowser(){
		DriverFactory.getInstance().setDriver(new BrowserFactory().chooseBrowser(prop.getProperty("browser")));
	    driver = DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void closeBrowser(){
		DriverFactory.getInstance().closeDriver();
	}
}
