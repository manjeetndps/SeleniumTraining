package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;

public class FramesAndWindowsPage extends BasePage {

	
	@FindBy(xpath="//a[contains(text(),'Frames and Windows')]")
	public WebElement lnkFramesAndWindows;
	
	@FindBy(xpath="//a[text()='New Browser Tab']")
	public WebElement lnkNewTab;
	
	
	public FramesAndWindowsPage()
	{
		initialize();
	}
	
	public WebElement getlnkFramesAndWindows(){
		return lnkFramesAndWindows;
		
	}
	
	public WebElement getlnkNewTab(){
		return lnkNewTab;
		
	}
}
