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

public class BasePageTest {

	// *********Page Objects*********
	public WebDriver driver;
	public WebDriverWait wait;
	public PageGenerator page;
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String loginpageJson = AdminUIConstants.loginpageJson;

	@BeforeMethod
	public void setup() {

		try {
			// Create a Browser driver. All test classes use this.
			BasePageTest objBasePageTest = new BasePageTest();
			String basePageJson = AdminUIConstants.ResourcesPath + objBasePageTest.getClass().getSimpleName() + ".json";
			String browser = jsonObj.ParseJson(basePageJson, "driver").toString();
			switch (browser) {

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
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
			
			// Create login page instance and calling AdminUI to assign base URL 
			page.GetInstance(LoginPage.class).GotoAdminUI();

			// Create login page instance and calling Login AdminUI to get/assign xpath values 
			page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(loginpageJson, "username").toString(),
					jsonObj.ParseJson(loginpageJson, "password").toString());

		} catch (Exception exp) {
			// throw exp.printStackTrace();
		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
