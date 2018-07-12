package com.acuitybrands.aatf.allspice.adminui;
import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;
public class UserAssignmentCreationTest extends BaseTest {
	JsonParser jsonObj = new JsonParser();
	
	
	// *********Page Variables*********
	//String loginpage = "src/test/resources/data/LoginPageTest.json";
	String FloorCreationJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	
  @Test
  public void UserAssignmentCreate() {
	  
	  try {
			//Initialize elements by using PageFactory
	        page.GetInstance(LoginPage.class).GotoAdminUI();        
	      
	        page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(AdminUIConstants.loginpageJson, "username").toString(), jsonObj.ParseJson(AdminUIConstants.loginpageJson, "password").toString());  
	        
	        page.GetInstance(UserAssignmentCreationPage.class).UserAssginmentCreation(jsonObj.ParseJson(AdminUIConstants.UserAssignmentCreatejson, "search_val").toString());
	               
			}
			catch(Exception exp)
			{
			
			}
	  
  }

	
}
