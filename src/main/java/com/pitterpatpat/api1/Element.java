package com.pitterpatpat.api1;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Element {
	
	public static final List<String> COLORS = (List<String>)asList("Red", "Blue", "LightBlue", "Green", "DarkGreen", "Yellow", "Purple", "Orange", "Pink", "Turquoise", "Brown", "Grey");
	public static final List<String> SHAPES = (List<String>)asList("Circle", "Square", "Triangle", "Rectangle", "Heart", "Diamond", "Oval", "Pentagon", "Hexagon", "Crescent", "Star", "Teardrop");
	public static final List<String> LETTERS = (List<String>)asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

	
	public static ArrayList<HashMap<String,String>> generateUniqueElements(int count) {
		ArrayList<HashMap<String,String>> elements = new ArrayList<HashMap<String,String>>(count);
		ArrayList<Integer> colorIndices = GetRandomIntegers.getArrayOfRandomInts(count, COLORS.size());
		ArrayList<Integer> shapeIndices = GetRandomIntegers.getArrayOfRandomInts(count, SHAPES.size());
		ArrayList<Integer> letterIndices = GetRandomIntegers.getArrayOfRandomInts(count, LETTERS.size());
		
		for ( int i = 0; i < count; i++ ) {
			String color = COLORS.get(colorIndices.get(i));
			String shape = SHAPES.get(shapeIndices.get(i));
			String symbol = LETTERS.get(letterIndices.get(i));
			
			HashMap<String, String> newElement = generateElement(color, shape, symbol);
			elements.add(newElement);
		}
		return elements;	
	}
	
	private static HashMap<String,String> generateElement(String color, String shape, String symbol) {
		HashMap<String,String> newElement = new HashMap<String,String>();
		newElement.put("color", color);
		newElement.put("shape", shape);
		newElement.put("symbol", symbol);
		
		return newElement;
	}

}
