package com.acuitybrands.aatf.allspice.adminui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;
public class CreateUserAssignmentPage extends BasePage {

	public CreateUserAssignmentPage(WebDriver driver) {
		super(driver);
		
	}
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;
	
	 // *********Page Variables*********
	 String userAssignmentCreatejson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

	public void UserAssginmentCreation(String search_val) {
		try {
			// Explicit Object
			//wait = ExplicitWait(driver, 7);
            WaitOnWebElement("partner",userAssignmentCreatejson, 40);
			ClickWebElement("user", userAssignmentCreatejson, 30);

			ClickWebElement("search", userAssignmentCreatejson, 20);

			WriteTextInToWebElement("search", userAssignmentCreatejson,search_val, 30);

			ClickWebElement("sitem", userAssignmentCreatejson, 30);

			ClickWebElement("assigmnent_nav", userAssignmentCreatejson, 30);
			ClickWebElement("org_nav", userAssignmentCreatejson, 10);
			ClickWebElement("org_name", userAssignmentCreatejson, 20);
			
			ClickWebElement("app_name", userAssignmentCreatejson, 30);
			ClickWebElement("role", userAssignmentCreatejson, 30);
			ClickWebElement("savebtn", userAssignmentCreatejson, 30);
			//ClickWebElement("maxheight", userAssignmentCreatejson, 10);
			
			//AssertValAgainstWebelement("search_val",userAssignmentCreatejson,, 30);

		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
