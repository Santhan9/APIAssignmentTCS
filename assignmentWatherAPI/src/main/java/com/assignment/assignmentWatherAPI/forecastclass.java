package com.assignment.assignmentWatherAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class forecastclass {
	
	
	public static void getforecastdetails(String uri) throws IOException, ParseException {
		
		URL url = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
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
	        //System.out.println(myResponse);
	        
	        JSONObject properties = (JSONObject) parser.parse(myResponse.get("properties").toString());
	        
	        JSONArray periodsArray = (JSONArray) parser.parse(properties.get("periods").toString());
	        
	        //System.out.println(periodsArray);
	        
	        Iterator<JSONObject> iterator =periodsArray.iterator();
	        
	        int i=1;
	        
	        System.out.println("State is "+pointsClas.State+" and City is "+pointsClas.City);
	        
	        while(iterator.hasNext()) {
	        	JSONObject forecastDetails =iterator.next();
	        	
	        	String isDay = forecastDetails.get("isDaytime").toString();
	        	System.out.println("*****************************************");
	        	if(isDay.equals("false")) {
	        	
	        	System.out.println("Day "+i+" Night Forecast");
	        	
	        	String name = forecastDetails.get("name").toString();
	        	System.out.println("Time = "+name);
	        	
	           	String temperature = forecastDetails.get("temperature").toString();
	        	System.out.println("Temperature = "+temperature+" F");
	        	
	        	
	           	String windSpeed = forecastDetails.get("windSpeed").toString();
	        	System.out.println("WindSpeed = "+windSpeed);
	        	
	        	
	        	String windDirection = forecastDetails.get("windDirection").toString();
	        	System.out.println("windDirection = "+windDirection);
	        	
	        	String shortForecast = forecastDetails.get("shortForecast").toString();
	        	System.out.println("shortForecast = "+shortForecast);
	        	
	        	String detailedForecast = forecastDetails.get("detailedForecast").toString();
	        	System.out.println("detailedForecast = "+detailedForecast);
	        	
	        	i++;
	        	
	        	}else {
	        		
	        		System.out.println("Day "+i+" Morning Forecast");
		        	
		        	String name = forecastDetails.get("name").toString();
		        	System.out.println("Time = "+name);
		        	
		           	String temperature = forecastDetails.get("temperature").toString();
		        	System.out.println("Temperature = "+temperature+" F");
		        	
		        	
		           	String windSpeed = forecastDetails.get("windSpeed").toString();
		        	System.out.println("WindSpeed = "+windSpeed);
		        	
		        	String windDirection = forecastDetails.get("windDirection").toString();
		        	System.out.println("windDirection = "+windDirection);
		        	
		        	String shortForecast = forecastDetails.get("shortForecast").toString();
		        	System.out.println("shortForecast = "+shortForecast);
		        	
		        	String detailedForecast = forecastDetails.get("detailedForecast").toString();
		        	System.out.println("detailedForecast = "+detailedForecast);
		        	
	        		
	        	}
	        	
	        	
	        	
	        	
	        }
	        
	        
	}

}
