package com.pitterpatpat.api1;

import java.util.ArrayList;

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
	
	public int getId() {
		return id;
	}

	public int getElementCount() {
		return elementCount;
	}

	public ArrayList<Integer> getPatternSequence() {
		ArrayList<Integer> indices = GetRandomIntegers.getArrayOfRandomInts(1, patternSequences.size());
		ArrayList<Integer> patternSequence = patternSequences.get(indices.get(0));
		return patternSequence;
	}


}
