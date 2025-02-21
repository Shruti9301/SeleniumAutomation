package basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigurationAnnotation2 {
	
	//Befor every Test method beforeMethod is execute and After every Test method afterMethod is execute. 
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMetod() {
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("I am Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am Test2");
	}
	
	@Test
	public void test3() {
		System.out.println("I am Test3");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void afterTeat() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}

}
