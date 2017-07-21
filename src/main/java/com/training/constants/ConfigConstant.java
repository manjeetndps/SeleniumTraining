/**
 * Author:- Manjeet Kumar
 */

package com.training.constants;

import java.util.HashMap;
import java.util.List;

/**
 * Fields should be updated as per Config.property file.
 * @author manjeetku
 *
 */
public class ConfigConstant {
	
	public static HashMap<String, List<String>> testCasesResutls = new HashMap<String, List<String>>();

	public static String TESTHTMLRESULTPATH = "";
	public static String TESTLRESULTPATH = "";
	public static String SCREENSHOTPATH = "";
	public static String LOGFILEPATH = "";

	// For Reporting Purpose --- From Application
	public static String BUILDNUMBER = "10144";
	public static String VERSIONNUMBER = "1.5";

	// Data from property configuration file.
	
	public static String APPURL = "appURL";
	public static String RETRYFAILEDTEST = "retryFailedTest";
	public static String APPNAME = "appName";
	public static String USERNAME = "userName";
	public static String PASSWORD = "password";
	public static String DATABASENAME = "databaseName";
	public static String TESTDATASHEETNAME = "testDataSheetName";
	public static String CLIENTLOGO = "clientLogo";
	public static String TESTTYPE = "strTestType";
	public static String BROWSERTYPE = "browserType";
	public static String TESTDATAPATH = "testDataPath";
	public static String DECODEDSTRING = "decodedString";
	public static String EMAILPASSWORD = "emailPassword";
	public static String TESTENVIRONMENTTYPE = "environmetType";
	public static String SOURCEEMAILADDRESS = "sourceEmailAddress";
	public static String SENTEMAILAFTEREACHEXECUTION = "sendEmailAfterEachRun";
	public static String DESTINATIONEMAILADDRESS = "destinationEmailAddress";
}
