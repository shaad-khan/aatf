package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateBuildingPageTest extends BasePageTest {
	
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	
	
	// *********Page Variables*********
	//String loginpage = "src/test/resources/data/LoginPageTest.json";
	//String createBuildingJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
	
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	
  @Test(priority = 2)
  public void CreateBuilding() {
	  
	  try {
			//Initialize elements by using PageFactory
//	        page.GetInstance(LoginPage.class).GotoAdminUI();        
//	      
//	        page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(AdminUIConstants.loginpageJson, "username").toString(), jsonObj.ParseJson(AdminUIConstants.loginpageJson, "password").toString());  
//	        
	        page.GetInstance(CreateBuildingPage.class).CreateBuilding();
	               
			}
			catch(Exception exp)
			{
			
			}
	  
  }
}
