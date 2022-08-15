package com.testscenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.annotation.CheckForNull;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.locators.D2HRegiLocators;
import com.util.CommonFunctions;
import com.util.StaticVariables;

public class D2H extends StaticVariables {
	CommonFunctions cf = new CommonFunctions();

	@Test
	public void f() throws IOException, InterruptedException {
		String propFilePath = System.getProperty("user.dir") + "\\TeastData\\d2h.properties";
		FileInputStream fio = new FileInputStream(propFilePath);
		Properties p = new Properties();
		p.load(fio);

		driver.get(p.getProperty("dtoh.url"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		cf.waitVisible(D2HRegiLocators.EMAIL_TEXT, 10);
		cf.sendKeys(D2HRegiLocators.EMAIL_TEXT, p.getProperty("email"));

		cf.waitVisible(D2HRegiLocators.Password_TEXT, 10);
		cf.sendKeys(D2HRegiLocators.Password_TEXT, p.getProperty("password"));

		cf.waitVisible(D2HRegiLocators.ConfirmPassword_TEXT, 10);
		cf.sendKeys(D2HRegiLocators.ConfirmPassword_TEXT, p.getProperty("confirm.password"));

		// cf.waitClickable(DtoHRegiLocators.Question_DD , 10);
		// cf.click(DtoHRegiLocators.Question_DD);

		Select se = cf.createSelect(D2HRegiLocators.Question_DD);

		// Select the option with value "6"
		se.selectByVisibleText("Name of School");

		cf.waitVisible(D2HRegiLocators.Ans_Text, 10);
		cf.sendKeys(D2HRegiLocators.Ans_Text, p.getProperty("answer"));

		// cf.waitClickable(DtoHRegiLocators.Req_Otp_Link, 10);
		// cf.click(DtoHRegiLocators.Req_Otp_Link);
		cf.scriptClick(D2HRegiLocators.Req_Otp_Link);
		
		/*
		 * cf.waitForAlertPresent(10); String
		 * alertText=driver.switchTo().alert().getText(); System.out.println(alertText);
		 * driver.switchTo().alert();
		 */
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		CommonFunctions.screenshot();
	}

	//String browsername = "firefox";
	@Parameters("browsername")

	@BeforeClass
	public void beforeClass(String browsername) {
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

	@AfterClass
	public void afterClass() {
	}

}
