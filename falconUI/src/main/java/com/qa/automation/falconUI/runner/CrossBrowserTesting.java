package com.qa.automation.falconUI.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void example(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.IE.driver", "C:\\Users\\Seshu.Garikapati\\eclipse-workspace\\falconUI\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Seshu.Garikapati\\eclipse-workspace\\falconUI\\lib\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	}

    @Test(priority=1)
    public void sample()
    {
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://demo.automationtesting.in/");
    }

    @AfterTest
    public void aftertest()
    {
    	driver.quit();
    	
    }
}
