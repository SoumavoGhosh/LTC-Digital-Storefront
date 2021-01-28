package com.qa.midtrans_pillow.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.midtrans_pillow.base.TestBase;
import com.qa.midtrans_pillow.util.Interaction;



public class PaymentPage extends TestBase {
	
	//public static WebDriver driver = TestBase.driver;
	Logger  log = Logger.getLogger(PaymentPage.class);
	
	@FindBy(xpath="//a[@class='btn buy']")
	WebElement buy_now_button;
	
	@FindBy(xpath="//div[@class='cart-checkout']")
	WebElement check_out_button;
	
	@FindBy(xpath="//*[@id='header']//*[@class='logo-store']")
	WebElement coco_store_header;
	
	@FindBy(xpath="//*[@id='header']//*[@class='text-page-title-content']")
	WebElement order_summary_header;
	
	@FindBy(xpath="//*[@class='amount']//div[@class='amount-title pull-left']//span[@class='text-amount-title']")
	WebElement amount_header;
	
	@FindBy(xpath="//*[@class='amount']//div[@class='amount-content pull-right']//span[@class='text-amount-amount']")
	WebElement amount_value;
	
	@FindBy(xpath="//ul[@class='nav-tabs nav-justified']//a//span[text()='order details']")
	WebElement order_details_header;
	
	@FindBy(xpath="//ul[@class='nav-tabs nav-justified']//a//span[text()='shipping details']")
	WebElement shipping_details_header;
	
	@FindBy(xpath="//a[contains(@href,'#/select-payment')]")     //div[@class='button-main show']//div//span
	WebElement continue_button;
	
	@FindBy(xpath="//a[contains(@href,'#/credit-card')]")
	WebElement payment_mode;
	
	@FindBy(name="cardnumber")
	WebElement cardnumber;
	
	@FindBy(xpath="//input[@type='tel' and @placeholder='MM / YY']")
	WebElement cardexpiry;
	
	@FindBy(xpath="//input[@type='tel' and @inputmode='numeric']")
	WebElement cardcvv;
	
	@FindBy(xpath="//a[@class='button-main-content']")  //span[text()='Pay Now']
	WebElement pay_now_button;
	
	@FindBy(xpath="//input[@type='password' and @name='PaRes']")  //PaRes   //input[@type='password' and @placeholder='112233']   //*[@id='merchant_name']/../../following-sibling::div)[4]/div/input
	WebElement password;
	
	@FindBy(name="ok")
	WebElement submit_button;
	
	@FindBy(xpath="//*[contains(text(),'Transaction successful')]") //div[@class='text-success text-bold']  //*[contains(text(),'Transaction successful')]
	WebElement success_message;
	
	@FindBy(xpath="//*[contains(text(),'Transaction failed')]")
	WebElement failed_message;
	
	@FindBy(xpath="//*[contains(@src,'https://api.sandbox.veritrans.co.id/v2/token/rba/redirect/')]")
	WebElement form_frame;
	
	public PaymentPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean clickBuyNow(){
		log.info("Clicked on Buy Now button");
		return Interaction.clickWebElement(buy_now_button);
	}
	
	public boolean clickCheckOut(){
		log.info("Clicked on Check Out button");
		return Interaction.clickWebElement(check_out_button);
	}
	
	public boolean verifyTextValue(String text) throws InterruptedException/*, AWTException*/{
		
		/*Thread.sleep(3000);
		
		driver.switchTo().activeElement();
		driver.switchTo().frame("popup_1608054409080");
		driver .switchTo().alert();
		driver.findElement(By.id("application")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		driver.switchTo().window(it.next());
		driver.switchTo().window(it.next());
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		
		switch (text) {
		case "COCO STORE":
			return Interaction.verifyTextForWebElement(coco_store_header, text);
		default:
			return false;
		}
	}*/
		
		switch (text) {
		case "COCO STORE":
			log.info("Verified header - 'Coco Store'");
			return Interaction.verifyTextForWebElement(coco_store_header, text);
		case "Order Summary":
			log.info("Verified header - 'Order Summary'");
			return Interaction.verifyTextForWebElement(order_summary_header, text);
		case "amount":
			log.info("Verified header - 'Amount'");
			return Interaction.verifyTextForWebElement(amount_header, text);
		case "20,000":
			log.info("Verified amount value to be - '20,000'");
			return Interaction.verifyTextForWebElement(amount_value, text);
		case "order details":
			log.info("Verified header - 'Order Details'");
		    return Interaction.verifyTextForWebElement(order_details_header, text);
		case "shipping details":
			log.info("Verified header - 'Shipping Details'");
		    return Interaction.verifyTextForWebElement(shipping_details_header, text);
		default:
			return false;
		}
	}
	
	
	public boolean verifyTableContents(){
		WebElement elm=null;
		boolean[] b1 = new boolean[4];
		
		for(int i=1;i<=2;i++){
			elm= driver.findElement(By.xpath("//div[@class='content-table']//table[@class='table']//tr//th["+i+"]"));
			b1[i-1]= Interaction.verifyTextForWebElement(elm,elm.getText());
		}	
		
		for(int i=1;i<=2;i++){
			if(i==1){
			elm= driver.findElement(By.xpath("//div[@class='content-table']//table[@class='table']//tr//td["+i+"]//span"));
			}
			else{
			elm= driver.findElement(By.xpath("//div[@class='content-table']//table[@class='table']//tr//td["+i+"]"));
			}
			b1[i+1]= Interaction.verifyTextForWebElement(elm,elm.getText());
		}
		
		for (int i=0 ; i<b1.length;i++){
			if(!b1[i]){
				return false;
			}
		}
		return true;
	}
	
	public boolean clickContinue() throws InterruptedException/*, AWTException*/{
		Thread.sleep(4000);
		/*Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);*/
		log.info("Clicked on Continue button");
		return Interaction.clickWebElement(continue_button);
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeAsyncScript("arguments[0].click();", continue_button);
		return true;*/
	}
	
	public boolean choosePaymentMode() throws InterruptedException, AWTException{
		/*Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);*/
		//robot.keyPress(KeyEvent.VK_TAB);
		/*Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);*/
		//return true;
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(4000);
		//return true;
		log.info("Selected Payment Mode");
		return Interaction.clickWebElement(payment_mode);
	}
	
	public boolean  setCardNumber(String text){
		log.info("Set Card Number");
		return Interaction.setTextElement(cardnumber,text);
	}
	
	public boolean setCardCVV(String text){
		log.info("Set Card CVV");
		return Interaction.setTextElement(cardcvv, text);
	}
	
	public boolean setCardExpiry(String text){
		log.info("Set Card Expiry");
		return Interaction.setTextElement(cardexpiry,text);
	}
	
	public boolean clickPayNow(){
		log.info("Clicked Pay Now");
		return Interaction.clickWebElement(pay_now_button);
	}
	
	public boolean switchNextFrame() throws InterruptedException{
	 Thread.sleep(4000);
	 //driver.switchTo().frame(form_frame);
	 //driver.switchTo().defaultContent();
	 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	 System.out.println(driver.findElement(By.id("card_number")).getText());
	 return true;
	}
	
	public boolean setPassword(String text) throws InterruptedException, AWTException{
		Thread.sleep(4000);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		/*js.executeScript("document.getElementsByName('MD')[0];");
		js.executeScript("document.getElementsByName('Status')[0];");*/
		//js.executeScript("arguments[0].setAttribute('innerHTML',text)", password);
		//return true;
		/*js.executeScript("document.getElementsByName('PaRes')[0].setAttribute('type', 'text');");
		password.clear();
		password.sendKeys(text);
		return true;*/
	 //System.out.println(driver.findElement(By.id("//*[@id='merchant_name']")).getText());
	 //return true;
		/*if(Interaction.clickWebElement(password)){
			return Interaction.setTextElement(password,text);
		}else {
			return false;
		}*/
		
		if(password!=null){
		password.clear();
		password.sendKeys(text);
		log.info("Set Password");
		return true;
		}
		else {
			log.info("Couldnt set Password");
			return false;
		}
		
		/*Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_3);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_3);
        return true;*/
	}
	
	public boolean clickSubmit() throws InterruptedException{
		log.info("Clicked on Sumbit button");
		 return Interaction.clickWebElement(submit_button);
		 /*if(driver.switchTo().defaultContent() != null){
			 Thread.sleep(2000);
			 if(success_message.isDisplayed()){
				 System.out.println(success_message.getText());
					return true;
			 }
					else 
						return false;
			 
		 } else{
				System.out.println("Frame not switched");
				return false;
			}*/
		 
	}
	
	public boolean verifyTransactionCompletion() throws InterruptedException{
		//Thread.sleep(4000);
		driver.switchTo().parentFrame();

		//driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));

		//if(success_message!=null){
			//password.clear();
			//String str= driver.findElement(By.xpath("//div[@class='text-success text-bold']")).getText();
			//String javascript = "document.evaluate('//*[contains(text(),'Transaction successful')]',document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;";  
			//System.out.println(driver.findElement(By.tagName("iframe")).getText());

			//Object s = jsExecutor.executeScript("return document.body.innerHTML;",null).toString();

			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", success_message);
			//WebElement element = (WebElement)(jsExecutor.executeScript(javascript));
			
			//WebElement elm =  new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(success_message));
			//Thread.sleep(8000);
			//driver.manage().timeouts().setScriptTimeout(8, TimeUnit.SECONDS);
			///jsExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
			//String text = (String) jsExecutor.executeScript("return document.getElementByClassName(\'text-success text-bold\').value");

			if(success_message.isDisplayed()){
				log.info("Succesful transaction");
			return true;
			}
			else {
				log.info("Un-Succesful transaction");
				return false;
			}
			//}
			//else {
				//return false;
			//}
		}
		/*else{

			return false;
		}*/
		//return driver.findElement(By.cssSelector(".text-success text-bold")).isDisplayed();
		//Thread.sleep(4000);
		/*System.out.println(driver.findElement(By.css).getText());
		if(success_message.isDisplayed()){
			return true;
		}
		else if(failed_message.isDisplayed()){
			return false;
		}
		else {
			return false;
		}*/
		
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.('periodId').style.display='block';");*/
	//}
	
	public boolean verifyUnSuccesfulTransactionCompletion(){
		driver.switchTo().parentFrame();
		if(failed_message.isDisplayed()){
			log.info("Un-Succesful transaction");
			return true;
		}
			else {
				log.info("Succesful transaction");
				return false;
			}
	}
}
