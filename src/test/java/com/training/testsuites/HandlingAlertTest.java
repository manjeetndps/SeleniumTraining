package com.training.testsuites;

import org.apache.commons.lang3.StringUtils;
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

public class HandlingAlertTest extends BaseTestSetup {

	@SuppressWarnings("unused")
	private SignInPage signInPage;
	private DragAndDropPage dragAndDropPage;
	private WebElement element;
	
	@BeforeClass
	public void setup() {
		signInPage = PageFactory.getSignInPage();
		dragAndDropPage = PageFactory.getDragAndDropPage();
		LoginService.login();
	}
	
	@Test
	public void verifyAlert() {
		
		dragAndDropPage.getAlertLink().click();
		
		element = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(element);
		
		WebdriverWait.waitForElementPresent(dragAndDropPage.btnToGetAlert());
		
		dragAndDropPage.btnToGetAlert().click();
		
		Assert.assertTrue(WebdriverWait.isAlertPresent());
		
		MouseAndKeyBoardActions.switchToAlert(true, StringUtils.EMPTY, false, false);
		
		Assert.assertTrue(dragAndDropPage.btnToGetAlert().isDisplayed());
	}
}
