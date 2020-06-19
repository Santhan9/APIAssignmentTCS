package com.assignment.assignmentWatherAPI;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class mainClass {
	
	static String lattitude;
	
	static String longitude;
	

	public static void main(String[] args) throws IOException, ParseException {
		lattitude = args[0];
		longitude = args[1];
		
		
	String forecastURL =	pointsClas.getGridEndpoint(Double.parseDouble(lattitude),Double.parseDouble(longitude));
	forecastclass.getforecastdetails(forecastURL);

	}

}
