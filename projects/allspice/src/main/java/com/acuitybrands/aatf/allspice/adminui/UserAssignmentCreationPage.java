package com.acuitybrands.aatf.allspice.adminui;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;
public class UserAssignmentCreationPage extends BasePage {

	public UserAssignmentCreationPage(WebDriver driver) {
		super(driver);
		
	}
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;
	public void UserAssginmentCreation(String search_val) {
		try {
			// Explicit Object
			//wait = ExplicitWait(driver, 7);
            WaitOnWebElement("partner",AdminUIConstants.UserAssignmentCreatejson, 40);
			ClickWebElement("user", AdminUIConstants.UserAssignmentCreatejson, 30);

			ClickWebElement("search", AdminUIConstants.UserAssignmentCreatejson, 20);

			WriteTextInToWebElement("search", AdminUIConstants.UserAssignmentCreatejson,search_val, 30);

			ClickWebElement("sitem", AdminUIConstants.UserAssignmentCreatejson, 30);

			ClickWebElement("assigmnent_nav", AdminUIConstants.UserAssignmentCreatejson, 30);
			ClickWebElement("org_nav", AdminUIConstants.UserAssignmentCreatejson, 10);
			ClickWebElement("org_name", AdminUIConstants.UserAssignmentCreatejson, 20);
			
			ClickWebElement("app_name", AdminUIConstants.UserAssignmentCreatejson, 30);
			ClickWebElement("role", AdminUIConstants.UserAssignmentCreatejson, 30);
			ClickWebElement("savebtn", AdminUIConstants.UserAssignmentCreatejson, 30);
			//ClickWebElement("maxheight", AdminUIConstants.UserAssignmentCreatejson, 10);
			
			//AssertValAgainstWebelement("search_val",AdminUIConstants.UserAssignmentCreatejson,, 30);

		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	

}
