package com.comcast.crm.generic.listenerlib;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.comcast.basetest.BaseClass;

public class ListenersClass implements ITestListener ,ISuiteListener{

	public ExtentReports report;
	public ExtentTest test;
	public ExtentSparkReporter spart;

	@Override
	public void onStart(ISuite suite) {
		String time=new Date().toString().replaceAll(" ","_").replaceAll(":","_");
		spart=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spart.config().setDocumentTitle(" CRM Test Suite Results ");
		spart.config().setReportName(" CRM Report ");
		spart.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spart);
		report.setSystemInfo("Os","Windows");
		report.setSystemInfo("Browser","Chrome-100");		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+"==> Started <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"==> Completed <==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot eDriver=(TakesScreenshot) BaseClass.sdriver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":"," ");
		test.addScreenCaptureFromBase64String(filePath, testName+" "+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+" ==> Failed <==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
