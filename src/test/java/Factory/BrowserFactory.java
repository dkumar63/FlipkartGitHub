package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory 
{
	static WebDriver driver;
	public static WebDriver getBrowser(String browsername)
	{		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().ChromePath());
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().IEPath());
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().FirefoxPath());
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void CloseBrowser()
	{
		driver.quit();
		
	}
}
