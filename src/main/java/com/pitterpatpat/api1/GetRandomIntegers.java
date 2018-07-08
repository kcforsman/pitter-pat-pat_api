package com.pitterpatpat.api1;

import java.util.ArrayList;
import java.util.Random;

public class GetRandomIntegers {
	public ArrayList<Integer> getArrayOfRandomInts(int count, int upperBound) {
		ArrayList<Integer> randomInts = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) {
			int newNum = new Random().nextInt(upperBound);
				while(randomInts.contains(newNum)) {
					newNum = new Random().nextInt(upperBound);
				}
			randomInts.add(new Random().nextInt(upperBound));
		}
		
		return randomInts;
	}
}
