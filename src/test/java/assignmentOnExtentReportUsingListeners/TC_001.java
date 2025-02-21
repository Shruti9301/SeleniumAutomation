package assignmentOnExtentReportUsingListeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Assignment.DwsBase;
@Listeners(com.crm.AssignmentListeners.AttachExtentReportForTC_001.class)
public class TC_001 extends DwsBase {
	@Test
	public void search_field() {
		String search_text = "Smart Watch";
		WebElement search_field = driver.findElement(By.xpath("//input[@value='Search store']"));
		search_field.sendKeys("Smart Watch");
		assertEquals(search_field.getAttribute("value"),search_text);
	}

}
