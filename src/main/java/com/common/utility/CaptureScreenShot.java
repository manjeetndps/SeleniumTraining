package com.common.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.training.fileparser.FileSystemUtils;
import com.training.webdriverhelper.DriverUtility;

public class CaptureScreenShot extends DriverUtility{
	
	private static Logger logger = LoggerFactory.getLogger(CaptureScreenShot.class);
	
	public static RandomNumberGeneration randomNumberGeneration;
	
	public static String takeScreenShot(String appName,String testName) {

		String strScreenshotName=null;
		try
		{
			randomNumberGeneration=new RandomNumberGeneration();
			String today=randomNumberGeneration.getToDayDate();
			String scrShotFolder=randomNumberGeneration.getDateAndTime();

			String name = ".\\ScreenShots\\" +appName;
			FileSystemUtils.createDir(name);

			name = name + "\\" + today;
			FileSystemUtils.createDir(name);

			name = name + "\\" + scrShotFolder;
			FileSystemUtils.createDir(name);

			strScreenshotName = name + "\\" +appName+"_"+testName+"_"+ scrShotFolder + ".png";
			File screenShotFileType = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File screenshotFile = new File(strScreenshotName);

			FileUtils.copyFile(screenShotFileType ,screenshotFile);


			strScreenshotName = screenshotFile.getCanonicalPath();
			logger.info("Screenshot Path ::"+strScreenshotName);
		}
		catch(Exception e)
		{
			logger.info("Error Occured while taking the Screenshot... "+e.getMessage());
			Assert.fail("Error Occured while taking the Screenshot... "+e.getMessage());
		}

		return strScreenshotName;
	}

}
