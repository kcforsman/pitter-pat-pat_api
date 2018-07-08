package com.pitterpatpat.api1;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Element {
	
	public static final List<String> COLORS = (List<String>) asList("red", "blue", "green", "yellow", "purple", "orange", "pink");
	public static final List<String> SHAPES = (List<String>) asList("circle", "square", "triangle", "rectangle");
	public static final List<String> LETTERS = (List<String>) asList("A", "B", "C", "D", "E", "F", "G", "H");

	
	public ArrayList<HashMap<String,String>> generateUniqueElements(int count) {
		ArrayList<HashMap<String,String>> elements = new ArrayList<HashMap<String,String>>();
		ArrayList<Integer> colorIndices = new GetRandomIntegers().getArrayOfRandomInts(count, COLORS.size());
		ArrayList<Integer> shapeIndices = new GetRandomIntegers().getArrayOfRandomInts(count, SHAPES.size());
		ArrayList<Integer> letterIndices = new GetRandomIntegers().getArrayOfRandomInts(count, LETTERS.size());
		
		for ( int i = 0; i < count; i++ ) {
			String color = COLORS.get(colorIndices.get(i));
			String shape = SHAPES.get(shapeIndices.get(i));
			String symbol = LETTERS.get(letterIndices.get(i));
			
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
