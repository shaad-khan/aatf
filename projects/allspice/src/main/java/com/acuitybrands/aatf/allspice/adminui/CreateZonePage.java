package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateZonePage extends BasePage {

	public CreateZonePage(WebDriver driver) {
		super(driver);
	}
	
	JsonParser jsonObj = new JsonParser();

	public void CreateZone() {

		try {
			String createZonePageJson = AdminUIConstants.ResourcesPath + new Object() {
			}.getClass().getEnclosingClass().getSimpleName() + "Test" + ".json";

			ClickWebElement("SitesTab", createZonePageJson, 20);

			/*List<WebElement> options = driver.findElements(By.tagName("/html/body/section/div/router-view/aside/ul/li"));
			for (WebElement option : options) {
				if (option.getText().equals("Test2_Site")) {
					option.click(); 
					break;
				}
			}*/
			
			// Select the site to create zone
			SelectSite("lstSites",createZonePageJson,"selectSiteName",50);
	        
			//ExplicitWait(driver,30);
			
	       // Clicking on Map Tab
			ClickWebElement("Maptab", createZonePageJson, 30);

			// Clicking on Zone Tab
			ClickWebElement("ZoneTab", createZonePageJson, 30);

			// Clicking on New button to create new zone
			ClickWebElement("btnNewZone", createZonePageJson, 30);			
			
			// Enter zone name 
			WriteTextInToWebElement("txtZoneName", createZonePageJson, jsonObj.ParseJson(createZonePageJson, "ZoneName"), 30, "Zone Name");

			// Select Zone type
			SelectDropDownOption("ddlZoneType", createZonePageJson, "ddlZoneTypeOption");

			// Select Building 
			SelectDropDownOption("ddlBuilding", createZonePageJson, "ddlBuildingOption");

			// Select Floor
			SelectDropDownOption("ddlFloor", createZonePageJson, "ddlFloorOption");

			// Clicking on draw zone button to draw points
			ClickWebElement("btnDrawZone", createZonePageJson, 30);

			// Create action object to draw zone
			//Actions action = new Actions(driver);
			
			// Clicking on the map to create zone with X,Y  values 
			
			DrawMap("map",createZonePageJson,"pixel1-X","pixel1-Y");
			DrawMap("map",createZonePageJson,"pixel2-X","pixel2-Y");
			DrawMap("map",createZonePageJson,"pixel3-X","pixel3-Y");
			DrawMap("map",createZonePageJson,"pixel4-X","pixel4-Y");
		
			// Clicking on Finish button to create zone
			ClickWebElement("btnFinishSetup", createZonePageJson, 30);
			
			// Check success message
			//CheckErrorMessage("lblSuccessMessage",createZonePageJson,"All done.  Nice job!",30);
			
            String ErrorMsgXpath = jsonObj.ParseJson(createZonePageJson, "ErrorMsgAlert") ;
			
			//Checking for error message
			if(CheckForErrorMessage(ErrorMsgXpath, 10))
			{
				Assert.fail("Failed to create new organization.");
			}
			
			//Thread.sleep(100000);
		

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
