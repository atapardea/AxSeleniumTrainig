package atapardea;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest {
	
	private Logger log = Logger.getLogger(FirstTest.class);
	private String chromeDriverPath = "/src/main/resources";
	private By hplogo = By.id("hplogo");
	
	
	private By byNameElement = By.name("btnI");
	private By byclassName = By.className("gsst_a");
	private By byLink = By.linkText("magyar");
	private By byCss = By.cssSelector("input[value*='napom']");
	private By byXpath = By.xpath("//*[contains(text(),'About')]");
	

	@Test
	public void firstT() throws InterruptedException {
		
		final String chromeDriverPath = "src/main/resources/chromedriver.exe";
		

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.ro");
		
		
		
		
//		log.info("---------------");
//		log.info(driver.findElement(hplogo).getAttribute("title"));
		log.info("---------------");
		
		
		// DIFF ELEMENTS, DIFF LOCATORS
		
		
		//name
		//driver.findElement(byNameElement).click();
		
		//class
//		driver.findElement(byclassName).click();
		
		//linkText byLink
//		driver.findElement(byLink).click();
		
		//by css
//		driver.findElement(byCss).click();
		
		//by xpath
//		driver.findElement(byXpath).click();
		
		
	

		
		// SAME BUT DIFF LOCATORS
		
		//XPATH
		driver.findElement(By.xpath("//*[contains(text(),'Publicitate')]")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		
		//CSS
		driver.findElement(By.cssSelector("a[href*='ads']")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		
		
		//LINKTEXT
		driver.findElement(By.linkText("Publicitate")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
