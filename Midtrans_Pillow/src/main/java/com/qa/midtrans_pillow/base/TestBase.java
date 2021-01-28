package com.qa.midtrans_pillow.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.midtrans_pillow.pageobjects.PaymentPage;
import com.qa.midtrans_pillow.util.TestUtil;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//public Interaction intrct;
	public PaymentPage paypage;
	
	public TestBase(){
		
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config_reader\\config.properties\\"); //"C:\\Eclipse Workspace\\Workspace007\\Midtrans_Pillow\\src\\test\\resources\\config_reader\\config.properties"
			prop.load(ip);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 
	}
	
	public  void initialization(){
	
		String browser= prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else{
			System.out.println("Default Browser");
		}
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	    //intrct = new Interaction();
	    //new PaymentPage(driver);
	}

	public boolean switchToFrame() throws InterruptedException {
		Thread.sleep(8000);
		driver.switchTo().frame("snap-midtrans");
		paypage = new PaymentPage();
		return true;
		
	}
	
	public boolean verifyFrameElements(String text) throws InterruptedException {
		Thread.sleep(4000);
		return paypage.verifyTextValue(text);
	}
	
	public PaymentPage ClickFrameElements() throws InterruptedException{
		 return paypage;
	}
	
	public void closeBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
	
	/*public static String getReportConfigPath() {
		String reportConfigPath = prop.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}*/
}

