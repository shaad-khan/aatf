package com.acuitybrands.aatf.allspice.adminui;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;
public class FloorSpaceCreationPage extends BasePage {

	public FloorSpaceCreationPage(WebDriver driver) {
		super(driver);
		
	}
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;
	public void FloorCreation(String floorname,String maxheight) {
		try {
			// Explicit Object
			// wait = explicitWait(driver, 7);

			ClickWebElement("site", AdminUIConstants.FloorCreatePageJson, 20);

			ClickWebElement("siteval", AdminUIConstants.FloorCreatePageJson, 20);

			ClickWebElement("map", AdminUIConstants.FloorCreatePageJson, 30);

			ClickWebElement("light", AdminUIConstants.FloorCreatePageJson, 30);

			ClickWebElement("new", AdminUIConstants.FloorCreatePageJson, 30);
			ClickWebElement("txtfloorname", AdminUIConstants.FloorCreatePageJson, 10);
			ClearWebElement("txtfloorname", AdminUIConstants.FloorCreatePageJson, 20);
			WriteTextInToWebElement("txtfloorname", AdminUIConstants.FloorCreatePageJson,floorname, 30);
			ClickWebElement("selectfloor", AdminUIConstants.FloorCreatePageJson, 30);
			ClickWebElement("prototype", AdminUIConstants.FloorCreatePageJson, 30);
			ClickWebElement("fixture", AdminUIConstants.FloorCreatePageJson, 30);
			ClickWebElement("maxheight", AdminUIConstants.FloorCreatePageJson, 10);
			ClearWebElement("maxheight", AdminUIConstants.FloorCreatePageJson, 20);
			WriteTextInToWebElement("maxheight", AdminUIConstants.FloorCreatePageJson,maxheight, 10);
			ClickWebElement("button_save", AdminUIConstants.FloorCreatePageJson, 30);
			ClickWebElement("search", AdminUIConstants.FloorCreatePageJson, 30);
			WriteTextInToWebElement("search", AdminUIConstants.FloorCreatePageJson,floorname, 30);
			AssertValAgainstWebelement("search_val",AdminUIConstants.FloorCreatePageJson,floorname, 30);

		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	

}
