package com.training.basicseleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchWebPage {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.seleniumhq.org/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("q")).sendKeys("Webdriver");

		driver.findElement(By.id("submit")).click();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
