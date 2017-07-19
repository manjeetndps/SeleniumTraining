package com.training.webdriverhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindElement extends DriverUtility {

	private static Logger logger = LoggerFactory.getLogger(FindElement.class);

	public static WebElement element;

	public static WebElement getElement(Identifier identifier, String expression) {

		By byElement = null;

		try {
			switch (identifier) {

			case xpath: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.xpath(expression);
				break;
			}
			case id: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.id(expression);
				break;
			}
			case name: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.name(expression);
				break;
			}
			case classname: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.className(expression);
				break;
			}
			case linktext: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.linkText(expression);
				break;
			}
			case paritallinktext: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.partialLinkText(expression);
				break;
			}
			case tagname: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.tagName(expression);
				break;
			}
			
			case css: {

				logger.info("Finding element by ->> " + identifier);
				byElement = By.cssSelector(expression);
				break;
			}
			}

		} catch (Exception e) {

			logger.error("Error in finding the element. Element not found on page ! ");
			e.printStackTrace();
		}

		WebElement element = driver.findElement(byElement);

		return element;
	}

	public static enum Identifier {
		xpath, id, name, classname, paritallinktext, linktext, tagname, css
	};
}
