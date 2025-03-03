package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLogin {
	public DwsLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-login")
	public WebElement login_link;
	
	@FindBy(id = "Email")
	public WebElement username;
	
	@FindBy(id = "Password")
	public WebElement password;
	
	@FindBy(id = "RememberMe")
	public WebElement rememberMe;
	
	@FindBy(xpath = "//a[text()='Forget password?']")
	public WebElement forgot_password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	public WebElement login_button;
	
	public void loginLink() {
		login_link.click();
	}
	public void userName(String email){
		username.sendKeys(email);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void rememberMe() {
		rememberMe.click();
	}
	public void forgotPassword() {
		forgot_password.click();
	}
	public void loginButton() {
		login_button.click();
	}

}
