package com.TestNG.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CBayDriver {
	public static WebDriver driver;
	public final String url = "http://localhost:4200";
	public CBayLogin LoginPage;
	public EditProfilePage EditPage;
	public SearchForItem SearchItem;
	public AddItemToCart addItem;
	public CheckOut checkout;
	
	
	@BeforeTest(groups={"setup"})
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@AfterTest(groups={"teardown"})
	public void teardown() throws InterruptedException {
		Thread.sleep(2500);
		driver.quit();
	}
	
	@Test(priority = 0, groups={"Excluded","Included"})
	public void ConfirmHomePage() {
		AssertJUnit.assertEquals(driver.getTitle(), "CBAY");
	}
	
	@Test(priority = 1, groups={"Excluded","Included"})
	public void logInToCBay() {
		LoginPage = new CBayLogin(driver);
		LoginPage.driverLogIn("RRob", "RRob", "buyer");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Profile"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div[3]/app-profile/div[3]/div/div[3]/h4/a")));


	}
	
	@Test(priority = 2, groups={"Excluded","Included"})
	public void ConfirmProfileLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "Profile");
	}

	
	@Test(priority = 3, groups={"Excluded","Included"})
	public void EditProfile() {
		EditPage = new EditProfilePage(driver);
		EditPage.editProfile("EditedEmail@Test.com");
		
	}
	
	
	
	
	@Test(priority = 4, groups={"Excluded","Included"})
	public void SearchItem() {
		SearchItem = new SearchForItem(driver);
		SearchItem.SearchItem("Tv");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Search Results"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div[3]/app-items/footer/div/div/div[3]/p")));
		
	}
	
	
	@Test(priority = 5, groups={"Excluded","Included"})
	public void ConfirmSearchLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "Search Results");
	}
	
	
	@Test(priority = 6, groups={"Excluded","Included"})
	public void ClickItem() {
		SearchItem = new SearchForItem(driver);
		SearchItem.ClickItem();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Item Information"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div[3]/app-singleitem/div[2]/app-reviews/footer/div/div/div[3]/p")));
		
	}
	

	@Test(priority = 7, groups={"Excluded","Included"})
	public void ConfirmItemLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "Item Information");
	}
	
	
	
	@Test(priority = 8, groups={"Excluded","Included"})
	public void AddItemToCart() {
		  
		 addItem = new AddItemToCart(driver);
		 addItem.addToCart("3");
		 //Thread.sleep(500);
		 addItem.goToCart();
		 
		WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("Cart"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a")));

		 
	}
	
	
	/*@Test(priority = 9, groups={"Excluded","Included"})
	public void goToCart() {
		  
		 addItem = new AddItemToCart(driver);
		 addItem.goToCart();
		 
		 
		 WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("Cart"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a")));
			
	}*/
	
	
	@Test(priority = 10, groups={"Excluded","Included"})
	public void ConfirmCartLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "Cart");
	}	
		
	
	
	@Test(priority = 11, groups={"Excluded","Included"})
	public void CheckOut() {
		  
		checkout = new CheckOut(driver);
		checkout.clickToCheckOut();
		 
		 
		 WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("Orders"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[1]/a")));
			
	}
	
	
	@Test(priority = 12, groups={"Excluded","Included"})
	public void ConfirmOrderLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "Orders");
	}	
	
	
	
	@Test(priority = 13, groups={"Excluded","Included"})
	public void SignOut() {
		  
		checkout = new CheckOut(driver);
		checkout.SignOut();
		 
		 
		 WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("CBAY"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div[3]/app-home/div[2]/app-registertemp/div/div/div/div/form/button[2]")));
			
	}
	
	
	@Test(priority = 14, groups={"Excluded","Included"})
	public void ConfirmSignOutLanding() {
		AssertJUnit.assertEquals(driver.getTitle(), "CBAY");
	}
	
	
}
