package com.training.abcofselenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames_And_DragAndDrop {

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
		
		Frames_And_DragAndDrop dragAndDrop = new Frames_And_DragAndDrop();

		dragAndDrop.launchWebPage();
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Interaction']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		
		element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
		Thread.sleep(3000);	
		
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		
		dragAndDrop.action.dragAndDrop(sourceElement, targetElement).perform();
		Thread.sleep(3000);	
		
		driver.switchTo().defaultContent();
		
		driver.close();

	}

}

