package com.acuitybrands.aatf.allspice.adminui;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;
public class CreateFloorSpacePage extends BasePage {

    public CreateFloorSpacePage(WebDriver driver) {
        super(driver); 

    }
    JsonParser jsonObj = new JsonParser();
    public WebElement element;
    public WebDriverWait wait;
	
 // *********Page Variables*********
 	String floorSpaceCreatePageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

    
    public void FloorCreation(String floorname, String maxheight) 
	{
		try 
		{
            // Explicit Object
            // wait = explicitWait(driver, 7); a

            ClickWebElement("site", floorSpaceCreatePageJson, 20);

            ClickWebElement("siteval",floorSpaceCreatePageJson, 20);

            ClickWebElement("map", floorSpaceCreatePageJson, 30);

            ClickWebElement("light", floorSpaceCreatePageJson, 30);

            ClickWebElement("new", floorSpaceCreatePageJson, 30);
            ClickWebElement("txtfloorname", floorSpaceCreatePageJson, 10);
            ClearWebElement("txtfloorname", floorSpaceCreatePageJson, 20);
            WriteTextInToWebElement("txtfloorname", floorSpaceCreatePageJson, floorname, 30);
            ClickWebElement("selectfloor", floorSpaceCreatePageJson, 30);
            ClickWebElement("prototype", floorSpaceCreatePageJson, 30);
            ClickWebElement("fixture", floorSpaceCreatePageJson, 30);
            ClickWebElement("maxheight", floorSpaceCreatePageJson, 10);
            ClearWebElement("maxheight", floorSpaceCreatePageJson, 20);
            WriteTextInToWebElement("maxheight", floorSpaceCreatePageJson, maxheight, 10);
            ClickWebElement("button_save", floorSpaceCreatePageJson, 30);
            ClickWebElement("search", floorSpaceCreatePageJson, 30);
            WriteTextInToWebElement("search", floorSpaceCreatePageJson, floorname, 30);
            AssertValAgainstWebelement("search_val", floorSpaceCreatePageJson, floorname, 30);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
