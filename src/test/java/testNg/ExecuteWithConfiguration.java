package testNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

public class ExecuteWithConfiguration extends DWSBase{
	
	@Test
	public void main1() throws InterruptedException {
	Thread.sleep(2000);	
	driver.findElement(By.id("small-searchterms")).sendKeys("Welcome to Advanced Selenium");
	driver.findElement(By.xpath("//input[@fdprocessedid='nyd3e']")).click();
	Thread.sleep(2000);
	}
	
	@Test
	public void main2() throws InterruptedException {
		String rss_url = "https://demowebshop.tricentis.com/news/rss/1";
		List<WebElement> ecommerce = driver.findElements(By.cssSelector(".column.follow-us"));
		for(WebElement web : ecommerce) {
			String actual_url = driver.getCurrentUrl();
			if(rss_url.equals(actual_url)) {
				driver.navigate().back();
			}
			web.click();
			Thread.sleep(2000);
		}
	}

}
