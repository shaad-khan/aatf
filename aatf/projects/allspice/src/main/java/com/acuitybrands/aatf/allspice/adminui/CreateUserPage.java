package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	//String userCreatePageJson = "src/test/resources/data/UserCreatePageTest.json";

	public void UserCreation() {
		try {
			// Explicit Object
			// wait = explicitWait(driver, 7);

			ClickWebElement("UsersTab", AdminUIConstants.userCreatePageJson, 20);

			ClickWebElement("btnUserCreate", AdminUIConstants.userCreatePageJson, 20);

			ClickWebElement("txtFirstName", AdminUIConstants.userCreatePageJson, 5);

			WriteTextInToWebElement("txtFirstName", AdminUIConstants.userCreatePageJson, "FirstName", 5);

			ClearWebElement("txtLastName", AdminUIConstants.userCreatePageJson, 5);

			WriteTextInToWebElement("txtLastName", AdminUIConstants.userCreatePageJson, "LastName", 5);

			ClearWebElement("txtEmail", AdminUIConstants.userCreatePageJson, 5);

			WriteTextInToWebElement("txtEmail", AdminUIConstants.userCreatePageJson, "Email", 5);

			ClearWebElement("txtUserName", AdminUIConstants.userCreatePageJson, 5);

			WriteTextInToWebElement("txtUserName", AdminUIConstants.userCreatePageJson, "UserName", 5);

			ClickWebElement("btnSaveUser", AdminUIConstants.userCreatePageJson, 20);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search for site...\"]")))
					.click();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
