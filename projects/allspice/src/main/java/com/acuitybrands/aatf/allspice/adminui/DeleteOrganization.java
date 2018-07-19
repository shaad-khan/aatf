package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.WebDriver;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;

public class DeleteOrganization extends BasePage {

	public DeleteOrganization(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void OrgDelete() {
		try {
			String OrganizationDeleteJson = AdminUIConstants.ResourcesPath + new Object() {
			}.getClass().getEnclosingClass().getSimpleName() + "Test" + ".json";

			
			// Clicking on Setting Navigation tab
			ClickWebElement("settingsTab", OrganizationDeleteJson, 20);

			//Clicking on Organization Div to show the Org list Div
			ClickWebElement("divOrg", OrganizationDeleteJson, 20);

			// Selecting Organization to be deleted
			ClickWebElement("ddlOrg", OrganizationDeleteJson, 30);			

			// Clicking on Organization delete button to deleted the selected item
			ClickWebElement("btnOrgDelete", OrganizationDeleteJson, 30);

			// Clicking on confirmation link to delete Organization
			ClickWebElement("lnkYesPlease", OrganizationDeleteJson, 30);
			
			// Checking error message
			CheckErrorMessage("lblMessage", OrganizationDeleteJson,"Gah! Unable to delete the org.",20);		
			
			Thread.sleep(100000);

		} catch (Exception exp) {

			exp.printStackTrace();

		}

	}
}
