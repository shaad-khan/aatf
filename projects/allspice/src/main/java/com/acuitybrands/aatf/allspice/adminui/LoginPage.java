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
	WebDriverWait wait = ExplicitWait(driver, 5);

	// *********Page Variables*********
	
	String loginPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

	
	// *********Page Methods*********
	// Go to Homepage
	public void GotoAdminUI() {		
		
		//String Tet = new Object().getClass().getEnclosingClass().getName();
		String baseURL = jsonObj.ParseJson(loginPageJson, "url").toString();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Admin", "Check Connection/URL.");
	}

	// *********Page Methods*********
	public void LoginToAdminUI(String username, String password) {

		try {
			
			// Entering user's email id			
			WriteTextInToWebElement("usertxtlid",loginPageJson, username,5,"Email Textbox");	
			
			// Clicking on next button to enter user password
			ClickWebElement("nextbtnid",loginPageJson,5);
			
			//CheckErrorMessage("userErrorMsg",AdminUIConstants.loginpageJson);			
			
			// Entering user's password
			WriteTextInToWebElement("passwordtxtid",loginPageJson, password,10,"Password Textbox");

			// Clicking on next button to login to AdminUI
			ClickWebElement("nextbtnid",loginPageJson,5);

			//CheckErrorMessage("passwordErrorMsg",AdminUIConstants.loginpageJson);
			
			// Clicking on "Yes" to make the user "Stay signed in" on the browser 
			ClickWebElement("nextbtnid",loginPageJson,5);

			// Explicit wait to select the partner drop down is available and selecting "_QA_ATG_Atrius" 
			ClickWebElement("ddlpartnerid",loginPageJson,10);
			
			// Clicking on Save button to transfer the user to the home page 
			ClickWebElement("savebtnid",loginPageJson,5);
			
			// Explicit wait to select the Environment drop down is available and selecting "Acuity QA US" 
			ClickWebElement("ddlEnvironmentid",loginPageJson,10);
			
			// Clicking on Save button to transfer the user to the home page 
			ClickWebElement("savebtnid",loginPageJson,5);

			

			/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search for site...\"]")))
					.click();*/

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
