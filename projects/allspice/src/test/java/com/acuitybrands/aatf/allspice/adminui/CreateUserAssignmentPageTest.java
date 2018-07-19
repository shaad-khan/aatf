package com.acuitybrands.aatf.allspice.adminui;
import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateUserAssignmentPageTest extends BasePageTest {
	JsonParser jsonObj = new JsonParser();
	
	
	// *********Page Variables*********
	//String loginpage = "src/test/resources/data/LoginPageTest.json";
	String FloorCreationJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	
  @Test
  public void UserAssignmentCreate() {
	  
	  try {
			//Initialize elements by using PageFactory
	        page.GetInstance(CreateUserAssignmentPage.class).UserAssginmentCreation(jsonObj.ParseJson(FloorCreationJson, "search_val").toString());
	               
			}
			catch(Exception exp)
			{
			
			}
	  
  }

	
}
