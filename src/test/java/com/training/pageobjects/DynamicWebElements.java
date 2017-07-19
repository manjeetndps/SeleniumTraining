package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;

public class DynamicWebElements extends BasePage{

	@FindBy(xpath="//input[starts-with(@id, 'submit')]")
	public WebElement btnStartsWith;
	
	
	@FindBy(xpath="//input[starts-with(@id, 'submit')]/preceding-sibling::input")
	public WebElement txtStartsWith;
	
	
	public DynamicWebElements()
	{
		initialize();
	}
}
