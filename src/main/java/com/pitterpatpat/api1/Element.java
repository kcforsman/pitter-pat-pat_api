package com.pitterpatpat.api1;

import java.util.ArrayList;
import java.util.HashMap;

public class Element {
	
	public ArrayList<HashMap<String,String>> generateUniqueElements(int count) {
		ArrayList<HashMap<String,String>> elements = new ArrayList<HashMap<String,String>>();
		
		for ( int i = 0; i < count; i++ ) {
			String color = "blue";
			String shape = "square";
			String symbol = "A";
			
			HashMap<String, String> newElement = generateElement(color, shape, symbol);
			elements.add(newElement);
		}
		return elements;	
	}
	
	private HashMap<String,String> generateElement(String color, String shape, String symbol) {
		HashMap<String,String> newElement = new HashMap<String,String>();
		newElement.put("color", color);
		newElement.put("shape", shape);
		newElement.put("symbol", symbol);
		
		return newElement;
	}

}
