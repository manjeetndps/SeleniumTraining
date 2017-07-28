/**
 * This class is to test dragAndDrop and frame handling.
 */
package com.training.testsuites;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.databuilder.ContextData;
import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.DragAndDropPage;
import com.training.pageobjects.FramesAndWindowsPage;
import com.training.pageobjects.WidgetPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;
import com.training.webdriverwait.WebdriverWait;

@Listeners(com.training.reportutility.DemoListener.class)
public class DragAndDropTest extends BaseTestSetup {

	private WebElement element;
	private WidgetPage widgetPage;
	private DragAndDropPage dragAndDropPage;
	private ContextData contextData;
	private FramesAndWindowsPage framesAndWindowsPage;

	@BeforeClass
	public void setup() {
		contextData = new ContextData();
		widgetPage = PageFactory.getWidgetPage();
		dragAndDropPage = PageFactory.getDragAndDropPage();
		framesAndWindowsPage = PageFactory.getFramesAndWindowsPage();
	}

	// @Test()
	public void verifyFrame_DragAndDrop_Elements() {
		LoginService.login();

		dragAndDropPage.clickInteractionLink();
		WebdriverWait.waitForElementPresent(dragAndDropPage.getDroppableLInk());

		dragAndDropPage.clickDroppableLink();

		element = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);

		WebdriverWait.waitForElementPresent(element);
		MouseAndKeyBoardActions.switchToFrame(element);

		WebdriverWait.waitForElementPresent(dragAndDropPage.txtDraggable);
		WebdriverWait.waitForElementPresent(dragAndDropPage.txtDroppable);
		MouseAndKeyBoardActions.dragAndDrop(dragAndDropPage.txtDraggable, dragAndDropPage.txtDroppable);

		driver.switchTo().defaultContent();

		Assert.assertTrue(element.isDisplayed());
	}

	@Test()
	public void verifyContextClick() throws InterruptedException {
		LoginService.login();

		WebElement element = framesAndWindowsPage.getlnkFramesAndWindows();
		Thread.sleep(3000);

		contextData = buildContextData(7, element, true);

		MouseAndKeyBoardActions.contextSelect(contextData);

		Thread.sleep(10000);
	}

	//@Test
	public void verifySliderMoved() {
		LoginService.login();
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkWidget());
		widgetPage.getLnkWidget().click();
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkSlider());
		widgetPage.getLnkSlider().click();
		
		driver.switchTo().frame(0);
		
		WebdriverWait.waitForElementPresent(widgetPage.getBtnSlider());
		widgetPage.getBtnSlider();
		
		contextData = buildContextData(1, widgetPage.getBtnSlider(), false);
		
		MouseAndKeyBoardActions.contextSelect(contextData);

	}

	private ContextData buildContextData(int count, WebElement element, boolean isContextClick) {

		contextData.setElement(element);
		contextData.setnumberCount(count);

		if (isContextClick) {

			contextData.setContextClick(isContextClick);
			contextData.setKey(Keys.ARROW_DOWN);
			contextData.setDoPressEnter(isContextClick);
		} else {

			contextData.setSlider(true);
			contextData.setKey(Keys.ARROW_RIGHT);
		}

		return contextData;

	}
}
