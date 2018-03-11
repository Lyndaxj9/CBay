package com.TestNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemToCart {
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/app-root/div[3]/app-singleitem/div[1]/div/input")
	WebElement addQuantity;

	@FindBy(xpath="/html/body/app-root/div[3]/app-singleitem/div[1]/div/button")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id=\"flipkart-navbar\"]/div/div[2]/div[3]/a")
	WebElement goCart;

		
		public AddItemToCart(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		public void setQuantity(String quantity){
			this.addQuantity.sendKeys(quantity);
		}
		
		public void clickToCart() {
			this.addToCart.click();
		}
		
		public void addToCart(String quantity) {
			setQuantity(quantity);
			this.addToCart.click();
		}
		
		public void goToCart() {
			this.goCart.click();
		}
		
}
