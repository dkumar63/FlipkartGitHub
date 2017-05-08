package TestCases.Flipkart.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductSearch 
{
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void VerifyTitle()
	{
		Assert.assertEquals("Online Shopping Site for Mobiles,Fashion,Books,Electronics,Home Appliances & More @ Flipkart", driver.getTitle());
	}
	
	@Test(priority = 2)
	public void searchiphone6() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("iphone 6");
		driver.findElement(By.xpath("//button[@class='vh79eN' and @type='submit']")).click();
		Thread.sleep(3000);
		boolean visible = driver.findElement(By.xpath("//div[@class='_1QaKk1']/select")).isDisplayed();
		if(visible == true)
		{
		Select selByVisText =new Select(driver.findElement(By.xpath("//div[@class='_1QaKk1']/select")));
		selByVisText.selectByValue("35000");
		System.out.println("Min value 35000 entered ");
		Thread.sleep(2000);
	}
	
		WebElement Apple_sele = driver.findElement(By.xpath("//div[@class='_2kFyHg _-9cJSB']/label/div[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(Apple_sele).build().perform();
		Thread.sleep(2000);
		boolean selected_Apple = driver.findElement(By.xpath("//div[@class='_2kFyHg _-9cJSB']/label/div[1]")).isSelected();
		if(selected_Apple== false)
		{
		driver.findElement(By.xpath("//div[@class='_2kFyHg _-9cJSB']/label/div[1]")).click();
		System.out.println("Brand value Apple Selected.");
	}
	else
	{
		System.out.println("Apple already Selected.");
	}
		Thread.sleep(3000);
		boolean availability = driver.findElement(By.xpath("//div[text()='Availability']")).isDisplayed();
	if(availability==true)
	{
		WebElement available = driver.findElement(By.xpath("//div[text()='Availability']"));
		Actions action = new Actions(driver);
		action.moveToElement(available).click().perform();
		System.out.println("Clicked on Availability :) ");
		Thread.sleep(3000);
		WebElement OutofStock = driver.findElement(By.xpath("//input[@class='_3uUUD5' and @type='checkbox']"));
		js.executeScript("arguments[0].click;", OutofStock);
		action.moveToElement(OutofStock).click().perform();
		Thread.sleep(3000);
	}

	List<WebElement> list = driver.findElements(By.xpath("//div[@class='col col-3-12 col-md-3-12 MP_3W3']"));
	System.out.println("Total Phone is : "+ list.size());
	for(WebElement ele : list)
	{
	WebElement title = ele.findElement(By.xpath("div/a[2]"));
	WebElement price = ele.findElement(By.xpath("div/a[3]/div/div"));
	System.out.println(title.getAttribute("title")+" | "+price.getText());
	System.out.println();
	}
}
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
