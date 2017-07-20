package com.training.abcofselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuOptions {

	private static WebDriver driver;
	private static WebElement element;
	private Select select;

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
		
		SelectMenuOptions contextClick = new SelectMenuOptions();

		contextClick.launchWebPage();
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Dynamic Elements']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(element);
		Thread.sleep(3000);

		contextClick.select = new Select(driver.findElement(By.xpath("html/body/select")));
		contextClick.select.selectByVisibleText("Bermuda");
		Thread.sleep(5000);
		
		//driver.quit();

	}

}

