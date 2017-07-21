/**
 * Author:- Manjeet Kumar
 */

package com.training.reportutility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import com.common.utility.CaptureScreenShot;
import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;

public class ReportUtils {

	private static Logger logger = LoggerFactory.getLogger(ReportUtils.class);

	int total = 0;
	int failed = 0;
	int passed = 0;
	int sikped = 0;

	ExportTestResults export = new ExportTestResults();
	HashMap<String, String> tcDetails = new HashMap<String, String>();

	public void fGenerateExcelReport(ITestResult result) {

		System.out.println(" fGenerateExcelReport ");

		try {

			String tcId = result.getName();
			String tcName = result.getName();

			total++;

			// System.out.println("Total After Increment ::"+total);
			List<String> tcExeDetails = new ArrayList<String>();

			tcExeDetails.add(Integer.toString((total)));

			tcExeDetails.add(tcId);
			tcExeDetails.add(tcName);

			String status = null;
			String screenshotPath = null;
			String errorMessage = null;

			switch (result.getStatus()) {

			case ITestResult.SUCCESS:

				passed++;
				status = "Pass";
				errorMessage = "";
				screenshotPath = "";

				break;

			case ITestResult.FAILURE:

				failed++;
				status = "Fail";
				errorMessage = fToString(result.getThrowable());

				if (errorMessage.length() > 200)
					errorMessage = errorMessage.substring(0, 200);
				
				// calling take a screenshot method
				screenshotPath = CaptureScreenShot.takeScreenShot(BaseTestSetup.configDataList.get(ConfigConstant.APPNAME).toString(), result.getMethod().getMethodName());
				break;

			case ITestResult.SKIP:

				sikped++;
				status = "Skip";
				errorMessage = "";
				screenshotPath = "";
				break;

			}

			tcExeDetails.add(status);
			tcExeDetails.add(errorMessage);
			tcExeDetails.add(screenshotPath);

			logger.info("######################################");
			logger.info(tcName + " Status :: " + status);
			logger.info("######################################");

			String timeTaken = Long.toString((result.getEndMillis() - result.getStartMillis()) / 1000);

			tcExeDetails.add((new Date()).toString());
			tcExeDetails.add(timeTaken);

			ConfigConstant.testCasesResutls.put("Row" + total, tcExeDetails);

			export.exportExcelRows(tcExeDetails);

			System.out.println("testCasesResutls  ::" + ConfigConstant.testCasesResutls.size());

		} catch (Exception e) {
			System.out.println("Error occured while generating Excel Report the Module " + BaseTestSetup.configDataList.get(ConfigConstant.APPNAME).toString()
					+ " " + e.getMessage());
		}
	}

	public void fGenerateHTMLReport() {
		try {

			System.out.println("testCasesResutls in HTML Report ::" + ConfigConstant.testCasesResutls.size());

			TemplateGenerator template = new TemplateGenerator(ConfigConstant.testCasesResutls);

			ConfigConstant.testCasesResutls = new HashMap<String, List<String>>();

			export.exportTestSummary(total, passed, failed);
			template.buildTemplate(total, passed, failed);

		} catch (Exception e) {
			System.out.println("Error occured while generating the HTML report   for the Module "
					+ BaseTestSetup.configDataList.get(ConfigConstant.APPNAME).toString() + "  " + e.getMessage());
		}
	}

	public static String fToString(Throwable t) {
		String value = "";
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			value = sw.toString();

		} catch (Exception e) {
			System.out.println("Error Occured while converting the Throwable to string .." + e.getMessage());
		}

		return value;
	}

}
