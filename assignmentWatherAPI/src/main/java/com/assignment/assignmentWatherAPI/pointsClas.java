package com.assignment.assignmentWatherAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class pointsClas {
	
	static String City;
	static String State;
	
	
	public static String getGridEndpoint(double d,double e) throws IOException, ParseException {
		
		URL url = new URL("https://api.weather.gov/points/"+d+","+e);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		if(status<299) {
			
		
		 BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	       
	        JSONParser parser = new JSONParser();
	        JSONObject myResponse = (JSONObject) parser.parse(response.toString());
	        
	        JSONObject properties = (JSONObject) parser.parse(myResponse.get("properties").toString());
	        
	       // System.out.println(properties.get("forecast"));
	        
	        JSONObject rl = (JSONObject) parser.parse(properties.get("relativeLocation").toString());
	        
	        JSONObject properties1 = (JSONObject) parser.parse(rl.get("properties").toString());
	        
	        City = properties1.get("city").toString();
	        State = properties1.get("state").toString();
	        
	        System.out.println(City+State);
	        
	        return properties.get("forecast").toString();
	        }else {
	        	System.out.println("Invalid Data Entered");
	        	
	        	return null;
	        }
		
	       
	}

}
