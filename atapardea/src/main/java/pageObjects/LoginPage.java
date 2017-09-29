package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By usernameField = By.xpath(".//*[@id='loginUserId']");
	private By passwordField = By.xpath(".//*[@id='loginPassword']");
	private By loginButton = By.xpath(".//*[@id='N1007B']");
	private WebDriver driver ;
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	public GettingStartedPage loginAction(String username, String password) {
		
		type(usernameField,username);
		type(passwordField,password);
		click(loginButton);
		return new GettingStartedPage(driver);
	
	}
	
	public void type(By element, String input) {
	
	driver.findElement(element).sendKeys(input);
	
	}
	public void click(By element){
		driver.findElement(element).click();
	}
}
