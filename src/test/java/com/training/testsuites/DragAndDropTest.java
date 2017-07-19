/**
 * This class is to test dragAndDrop and frame handling.
 */
package com.training.testsuites;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.DragAndDropPage;
import com.training.pageobjects.SignInPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;
import com.training.webdriverwait.WebdriverWait;

@Listeners(com.training.reportutility.DemoListener.class)
public class DragAndDropTest extends BaseTestSetup {

	@SuppressWarnings("unused")
	private SignInPage signInPage;
	private DragAndDropPage dragAndDropPage;
	private WebElement fElement;

	@BeforeClass
	public void setup() {
		signInPage = PageFactory.getSignInPage();
		dragAndDropPage = PageFactory.getDragAndDropPage();
	}

	@Test()
	public void verifyFrame_DragAndDrop_Elements() {
		LoginService.login();
		
		dragAndDropPage.clickInteractionLink();
		WebdriverWait.waitForElementPresent(dragAndDropPage.getDroppableLInk());
		
		dragAndDropPage.clickDroppableLink();
		
		fElement = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(fElement);
		
		MouseAndKeyBoardActions.dragAndDrop(dragAndDropPage.txtDraggable, dragAndDropPage.txtDroppable, true);
		
		 driver.switchTo().defaultContent();
		
		Assert.assertTrue(fElement.isDisplayed());
	}
}
