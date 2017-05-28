package TestCases.Flipkart.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class HomePage 
{
	WebDriver driver;
	@BeforeTest
	public void set()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getUrl());
		driver.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	@Test
	public void VerifyTitle()
	{
		System.out.println("Title is : "+driver.getTitle());
	}
}
