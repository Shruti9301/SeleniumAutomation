package assignmentOnExtentReportUsingListeners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Assignment.DwsBase;
@Listeners(com.crm.AssignmentListeners.AttachExtentReportForTC_002.class)
public class TC_002 extends DwsBase {
	@Test
	public void giftCard() throws InterruptedException {
		String expected_url_5gift = "https://demowebshop.tricentis.com/5-virtual-gift-card";
		String expected_url_25gift = "https://demowebshop.tricentis.com/25-virtual-gift-card";
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
		Thread.sleep(2000);
		List<WebElement> add_to_cart = driver.findElements(By.xpath("//input[@ value='Add to cart']"));
		Thread.sleep(2000);
		for(WebElement web : add_to_cart) {
			web.click();
			Thread.sleep(2000);
			String actual_url = driver.getCurrentUrl();
			if(actual_url.equals(expected_url_5gift) || actual_url.equals(expected_url_25gift)) {
				driver.findElement(By.className("recipient-name")).sendKeys("Ram");
				Thread.sleep(2000);
				driver.findElement(By.className("recipient-email")).sendKeys("ram29@gmail.com");
				Thread.sleep(2000);
			}
			else {
				driver.findElement(By.className("recipient-name")).sendKeys("Ram");
				Thread.sleep(2000);
			}
			WebElement cart_button = driver.findElement(By.xpath("//input[@value='Add to cart']"));
			cart_button.click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		//remove the highest price iteam
		
		double highestPrice = 0.0;
		WebElement highestPriceIteam = null;
		List<WebElement> prices = driver.findElements(By.className("product-unit-price"));
		List<WebElement> removeCheckboxes = driver.findElements(By.name("removefromcart"));
		
		 for(int i = 0; i < prices.size(); i++) {
			double price = Double.parseDouble(prices.get(i).getText().replace("$", "").trim());
			
				 if(price > highestPrice) {
					 highestPrice = price;
					 highestPriceIteam = removeCheckboxes.get(i);
				}
		    }
		    Thread.sleep(2000);
		    if(highestPriceIteam != null) {
		    	highestPriceIteam.click();
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		    	Thread.sleep(2000);
		    }
		    System.out.println("Removes the highest priced iteam: "+highestPrice);
	 }

}
