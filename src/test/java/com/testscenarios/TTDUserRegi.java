package com.testscenarios;

import static com.locators.TTDURLocator.ADDRESS_1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.locators.TTDURLocator;
import com.util.CommonFunctions;
import com.util.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TTDUserRegi extends StaticVariables {
	private CommonFunctions cf = new CommonFunctions();

	@Test
	public void f() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://tirupatibalaji.ap.gov.in/#/login");

		Thread.sleep(10000);
		driver.findElement(TTDURLocator.SIGN_UP).click();
		Thread.sleep(2000);
		driver.findElement(TTDURLocator.ENTITY).click();
		Thread.sleep(10000);
		driver.findElement(TTDURLocator.INDIVIDUAL).click();

		cf.sendKeys(TTDURLocator.FIRST_NAME, "sravani");
		cf.sendKeys(TTDURLocator.LAST_NAME, "vulli");
		cf.sendKeys(TTDURLocator.MOBILE_NUMBER, "8374038136");

		Thread.sleep(10000);
		cf.sendKeys(ADDRESS_1, "108 d frt");
		cf.sendKeys(TTDURLocator.ADDRESS_2, "Telangana");
		cf.sendKeys(TTDURLocator.CITY_S, "suryapet");
		cf.sendKeys(TTDURLocator.ZIP_CODE, "85027");
		cf.sendKeys(TTDURLocator.PROOF_ID, "abc85027");
		cf.sendKeys(TTDURLocator.EMAIL_ID, "sravani.vulli3@gmail.com");
		cf.sendKeys(TTDURLocator.PASSWORD, "Abcd@1234");
		cf.sendKeys(TTDURLocator.RE_PASSWORD, "Abcd@1234");
		driver.findElement(TTDURLocator.REGI_CONTINUE).click();

		//
		
		Select countrysDD = cf.createSelect(TTDURLocator.COUNTRY_S);
		countrysDD.selectByVisibleText("India");
		Thread.sleep(1000);
		Select stateDD = cf.createSelect(TTDURLocator.STATE_S);
		stateDD.selectByVisibleText("Andhra Pradesh");

		Select idDD = cf.createSelect(TTDURLocator.PROOF_S);
		idDD.selectByVisibleText("PAN Card");

		System.out.println("success");
		
		
	}
	

	
}
