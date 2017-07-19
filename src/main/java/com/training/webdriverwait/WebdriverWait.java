package com.training.webdriverwait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	@SuppressWarnings("unused")
	public static boolean isAlertPresent() {

		  boolean presentFlag = false;

		  try {

		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();
		   // Alert present; set the flag
		   presentFlag = true;

		  } catch (NoAlertPresentException ex) {
		   // Alert not present
		   ex.printStackTrace();
		  }

		  return presentFlag;

		 }
}
