package com.acuitybrands.aatf.allspice.adminui;

import java.util.List;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class BuildingAddHoursOfOperationPage extends BasePage {

	public BuildingAddHoursOfOperationPage(WebDriver driver) {
		super(driver);
	}

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;

	// *********Page Variables*********
	String BuildingAddHoursOfOperationJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test.json";
	String createBuildingPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test.json";
	
	public void BuildingAddHoursOfOperation() {
		try {
			//Click on Sites link
			ClickWebElement("SitesLink", BuildingAddHoursOfOperationJson, 30);
			
			//Select Test2_Site from the Sites list
			SelectSite("lstSites", AdminUIConstants.BuildingAddHoursOfOperationJson, jsonObj.ParseJson(createBuildingPageJson, "SiteName").toString(), 20);
			//ClickWebElement("SiteName", BuildingAddHoursOfOperationJson, 10);
			
			ClickWebElement("Maptab", BuildingAddHoursOfOperationJson, 20);
			ClickWebElement("BuildingTab", BuildingAddHoursOfOperationJson, 20);
			ClickWebElement("btnCreateNewBuilding", createBuildingPageJson, 20);
			
			ClickWebElement("txtBuildingName", createBuildingPageJson, 5);

			ClearWebElement("txtBuildingName", createBuildingPageJson, 5);
			
			WriteTextInToWebElement("txtBuildingName", createBuildingPageJson, jsonObj.ParseJson(createBuildingPageJson, "findBuildingName").toString(), 20);
			
			//ClickWebElement("btnBuildingSave", AdminUIConstants.createBuildingJson, 20);
			
			//ClickWebElement("searchBuildingField", AdminUIConstants.createBuildingJson, 20);
			
			//WriteTextInToWebElement("searchBuildingField", AdminUIConstants.createBuildingJson, "TestBuilding1", 20);
			
			ClickWebElement("linkHrsOfOperation", BuildingAddHoursOfOperationJson, 20);
			
			//Click on Hours of operation type and select value from the dropdown
			ClickWebElement("HrsOfOperType", BuildingAddHoursOfOperationJson, 20);
			
			//Get ddlPartner Xpath value from Json
			String ddlHrsTypeXPath=jsonObj.ParseJson(BuildingAddHoursOfOperationJson, "ddlHrsType").toString();
			
			//Get Partner name value from Json
			String ddlHrsTypeName=jsonObj.ParseJson(BuildingAddHoursOfOperationJson, "ddlHrsTypeName").toString();
			WebElement mySelectElement = driver.findElement(By.xpath(ddlHrsTypeXPath));
			Select dropdown= new Select(mySelectElement);
			dropdown.selectByVisibleText(ddlHrsTypeName);
			
			//Click on Hours of operation inpOpeningTime
			ClickWebElement("inpOpeningTime", BuildingAddHoursOfOperationJson, 20);
			
			WriteTextInToWebElement("inpOpeningTime", BuildingAddHoursOfOperationJson, jsonObj.ParseJson(createBuildingPageJson, "inpOpeningTimeValue").toString(), 20);
			
			ExplicitWait(driver, 30);
			
			//Click on Hours of operation inpOpeningTime
			ClickWebElement("inpclosingTime", BuildingAddHoursOfOperationJson, 20);
			
			WriteTextInToWebElement("inpclosingTime", BuildingAddHoursOfOperationJson, jsonObj.ParseJson(createBuildingPageJson, "inpclosingTimeValue").toString(), 20);
			
			//Select Occurs On
			ClickWebElement("daySelector", BuildingAddHoursOfOperationJson, 20);
			
			//Click on Add Hours Button
			ClickWebElement("btnAddHrs", BuildingAddHoursOfOperationJson, 20);
			
			//Select Save Changes Button
			ClickWebElement("btnSaveChanges", BuildingAddHoursOfOperationJson, 20);
			
			//get the text of pop-up
			String ctrlText = driver.findElement(By.xpath(jsonObj.ParseJson(BuildingAddHoursOfOperationJson, "message"))).getText();
			
			//check if the message is not "Good Job"
			if (!ctrlText.equals(jsonObj.ParseJson(BuildingAddHoursOfOperationJson, "successMessage")))
			{
				Assert.fail(ctrlText);
			}
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search for site...\"]")))
					//.click();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
