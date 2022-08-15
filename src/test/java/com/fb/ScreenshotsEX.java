package com.fb;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsEX {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("sravani.vulli3@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Nani@2013");
		CommonFunctions.screenshot();
		driver.close();
	}

}
