package com.training.abcofselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Click_ClickAndHold_Clear_And_SendKeys {

	private static WebDriver driver;
	private static Actions action;
	private static WebElement element;

	public void launchWebPage() {

		driver = new FirefoxDriver();
		action = new Actions(driver);

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws InterruptedException {
		
		Click_ClickAndHold_Clear_And_SendKeys mouseAction = new Click_ClickAndHold_Clear_And_SendKeys();
		
		mouseAction.launchWebPage();

		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']"))
				.sendKeys("way2automation");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']"))
				.sendKeys("manjeetku");
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]"))
				.sendKeys("8885522072");

		element = driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]"));
		Thread.sleep(3000);

		action.clickAndHold(element).release();
		Thread.sleep(3000);

		action.release().perform();
		
		driver.close();
	}

}
