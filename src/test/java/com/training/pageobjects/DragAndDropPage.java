package com.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;
import com.training.actionparser.MouseAndKeyBoardActions;

public class DragAndDropPage extends BasePage {

	public static String draggable_Frame = "//iframe[@class='demo-frame']";

	public String inputAlert = "//button[contains(text(),'demonstrate')]";
	public String framePath = "//div[@id='example-1-tab-%d']/div/iframe[@class='demo-frame']";

	@FindBy(xpath = "//a[text()='Interaction']")
	private WebElement lnkInteraction;

	@FindBy(xpath = "//a[text()='Droppable']")
	private WebElement lnkDroppable;

	@FindBy(xpath = "//div[@id='draggable']/p")
	public WebElement txtDraggable;

	@FindBy(xpath = "//div[@id='droppable']/p")
	public WebElement txtDroppable;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	public WebElement frameElement;

	@FindBy(xpath = "//a[text()='Draggable']")
	public WebElement lnkDraggable;

	@FindBy(xpath = "//h1[contains(text(),'Droppable')]")
	public WebElement lblDroppable;

	@FindBy(xpath = "//a[text()='Alert']")
	public WebElement lnkAlert;

	@FindBy(xpath = "//button[contains(text(),'Click the button to display an alert box:')]")
	public WebElement btnToGetAlert;

	@FindBy(xpath = "//a[contains(text(),'Input Alert')]")
	public WebElement lnkInputAlert;

	@FindBy(xpath = "//button[contains(text(),'demonstrate')]")
	public WebElement btnToGetInputAlert;

	public DragAndDropPage() {
		initialize();
	}

	public void clickInteractionLink() {
		MouseAndKeyBoardActions.clickElement(lnkInteraction, "lnkInteraction");
	}

	public void clickDroppableLink() {
		MouseAndKeyBoardActions.clickElement(lnkDroppable, "lnkDroppable");
	}

	public WebElement getFrameElement() {
		return frameElement;
	}

	public WebElement getLblDroppable() {
		return lblDroppable;

	}

	public WebElement getInteractionLink() {
		return lnkInteraction;

	}

	public WebElement getDroppableLInk() {
		return lnkDroppable;

	}

	public WebElement getAlertLink() {
		return lnkAlert;

	}

	public WebElement btnToGetAlert() {
		return btnToGetAlert;
	}

	public WebElement getInputAlertLink() {
		return lnkInputAlert;
	}

	public WebElement getInputAlertButton() {
		return btnToGetInputAlert;
	}

	public WebElement getFrameElement(int index) {

		String xpath = String.format(framePath, index).toString();

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
}
