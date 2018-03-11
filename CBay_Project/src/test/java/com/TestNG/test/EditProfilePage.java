package com.TestNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {

	
	@FindBy(xpath="/html/body/app-root/div[3]/app-profile/div[2]/app-entity-display/div/form/button")
	WebElement editButton;

	@FindBy(xpath="/html/body/app-root/div[3]/app-profile/div[2]/app-entity-display/div/form/div[3]/div/input")
	WebElement Email;
	
	@FindBy(xpath="/html/body/app-root/div[3]/app-profile/div[3]/div/div[2]/div/h4/a")
	WebElement goCart;
	
	
	
	public EditProfilePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void startEdit() {
		this.editButton.click();
	}
	
	public void editEmail(String Email){
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void saveEdit() {
		this.editButton.click();
	}
	
	
	public void editProfile(String Description) {
		 startEdit();
		 editEmail(Description);
		 saveEdit();
	}
	
	public void goToCart() {
		this.goCart.click();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


