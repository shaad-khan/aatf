package com.acuitybrands.aatf.allspice.adminui;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateSitePage extends BasePage {

	public CreateSitePage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;

	// *********Page Variables*********
	String createSitePageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";


	public void SiteCreation() {
		try {
			// Explicit Object
			//wait = ExplicitWait(driver, 10);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jsonObj.ParseJson(createSitePageJson, "createSiteId").toString())));
			//click on Create site button
			ClickWebElement("createSiteId", createSitePageJson, 20);
			//click on SiteName textbox
			ClickWebElement("siteNameId", createSitePageJson, 5);
			//Clear data in SiteName textbox
			ClearWebElement("siteNameId", createSitePageJson, 5);
			//Enter the Site name
			WriteTextInToWebElement("siteNameId", createSitePageJson, jsonObj.ParseJson(createSitePageJson, "siteName").toString(), 5);
			//click on Next Page Button
			ClickWebElement("btnNext1Id", createSitePageJson, 5);
			
			//click on Next Page Button
			ClickWebElement("btnNext2Id", createSitePageJson, 5);
			
			//click on buildingName textbox
			ClickWebElement("BuildingNameId", createSitePageJson, 5);
			//Clear data in buildingName textbox
			ClearWebElement("BuildingNameId", createSitePageJson, 5);
			//Enter the buildingName
			WriteTextInToWebElement("BuildingNameId", createSitePageJson, jsonObj.ParseJson(createSitePageJson, "BuildingName").toString(), 5);
			//click on Next Page Button
			ClickWebElement("btnNext3Id", createSitePageJson, 5);
			
			//click on FloorName textbox
			ClickWebElement("FloorNameId", createSitePageJson, 5);
			//Clear data in FloorName textbox
			ClearWebElement("FloorNameId", createSitePageJson, 5);
			//Enter the FloorName
			WriteTextInToWebElement("FloorNameId", createSitePageJson, jsonObj.ParseJson(createSitePageJson, "FloorName").toString(), 5);
			//click on Next Page Button
			ClickWebElement("btnNext4Id", createSitePageJson, 5);
			
			String ErrorMsgXpath = jsonObj.ParseJson(createSitePageJson, "ErrorMsgAlert") ;
			
			//Checking for error message
			if(CheckForErrorMessage(ErrorMsgXpath, 20))
			{
				Assert.fail("Failed to create new organization.");
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
