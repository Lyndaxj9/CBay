package com.TestNG.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CBayLogin {
private WebDriver driver;
	
	private By username = By.xpath("//input[@id='loginusername']");
	private By password = By.xpath("//input[@id='loginpassword']");
	private By type = By.xpath("//select[@id='logintype']");
	private By login = By.linkText("Login Here");
	
	public CBayLogin(WebDriver driver){
		this.driver = driver;
	}
	
	public void inputUsername(String username){
		driver.findElement(this.username).sendKeys(username);
	}
	
	public void inputpassword(String password){
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void inputType(String password){
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void submitLoginCredentials(){
		driver.findElement(this.login).click();
	}
	
	public void driverLogIn(String username, String password, String Type){
		inputUsername(username);
		inputpassword(password);
		inputType(Type);
		submitLoginCredentials();
	}
}