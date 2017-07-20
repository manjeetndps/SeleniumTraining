package com.training.abcofselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {

	private static WebDriver driver;

	public void launchWebPage(){
		
		driver = new FirefoxDriver();

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
		
		NavigationCommands action = new NavigationCommands();

		action.launchWebPage();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		login();

		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.close();

	}

}

