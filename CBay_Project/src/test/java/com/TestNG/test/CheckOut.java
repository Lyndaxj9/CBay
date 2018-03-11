package com.TestNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	
private WebDriver driver;
	
	@FindBy(xpath="/html/body/app-root/div[3]/app-singleitem/div[1]/div/input")
	WebElement addQuantity;

	@FindBy(xpath="//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a")
	WebElement checkout;
	
	@FindBy(xpath="//*[@id=\"flipkart-navbar\"]/div/div[1]/ul/li[2]/a")
	WebElement signout;

		
		public CheckOut(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		public void setQuantity(String quantity){
			this.addQuantity.sendKeys(quantity);
		}
		
		public void clickToCheckOut() {
			this.checkout.click();
		}
		
		
		
		public void SignOut() {
			this.signout.click();
		}
		

}
