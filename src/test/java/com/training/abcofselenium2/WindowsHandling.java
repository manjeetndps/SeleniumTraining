package com.training.abcofselenium2;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsHandling {

	private static WebDriver driver;
	private WebElement element;
	private String windowHandle;
	public ArrayList<?> tabs;

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {

		WindowsHandling winHandle = new WindowsHandling();

		winHandle.launchWebPage();

		login();

		winHandle.windowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(text(),'Frames and Windows')]")).click();
		Thread.sleep(3000);

		winHandle.element = driver.findElement(By.xpath("//div[@id='example-1-tab-1']/div/iframe[@class='demo-frame']"));
		driver.switchTo().frame(winHandle.element);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'New Browser Tab')]")).click();
		Thread.sleep(3000);

		winHandle.tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(winHandle.tabs.size());

		// Use the list of window handles to switch between windows
		driver.switchTo().window((String) winHandle.tabs.get(1));
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'New Browser Tab')]")).getText());
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(winHandle.windowHandle);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

		driver.quit();

	}

}
