
package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class LoginPageTest extends BasePageTest {

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String baseURL = "";

	@Test(priority = 1)
	public void ValidLoginTest_ValidUserNameValidPassword() {
		try {
			
			/*String loginPageJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +".json";
			baseURL = jsonObj.ParseJson(loginPageJson, "url").toString();*/

		} catch (Exception exp) {
			// throw exp.printStackTrace();
		}

	}

}
