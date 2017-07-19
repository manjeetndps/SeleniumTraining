package com.training.testsuites;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

public class HandleInputAlertTest extends BaseTestSetup {

	@SuppressWarnings("unused")
	private SignInPage signInPage;
	private DragAndDropPage dragAndDropPage;
	private WebElement element;
	
	//Test data
	private static final String NAME_TO_BE_ENTERRED_IN_ALERT = "Cybage";

	@BeforeClass
	public void setup() {
		signInPage = PageFactory.getSignInPage();
		dragAndDropPage = PageFactory.getDragAndDropPage();
		LoginService.login();
	}
	
	
	@Test
	public void verifyInputAlertAlert() {
		
		dragAndDropPage.getAlertLink().click();
		
		WebdriverWait.waitForElementPresent(dragAndDropPage.getApplicationLogo());
		
		dragAndDropPage.getInputAlertLink().click();
		
		element = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(element);
		
		element = FindElement.getElement(Identifier.xpath, DragAndDropPage.inputAlert);
		
		MouseAndKeyBoardActions.javaScriptClickElement(element, "inputAlert");
		
		MouseAndKeyBoardActions.switchToAlert(true, NAME_TO_BE_ENTERRED_IN_ALERT, true, false);
		
		Assert.assertTrue(dragAndDropPage.getInputAlertButton().isEnabled());
	}

}
