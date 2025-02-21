package assignmentOnExtentReportUsingListeners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Assignment.DwsBase;
@Listeners(com.crm.AssignmentListeners.AttachExtentReportForTC_003.class)
public class TC_003 extends DwsBase {
	@Test
	public void communityPoll() throws InterruptedException {
		List<WebElement> community_poll = driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement web : community_poll) {
			web.click();
			Thread.sleep(2000);
		}
	}

}
