package com.training.abcofselenium2;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindowsHandling {

	private static WebDriver driver;
	private static WebElement element;
	private static String parentWindow;
	private static String text;
	public static ArrayList<?> tabs;

	public static void launchWebPage() {

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
		

		launchWebPage();

		login();

		parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(text(),'Frames and Windows')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'Open Multiple Windows')]")).click();
		Thread.sleep(3000);

		switchToFrame(4);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Open multiple pages')]")).click();
		Thread.sleep(3000);
		
		switchWindows();
		
		Thread.sleep(3000);
		driver.close();
	}
	
	private static void switchToFrame(int indexToSwitch) {

		String xpath = String.format("//div[starts-with(@id, 'example-1-tab-%d')]/div/iframe[@class='demo-frame']",
				indexToSwitch);

		element = driver.findElement(By.xpath(xpath));

		driver.switchTo().frame(element);
	}
	
	private static void switchWindows() throws InterruptedException {

		tabs = new ArrayList<>(driver.getWindowHandles());

		for (int i = 1; i < tabs.size(); i++) {
			if (!tabs.get(i).equals(0) || !tabs.get(i).equals(null)) {
				driver.switchTo().window(tabs.get(i).toString());
				Thread.sleep(3000);

				text = driver.findElement(By.xpath("//a[contains(text(),'Open Window')]")).getText();
				Thread.sleep(3000);

				System.out.println(text);
				driver.close();

			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
	}
}
