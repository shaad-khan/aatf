package com.acuitybrands.aatf.allspice.adminui;
import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateFloorSpacePageTest extends BasePageTest 
{
	// *********Page Objects*********
		JsonParser jsonObj = new JsonParser();
		
		
		// *********Page Variables*********
		//String loginpage = "src/test/resources/data/LoginPageTest.json";
		String FloorCreationJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
		String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
		
	  @Test
	  public void FloorCreate() {
		  
		  try 
		  {
				
			//Initialize elements by using PageFactory
		        page.GetInstance(CreateFloorSpacePage.class).FloorCreation(jsonObj.ParseJson(FloorCreationJson, "txtfloorname_val").toString(), jsonObj.ParseJson(FloorCreationJson, "maxheight_val").toString());
		               
				}
				catch(Exception exp)
				{
				
				}
		  
	  }

}
