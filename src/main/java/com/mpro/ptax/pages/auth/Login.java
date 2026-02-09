package com.mpro.ptax.pages.auth;

import org.openqa.selenium.By;

import com.mpro.ptax.Utils.ReadConfig;
import com.mpro.ptax.base.BasePage;

public class Login extends BasePage{


	private static final By username 			= By.id("loginId");
	private static final By password 			= By.id("password");
	private static final By loginButton 		= By.id("butsub");
	public 	static final By loginErrorMessage 	= By.xpath("//div[contains(@class,'growl-message')]");
	public void openUrl() {
		
		driver.get(ReadConfig.get("Url"));	
	}
	
	
	public void login(String user, String pass) {
		
		Input(username, user);
		Input(password, pass);
		click(loginButton);
		waitForPageLoad();
		
	}
}
