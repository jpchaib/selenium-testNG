package revenue.testNG;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
	ChromeDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com.au");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifyTitle() {
		//Amazon.com.au: Shop online for Electronics, Apparel, Toys, Books, DVDs & more
		String realTitle = driver.getTitle();
		String expectedTitle = "Amazon.com.au: Shop online for Electronics, Apparel, Toys, Books, DVDs & more";
		
		Assert.assertEquals(realTitle, expectedTitle);
	}
	
	@Test
	public void verifyLogo() {
		//a[@id='nav-logo-sprites']
		boolean isDisplayed = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
			
	}
}
