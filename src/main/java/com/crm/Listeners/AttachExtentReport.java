package com.crm.Listeners;

import java.io.File;
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
import com.crm.BaseClass.DWSBase;

public class AttachExtentReport extends DWSBase implements ITestListener{
	public static ExtentSparkReporter spark = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
		test.log(Status.INFO, name+" is onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) driver;
		 String from = ts.getScreenshotAs(OutputType.BASE64);
		 test.addScreenCaptureFromBase64String(from);
		test.log(Status.FAIL, name+" is fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name+" is skip");
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart", true);
        File path = new File(".\\src\\test\\resources\\Reports\\MultipleTestCases.html");
		
		//Create ExtentSparkReport
		spark = new ExtentSparkReporter(path);
		
		//Configure ExtentSparkReport
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Shruti");
		spark.config().setTheme(Theme.DARK);
		
		//Create ExtentReport
		report = new ExtentReports();
		
		//Provide System information
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "Chrome-111");
		
		//Attach ExtentSparkReport to the ExteneReports
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish", true);
		report.flush();
	}

}
