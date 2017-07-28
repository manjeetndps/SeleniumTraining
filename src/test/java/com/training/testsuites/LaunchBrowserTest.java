package com.training.testsuites;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.DragAndDropPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.FindElement;
import com.training.webdriverhelper.FindElement.Identifier;

@Listeners(com.training.reportutility.DemoListener.class)
public class LaunchBrowserTest extends BaseTestSetup{
	
	private DragAndDropPage dragAndDropPage;
	
	@BeforeClass
	public void setup(){
		
		dragAndDropPage = PageFactory.getDragAndDropPage();
	}
	
	@Test
	public void testBrowser() throws InterruptedException{
		
		LoginService.login();		
		
		dragAndDropPage.clickInteractionLink();
		dragAndDropPage.clickDroppableLink();
		
		WebElement fElement = FindElement.getElement(Identifier.xpath, DragAndDropPage.draggable_Frame);
		
		MouseAndKeyBoardActions.switchToFrame(fElement);
		
		MouseAndKeyBoardActions.dragAndDrop(dragAndDropPage.txtDraggable, dragAndDropPage.txtDroppable);
	}
}
