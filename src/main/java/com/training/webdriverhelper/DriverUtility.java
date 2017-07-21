/**
 * Author:- Manjeet Kumar
 */

package com.training.webdriverhelper;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class DriverUtility {

	private static Logger logger = LoggerFactory.getLogger(DriverUtility.class);

	public static WebDriver driver;
	private static DesiredCapabilities desiredCapabilities;

	public static WebDriver browserLanch(String browserType, String appURL) {

		try {
			
			switch (browserType) {
			case "FF":
				driver = new FirefoxDriver();

				logger.info("Launching new instance of firefox web driver.");
				break;

			case "FirefoxLatest":
				File firefoxDriver = new File("./lib/geckodriver.exe");
				System.setProperty("webdriver.firefox.marionette", firefoxDriver.getAbsolutePath());
				System.setProperty("webdriver.gecko.driver", firefoxDriver.getAbsolutePath());
				desiredCapabilities = DesiredCapabilities.firefox();
				desiredCapabilities.setCapability("marionette", true);
				desiredCapabilities.setBrowserName("firefox");
				driver = new FirefoxDriver(desiredCapabilities);

				logger.info("Launching new instance of firefox(Gecko) web driver.");
				break;

			case "GC":
				File chromeDriver = new File("./lib/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

				desiredCapabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments(new String[] { "test-type" });
				options.addArguments(new String[] { "disable-extensions" });
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(desiredCapabilities);

				logger.info("Launching new instance of google chrome web driver.");
				break;

			case "IE":

				File ieDriver = new File("./lib/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", ieDriver.getAbsolutePath());
				driver = new InternetExplorerDriver();

				logger.info("Launching new instance of internet explorer web driver.");
				break;

			case "HTMLUnit":

				desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setBrowserName("htmlunit");
				driver = new HtmlUnitDriver();

				logger.info("Launching new instance of HTML unit web driver.");
				break;

			}

			driver.manage().window().maximize();
			driver.get(appURL);
		} catch (Exception ex) {
			Assert.fail("Error occured while lanching the Browser ::" + browserType + " ::" + ex.getMessage());
		}

		return driver;

	}

	public static WebDriver getWebDriver() {
		return driver;
	}
}
