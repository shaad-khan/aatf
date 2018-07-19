package com.acuitybrands.aatf.allspice.adminui;

import org.testng.annotations.Test;

public class DeleteOrganizationTest extends BasePageTest {
	@Test
	public void DeleteOrganization() {
		try {

			page.GetInstance(DeleteOrganization.class).OrgDelete();

		} catch (Exception exp) {
			
			 exp.printStackTrace();

		}
	}
}
