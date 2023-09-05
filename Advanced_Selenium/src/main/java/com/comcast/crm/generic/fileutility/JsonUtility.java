package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public Object getJsonData(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("./configAppData/JsonData.json"));
		JSONObject map=(JSONObject)obj;
		Object result = map.get(key);
		return result;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JsonUtility ju=new JsonUtility();
		System.out.println(ju.getJsonData("url"));
	}
	
}
