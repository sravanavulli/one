package com.testscenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.locators.FBLoginLocators;
import com.util.CommonFunctions;
import com.util.StaticVariables;

public class FB_Login extends StaticVariables {
	CommonFunctions cf = new CommonFunctions();

	@Test

	public void f() throws Exception {
		String propFilePath = System.getProperty("user.dir") +"\\TeastData\\fb.properties";
		FileInputStream fio = new FileInputStream(propFilePath);
		Properties p = new Properties();
		p.load(fio);
				  
		//cf.chromeBrowserLaunch();
		driver.get(p.getProperty("fb.url"));
		cf.sendKeys(FBLoginLocators.FB_login_Email_Editbox, p.getProperty("user.name"));
		cf.sendKeys(FBLoginLocators.FB_login_Password_Editbox, p.getProperty("user.password"));
		cf.click(FBLoginLocators.FB_login_Login_Button);
		Thread.sleep(10000);
		}
	
	
	@Parameters("browsername")

	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsername) {
		if (browsername.equalsIgnoreCase("Chrome")) {
			cf.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			cf.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			cf.edgeBrowserLaunch();
		} else {
			System.out.println("Please enter valid browser name..");
		}
	}
	@AfterMethod
	
	public void takeScreenshot() throws IOException {
		cf.screenshot();
		
		
	}

}
