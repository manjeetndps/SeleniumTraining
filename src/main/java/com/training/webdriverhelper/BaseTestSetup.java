package com.training.webdriverhelper;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.training.constants.ConfigConstant;

public class BaseTestSetup extends DriverUtility{
	
	private static File file;
	public static Properties properties;
	private static FileInputStream fileInput;
	private static SimpleDateFormat dateFormat;
	public static HashMap<Object, Object> configDataList;

	/**
	 * This method is to set current date time.{ It appends current date time in log file name}.
	 */
	static {

		dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	private static Logger logger = LoggerFactory.getLogger(BaseTestSetup.class);
	
	@BeforeSuite
	public void startExecution()
	{
		PropertyConfigurator.configure("log4j.properties");
		configDataList = readConfigData();
		browserLanch(configDataList.get(ConfigConstant.BROWSERTYPE).toString(), configDataList.get(ConfigConstant.APPURL).toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static HashMap<Object, Object> readConfigData()
	{

		try
		{
			configDataList = new HashMap<Object, Object>();
			file = new File("./src/test/resources/Config.properties");
			fileInput = new FileInputStream(file);
			properties = new Properties();

			properties.load(fileInput);
			
			for(HashMap.Entry<Object, Object> entry : properties.entrySet()){
				
				configDataList.put(entry.getKey() , entry.getValue());
			}
			
			 logger.info(" Browser Type ::"+ configDataList.get(ConfigConstant.BROWSERTYPE));
			 logger.info(" App URL ::"+ configDataList.get(ConfigConstant.APPURL));

			fileInput.close();
		}
		catch(Exception  ex)
		{
			ex.printStackTrace();
			Assert.fail("Unable to read property configuration file. Some error occured ! Error detail is as follows->> ", ex.getCause());
		}
		return configDataList;
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown()
	{
		if (driver != null){
			logger.info("Execution is completed. Closing the web driver now!");
			driver.close();
		}
	}
}
