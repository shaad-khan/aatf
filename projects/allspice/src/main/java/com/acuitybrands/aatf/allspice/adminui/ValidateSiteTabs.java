package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class ValidateSiteTabs extends BasePage {

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	public WebElement element;
	public WebDriverWait wait;
	String ValidateSiteTabsJson = AdminUIConstants.ResourcesPath + new Object(){}.getClass().getEnclosingClass().getSimpleName() +"Test" +".json";

	public ValidateSiteTabs(WebDriver driver) {
		super(driver);
	}

	public void ValidateAllSiteTabs() {
		try {
			// Reading values for URL's from Json file.
			String DetailsTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "DetailsTabURL");
			String MapTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "MapTabURL");
			String UsersTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "UsersTabURL");
			String DevicesTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "DevicesTabURL");
			String SummaryTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "SummaryTabURL");
			String ConfigTabURL = jsonObj.ParseJson(ValidateSiteTabsJson, "ConfigTabURL");

			//Navigating to 'Sites' tab.
			NavigateToSitesTab(ValidateSiteTabsJson, "SitesTab");

			//Validating URL for 'Details' tab.
			ValidateURL(DetailsTabURL, "URL not matching for Details tab");

			//Clicking on 'Map' tab and validating the URL.
			ValidateTab(ValidateSiteTabsJson, "MapTab", MapTabURL, "URL not matching for Map tab");

			//Clicking on 'Users' tab and validating the URL.
			ValidateTab(ValidateSiteTabsJson, "UsersTab", UsersTabURL,
					"URL not matching for Users tab");

			//Clicking on 'Devices' tab and validating the URL.
			ValidateTab(ValidateSiteTabsJson, "DevicesTab", DevicesTabURL,
					"URL not matching for Devices tab");

			//Clicking on 'Summary' tab and validating the URL.
			ValidateTab(ValidateSiteTabsJson, "SummaryTab", SummaryTabURL,
					"URL not matching for Summary tab");

			//Clicking on 'Config' tab and validating the URL.
			ValidateTab(ValidateSiteTabsJson, "ConfigTab", ConfigTabURL,
					"URL not matching for Config tab");

			// Need to remove - Using to make the window open for few seconds before closing it.
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void NavigateToSitesTab(String JsonFile, String Jsonkey) {
		try {

			// Clicking on Sites tab on Admin UI home page.
			ClickWebElement(Jsonkey, JsonFile, 20);

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
