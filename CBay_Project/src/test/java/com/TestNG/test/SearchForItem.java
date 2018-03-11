package com.TestNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForItem {

	private WebDriver driver;

	@FindBy(xpath="/html/body/app-root/div[3]/app-items/div/div/div/div[2]/div[3]/div/div[2]")
	WebElement SelectItem;
	
	@FindBy(xpath="//*[@id=\"flipkart-navbar\"]/div/div[2]/div[2]/div/input")
	WebElement SearchBar;

	@FindBy(xpath="//*[@id=\"flipkart-navbar\"]/div/div[2]/div[2]/div/button")
	WebElement SearchButton;

		
		public SearchForItem(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		public void typeItem(String search){
			this.SearchBar.sendKeys(search);
		}
		
		public void ClickToSearch() {
			this.SearchButton.click();
		}
		
		public void SearchItem(String search){
			typeItem(search);
			ClickToSearch();
		}
		
		public void ClickItem() {
			this.SelectItem.click();
		}
		
}
