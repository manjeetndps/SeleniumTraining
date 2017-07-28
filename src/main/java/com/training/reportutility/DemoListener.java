/**
 * Author:- Manjeet Kumar
 */

package com.training.reportutility;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.common.reruntestutils.RerunFailedTestSuite;
import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;
import com.training.webdriverhelper.DriverUtility;




public class DemoListener extends DriverUtility implements ITestListener, ISuiteListener {

	// This belongs to ISuiteListener and will execute before the Suite start

	public static int count = 2;
	ReportUtils report=new ReportUtils();
	
	@Override
	public void onStart(ISuite arg0) {
		
		BaseTestSetup.readConfigData();
		BaseTestSetup.configDataList.get(ConfigConstant.APPNAME).toString();
		
		ExportTestResults export=new ExportTestResults();
		export.exportExcelHeader(BaseTestSetup.configDataList.get(ConfigConstant.APPNAME).toString());


	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {

		report.fGenerateHTMLReport();
	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		report.fGenerateExcelReport(arg0);

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		while (count < 3) {
			getWebDriver().close();
			count++;
			report.fGenerateExcelReport(arg0);
			RerunFailedTestSuite.runFailedTest();
		}

	}

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult arg0) {

		//System.out.println("The execution of the main test starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		report.fGenerateExcelReport(arg0);

		}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}
}