package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GettingStartedPage {

	
	private WebDriver driver ;
	private By welcomeMessage = By.xpath(".//*[@id='content']/tbody/tr/td/div[1]");
	
	public GettingStartedPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getTitle (){
		return driver.findElement(welcomeMessage).getText();
		
	}
	
}
