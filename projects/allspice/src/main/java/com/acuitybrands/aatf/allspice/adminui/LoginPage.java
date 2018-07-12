package com.acuitybrands.aatf.allspice.adminui;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class LoginPage extends BasePage {

	// *********Constructor*********
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	WebDriverWait wait = ExplicitWait(driver, 20);

	// *********Page Variables*********
	//String loginPageJson = "src/test/resources/data/LoginPageTest.json";
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	

	// *********Page Methods*********
	// Go to Homepage
	public void GotoAdminUI() {

		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Admin", "Check Connection/URL.");
	}

	// *********Page Methods*********
	public void LoginToAdminUI(String username, String password) {

		try {
			// Explicit Object

			// Entering user's email id			
			WriteTextInToWebElement("usertxtlid",AdminUIConstants.loginpageJson, username,5,"Email Textbox");	
			
			// Clicking on next button to enter user password
			ClickWebElement("nextbtnid",AdminUIConstants.loginpageJson,5);
			
			//CheckErrorMessage("userErrorMsg",AdminUIConstants.loginpageJson);			
			
			// Entering user's password
			WriteTextInToWebElement("passwordtxtid",AdminUIConstants.loginpageJson, password,10,"Password Textbox");

			// Clicking on next button to login to AdminUI
			ClickWebElement("nextbtnid",AdminUIConstants.loginpageJson,5);

			//CheckErrorMessage("passwordErrorMsg",AdminUIConstants.loginpageJson);
			
			// Clicking on "Yes" to make the user "Stay signed in" on the browser 
			ClickWebElement("nextbtnid",AdminUIConstants.loginpageJson,5);

			// Explicit wait to select the partner drop down is available and selecting "_QA_ATG_Atrius" 
			ClickWebElement("ddlpartnerid",AdminUIConstants.loginpageJson,30);

			// Clicking on Save button to transfer the user to the home page 
			ClickWebElement("savebtnid",AdminUIConstants.loginpageJson,30);

			/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search for site...\"]")))
					.click();*/
            System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Detail | Sites | Acuity IPS Admin","Page Title not matched");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Verify Username Condition
	public void VerifyLoginUserName(String expectedText) {
		// Assert.assertEquals(readText(errorMessageUsername), expectedText);
	}

	// Verify Password Condition
	public void VerifyLoginPassword(String expectedText) {
		// Assert.assertEquals(readText(errorMessagePassword), expectedText);
	}

	
}
