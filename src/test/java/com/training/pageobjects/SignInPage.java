package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;
import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;

public class SignInPage extends BasePage {

	@FindBy(xpath="//a[contains(text(),\"Signin\")]")
	public WebElement lnkSignIn;
	
	@FindBy(xpath="//a[text()=\"Signup\"]/../../../../fieldset/input[@name=\"username\"]")
	public WebElement txtUserName;
	
	@FindBy(css="#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]")
	public WebElement txtPassword;
	
	@FindBy(xpath="//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")
	public WebElement btnSubmitt;
	
	
	public SignInPage()
	{
		initialize();
	}
	
	
	public void clickRegisterLink()
	{
		MouseAndKeyBoardActions.clickElement(lnkSignIn, "lnkSignIn");
	}
	
	public void enterUserName()
	{
		MouseAndKeyBoardActions.enterText(txtUserName, BaseTestSetup.configDataList.get(ConfigConstant.USERNAME).toString(), "txtUserName");
	}
	
	public void clearUserName()
	{
		MouseAndKeyBoardActions.clearText(txtUserName, "txtUserName");
	}
	
	public void enterPassword()
	{
		MouseAndKeyBoardActions.enterText(txtPassword, BaseTestSetup.configDataList.get(ConfigConstant.PASSWORD).toString(), "txtPassword");
	}
	
	public void clickSubmittButton()
	{
		MouseAndKeyBoardActions.javaScriptClickElement(btnSubmitt, "btnSubmitt");
	}
}
