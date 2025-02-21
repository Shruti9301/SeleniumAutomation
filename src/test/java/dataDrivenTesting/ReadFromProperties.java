package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadFromProperties {
	@Test
	public void data() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\DwsLogin.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Thread.sleep(2000);
		System.out.println(browser);
		Thread.sleep(2000);
		System.out.println(url);
		Thread.sleep(2000);
		System.out.println(username);
		Thread.sleep(2000);
		System.out.println(password);
	}
 
}
