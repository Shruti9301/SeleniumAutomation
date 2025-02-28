package com.crm.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pom.DwsLogin;

public class Login {
	@Test
	public void loginTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		DwsLogin dws = new DwsLogin(driver);
		dws.login_link.click();
		dws.username.sendKeys("admin01@gmail.com");
		dws.password.sendKeys("admin01");
		dws.rememberMe.click();
		dws.login_button.click();
		driver.close();
		
	}

}
