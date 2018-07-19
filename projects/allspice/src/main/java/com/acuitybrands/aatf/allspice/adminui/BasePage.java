package com.acuitybrands.aatf.allspice.adminui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.List;
import org.testng.Assert;

//import com.acuitybrands.aatf.helper.allspice.adminui.AdminUIConstants;
import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class BasePage extends PageGenerator {

	// *********Page Variables*********
	public WebElement element;
	String userErrorMessage = "";	
	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	WebDriverWait wait = new WebDriverWait(this.driver, 20);
	
	public BasePage(WebDriver driver) {
		super(driver);
	}

	public WebDriverWait ExplicitWait(WebDriver driver, long seconds) 
	{
		// Creating web driver wait object
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		// returning the wait object to the calling method
		return wait;
	}

	public void WriteTextInToWebElement(String jsonKey, String jsonFile, String value, int seconds, String... msg) 
	{
		CheckVisibilityOfWebElement(jsonObj.ParseJson(jsonFile, jsonKey),seconds, msg + ": Element not found ");
		driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))).sendKeys(value);
	}

	public void ClickWebElement(String jsonKey, String jsonFile, int seconds, String... msg) 
	{
		
		CheckIfWebElementIsClickable(jsonObj.ParseJson(jsonFile, jsonKey),seconds, msg + ": Element not found ");
		driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))).click();

	}

	public void ClearWebElement(String jsonKey, String jsonFile, int seconds) {
		
		WebDriverWait wait = ExplicitWait(driver, seconds);

		element = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
	}

	public void CheckVisibilityOfWebElement(String xpath,int seconds, String msg) {
		
		if (!xpath.isEmpty()) 
		{
			new WebDriverWait(this.driver, seconds).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			try {
					//here we check if the web element is visible on the page
					if (!driver.findElement(By.xpath(xpath)).isDisplayed()) 
					{
						Assert.fail(msg);
					}
			} 
			catch (NoSuchElementException ex) 
			{
				ex.printStackTrace();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		} 
		else 
		{
			Assert.fail("Unable to locate the element :" + xpath);
		}
	}

	public void CheckIfWebElementIsClickable(String xpath,int seconds, String msg) 
	{
		if (!xpath.isEmpty()) 
		{
			new WebDriverWait(this.driver, seconds).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			try 
			{
				if (!driver.findElement(By.xpath(xpath)).isEnabled()) 
				{
					Assert.fail(msg);
				}
			} 
			catch (NoSuchElementException ex) 
			{
				ex.printStackTrace();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		} 
		else {
			Assert.fail("Unable to locate the element :" + xpath);
		}
	}

	public void CheckErrorMessage(String jsonKey, String jsonFile,String successMessage, int seconds) {

		try {

			CheckVisibilityOfWebElement(jsonObj.ParseJson(jsonFile, jsonKey), seconds, "");

			String ctrlText = driver.findElement(By.cssSelector(jsonObj.ParseJson(jsonFile, jsonKey))).getText();

			if (ctrlText != successMessage) {
				Assert.fail(ctrlText);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void AssertValAgainstWebelement(String jsonKey, String jsonFile, String value, int seconds)
	{
		WebDriverWait wait = ExplicitWait(driver, seconds);
		element = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));
		
		
	 	String val=wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
	 	Assert.assertEquals(val, value);
	}

	public void SelectDropDownOption(String jsonKey, String jsonFile, String ddlOption) {
		try {

			Select dropdown = new Select(driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))));
			
			dropdown.selectByVisibleText(jsonObj.ParseJson(jsonFile, ddlOption));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void DrawMap(String jsonKey, String jsonFile,String X,String Y)
	{
		try
		{
			// Create action object to draw zone
			Actions action = new Actions(driver);
			
			action.moveToElement(driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))), 
					Integer.parseInt(jsonObj.ParseJson(jsonFile, X)), Integer.parseInt(jsonObj.ParseJson(jsonFile, Y))).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void SelectSite(String jsonKey, String jsonFile,String selectSiteName,int seconds)
	{		
		try
		{  
			// Calling explicit wait to load all sites in UI
			ExplicitWait(driver,seconds);
			
			//List<WebElement> lstElements = driver.findElements(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));		
			//lstElements.size()
			//We have hardcoded to 9 on purpose.
			for(int i=1; i <= 9; i++)
	        {
				String currElementXPath = jsonObj.ParseJson(jsonFile, jsonKey) +"[" + i + "]/div/div/h1";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currElementXPath)));
				
	            WebElement linkElement = driver.findElement(By.xpath(currElementXPath));
	            System.out.println(linkElement.getText());     
	            
	            if (linkElement.getText().equals(jsonObj.ParseJson(jsonFile, selectSiteName))) {
	            	linkElement.click(); 
					break;
				}
	        }

		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public void WaitOnWebElement(String jsonKey, String jsonFile, int seconds, String... msg) 
	{
		WebDriverWait wait = ExplicitWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))));
	} 
	
	public Boolean CheckForErrorMessage(String xpath, int seconds)
	{
		Boolean Status = false;
		
		if (!xpath.isEmpty()) 
		{
			try {
					new WebDriverWait(this.driver, seconds).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				
					//here we check if the web element is visible on the page
					if (driver.findElement(By.xpath(xpath)).isDisplayed()) 
					{
						Status = true;
					}
			} 
			catch (Exception ex) 
			{
				//ex.printStackTrace();
			}
		} 
		return Status;
	}
}
