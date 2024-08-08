package com.crm.Listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.Baseclass.VitigerBase;





public class VitigerListners extends VitigerBase implements ITestListener{
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String method = result.getMethod().getMethodName();
		Reporter.log(method+" is Started !");
		test = report.createTest(method);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String method = result.getMethod().getMethodName();
		test.log(Status.FAIL, method + " is Failed !");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String ss = screenshot.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("onTestFailedButWithinSuccessPercentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("onTestFailedWithTimeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter("./Extent Report/Report.html");
		spark.config().setDocumentTitle("Software Testing Report (Selenium)");
		spark.config().setReportName("Test failure report....");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11 Home");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "126");
		report.setSystemInfo("Author", "Amit");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish",true);
	}

}

