package com.locators;

import org.openqa.selenium.By;

public interface TTDURLocator {
	By SIGN_UP = By.partialLinkText("Sign Up");
	By ENTITY = By.id("entity");
	By INDIVIDUAL = By.id("individual");
	By FIRST_NAME = By.name("fName");
	By LAST_NAME = By.name("lName");
	By MOBILE_NUMBER = By.id("indiMobile");
	By ADDRESS_1 = By.name("address1");
	By ADDRESS_2 = By.name("address2");
	By CITY_S = By.name("cityS");
	By ZIP_CODE = By.name("zipCode");
	By PROOF_ID = By.id("proofid");
	By EMAIL_ID = By.name("emailId");
	By PASSWORD = By.name("password");
	By RE_PASSWORD = By.name("repassword");
	By REGI_CONTINUE = By.id("regi_continue");
	By COUNTRY_S = By.name("countryS");
	By STATE_S = By.name("stateS");
	By PROOF_S = By.name("proofS");
	
}
