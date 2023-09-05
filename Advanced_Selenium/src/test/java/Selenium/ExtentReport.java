package Selenium;

import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	@Test
	public void extentRepo() {
		String time=new Date().toString().replaceAll(" ","_").replaceAll(":","_");
		ExtentSparkReporter spart=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spart.config().setDocumentTitle(" CRM Test Suite Results ");
		spart.config().setReportName(" CRM Report ");
		spart.config().setTheme(Theme.DARK);
		ExtentReports report=new ExtentReports();
		report.attachReporter(spart);
		report.setSystemInfo("Os","Windows");
		report.setSystemInfo("Browser","Chrome-100");
		ExtentTest test=report.createTest("Create Contact Test");
		
		test.log(Status.INFO,"Login To Application");
		test.log(Status.INFO,"Navigate To Contact Page");
		test.log(Status.INFO,"Create Contact");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact Is Created");
		}else {
			test.log(Status.FAIL,"Contact Is Not Created");
		}
		report.flush();
	}
	
}
