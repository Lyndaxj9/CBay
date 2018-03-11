package com.TestNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CBayDriver {
	public static WebDriver driver;
	public final String url = "http://localhost:4200/cbay/";
	public CBayLogin LoginPage;
	
	
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
	public void confirmHomepage() {
		AssertJUnit.assertEquals(driver.getTitle(), "CBAY");
	}
	
	@Test(dependsOnMethods = "confirmHomepage",groups={"Excluded","Included"})
	public void logInToCBay() {
		LoginPage = new CBayLogin(driver);
		LoginPage.driverLogIn("JDoe", "JDoe", "seller");
		AssertJUnit.assertEquals(driver.getTitle(), "CBAY");
	}
}
