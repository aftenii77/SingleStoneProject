package com.singleStone.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
private static WebDriver driver;
	
	@Before 
	public void setDriver() {
		
		System.setProperty(Config.getProperty("webdriver"), 
				Config.getProperty("driverpath"));
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	    
	    Base.driver = driver;
	}
	
	@After
	public void tearDown(){
		//closing the browser after the execution
		driver.close();
	}

}
