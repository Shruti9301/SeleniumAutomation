package extentReportMethod;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBase;

public class UsingListeners extends DWSBase{
	@Test
	public void main1() {
		Reporter.log("main1");
	}
	
	@Test (timeOut = 1000)
	public void main2() throws InterruptedException {
		Reporter.log("main2");
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods = "main2")
	public void main3() {
		Reporter.log("main3");
	}

}
