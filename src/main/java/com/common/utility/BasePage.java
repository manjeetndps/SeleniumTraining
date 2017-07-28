/**
 * Author:- Manjeet Kumar
 */

package com.common.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.webdriverhelper.DriverUtility;

public class BasePage extends DriverUtility{
	
	@FindBy(xpath=".//*[@id='wrapper']/header/div/div[1]/div/a/img")
	private WebElement imgApplicationLogo;
	
	public BasePage (){
		
		initialize();
	}

	public void initialize(){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getApplicationLogo(){
		return imgApplicationLogo;
		
	}
}
