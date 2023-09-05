package Selenium;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./configAppData/JsonData.json"));
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("url"));
	}
}
