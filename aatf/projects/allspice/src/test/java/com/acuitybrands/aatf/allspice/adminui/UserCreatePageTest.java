package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class UserCreatePageTest extends BaseTest {
	
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	
	
	// *********Page Variables*********
	//String loginpage = "src/test/resources/data/LoginPageTest.json";
	String userCreateJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	
  @Test
  public void UserCreate() {
	  
	  try {
			//Initialize elements by using PageFactory
	        page.GetInstance(LoginPage.class).GotoAdminUI();        
	      
	        page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(userCreateJson, "username").toString(), jsonObj.ParseJson(AdminUIConstants.loginpageJson, "password").toString());  
	        
	        page.GetInstance(CreateUserPage.class).UserCreation();
	               
			}
			catch(Exception exp)
			{
			
			}
	  
  }
}
