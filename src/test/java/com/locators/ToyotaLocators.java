package com.locators;

import org.openqa.selenium.By;

public interface ToyotaLocators {
	By TERM_BUTTON=By.id("onetrust-accept-btn-handler");
	By TITLE_LINK = By.xpath("//*[text()='- Please select -']");
	By TITLE_LINK_CLASS = By.xpath("//*[@id='order_brochure']/div/form/div[7]/div[1]/div[3]/div/div/a");
	By TITLE_LINK_MR = By.xpath("//*[@id='order_brochure']/div/form/div[7]/div[1]/div[3]/div/div/ul/li[1]/a");
	By TITLE_LINK_2 = By.xpath("//*[text()='Mrs']");
	By FNAME_TXT = By.xpath("//input[@name='firstname']");
	By SURNAME_TEXT= By.xpath("//input[@name='surname']");
	By EMAIL_TEXT=By.xpath("//input[@name='email']");
	By SUBMIT_BUTTON = By.id("submit-br");
	By SUBMIT_BUTTON_2 = By.xpath("//a[@id='submit-br']");
}
