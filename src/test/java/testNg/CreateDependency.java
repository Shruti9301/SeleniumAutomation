package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateDependency {
	
	// 1st execute
	// This method is get failed
	@Test (priority = 1, timeOut = 2000)
	public void createAccount() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();
		System.out.println("Create Account");
		Thread.sleep(3000);
	}
	
	// 2nd execute
	// This method get skips bcz 1st one is failed (dependency)
	@Test (priority = 0, dependsOnMethods = "createAccount")
	public void updateAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chennaisuperkings.com/");
		driver.close();
		System.out.println("Update Account");
	}
	
	// 3rd execute
	// This method get skips bcz 1st one is failed (dependency)
	@Test (priority = 2, dependsOnMethods = "createAccount")
	public void deleteAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.royalchallengers.com/");
		driver.close();
		System.out.println("Delete Account");
	}
}
