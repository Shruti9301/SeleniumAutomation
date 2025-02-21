package listeners;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;
@Listeners(com.crm.Listeners.FailTestCaseScreenShot.class)
public class FailedTestCaseScreenShot extends DWSBase{
	@Test
	public void digitalDownload() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
//		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.className("ico-cart")).click();
		//verify product whether is added successfully or not
		Thread.sleep(2000);
		try {
			WebElement album3rd = driver.findElement(By.xpath("(//a[text()='3rd Album'])[2]"));
			assertTrue(album3rd.isDisplayed(), "Product is not added");
			Reporter.log("Product is successfully added",true);
			driver.findElement(By.name("removefromcart")).click();
			driver.findElement(By.name("updatecart")).click();
		} catch (Exception e) {
			Reporter.log("Product is not present",true);
			fail();
		}
	}
}
