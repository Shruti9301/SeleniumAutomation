package dataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {
	
	@DataProvider (name = "login")
	public Object[][] sender(){
		Object[][] obj = new Object[2][2];
		obj[0][0] = "admin01@gmail.com";
		obj[0][1] = "admin01";
		obj[1][0] = "admin01@@gmail.com";
		obj[1][1] = "admin111";
		return obj;
	}
	
	@Test (dataProvider = "login")
	public void reciever(String username, String password) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("ico-login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class='ico-logout']")).click();
		Thread.sleep(2000);
		driver.quit();
		Thread.sleep(5000);
	}
}
