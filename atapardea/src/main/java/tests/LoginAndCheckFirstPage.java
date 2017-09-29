package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.GettingStartedPage;
import pageObjects.LoginPage;

public class LoginAndCheckFirstPage {
	
	final String chromeDriverPath = "src/main/resources/chromedriver.exe";
	WebDriver driver;
	
	@BeforeClass
	public void setUp (){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		 driver = new ChromeDriver();
	}
	
	
	@Test
	public void loginAndCheckFirstPage() {
		
		driver.get("http://lsusats001.lab.phx.axway.int:6080/ui/");
		
		LoginPage login=new LoginPage(driver);
		GettingStartedPage gsp = login.loginAction("admin", "Secret01");
		Assert.assertEquals("Getting started", gsp.getTitle());
	}

}
