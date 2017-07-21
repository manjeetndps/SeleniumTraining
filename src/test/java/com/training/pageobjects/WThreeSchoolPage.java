package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;

public class WThreeSchoolPage extends BasePage{

	@FindBy(xpath = "//a[text()='LEARN HTML']")
	private WebElement btnHtml;
	
	@FindBy(xpath = "//h2[contains(text(),'Every Chapter')]")
	private WebElement lblEveryChapter;
	
	public WThreeSchoolPage(){
		
		initialize();
	}
	
	public WebElement getButtonHTML(){
		return btnHtml;
		
	}
	
	public WebElement getLabelEveryChapter(){
		return lblEveryChapter;
	}
}
