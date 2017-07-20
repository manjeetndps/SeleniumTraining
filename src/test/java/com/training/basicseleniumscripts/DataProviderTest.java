package com.training.basicseleniumscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.webdriverhelper.BaseTestSetup;

public class DataProviderTest extends BaseTestSetup {

	@Test(dataProvider = "getData")
	public void verifyLogin(String userName, String password) throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']"))
				.sendKeys(userName);
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]"))
				.sendKeys(password);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);

		Assert.assertFalse(driver.getTitle().isEmpty());
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][2];

		// login Credentials
		data[0][0] = "manjeetku";
		data[0][1] = "8885522072";
		return data;
	}
}
