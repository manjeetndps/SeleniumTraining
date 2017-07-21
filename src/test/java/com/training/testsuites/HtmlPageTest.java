package com.training.testsuites;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.training.pagefactory.PageFactory;
import com.training.pageobjects.WThreeSchoolPage;
import com.training.webdriverhelper.BaseTestSetup;

@Listeners(com.training.reportutility.DemoListener.class)
public class HtmlPageTest extends BaseTestSetup{

	private WThreeSchoolPage wThreeSchoolPage;
	
	@BeforeSuite
	public void startTesting(){
		
		wThreeSchoolPage = PageFactory.getWThreeSchoolPage();
	}
	
	@Test()
	public void verifyHTML() {
		
		wThreeSchoolPage.getButtonHTML().click();
		
		Assert.assertTrue(wThreeSchoolPage.getLabelEveryChapter().isDisplayed());
	}
}
