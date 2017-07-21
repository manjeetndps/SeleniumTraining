package com.common.reruntestutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;

public class RerunFailedTestSuite extends BaseTestSetup {

	private static Logger logger = LoggerFactory.getLogger(RerunFailedTestSuite.class);

	private static File file;
	private static TestNG runner;
	private static String failedTest;
	private static NodeList nList;
	private static DocumentBuilder db;
	private static Document document;
	private static DocumentBuilderFactory dbf;

	private static List<String> suitefiles;

	public static void runFailedTest() {

			// Create object of TestNG Class
			runner = new TestNG();

			// Create a list of String
			suitefiles = new ArrayList<String>();

			// Check if file exist and Add xml file which you have to execute

			failedTest = getFailedTextString();

			suitefiles.add(file.toString());

			if (failedTest.contains("Failed suite") && configDataList.get(ConfigConstant.RETRYFAILEDTEST).toString().contains("yes")) {
				// now set xml file for execution
				runner.setTestSuites(suitefiles);

				// finally execute the runner using run method
				logger.info("To make sure Failure didn't caused due to network or web page issue, Re-running the failed test cases !");
				runner.run();
			}

			}

	public static String getFailedTextString() {

		file = new File("./test-output/testng-failed.xml");
		if (file.exists() && !file.isDirectory()) {

			dbf = DocumentBuilderFactory.newInstance();

			try {
				db = dbf.newDocumentBuilder();
				document = db.parse(file);
			}

			catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			nList = document.getElementsByTagName("suite");
			failedTest = nList.item(0).getAttributes().getNamedItem("name").getNodeValue();
		}
		return failedTest;
	}
}