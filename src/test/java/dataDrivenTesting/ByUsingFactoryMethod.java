package dataDrivenTesting;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.FileUtility.ReadFromProperties;

public class ByUsingFactoryMethod {
	@Test
	public void readData() throws IOException {
		String browser = ReadFromProperties.getData("browser");
		System.out.println(browser);
		String url = ReadFromProperties.getData("url");
		System.out.println(url);
		String username = ReadFromProperties.getData("username");
		System.out.println(username);
		String password = ReadFromProperties.getData("password");
		System.out.println(password);	
	}
}
