package com.training.reusableservice;

import com.training.pagefactory.PageFactory;
import com.training.pageobjects.SignInPage;
import com.training.webdriverhelper.BaseTestSetup;

public class LoginService extends BaseTestSetup {

	private static SignInPage signInPage;

	public static void login() {

		signInPage = PageFactory.getSignInPage();

		signInPage.clickRegisterLink();

		signInPage.enterUserName();

		signInPage.enterPassword();

		signInPage.clickSubmittButton();
	}
}
