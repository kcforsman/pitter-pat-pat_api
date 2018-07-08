package com.pitterpatpat.api1;

import java.util.ArrayList;
import java.util.Random;

public class Pattern {
	int id;
	int unitLength;
	int elementCount;
	ArrayList<ArrayList<Integer>> patternSequences;
	
	public Pattern(int id, int unitLength, int elementCount, ArrayList<ArrayList<Integer>> patternSequences) {
		super();
		this.id = id;
		this.unitLength = unitLength;
		this.elementCount = elementCount;
		this.patternSequences = patternSequences;
	}

	public int getElementCount() {
		return elementCount;
	}

	public ArrayList<Integer> getPatternSequence() {
		Random random = new Random();
		int index = random.nextInt(patternSequences.size());
		ArrayList<Integer> patternSequence = patternSequences.get(index);
		return patternSequence;
	}

}
