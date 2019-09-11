package com.qa.automation.falconUI.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class demoautomation {
	   WebDriver driver; 

	@Test
	public void autodemo() throws InterruptedException
	{
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seshu.Garikapati\\eclipse-workspace\\falconUI\\lib\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/");
    driver.findElement(By.xpath("//img[@id='enterimg']")).click();
	Thread.sleep(2000);
	WebElement element=driver.findElement(By.xpath("//select[@id='Skills']"));
	Select ele=new Select(element);
	JavascriptExecutor je= (JavascriptExecutor) driver;
	Thread.sleep(5000);
	je.executeScript("scroll(0, 200)");
	Thread.sleep(2000);
	ele.selectByIndex(13);
	List<WebElement> rad=driver.findElements(By.xpath("//input[@type='radio']"));	
     rad.get(1).click();
     List<WebElement> check=driver.findElements(By.xpath("//input[@type='checkbox']"));
     for(int i=0;i<check.size();i++)
     {
    	 check.get(i).click();
     }
     Thread.sleep(5000);
   WebElement sele=driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[1]"));
 	Actions act=new Actions(driver);
 	act.moveToElement(sele).build().perform();
    driver.findElement(By.xpath("//a[contains(text(),'Alerts')]")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]")).click();
    driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]")).click();
    System.out.println(driver.switchTo().alert().getText());
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    
    Thread.sleep(5000);

     driver.close();
     }
}


