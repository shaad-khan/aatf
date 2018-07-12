package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.acuitybrands.aatf.allspice.adminui.PageGenerator;
import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class BaseTest {	

	// *********Page Objects*********
	public WebDriver driver;
	public WebDriverWait wait;
	public PageGenerator page;
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String baseJson = AdminUIConstants.ResourcesPath +"BaseTest.json";
   
	@BeforeMethod
	public void setup() {
		System.out.println(baseJson);
		// Create a Browser driver. All test classes use this.

		switch (jsonObj.ParseJson(baseJson, "driver").toString()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Driver");
			break;

		}
		
		// Create a wait. All test classes use this.
		wait = new WebDriverWait(driver, 15);

		// Maximize Window
		driver.manage().window().maximize();

		// Instantiate the Page Class
		page = new PageGenerator(driver);
	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
