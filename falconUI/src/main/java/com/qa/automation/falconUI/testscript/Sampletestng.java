package com.qa.automation.falconUI.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

   public class Sampletestng {
	
    WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Seshu.Garikapati\\eclipse-workspace\\falconUI\\lib\\chromedriver.exe");
		
		driver = new ChromeDriver();

	}

	@Test(priority=1)
	public void testcase()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/");
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		System.out.println("Current URL ="+ driver.getCurrentUrl());
	}
	
	@Test(priority=2)
	public void Register() throws InterruptedException
	{
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Roja");
	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Garikapati");
	   driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rojagarikapati@gmail.com");
	   driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("7207111040");
	   List<WebElement> rad=driver.findElements(By.xpath("//input[@type='radio']"));
	   rad.get(1).click();
	   List<WebElement> check=driver.findElements(By.xpath("//input[@type='checkbox']"));
	   for(int i=0;i<check.size();i++)
	   {
		   check.get(i).click();
	   }
	   
	   WebElement Country=driver.findElement(By.xpath("//select[@id='countries']"));
	   Select countryname=new Select(Country);
	   countryname.selectByVisibleText("India");
		WebElement Year=driver.findElement(By.xpath("//select[@id='yearbox']"));
		Select year=new Select(Year);
		year.selectByVisibleText("1983");
		WebElement Month=driver.findElement(By.xpath("//select[@type='text' and @ng-model='monthbox']"));
		Select month=new Select(Month);
		month.selectByVisibleText("September");
		WebElement Day=driver.findElement(By.xpath("//select[@id='daybox']"));
		Select day=new Select(Day);
		day.selectByVisibleText("6");
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("Cherry123");
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("Cherry123");
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

	}
	

	@Test(priority=3)
	public void Interactions()
	{
		WebElement inter=driver.findElement(By.xpath("//a[contains(text(),'Interactions')]"));
	    Actions element=new Actions(driver);
	    element.moveToElement(inter).build().perform();
		WebElement dragndrop=driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop ')]"));
        element.moveToElement(dragndrop).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Static ')]")).click();
	   	}
	
	@AfterTest
	public void aftertest() throws InterruptedException
	{
		System.out.println("Current URL ="+ driver.getCurrentUrl());
		Assert.assertTrue(driver.findElement(By.xpath("//img[@id='angular']")).isDisplayed());
		Thread.sleep(2000);
		driver.quit();
	}

	

}
