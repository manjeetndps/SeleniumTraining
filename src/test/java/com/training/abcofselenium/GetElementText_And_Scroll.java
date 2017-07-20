package com.training.abcofselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GetElementText_And_Scroll {

	private static WebDriver driver;
	private WebElement element;
	private Actions action;

	public void launchWebPage() {

		driver = new FirefoxDriver();
		action = new Actions(driver);

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
	}

	/**
	 * Login Method
	 * 
	 * @throws InterruptedException
	 */
	private static void login() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']"))
				.sendKeys("manjeetku");
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]"))
				.sendKeys("8885522072");

		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {

		GetElementText_And_Scroll scroll = new GetElementText_And_Scroll();

		scroll.launchWebPage();

		login();

		scroll.element = driver.findElement(By.xpath("//a[text()='Registration']"));
		Thread.sleep(3000);

		System.out.println(scroll.element.getText());

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		scroll.element = driver.findElement(By.xpath("//img[@src='images/simple_alert.jpg']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", scroll.element);

		scroll.action.moveToElement(scroll.element).perform();

		// jse.executeScript("window.scrollBy(980,321.567)", "");

		Thread.sleep(5000);

		driver.close();

	}

}
