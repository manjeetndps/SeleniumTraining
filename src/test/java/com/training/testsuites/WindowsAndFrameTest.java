package com.training.testsuites;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.DragAndDropPage;
import com.training.pageobjects.FramesAndWindowsPage;
import com.training.pageobjects.SignInPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;
import com.training.webdriverhelper.WindowsHandler;

@Listeners(com.training.reportutility.DemoListener.class)
public class WindowsAndFrameTest extends BaseTestSetup {

	private FramesAndWindowsPage framesAndWindowsPage;
	private WebElement fElement;
	private static SignInPage signInPage;
	
	@BeforeClass
	public void setup() {
		framesAndWindowsPage = PageFactory.getFramesAndWindowsPage();
		//LoginService.login();
	}

	//@Test()
	public void verifyNew_Window() {
		
		MouseAndKeyBoardActions.clickElement(framesAndWindowsPage.getlnkFramesAndWindows(), "lnkFramesAndWindows");
		
		fElement = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(fElement);
		
		MouseAndKeyBoardActions.clickElement(framesAndWindowsPage.getlnkNewTab(), "lnkNewTab");
		
		WindowsHandler.selectLatestWindow();
		
		Assert.assertTrue(framesAndWindowsPage.getlnkNewTab().isDisplayed());
	}
	
	//@Test()
	public void verifyKeyDown_And_KeyUp() {
		
		signInPage = PageFactory.getSignInPage();

		signInPage.clickRegisterLink();

/*		signInPage.enterUserName();

		signInPage.enterPassword();*/
		
		MouseAndKeyBoardActions.keyPress(signInPage.txtUserName, Keys.SHIFT, "manjeetku");
		
		MouseAndKeyBoardActions.keyPress(signInPage.txtPassword, Keys.SHIFT, "8885522072");

		signInPage.clickSubmittButton();
		
		
	}
}
