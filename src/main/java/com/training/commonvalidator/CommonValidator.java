/**
 * Author:- Manjeet Kumar
 */

package com.training.commonvalidator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.training.actionparser.MouseAndKeyBoardActions;
import com.training.webdriverhelper.DriverUtility;

public class CommonValidator extends DriverUtility{

	private static Logger logger = LoggerFactory.getLogger(CommonValidator.class);
	
	public static  void verifyPageTilte(String expTitle,String fieldName)
	{
		try
		{

			String actTitle=driver.getTitle();
			System.out.println("Actual Page Title   :: "+actTitle);
			System.out.println("Expected Page Title :: "+expTitle);
		    Assert.assertEquals(actTitle, expTitle,"Title Mis Matched ");

		    logger.info(fieldName+" Title verified Successfully.");

		}
		catch(Exception ex)
		{
			logger.info("Error occured while verifying the Page title ::"+ex.getMessage());
			Assert.fail("Error occured while verifying the Page title ::"+ex.getMessage());
		}
	}

	public static  void verifyPageURL(String expPageURL,String fieldName)
	{
		try
		{

			String actPageURL=driver.getCurrentUrl();
			System.out.println("Actual Page URL  :: "+actPageURL);
			System.out.println("Expected Page URL :: "+expPageURL);
		    Assert.assertEquals(actPageURL, expPageURL,"URL Mis Matched ");

		    logger.info(fieldName+" Title verified Successfully.");

		}
		catch(Exception ex)
		{
			logger.info("Error occured while verifying the Page URL ::"+ex.getMessage());
			Assert.fail("Error occured while verifying the Page URL ::"+ex.getMessage());
		}
	}


	public static  void verifyPageText(String expPageText,String fieldName)
	{
		try
		{

			String actPageText=driver.getPageSource();
			logger.info("Page Source ::"+actPageText);
			Boolean isText=actPageText.contains(expPageText);
			Assert.assertTrue(isText,expPageText+" Not Present in the Web Page.");

			logger.info(expPageText+" Found in the Web Page.");

		}
		catch(Exception ex)
		{
			Assert.fail("Error occured while verifying the Page URL ::"+ex.getMessage());
		}
	}


	public static  void verifyValue(WebElement element,String expValue,String fieldName)
	{
		try
		{

			String actValue=element.getAttribute("value");
			logger.info("Value from the Text Box :: "+actValue);

		    Assert.assertEquals(actValue, expValue,"Value Mis matched . ");

		    logger.info(expValue+" Value verified int the Text Box '"+fieldName+"'");

		}
		catch(Exception ex)
		{
			Assert.fail("Error occured while verifying the "+expValue+" value in the text box ::"+fieldName+" "+ex.getMessage());
		}
	}

	public static  void verifyText(WebElement element,String expValue,String fieldName)
	{
		try
		{

			String actText=element.getText();
			logger.info(fieldName+" Text Value:: "+actText);

		    Assert.assertEquals(actText, expValue,"Text Value Mis matched . ");

		    logger.info(expValue+" Text verified on the '"+fieldName+"'");

		}
		catch(Exception ex)
		{
			Assert.fail("Error occured while verifying the "+expValue+" text in the ::"+fieldName+" "+ex.getMessage());
		}
	}


	public static List<String> fVerifyOptions(WebElement eListBox,String value,String fieldName) throws Exception
	{
		List<String> listValues = new ArrayList<String>();
		try
		{
			Boolean flag=false;
			listValues=MouseAndKeyBoardActions.getOptions(eListBox);

			flag=listValues.contains(value);


			Assert.assertTrue(flag,value+" not found in the drop down"+fieldName);
			logger.info(value+" verified in the drop down "+fieldName);

		}catch(Exception ex){

			Assert.fail("Error occured while verifying the option value "+value+"  in the drop down ::"+fieldName+" "+ex.getMessage());
		}
		return listValues;
	}

	public static void verifyChecked(WebElement velLocator,String fieldName) throws Exception{
		try
		{
			Boolean isSelected=velLocator.isSelected();


			Assert.assertTrue(isSelected,fieldName+" unchecked Mode");
			logger.info("Element  '"+fieldName+"'  verified the Checked Property. ");
		}
		catch(Exception  ae)
		{
			logger.info("Element  '"+velLocator+"' = not selected. "+ae);
			Assert.fail("Element '"+velLocator+"' is not selected."+ae);
		}

	}

	public static void verifyUnChecked(WebElement velLocator,String fieldName) throws Exception{
		try
		{
			Boolean isSelected=velLocator.isSelected();


			Assert.assertFalse(isSelected,fieldName+" is  checked mode");


			logger.info("Element  '"+fieldName+"'  verified the un checked property.");
		}catch(Exception  ae){
			logger.info("Element  '"+velLocator+"' = not selected. "+ae);
			Assert.fail("Element '"+velLocator+"' is not selected."+ae);
		}

	}

}
