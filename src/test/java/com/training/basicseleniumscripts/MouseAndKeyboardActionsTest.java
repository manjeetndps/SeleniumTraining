package com.training.basicseleniumscripts;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.common.utility.DatabaseUtility;
import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;

public class MouseAndKeyboardActionsTest extends BaseTestSetup {

	private WebDriver driver;
	private Actions action;
	private WebElement element;
	private Select select;
	private String windowHandle;
	private DatabaseUtility databaseUtility;
	
	public ArrayList<?> tabs;
	
	@BeforeClass
	public void setup(){
		
		driver = new FirefoxDriver();
		
		/*System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		action = new Actions(driver);
		
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		
		driver.manage().window().maximize();
	}
	
	//@Test
	public void browserNavigationCommands() throws InterruptedException{
		
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
		
	}
	
	//@Test
	public void mouseAndKeyBoardActions_Click_ClickAndHold_Clear_And_SendKeys() throws InterruptedException {
				
		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).sendKeys("way2automation");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).clear();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).sendKeys("manjeetku");
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]")).sendKeys("8885522072");
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);
		
		action.clickAndHold(element).perform();
		Thread.sleep(3000);
		
		action.release().perform();
		}
		
	//@Test
	public void mouseAndKeyBoardActions_MoveToElement_And_DoubleClick() throws InterruptedException {
		
		login();
		
		element = driver.findElement(By.xpath("//a[text()=\"Home\"]"));		
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		
		action.doubleClick(element).perform();
		Thread.sleep(3000);
		
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_RadioButton_And_CheckBoxes() throws InterruptedException {
				
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[contains(text(),'Single')]/input")).click();
		Thread.sleep(3000);
		
		element = driver.findElement(By.xpath("//label[contains(text(),'Dance')]/input"));
		
		if(!element.isSelected()){
			element.click();
		} else if(element.isSelected()){
			element.click();
		}
		
		Thread.sleep(3000);
		
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_ContextClick() throws InterruptedException {
				
		
		login();
		
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		action.contextClick(driver.findElement(By.xpath("//a[text()='Registration']"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		Thread.sleep(3000);
		
		
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_SelectOption() throws InterruptedException {

		login();

		driver.findElement(By.xpath("//a[text()='Dynamic Elements']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(element);
		Thread.sleep(3000);

		select = new Select(driver.findElement(By.xpath("html/body/select")));
		select.selectByVisibleText("Bermuda");
		Thread.sleep(5000);
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_Frame_DragAndDrop() throws InterruptedException {
				
		login();
		
		driver.findElement(By.xpath("//a[text()='Interaction']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		
		element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
		Thread.sleep(3000);	
		
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		
		action.dragAndDrop(sourceElement, targetElement).perform();
		Thread.sleep(3000);	
		
		driver.switchTo().defaultContent();
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_KeyDown_KeyUp() throws InterruptedException {

		login();

		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		
		element = driver.findElement(By.xpath("//label[contains(text(),'First Name')]/following-sibling::input"));
		
		action.keyDown(element, Keys.SHIFT).sendKeys("manjeetkumar").keyUp(element, Keys.SHIFT).perform();
		Thread.sleep(3000);
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_Alert() throws InterruptedException {

		login();

		driver.findElement(By.xpath("//a[text()='Alert']")).click();
		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(element);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Click the button to display an alert box:')]")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_InputAlert() throws InterruptedException {

		login();

		driver.findElement(By.xpath("//a[text()='Alert']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'Input Alert')]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='example-1-tab-2']/div/iframe[@class='demo-frame']")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'demonstrate')]")).click();

		driver.switchTo().alert().sendKeys("ManjeetKu");
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_GetText() throws InterruptedException {

		login();

		element = driver.findElement(By.xpath("//a[text()='Registration']"));
		Thread.sleep(3000);
		
		System.out.println(element.getText());
	}
	
	//@Test()
	public void mouseAndKeyBoardActions_Scroll_UP_Down() throws InterruptedException {

		login();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		element = driver.findElement(By.xpath("//img[@src='images/simple_alert.jpg']"));
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		
		action.moveToElement(element).perform();
		
		
		//jse.executeScript("window.scrollBy(980,321.567)", "");
		
		Thread.sleep(5000);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@Test()
	public void mouseAndKeyBoardActions_Window_Handling() throws InterruptedException {

		login();

		windowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(text(),'Frames and Windows')]")).click();
		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//div[@id='example-1-tab-1']/div/iframe[@class='demo-frame']"));
		driver.switchTo().frame(element);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'New Browser Tab')]")).click();
		Thread.sleep(3000);

		tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());

		// Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'New Browser Tab')]")).getText());
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
	}
	
	@Test()
	public void mouseAndKeyBoardActions_TakeScreenShot() throws InterruptedException, IOException {

		login();

		try {
			databaseUtility = new DatabaseUtility();
			
			databaseUtility.getDBConnection(databaseUtility.databaseType);
			
			databaseUtility.executeQuery("SELECT NAME FROM employee WHERE id = 100;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int testResult = TestResult.SUCCESS;

		if (testResult == 1) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./takenScreenShots/screenshot.png"));
		}
	}
	
	/**
	 * Login Method
	 * @throws InterruptedException
	 */
	private void login() throws InterruptedException{
		
		
		driver.findElement(By.xpath("//a[contains(text(),\"Signin\")]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../fieldset/input[@name='username']")).sendKeys("manjeetku");
		driver.findElement(By.cssSelector("#login>form>fieldset:nth-of-type(2)>input[type$=\"password\"]")).sendKeys("8885522072");
		
		driver.findElement(By.xpath("//a[text()=\"Signup\"]/../../../../div/div/input[@value=\"Submit\"]")).click();
		Thread.sleep(3000);
	}
	
	
	
	@AfterClass
	public void teatDown(){
		
		driver.close();
	}

}
