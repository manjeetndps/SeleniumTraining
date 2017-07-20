package com.training.abcofselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.webdriverhelper.DriverUtility;

public class WebDriverWaitCommands extends DriverUtility{

	
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public void fluentWait(){
	Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(Exception.class);
	}
	
	public void explicitWait(WebElement element){

		WebDriverWait waitForElementPresence = new WebDriverWait(driver, 30);
		waitForElementPresence.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		}
	
}
