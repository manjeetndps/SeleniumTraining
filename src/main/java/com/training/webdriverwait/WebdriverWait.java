/**
 * Author:- Manjeet Kumar
 */

package com.training.webdriverwait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.webdriverhelper.DriverUtility;

public class WebdriverWait extends DriverUtility{
	
	private static long timeout=60;
	
	public static void waitForElementPresent(WebElement element)
	{
		try
		{
			WebDriverWait waitForElementPresence = new WebDriverWait(driver, timeout);
			waitForElementPresence.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex)
		{
			Assert.fail(timeout+" Seconds Waited For Element '"+element+"'  "+ex.getMessage());
		}

	}
	public static void waitForElementNotPresent(By element)
	{
		try
		{
			WebDriverWait waitElementPresence = new WebDriverWait(driver, timeout);
			waitElementPresence.until(ExpectedConditions.invisibilityOfElementLocated(element));
		}
		catch(Exception ex)
		{
			Assert.fail(timeout+" Seconds Waited For Element '"+element+"'  "+ex.getMessage());
		}

	}


	public static void waitForElementText(WebElement element,String textValue)
	{
		try
		{
			WebDriverWait waitElementPresence = new WebDriverWait(driver, timeout);
			waitElementPresence.until(ExpectedConditions.textToBePresentInElement(element,textValue));
		}
		catch(Exception ex)
		{
			Assert.fail("Error occured in the Wait For Text '"+textValue+"' ::"+ex.getMessage());
		}

	}


	public void waitImplicitly()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception ex)
		{
			Assert.fail("Error occured while implict wait command");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void fluentWait() {
		try
		{
		new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		}
		catch(Exception ex)
		{
			Assert.fail("Error occured while fluent Wait command. It seems element is not pooled or WebDriver has encounterred error!");
		}
		
	}
	
	@SuppressWarnings("unused")
	public static boolean isAlertPresent() {

		boolean presentFlag = false;

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			
			// Alert present; set the flag to true
			presentFlag = true;

		} catch (NoAlertPresentException ex) {
			Assert.fail("Alert not present!");
			ex.printStackTrace();
		}

		return presentFlag;

	}
}
