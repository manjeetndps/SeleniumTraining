package com.training.abcofselenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Keys_UP_Down {

	private static WebDriver driver;
	private static WebElement element;
	private Actions action;

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
		
		Keys_UP_Down keyDownUp = new Keys_UP_Down();

		keyDownUp.launchWebPage();
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		element = driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following-sibling::input"));
		
		keyDownUp.action.keyDown(element, Keys.SHIFT).sendKeys("manjeetkumar").keyUp(element, Keys.SHIFT).perform();
		Thread.sleep(3000);
		
		driver.close();

	}

}

