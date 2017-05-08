package TestCases.Flipkart.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductSearch 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	@Test
	public void ProductInfo()
	{
		System.out.println("Title of the page is : "+driver.getTitle());
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
