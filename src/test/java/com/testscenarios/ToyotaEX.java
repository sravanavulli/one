package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.locators.ToyotaLocators;
import com.util.CommonFunctions;
import com.util.StaticVariables;

public class ToyotaEX extends StaticVariables {
	CommonFunctions cf = new CommonFunctions();

	@Test
	public void f() throws FileNotFoundException, IOException, Exception {
		String propFilePath = System.getProperty("user.dir") + "\\TeastData\\toyota.properties";
		FileInputStream fio = new FileInputStream(propFilePath);
		Properties p = new Properties();
		p.load(fio);
		
		driver.get(p.getProperty("toyota.url"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cf.click(ToyotaLocators.TERM_BUTTON);
		
		cf.waitClickable(ToyotaLocators.TITLE_LINK_CLASS, 10);
		cf.click(ToyotaLocators.TITLE_LINK_CLASS);
		
		cf.waitClickable(ToyotaLocators.TITLE_LINK_MR, 10);
		cf.click(ToyotaLocators.TITLE_LINK_MR);
		cf.waitVisible(ToyotaLocators.FNAME_TXT, 10);
		cf.sendKeys(ToyotaLocators.FNAME_TXT, p.getProperty("user.fname"));
		cf.waitVisible(ToyotaLocators.SURNAME_TEXT, 10);
		cf.sendKeys(ToyotaLocators.SURNAME_TEXT, p.getProperty("user.surname"));
		cf.waitVisible(ToyotaLocators.EMAIL_TEXT, 10);
		cf.sendKeys(ToyotaLocators.EMAIL_TEXT, p.getProperty("user.email"));
		cf.scriptClick(ToyotaLocators.SUBMIT_BUTTON);
	}



	



	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		CommonFunctions.screenshot();
	}

	@BeforeClass
	public void beforeClass() {
		cf.chromeBrowserLaunch();
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();

	}

}
