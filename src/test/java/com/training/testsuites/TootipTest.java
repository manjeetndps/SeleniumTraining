package com.training.testsuites;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.pagefactory.PageFactory;
import com.training.pageobjects.WidgetPage;
import com.training.reusableservice.LoginService;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverwait.WebdriverWait;

public class TootipTest extends BaseTestSetup {
	
	private WidgetPage widgetPage;
	private String tooltipText;
	

	@BeforeClass
	public void setup() {
		widgetPage = PageFactory.getWidgetPage();
	}
	
	@Test
	public void verifyTooltip() throws InterruptedException{
		
		LoginService.login();
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkWidget());
		MouseAndKeyBoardActions.clickElement(widgetPage.getLnkWidget(), "LnkWidget");
		
		WebdriverWait.waitForElementPresent(widgetPage.getLnkTooltip());
		MouseAndKeyBoardActions.clickElement(widgetPage.getLnkTooltip(), "LnkTooltip");
		
		driver.switchTo().frame(0);
		
		WebdriverWait.waitForElementPresent(widgetPage.getBtnTooltip());
		
		MouseAndKeyBoardActions.mouserOver(widgetPage.getBtnTooltip(), "Tooltip button");
		WebdriverWait.waitForElementPresent(widgetPage.getTooltipContent());
		
		tooltipText = widgetPage.getTooltipContent().getText();
		
		Assert.assertEquals(tooltipText, "That's what this widget is" , "Actual and expected doesn't matched!");
		
	}

}
