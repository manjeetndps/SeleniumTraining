package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;
import com.training.actionparser.MouseAndKeyBoardActions;

public class HomePage extends BasePage {

	@FindBy(xpath="//a[text()=\"Home\"]")
	public WebElement lnkHome;
	
	
	
	public HomePage()
	{
		initialize();
	}
	
	public void clickHomeLink()
	{
		MouseAndKeyBoardActions.clickElement(lnkHome, "lnkHome");
	}
}
