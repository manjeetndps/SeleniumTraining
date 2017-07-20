package com.training.abcofselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	private static WebDriver driver;
	private static Actions action;

	public void launchWebPage(){
		
		driver = new FirefoxDriver();
		action = new Actions(driver);

		driver.get("http://way2automation.com/way2auto_jquery/index.php");

		driver.manage().window().maximize();
	}
	
	/**
	 * Login Method
	 * @throws InterruptedException
	 */
	private static void login() throws InterruptedException{
		
		
		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).sendKeys("manjeetku");
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]")).sendKeys("8885522072");
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ContextClick contextClick = new ContextClick();

		contextClick.launchWebPage();
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		action.contextClick(driver.findElement(By.xpath("//a[text()='Registration']"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		Thread.sleep(3000);
		
		driver.quit();

	}

}

