package extentReportMethod;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	@Test
	public void reports() {
		File path = new File(".\\src\\test\\resources\\Reports\\SampleReport.html");
		
		//Create ExtentSparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		
		//Configure ExtentSparkReport
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Shruti");
		spark.config().setTheme(Theme.DARK);
		
		//Create ExtentReport
		ExtentReports report = new ExtentReports();
		
		//Provide System information
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "Chrome-111");
		
		//Attach ExtentSparkReport to the ExteneReports
		report.attachReporter(spark);
		
		//Create ExtentTest
		ExtentTest test = report.createTest("reports");
		
		//Use Flush
		report.flush();
	}

}
