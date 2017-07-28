package com.training.abcofselenium2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenShot {

	private static WebDriver driver;

	public void launchWebPage() {

		driver = new FirefoxDriver();

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		TakeScreenShot scrShot = new TakeScreenShot();

		scrShot.launchWebPage();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./takenScreenShots/screenshot.png"));

		driver.close();

	}

}
