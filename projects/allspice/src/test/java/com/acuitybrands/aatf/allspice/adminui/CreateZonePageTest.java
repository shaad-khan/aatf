package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

public class CreateZonePageTest extends BasePageTest {
	@Test
	public void CreateZone() {

		try {

			page.GetInstance(CreateZonePage.class).CreateZone();

		} catch (Exception exp) {

			exp.printStackTrace();

		}
	}
}
