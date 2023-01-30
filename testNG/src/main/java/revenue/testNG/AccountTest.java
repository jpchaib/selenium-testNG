package revenue.testNG;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest {
	ChromeDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5173/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void noAccountsOnPageLoad() {
		//p[normalize-space()='There are no accounts to display']
		
		List<WebElement> noAccountsDisplayMessage = driver.findElements(By.xpath("//p[normalize-space()='There are no accounts to display']"));  
		
		Assert.assertEquals(noAccountsDisplayMessage.size(), 1);
		
	}
	
	@Test
	public void showNewAccountOnSubmission() {
		//input[@id='appName']
		//input[@id='username']
		//button[normalize-space()='Submit']
		
		WebElement appName = driver.findElement(By.xpath("//input[@id='appName']"));
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		
		appName.sendKeys("Gmail");
		userName.sendKeys("thisIsMyUserName");
		
		submitButton.click();
		
		List<WebElement> accounts = driver.findElements(By.xpath("//p[normalize-space()='Gmail - thisIsMyUserName']"));
		List<WebElement> noAccountsMessage = driver.findElements(By.xpath("//p[normalize-space()='There are no accounts to display']"));
		
		
		Assert.assertEquals(noAccountsMessage.size(), 0);
		Assert.assertEquals(accounts.size(), 1);
		
		submitButton.click();
		submitButton.click();
		submitButton.click();
		submitButton.click();
		accounts = driver.findElements(By.xpath("//p[normalize-space()='Gmail - thisIsMyUserName']"));
		Assert.assertEquals(accounts.size(), 1);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
			
	}
}
