package com.training.actionparser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.training.webdriverhelper.FindElement;
import com.training.webdriverwait.WebdriverWait;

public class MouseAndKeyBoardActions extends FindElement {

	private static Logger logger = LoggerFactory.getLogger(MouseAndKeyBoardActions.class);

	public static Actions action;

	public static void enterText(WebElement element, String valueToBeEnter, String fieldName) {
		try {
			element.sendKeys(valueToBeEnter);
			logger.info(valueToBeEnter + " entered into the '" + fieldName + "' Text Box");
		} catch (Exception ex) {
			logger.info("Error occured while entring the " + valueToBeEnter + " value into text box '" + fieldName
					+ "' " + ex.getMessage());
			Assert.fail("Error occured while entring the " + valueToBeEnter + " value into text box '" + fieldName
					+ "' " + ex.getMessage());
		}

	}

	public static void clearText(WebElement element, String fieldName) {
		try {
			element.clear();
			logger.info("Cleared text the '" + fieldName + "' Text Box");
		} catch (Exception ex) {
			Assert.fail(
					"Error occured while clearing the text from the  '" + fieldName + "' Text Box" + ex.getMessage());
		}

	}

	public static void clickElement(WebElement element, String fieldName) {
		try {
			element.click();
			logger.info(fieldName + " Clicked Successfully");
		} catch (Exception ex) {
			Assert.fail("Error occured while clicking on element '" + fieldName + "' " + ex.getMessage());
		}

	}

	public static void selectDropDownItem(WebElement eListBox, String vLabelOrIndexOrValue, String vBy) {
		try {

			Select comboBox = new Select(eListBox);
			switch (vBy) {
			case "text":
				comboBox.selectByVisibleText(vLabelOrIndexOrValue);
				break;
			case "index":
				comboBox.selectByIndex(Integer.parseInt(vLabelOrIndexOrValue));
				break;
			case "value":
				comboBox.selectByValue(vLabelOrIndexOrValue);
				break;
			}

			logger.info("'" + vLabelOrIndexOrValue + "' value selected from the Dropdown  '" + eListBox + "'  ");

		} catch (Exception e) {
			logger.info("Error occured while selecting the Value  '" + vLabelOrIndexOrValue + "' from the Dropdown  '"
					+ eListBox + "'  " + e.getMessage());
			Assert.fail("Error occured while selecting the Value  '" + vLabelOrIndexOrValue + "' from the Dropdown  '"
					+ eListBox + "'  " + e.getMessage());
		}
	}

	public static List<String> getOptions(WebElement eListBox) throws Exception {
		List<WebElement> options = null;
		List<String> listValues = new ArrayList<String>();
		String listVal = null;

		try {

			Select comboBox = new Select(eListBox);
			options = comboBox.getOptions();

			logger.info("sizeInDriverUtils:" + options.size());

			for (WebElement option : options) {
				listVal = option.getText();

				System.out.println("listVal1:" + listVal);
				listValues.add(listVal);
			}

		} catch (Exception e) {

			logger.info("Error occured while getting the valus from the List Box" + e.getMessage());
			Assert.fail("Error occured while getting the valus from the List Box" + e.getMessage());

		}
		return listValues;
	}

	public static void checkElement(WebElement eButtonID, String fieldName) {
		try {

			if (!eButtonID.isSelected())
				eButtonID.click();

			logger.info("Check Element at the Locator '" + fieldName + "'");

		} catch (Exception e) {
			logger.info("Error occured cheking the web element '" + fieldName + "'" + e.getMessage());
			Assert.fail("Error occured cheking the web element '" + fieldName + "'" + e.getMessage());
		}
	}

	public static void unCheckElement(WebElement eButtonID, String fieldName) {
		try {

			if (eButtonID.isSelected())
				eButtonID.click();

			logger.info("UnCheck Element at the Locator '" + fieldName + "'");

		} catch (Exception e) {
			logger.info("Error occured uncheking the web element '" + fieldName + "'" + e.getMessage());
			Assert.fail("Error occured uncheking the web element '" + fieldName + "'" + e.getMessage());
		}
	}

	public static void javaScriptClickElement(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			logger.info(fieldName + " Clicked Successfully through Java Script");
		} catch (Exception ex) {
			Assert.fail("Error occured clicking on element '" + fieldName + "' through Java Script" + ex.getMessage());
		}

	}

	public static void mouserOver(WebElement element, String fieldName) {
		try {
			action = new Actions(driver);
			action.moveToElement(element).build().perform();
			logger.info("MouseOver on the '" + fieldName + "'");
		} catch (Exception ex) {
			Assert.fail("Error occured while mouse hovering on  '" + fieldName + "' " + ex.getMessage());
		}

	}

	public static void SelectDropDownItem(WebElement eListBox, String vLabelOrIndexOrValue, String vBy) {
		try {

			Select comboBox = new Select(eListBox);
			switch (vBy) {
			case "text":
				comboBox.selectByVisibleText(vLabelOrIndexOrValue);
				break;
			case "index":
				comboBox.selectByIndex(Integer.parseInt(vLabelOrIndexOrValue));
				break;
			case "value":
				comboBox.selectByValue(vLabelOrIndexOrValue);
				break;
			}

			logger.info("'" + vLabelOrIndexOrValue + "' value selected from the Dropdown  '" + eListBox + "'  ");

		} catch (Exception e) {
			logger.info("Error occured while selecting the Value  '" + vLabelOrIndexOrValue + "' from the Dropdown  '"
					+ eListBox + "'  " + e.getMessage());
			Assert.fail("Error occured while selecting the Value  '" + vLabelOrIndexOrValue + "' from the Dropdown  '"
					+ eListBox + "'  " + e.getMessage());
		}
	}

	public static void clickAndHold(WebElement element, String fieldName) {
		try {
			action = new Actions(driver);
			action.clickAndHold(element).build().perform();
			logger.info("clickAndHold on the '" + fieldName + "'");
		} catch (Exception ex) {
			Assert.fail("Error occured while clicking and Holding on  '" + fieldName + "' " + ex.getMessage());
		}

	}

	public static void doubleClick(WebElement element, String fieldName) {
		try {
			action = new Actions(driver);
			action.doubleClick(element).build().perform();
			logger.info("doubleClick on the '" + fieldName + "'");
		} catch (Exception ex) {
			Assert.fail("Error occured while double clicking on  '" + fieldName + "' " + ex.getMessage());
		}

	}

	public static void release(WebElement element, String fieldName) {
		try {
			action = new Actions(driver);
			action.release(element).build().perform();
			logger.info("release on the '" + fieldName + "'");
		} catch (Exception ex) {
			Assert.fail(
					"Error occured while releasing control from element on  '" + fieldName + "' " + ex.getMessage());
		}

	}

	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement, boolean isFrame) {
		try {
			action = new Actions(driver);
			action.dragAndDrop(sourceElement, targetElement).build().perform();
			logger.info("Dragging  '" + sourceElement + "' and dropping on '" + targetElement + "'");
		} catch (Exception ex) {
			Assert.fail(
					"Error occured while dragging and dropping element on  '" + targetElement + "' " + ex.getMessage());
		}

	}

	public static void switchToFrame(WebElement frameElement) {
		try {
			driver.switchTo().frame(frameElement);
		} catch (Exception ex) {
			Assert.fail("Error occured while switching to frame  '" + frameElement + "' " + ex.getMessage());
		}
	}

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			driver.wait();
		} catch (Exception ex) {
			Assert.fail("Error occured while switching to frame  '" + index + "' " + ex.getMessage());
		}
	}

	public static void switchToFrame(String frameName) {
		try {
			driver.switchTo().frame(frameName);
			driver.wait();
		} catch (Exception ex) {
			Assert.fail("Error occured while switching to frame  '" + frameName + "' " + ex.getMessage());
		}
	}

	public static void switchToAlert(boolean accept, String textToEnter, boolean isTextToEnter, boolean isDismiss) {
		try {
			if (isTextToEnter) {
				driver.switchTo().alert().sendKeys(textToEnter);
			}
			if (accept) {
				WebdriverWait.isAlertPresent();
				driver.switchTo().alert().accept();
			}
			else{

				WebdriverWait.isAlertPresent();
				driver.switchTo().alert().dismiss();
			}
		} catch (

		Exception ex) {
			Assert.fail("Error occured while switching to alert " + ex.getMessage());
		}
	}

	/**
	 * scroll window to an element view.
	 */
	public static void scrollToViewElement(WebElement scrollToElement)
	{

		try
		{
			WebdriverWait.getWebDriver().wait(10000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		} 
		
		catch(Exception ex)
		{
			Assert.fail("Error occured while forward navigation ::"+ex.getMessage());
		}
	}
	
	/**
	 * Keys press.
	 */
	public static void keyPress(WebElement element, Keys keyToPress, String textToSend)
	{

		try {
			action = new Actions(driver);
			action.keyDown(element, keyToPress).sendKeys(textToSend)
					.keyUp(element, keyToPress).perform();
		}

		catch (Exception ex) {
			Assert.fail("Error occured while key press ::" + ex.getMessage());
		}
	}
}
