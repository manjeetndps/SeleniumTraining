package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;
import com.training.actionparser.MouseAndKeyBoardActions;

public class DragAndDropPage extends BasePage {
	
	public static String draggable_Frame = "//iframe[@class='demo-frame']";
	
	public static String inputAlert = "//button[contains(text(),'demonstrate')]";
	
	@FindBy(xpath="//a[text()='Interaction']")
	public WebElement lnkInteraction;
	
	@FindBy(xpath="//a[text()='Droppable']")
	public WebElement lnkDroppable;
	
	@FindBy(xpath="//div[@id='draggable']/p")
	public WebElement txtDraggable;
	
	@FindBy(xpath="//div[@id='droppable']/p")
	public WebElement txtDroppable;
	
	@FindBy(xpath="//iframe[@class='demo-frame']")
	public WebElement frameElement;
	
	@FindBy(xpath="//a[text()='Draggable']")
	public WebElement lnkDraggable;
	
	@FindBy(xpath="//h1[contains(text(),'Droppable')]")
	public WebElement lblDroppable;
	
	@FindBy(xpath="//a[text()='Alert']")
	public WebElement lnkAlert;
	
	@FindBy(xpath="//button[contains(text(),'Click the button to display an alert box:')]")
	public WebElement btnToGetAlert;
	
	@FindBy(xpath="//a[contains(text(),'Input Alert')]")
	public WebElement lnkInputAlert;
	
	@FindBy(xpath="//button[contains(text(),'demonstrate')]")
	public WebElement btnToGetInputAlert;
	
	
	
	public DragAndDropPage()
	{
		initialize();
	}
	
	public void clickInteractionLink()
	{
		MouseAndKeyBoardActions.clickElement(lnkInteraction, "lnkInteraction");
	}
	
	public void clickDroppableLink()
	{
		MouseAndKeyBoardActions.clickElement(lnkDroppable, "lnkDroppable");
	}

	public WebElement getFrameElement(){
		return frameElement;
	}
	
	public WebElement getLblDroppable(){
		return lblDroppable;
		
	}
	
	public WebElement getInteractionLink(){
		return lnkInteraction;
		
	}
	
	public WebElement getDroppableLInk(){
		return lnkDroppable;
		
	}
	
	public WebElement getAlertLink(){
		return lnkAlert;
		
	}
	
	public WebElement btnToGetAlert(){
		return btnToGetAlert;
	}
	
	public WebElement getInputAlertLink(){
		return lnkInputAlert;
	}
	
	public WebElement getInputAlertButton(){
		return btnToGetInputAlert;
	}
}
