package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class ValidateSiteTabsTest extends BasePageTest {

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String baseURL = jsonObj.ParseJson(AdminUIConstants.loginpageJson, "url").toString();

	@Test
	public void ValidateSiteTabs() {
		try {
		
			page.GetInstance(ValidateSiteTabs.class).ValidateAllSiteTabs();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
