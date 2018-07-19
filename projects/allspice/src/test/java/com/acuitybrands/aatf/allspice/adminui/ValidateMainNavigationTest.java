package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class ValidateMainNavigationTest extends BasePageTest {
	
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	
	// *********Page Variables*********
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();
	
	  @Test
	  public void ValidateMainNavigations() {
		  try {
				// Initialize elements by using PageFactory
				//page.GetInstance(LoginPage.class).GotoAdminUI();

				//page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(AdminUIConstants.loginpageJson, "username").toString(),jsonObj.ParseJson(AdminUIConstants.loginpageJson, "password").toString());
				
				page.GetInstance(ValidateMainNavigation.class).ValidateAllMainNavigations();
				
			} catch (Exception exp) {
				exp.printStackTrace();
			}
	  }
}
