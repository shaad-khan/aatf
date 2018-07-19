package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;
//import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateFloorPageTest extends BasePageTest {
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	
	@Test
	public void CreateFloor() {

		try {
			page.GetInstance(CreateFloorPage.class).FloorCreation();

		} catch (Exception exp) {

		}

	}
}
