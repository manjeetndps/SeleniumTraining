/**
 * Author:- Manjeet Kumar
 */

package com.training.webdriverhelper;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class WindowsHandler extends FindElement{
	
	private static Logger logger = LoggerFactory.getLogger(WindowsHandler.class);
	
	/**
	 * Switch to immediate new window.
	 */
	public static void selectLatestWindow()
	{
		try
		{
			Set<String> handles1=driver.getWindowHandles();
			logger.info("No Of Browser  ::"+handles1.size());

			for(String handle : handles1)
			{
				logger.info("Window ID ::"+handle);
				driver.switchTo().window(handle);
			}
		}
		catch(Exception ex)
		{
			logger.error("Error occured while swtiching the window focus::"+ex.getMessage());
			Assert.fail("Error occured while swtiching the window focus::"+ex.getMessage());
		}
	}
	
	/**
	 * Switch to window based on title of the window.
	 */
	public static void selectLatestWindow(String windowTitle)
	{
		try
		{
			Set<String> handles1=driver.getWindowHandles();
			logger.info("No Of Browser  ::"+handles1.size());

			for(String handle : handles1)
			{
				logger.info("Window ID ::"+handle);
				String actTitle=driver.switchTo().window(handle).getTitle();

				if(actTitle.equals(windowTitle))
					break;
			}
		}
		catch(Exception ex)
		{
			logger.info("Error occured while swtiching the window focus based on the Title of the window::"+ex.getMessage());
			Assert.fail("Error occured!");
		}
	}

	/**
	 * Refresh current web page.
	 */
	public static void refreshWindow()
	{

		try
		{
			driver.navigate().refresh();
		} 
		
		catch(Exception ex)
		{
			logger.error("Error occured while refreshing the web page ::"+ex.getMessage());
			Assert.fail("Error occured!");
		}
	}
	
	/**
	 * Navigate Back to previous web page.
	 */
	public static void navigateBack()
	{

		try
		{
			driver.navigate().back();
		} 
		
		catch(Exception ex)
		{
			logger.error("Error occured while backward navigation ::"+ ex.getMessage());
			Assert.fail("Error occured while backward navigation. Driver did not navigated back.");
		}
	}
	
	/**
	 * Navigate forward to next web page.
	 */
	public static void navigateForward()
	{

		try
		{
			driver.navigate().forward();
		} 
		
		catch(Exception ex)
		{
			logger.info("Error occured while forward navigation ::"+ex.getMessage());
			Assert.fail("Error occured!");
		}
	}
}
