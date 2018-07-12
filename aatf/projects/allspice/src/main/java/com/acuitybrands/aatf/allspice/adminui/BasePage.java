package com.acuitybrands.aatf.allspice.adminui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.List;
import org.testng.Assert;

import com.acuitybrands.aatf.helper.allspice.adminui.JsonParser;

public class BasePage extends PageGenerator {

	// *********Page Variables*********
	public WebElement element;
	String userErrorMessage = "";

	// *********Page Objects*********
	JsonParser jsonObj = new JsonParser();
	WebDriverWait wait = new WebDriverWait(this.driver, 20);
	//String loginPage = "src/test/resources/data/LoginPageTest.json";
	//String userCreatePage = "src/test/resources/data/UserCreatePageTest.json";

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
		WebDriverWait wait = ExplicitWait(driver, seconds);
		element = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));
		CheckIfWebElementIsClickable(jsonObj.ParseJson(jsonFile, jsonKey),seconds, msg + ": Element not found ");
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))).click();

	}
	public void WaitOnWebElement(String jsonKey, String jsonFile, int seconds, String... msg) 
	{
		WebDriverWait wait = ExplicitWait(driver, seconds);
		//element = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))));
		//driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))).click();

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
	public void AssertValAgainstWebelement(String jsonKey, String jsonFile, String value, int seconds)
	{
		WebDriverWait wait = ExplicitWait(driver, seconds);
element = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey)));
		
		
	 String val=wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
	 Assert.assertEquals(val, value);
	}

	public void CheckErrorMessage(String jsonKey,String jsonFile) {		
		
		try {
			
			String ctrlText = driver.findElement(By.xpath(jsonObj.ParseJson(jsonFile, jsonKey))).getText();
			
			if (ctrlText != null)
			{
				Assert.fail(ctrlText);
			}
			
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}	
	}

}
