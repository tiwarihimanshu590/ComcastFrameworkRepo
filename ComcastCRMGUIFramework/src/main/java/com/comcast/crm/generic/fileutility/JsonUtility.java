package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Exception
	{
		FileReader fr = new FileReader("./configAppData/JScommData.json");
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
		JSONObject map = (JSONObject) obj;
		String data = (String) map.get(key);
		
		return data;
	}

}
