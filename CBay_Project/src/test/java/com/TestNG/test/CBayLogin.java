package com.TestNG.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CBayLogin {
private WebDriver driver;
	
@FindBy(xpath="//input[@name='creditnumber']")
WebElement CreditCardNum;


@FindBy(xpath="//input[@id='loginusername']")
WebElement username;

@FindBy(xpath="//input[@id='loginpassword']")
WebElement password;

@FindBy(xpath="//select[@id='logintype']")
WebElement type;

@FindBy(xpath="html/body/app-root/div[3]/app-home/div[1]/app-logintemp/div/div/div/div/form/button[1]")
WebElement login;
	
	public CBayLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username){
		this.username.sendKeys(username);
	}
	
	public void inputpassword(String password){
		this.password.sendKeys(password);
	}
	
	public void inputType(String type){
		this.type.sendKeys(type);
	}
	
	public void submitLoginCredentials(){
		this.login.click();
	}
	
	public void driverLogIn(String username, String password, String Type){
		inputUsername(username);
		inputpassword(password);
		inputType(Type);
		submitLoginCredentials();
	}
}