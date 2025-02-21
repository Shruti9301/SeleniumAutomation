package com.crm.AssertationMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	public void main() {
		String expected_result = "https://demowebshop.tricentis.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		String actual_result = driver.getCurrentUrl();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expected_result, actual_result, "I am not in DWS page");
		Reporter.log("I am in DWS page", true);
		driver.close();
		soft.assertAll();
	}

}
