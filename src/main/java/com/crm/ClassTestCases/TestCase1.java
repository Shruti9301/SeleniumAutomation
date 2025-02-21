package com.crm.ClassTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadFromProperties;

public class TestCase1 {
	
	public static WebDriver driver = null;
	
	@BeforeClass
	public static void preCondition() throws IOException {
		String browser = ReadFromProperties.getData("browser");
		String url = ReadFromProperties.getData("url");
		
	 if(browser.equalsIgnoreCase(browser)) {
		 driver = new ChromeDriver();
	 }
	 else if(browser.equalsIgnoreCase(browser)) {
		 driver = new EdgeDriver();
	 }
	 else if(browser.equalsIgnoreCase(browser)) {
		 driver = new FirefoxDriver();
	 }
	 else {
		 driver = new ChromeDriver();
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.get(url);	
	}
	
	@BeforeMethod
	public static void login() throws IOException {
		String expected_url = "url";
		String username = ReadFromProperties.getData("username");
		String password = ReadFromProperties.getData("password");
		String actual_url = driver.getCurrentUrl();
		
		if(actual_url.equals(expected_url)) {	
		System.out.println("I am in DWS page");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		System.out.println("Login is successfull");
		}
	}
	
	@AfterMethod
	public static void logout() {
		
		driver.findElement(By.className("ico-logout")).click();
		System.out.println("Logout is successfull");
	}
	@AfterClass
	public static void postCondition() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}	

}
