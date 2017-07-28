package com.training.abcofselenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InputAlertHandler {

	private static WebDriver driver;

	public void launchWebPage() {

		driver = new FirefoxDriver();

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

		InputAlertHandler alertHandler = new InputAlertHandler();

		alertHandler.launchWebPage();

		login();

		driver.findElement(By.xpath("//a[text()='Alert']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'Input Alert')]")).click();

		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@id='example-1-tab-2']/div/iframe[@class='demo-frame']")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'demonstrate')]")).click();

		driver.switchTo().alert().sendKeys("ManjeetKu");
		Thread.sleep(3000);

		driver.switchTo().alert().accept();

		driver.close();

	}

}
