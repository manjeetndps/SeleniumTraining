package com.training.abcofselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchWebPage {

	private static WebDriver driver;

	public void launchWebPage() {

		driver = new FirefoxDriver();

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
	}

	public static void main(String[] args) {

		LaunchWebPage action = new LaunchWebPage();

		action.launchWebPage();

		driver.close();
	}

}
