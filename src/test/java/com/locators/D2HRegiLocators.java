package com.locators;

import org.openqa.selenium.By;

public interface D2HRegiLocators {
	
	By EMAIL_TEXT=By.xpath("//input[@id='email']");
	By Password_TEXT= By.xpath("//input[@id='lpassword']");
	By ConfirmPassword_TEXT= By.xpath("//input[@id='cpassword']");
	By Question_DD = By.xpath("//select[@name='sqrtQues']");
	By Ans_Text = By.xpath("//input[@name='sqrtAns']");
	By Req_Otp_Link=By.xpath("//a[@id='rqstbtn']");
	

}
