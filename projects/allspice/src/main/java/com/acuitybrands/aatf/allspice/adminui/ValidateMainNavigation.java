package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class ValidateMainNavigation extends BasePage{
	
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;
	String ValidateMainNavigationsJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

	public ValidateMainNavigation(WebDriver driver) {
		super(driver);
	}
	
	public void ValidateAllMainNavigations() {
		try {
			// Reading values for URL's from Json file.
			String SitesTabURL = jsonObj.ParseJson(ValidateMainNavigationsJson, "SitesTabURL");
			String SiteGroupsTabURL = jsonObj.ParseJson(ValidateMainNavigationsJson, "SiteGroupsTabURL");
			String UsersTabURL = jsonObj.ParseJson(ValidateMainNavigationsJson, "UsersTabURL");
			String FixturesTabURL = jsonObj.ParseJson(ValidateMainNavigationsJson, "FixturesTabURL");
			String SettingsTabURL = jsonObj.ParseJson(ValidateMainNavigationsJson, "SettingsTabURL");

			//Clicking on 'Sites' tab and validating the URL.
			ValidateTab(ValidateMainNavigationsJson, "SitesTab", SitesTabURL, "URL not matching for Sites tab");

			//Clicking on 'SiteGroups' tab and validating the URL.
			ValidateTab(ValidateMainNavigationsJson, "SiteGroupsTab", SiteGroupsTabURL,
					"URL not matching for SiteGroups tab");

			//Clicking on 'Users' tab and validating the URL.
			ValidateTab(ValidateMainNavigationsJson, "UsersTab", UsersTabURL,
					"URL not matching for Users tab");

			//Clicking on 'Fixtures' tab and validating the URL.
			ValidateTab(ValidateMainNavigationsJson, "FixturesTab", FixturesTabURL,
					"URL not matching for Fixtures tab");

			//Clicking on 'Settings' tab and validating the URL.
			ValidateTab(ValidateMainNavigationsJson, "SettingsTab", SettingsTabURL,
					"URL not matching for Settings tab");

			// Need to remove - Using to make the window open for few seconds before closing it.
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ValidateTab(String JsonFile, String JsonKey, String URL, String Msg) {
		try {

			// Clicking respective tab under Sites
			ClickWebElement(JsonKey, JsonFile, 20);

			// Checking for URL
			ValidateURL(URL, Msg);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ValidateURL(String URL, String Msg) {
		if (!URL.isEmpty()) {

			try {
				String currentPageUrl = driver.getCurrentUrl();

				//here we check Page URL is matching with expected one or not.
				if (!currentPageUrl.equals(URL)) {
					Assert.fail(Msg + ": Expected[" + URL + "] Found[" + driver.getCurrentUrl() + "]");
				}
				
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
