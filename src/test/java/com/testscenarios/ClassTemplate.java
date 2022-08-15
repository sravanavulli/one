package com.testscenarios;

import org.testng.annotations.Test;

import com.util.CommonFunctions;
import com.util.StaticVariables;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class ClassTemplate extends StaticVariables {
	CommonFunctions cf = new CommonFunctions();
  @Test
  public void f() throws IOException {
	  String propFilePath = System.getProperty("user.dir") + "\\TeastData\\d2h.properties";
		FileInputStream fio = new FileInputStream(propFilePath);
		Properties p = new Properties();
		p.load(fio);

		driver.get(p.getProperty("url of website"));

  }
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
	  driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  cf.screenshot();
  }

}
