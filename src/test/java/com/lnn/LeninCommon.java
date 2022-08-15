package com.lnn;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeninCommon {
	protected WebDriver driver;
	protected Properties props = new Properties();

	/** send keys **/
	public void sendKeys(By locator, String input) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed()) {
			if (ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(props.getProperty(input));
			} else {
				System.out.println("web element not enabled");
			}
		} else {
			System.out.println("web element not displyad");
		}
	}

	/** click **/
	public void click(By locator) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed()) {
			if (ele.isEnabled()) {
				ele.click();
			} else {
				System.out.println("web element not enabled");
			}
		} else {
			System.out.println("web element not displyad");
		}
	}

	public Select createSelect(By id) {
		return new Select(driver.findElement(id));
	}

	public void readProperties(String fileName) {
		try {
			String propFilePath = System.getProperty("user.dir") + "\\TeastData\\" + fileName;
			FileInputStream fio = new FileInputStream(propFilePath);
			props.load(fio);
			fio.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void screenshot() {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotsPath = System.getProperty("user.dir") + "\\Screenshots\\";
			String timeStamp = getTimeStamp();
			FileHandler.copy(srcFile, new File(screenshotsPath + "Sravani_" + timeStamp + ".PNG"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getTimeStamp() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return dateFormat.format(date);
	}

	public void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void loadPage(String propName) {
		driver.get(props.getProperty(propName));
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
