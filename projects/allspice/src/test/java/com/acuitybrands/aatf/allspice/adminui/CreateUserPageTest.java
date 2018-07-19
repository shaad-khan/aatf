package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class CreateUserPageTest extends BasePageTest {

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();

	// *********Page Variables*********
	String baseURL = "";

	@Test
	public void UserCreate() {

		try {

			page.GetInstance(CreateUserPage.class).UserCreation();

		} catch (Exception exp) {

		}

	}
}
