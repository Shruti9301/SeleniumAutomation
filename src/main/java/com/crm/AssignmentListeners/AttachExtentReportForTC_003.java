package com.crm.AssignmentListeners;

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
import com.crm.Assignment.DwsBase;

public class AttachExtentReportForTC_003 extends DwsBase implements ITestListener{
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
		String screenShot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenShot);
		test.log(Status.FAIL, name+" is fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name+" is skip");
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart",true);
		File path = new File(".\\src\\test\\resources\\Reports_TC_003\\Report1.html");
		spark = new ExtentSparkReporter(path);
		
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Shruti");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Window-11");
		
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish",true);
		report.flush();
		
	}

}
