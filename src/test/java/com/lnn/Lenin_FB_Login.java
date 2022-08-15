package com.lnn;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.locators.FBLoginLocators;

public class Lenin_FB_Login extends LeninCommon {

	@BeforeMethod
	public void setup() {
		chromeDriver();
		readProperties("fb.properties");
	}

	@Test
	public void f() {
		loadPage("fb.url");
		sendKeys(FBLoginLocators.FB_login_Email_Editbox, "user.name");
		sendKeys(FBLoginLocators.FB_login_Password_Editbox, "user.password");
		click(FBLoginLocators.FB_login_Login_Button);
		sleep(1000);
	}

	@AfterMethod
	public void takeScreenshot() {
		screenshot();
	}
}
