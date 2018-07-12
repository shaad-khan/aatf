package com.acuitybrands.aatf.helper.allspice.adminui;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser 
{
	public String ParseJson(String jsonfile, String key) 
	{
		try 
		{
			
			JSONParser parser = new JSONParser();
			
			Object obj = parser.parse(new FileReader(jsonfile));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			return jsonObject.get(key).toString();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
