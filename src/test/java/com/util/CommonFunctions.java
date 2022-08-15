package com.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends StaticVariables {
	/** browser setup **/
	public void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void edgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	

	/** send keys **/
	public void sendKeys(By locator, String input) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed()) {
			if (ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(input);
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

	public void submit(By locator) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed()) {
			if (ele.isEnabled()) {
				ele.submit();
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

	/*
	 * public Properties readProperties() throws FileNotFoundException, IOException
	 * { String propFilePath = System.getProperty("user.dir") +
	 * "\\TeastData\\toyota.properties"; FileInputStream fio = new
	 * FileInputStream(propFilePath); Properties p = new Properties(); p.load(fio);
	 * fio.close(); return p; }
	 */

	public static void screenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotsPath = System.getProperty("user.dir") + "\\Screenshots\\";
		String timeStamp = getTimeStamp();
		FileHandler.copy(srcFile, new File(screenshotsPath + "Sravani_" + timeStamp + ".PNG"));
	}

	public static String getTimeStamp() {
		// TODO Auto-generated method stub
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String strDate = dateFormat.format(date);

		return strDate;
	}

	public WebElement waitClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForAlert(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void scriptClick(By locator) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(locator));
	}
}
