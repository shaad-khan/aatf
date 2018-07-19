package com.acuitybrands.aatf.allspice.adminui;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateUserPage extends BasePage {

	public CreateUserPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;

	// *********Page Variables*********	

	public void UserCreation() {
		try {
			//CreateUserPage objCreateUserPage = new CreateUserPage(driver);
			String createUserPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";
			
			//Reading values from Json file to create a test user.
			String User_FirstName = jsonObj.ParseJson(createUserPageJson, "FirstName") ;
			String User_LastName = jsonObj.ParseJson(createUserPageJson, "LastName") ;
			String User_Email = jsonObj.ParseJson(createUserPageJson, "Email") ;
			String User_UserName = jsonObj.ParseJson(createUserPageJson, "UserName") ;
			String ErrorMsgXpath = jsonObj.ParseJson(createUserPageJson, "ErrorMsgAlert") ;
			
			// Explicit Object
			// wait = explicitWait(driver, 7);

			ClickWebElement("UsersTab", createUserPageJson, 20);

			ClickWebElement("btnUserCreate", createUserPageJson, 20);

			ClickWebElement("txtFirstName", createUserPageJson, 20);
			ClearWebElement("txtFirstName",createUserPageJson, 20);
			WriteTextInToWebElement("txtFirstName", createUserPageJson, User_FirstName, 20);

			ClickWebElement("txtLastName", createUserPageJson, 20);
			ClearWebElement("txtLastName",createUserPageJson, 20);
			WriteTextInToWebElement("txtLastName", createUserPageJson, User_LastName, 20);

			ClickWebElement("txtEmail", createUserPageJson, 20);
			ClearWebElement("txtEmail", createUserPageJson, 20);
			WriteTextInToWebElement("txtEmail", createUserPageJson, User_Email, 20);

			ClickWebElement("txtUserName", createUserPageJson, 20);
			ClearWebElement("txtUserName", createUserPageJson, 20);
			WriteTextInToWebElement("txtUserName", createUserPageJson, User_UserName, 20);

			ClickWebElement("btnSaveUser", createUserPageJson, 20);

			//Checking for error message
			if(CheckForErrorMessage(ErrorMsgXpath, 20))
			{
				Assert.fail("Failed to create new User.");
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
