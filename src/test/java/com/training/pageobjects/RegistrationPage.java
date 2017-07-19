package com.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;

public class RegistrationPage extends BasePage {
	
	@FindBy(xpath = "//a[text()='Registration']")
	public WebElement lnkRegistration;
	
	
	public RegistrationPage() {
		initialize();
	}

	public WebElement getRegistrationLink() {

		return lnkRegistration;
	}
	
	
	public WebElement getMaritalStatusRadioButton(String status){
		
		return getWebDriver().findElement(By.xpath(String.format("//label[contains(text(),'%s')]/input", status)));
	}
}
