package com.training.testsuites;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.DragAndDropPage;
import com.training.pageobjects.HomePage;
import com.training.pageobjects.SignInPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;

@Listeners(com.training.reportutility.DemoListener.class)
public class LaunchBrowserTest extends BaseTestSetup{

	private SignInPage signInPage;
	private HomePage homePage;
	private DragAndDropPage dragAndDropPage;
	
	@BeforeClass
	public void setup(){
		
		homePage   		= PageFactory.getHomePage();
		signInPage 		= PageFactory.getSignInPage();
		dragAndDropPage = PageFactory.getDragAndDropPage();
	}
	
	@Test
	public void testBrowser() throws InterruptedException{
		
		LoginService.login();
		
		//MouseAndKeyBoardActions.clickAndHold(signInPage.btnSubmitt, "btnSubmitt");

		//MouseAndKeyBoardActions.release(signInPage.btnSubmitt, "btnSubmitt");
		
		//MouseAndKeyBoardActions.mouserOver(homePage.lnkHome, "lnkHome");
		Thread.sleep(5000);
		
		//homePage.clickHomeLink();
		
		//WebdriverWait.waitForElementText(homePage.lnkHome, "Home");		
		
		dragAndDropPage.clickInteractionLink();
		dragAndDropPage.clickDroppableLink();
		
		WebElement fElement = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(fElement);
		
		//MouseAndKeyBoardActions.switchToFrame(1);
		MouseAndKeyBoardActions.dragAndDrop(dragAndDropPage.txtDraggable, dragAndDropPage.txtDroppable, true);
	}
}
