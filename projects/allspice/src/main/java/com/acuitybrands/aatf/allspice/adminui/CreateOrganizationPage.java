package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateOrganizationPage extends BasePage {

	public CreateOrganizationPage(WebDriver driver) {
		super(driver);
	}
	
	// *********Page Objects*********
		JsonParser jsonObj = new JsonParser();
		public WebElement element;
		public WebDriverWait wait;
		String createOrganizationPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";
			

		public void OrganizationCreation() {
			try {
				
				//Reading values from Json file to create a test organization.
				String OrgName = jsonObj.ParseJson(createOrganizationPageJson, "OrgName") ;
				String OrgUUID = jsonObj.ParseJson(createOrganizationPageJson, "OrgUUID") ;
				String OrgAddress1 = jsonObj.ParseJson(createOrganizationPageJson, "OrgAddress1") ;
				String OrgAddress2 = jsonObj.ParseJson(createOrganizationPageJson, "OrgAddress2") ;
				String OrgCity = jsonObj.ParseJson(createOrganizationPageJson, "OrgCity") ;
				String OrgState = jsonObj.ParseJson(createOrganizationPageJson, "OrgState") ;
				String OrgPostalCode = jsonObj.ParseJson(createOrganizationPageJson, "OrgPostalCode") ;
				String OrgCountry = jsonObj.ParseJson(createOrganizationPageJson, "OrgCountry") ;
				String ErrorMsgXpath = jsonObj.ParseJson(createOrganizationPageJson, "ErrorMsgAlert") ;

				//Clicking on settings tab on Admin UI home page.
				ClickWebElement("OrganizationTab", createOrganizationPageJson, 20);
				
				//Clicking on 'Add New' button to create new organization.
				ClickWebElement("BtnAddNew", createOrganizationPageJson, 10);
				
				//If we are not making thread to sleep, below events are executing before clicking on 'Add New' button.
				Thread.sleep(5000);

				//Entering value to 'Organization Name' field
				ClickWebElement("txtOrgName", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgName", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgName", createOrganizationPageJson, OrgName, 5);
				
				//Entering value to 'Organization UUID' field
				ClickWebElement("txtOrgUUID", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgUUID", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgUUID", createOrganizationPageJson, OrgUUID, 5);
				
				//Entering value to 'Address1' field
				ClickWebElement("txtOrgAddress1", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgAddress1", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgAddress1", createOrganizationPageJson, OrgAddress1, 5);
				
				//Entering value to 'Address2' field
				ClickWebElement("txtOrgAddress2", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgAddress2", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgAddress2", createOrganizationPageJson, OrgAddress2, 5);

				//Entering value to 'City' field
				ClickWebElement("txtOrgCity", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgCity", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgCity", createOrganizationPageJson, OrgCity, 5);

				//Entering value to 'State' field
				ClickWebElement("txtOrgState", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgState", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgState", createOrganizationPageJson, OrgState, 5);

				//Entering value to 'Postal Code' field
				ClickWebElement("txtOrgPostalCode", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgPostalCode", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgPostalCode", createOrganizationPageJson, OrgPostalCode, 5);

				//Entering value to 'Country' field
				ClickWebElement("txtOrgCountry", createOrganizationPageJson, 5);
				ClearWebElement("txtOrgCountry", createOrganizationPageJson, 5);
				WriteTextInToWebElement("txtOrgCountry", createOrganizationPageJson, OrgCountry, 5);
				
				//Clicking on Save button
				ClickWebElement("BtnSaveOrg", createOrganizationPageJson, 20);
				
				//Checking for error message
				if(CheckForErrorMessage(ErrorMsgXpath, 20))
				{
					Assert.fail("Failed to create new organization.");
				}

				//Need to remove - Using to make the window open for few seconds before closing it.
				//Thread.sleep(20000);
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		
		
}
