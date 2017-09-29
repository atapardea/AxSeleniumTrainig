package atapardea;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.xml.serializer.Method;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.google.gson.annotations.Until;


public class SencondTest {

	private Logger log = Logger.getLogger(FirstTest.class);
	private String chromeDriverPath = "src/main/resources/chromedriver.exe";
	
	private By searchbar = By.cssSelector("#lst-ib");
	private By firstSearchElement = By.cssSelector(".r>a");
	private By butonCautare = By.cssSelector("input[value*='utare Google']");
	
	//@Test
	public void secondTrainingTest () {
		
		
		

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.ro");	
		
		driver.findElement(searchbar).sendKeys("Selenium");
		driver.findElement(butonCautare).click();
		
		String linkText = driver.findElement(firstSearchElement).getText();
		String link = driver.findElement(firstSearchElement).getAttribute("href");
		
		log.info(linkText + " \n" + link);
		
		driver.findElement(searchbar).clear();		
		driver.findElement(searchbar).sendKeys("Selenese");
		driver.findElement(searchbar).sendKeys(Keys.ENTER);
		
		
		
		driver.close();
	}
	
	
	
	
	//@Test
	public void dragAndDrop () {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");	
		
		Actions builder = new Actions(driver); 
		
		WebElement cercMic = driver.findElement(By.cssSelector("#draggable"));
		WebElement cercMare = driver.findElement(By.cssSelector("#droptarget"));
		
		
		cercMare.click();
		
		Action draganddrop = 
		builder.clickAndHold(cercMic).moveToElement(cercMare).release(cercMare).build();
		
		draganddrop.perform();
		
		
	}
	
		@Test
		public void frameApp () {
	
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/iframe");	
			
			
			driver.switchTo().frame("mce_0_ifr");
			log.info(driver.findElement(By.cssSelector("#tinymce>p")).getText());
		}
		
		
		
		//@Test
		public void javaAlert() throws InterruptedException {
	
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/javascript_alerts");	
			
			
			driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
			Thread.sleep(5000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		@Test
		public void addAlert() {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("http://google.com");	
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("alert('Test!')");
		}
		
		
		
		@Test
		public void waitS() {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("http://google.com");	
			
			//implicit
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//explicit			
//			WebDriverWait wait = new WebDriverWait(driver,10);
//			WebElement webESearchbar= wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar));
//			
			//fluent
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) ;                           
					((FluentWait<WebDriver>) wait).withTimeout(5, TimeUnit.SECONDS);          
					((FluentWait<WebDriver>) wait).pollingEvery(1, TimeUnit.SECONDS) ;         
					((FluentWait<WebDriver>) wait).ignoring(NoSuchElementException.class);
					wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar));
			
		}
}
