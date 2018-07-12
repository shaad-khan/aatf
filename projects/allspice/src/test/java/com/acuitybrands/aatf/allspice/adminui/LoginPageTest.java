
package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;
//import com.acuitybrands.allspice.adminui.HomePage;
import com.acuitybrands.aatf.allspice.adminui.LoginPage;
import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class LoginPageTest extends BaseTest {

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String loginJson = AdminUIConstants.ResourcesPath + this.getClass().getSimpleName() +".json";
	
	String baseURL = jsonObj.ParseJson(loginJson, "url").toString();

	@Test(priority = 1)
	public void ValidLoginTest_ValidUserNameValidPassword() {
		try {
			
			// Initialize elements by using PageFactory
			page.GetInstance(LoginPage.class).GotoAdminUI();

			page.GetInstance(LoginPage.class).LoginToAdminUI(jsonObj.ParseJson(loginJson, "username").toString(),
					jsonObj.ParseJson(loginJson, "password").toString());
			
			

		} catch (Exception exp) {
			// throw exp.printStackTrace();
		}

	}

}
