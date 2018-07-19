package com.acuitybrands.aatf.allspice.adminui;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateFloorPage extends BasePage {

	public CreateFloorPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;

	// *********Page Variables*********
	String createFloorPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

	public void FloorCreation() {
		try {
			// Explicit Object
			// wait = explicitWait(driver, 7);
			
			//wait till the map tab is clickable
			CheckIfWebElementIsClickable(jsonObj.ParseJson(createFloorPageJson, "selectMap").toString(), 30, "Map tab is not clickable.");
			//click on Map tab
			ClickWebElement("selectMap", createFloorPageJson, 20);
			//click on Floors tab
			ClickWebElement("selectFloors", createFloorPageJson, 20);
			//click on Create new Floor button
			ClickWebElement("newZoneBtnId", createFloorPageJson, 5);
			//click on Floor name text box
			ClickWebElement("floorNameId", createFloorPageJson, 5);
			//clear data present in Floor name text box
			ClearWebElement("floorNameId", createFloorPageJson, 5);
			//Enter the floor name
			WriteTextInToWebElement("floorNameId", createFloorPageJson, jsonObj.ParseJson(createFloorPageJson, "floorName").toString(), 5);
			//click on save button
			ClickWebElement("savebtnid", createFloorPageJson, 20);

			
			String ErrorMsgXpath = jsonObj.ParseJson(createFloorPageJson, "ErrorMsgAlert") ;
			
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
