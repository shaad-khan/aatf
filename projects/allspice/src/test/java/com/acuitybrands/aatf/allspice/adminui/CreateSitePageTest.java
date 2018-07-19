package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;
//import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateSitePageTest extends BasePageTest {
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********

	@Test
	public void CreateSite() {

		try {
			page.GetInstance(CreateSitePage.class).SiteCreation();

		} catch (Exception exp) {

		}

	}
}
