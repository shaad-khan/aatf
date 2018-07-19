package com.acuitybrands.aatf.allspice.adminui;

import java.util.List;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateBuildingPage extends BasePage {

	public CreateBuildingPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;

	// *********Page Variables*********
	String createBuildingPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test.json";

	public void CreateBuilding() {
		try {
						
			//Click Sites link
			ClickWebElement("SitesLink", createBuildingPageJson, 20);

			//Select Test2_Site from the Sites list
			SelectSite("lstSites", createBuildingPageJson, "SiteName", 20);
			//ClickWebElement("SiteName", createBuildingPageJson, 10);
			
			ClickWebElement("Maptab", createBuildingPageJson, 20);
			ClickWebElement("BuildingTab", createBuildingPageJson, 20);
			ClickWebElement("btnCreateNewBuilding", createBuildingPageJson, 20);
			
			ClickWebElement("txtBuildingName", createBuildingPageJson, 5);

			ClearWebElement("txtBuildingName", createBuildingPageJson, 5);
			
			WriteTextInToWebElement("txtBuildingName", createBuildingPageJson, jsonObj.ParseJson(createBuildingPageJson, "newBuildingName").toString(), 20);
			
			ClickWebElement("btnBuildingSave", createBuildingPageJson, 20);
			
			String ErrorMsgXpath = jsonObj.ParseJson(createBuildingPageJson, "ErrorMsgAlert") ;
			
			//Checking for error message
			if(CheckForErrorMessage(ErrorMsgXpath, 20))
			{
				Assert.fail("Failed to create new building.");
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
