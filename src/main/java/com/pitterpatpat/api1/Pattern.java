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
	
	public static ArrayList<Pattern> getAllPatterns() {
		return generatePatterns();
	}
	
	public static Pattern retrievePattern(int patternId) {
		return generatePatterns().get(patternId-1);
	}
	
	private static ArrayList<Pattern> generatePatterns() {
//		Pattern Sequence 1 for Pattern 1
		ArrayList<Integer> patternSequence1 = new ArrayList<Integer>();
		patternSequence1.add(0);
		patternSequence1.add(1);
//		Pattern Sequences for Pattern 1
		ArrayList<ArrayList<Integer>> patternSequences1 = new ArrayList<ArrayList<Integer>>();
		patternSequences1.add(patternSequence1);
		
//		Pattern Sequence 2 for Pattern 2
		ArrayList<Integer> patternSequence2 = new ArrayList<Integer>();
		patternSequence2.add(0);
		patternSequence2.add(1);
		patternSequence2.add(2);
//		Pattern Sequences for Pattern 2
		ArrayList<ArrayList<Integer>> patternSequences2 = new ArrayList<ArrayList<Integer>>();
		patternSequences2.add(patternSequence2);
		
//		Pattern Sequence 3 for Pattern 3
		ArrayList<Integer> patternSequence3 = new ArrayList<Integer>();
		patternSequence3.add(0);
		patternSequence3.add(1);
		patternSequence3.add(1);
		
//		Pattern Sequence 4 for Pattern 3
		ArrayList<Integer> patternSequence4 = new ArrayList<Integer>();
		patternSequence4.add(0);
		patternSequence4.add(0);
		patternSequence4.add(1);
//		Pattern Sequence 5 for Pattern 3
		ArrayList<Integer> patternSequence5 = new ArrayList<Integer>();
		patternSequence5.add(0);
		patternSequence5.add(1);
		patternSequence5.add(0);
//		Pattern Sequences for Pattern 3
		ArrayList<ArrayList<Integer>> patternSequences3 = new ArrayList<ArrayList<Integer>>();
		patternSequences3.add(patternSequence3);
		patternSequences3.add(patternSequence4);
		patternSequences3.add(patternSequence5);
		
//		Pattern Sequence 6 for Pattern 4
		ArrayList<Integer> patternSequence6 = new ArrayList<Integer>();
		patternSequence6.add(0);
		patternSequence6.add(1);
		patternSequence6.add(2);
		patternSequence6.add(3);
//		Pattern Sequence 6 for Pattern 4
		ArrayList<ArrayList<Integer>> patternSequences4 = new ArrayList<ArrayList<Integer>>();
		patternSequences4.add(patternSequence6);
		
//		Pattern Sequence 7 for Pattern 5
		ArrayList<Integer> patternSequence7 = new ArrayList<Integer>();
		patternSequence7.add(1);
		patternSequence7.add(1);
		patternSequence7.add(0);
		patternSequence7.add(0);
//		Pattern Sequence 8 for Pattern 5
		ArrayList<Integer> patternSequence8 = new ArrayList<Integer>();
		patternSequence8.add(1);
		patternSequence8.add(0);
		patternSequence8.add(0);
		patternSequence8.add(1);
//		Pattern Sequence 9 for Pattern 5
		ArrayList<Integer> patternSequence9 = new ArrayList<Integer>();
		patternSequence9.add(1);
		patternSequence9.add(0);
		patternSequence9.add(0);
		patternSequence9.add(0);
//		Pattern Sequence 10 for Pattern 5
		ArrayList<Integer> patternSequence10 = new ArrayList<Integer>();
		patternSequence10.add(0);
		patternSequence10.add(1);
		patternSequence10.add(0);
		patternSequence10.add(0);
//		Pattern Sequence 11 for Pattern 5
		ArrayList<Integer> patternSequence11 = new ArrayList<Integer>();
		patternSequence11.add(0);
		patternSequence11.add(0);
		patternSequence11.add(1);
		patternSequence11.add(0);
//		Pattern Sequence 12 for Pattern 5
		ArrayList<Integer> patternSequence12 = new ArrayList<Integer>();
		patternSequence12.add(0);
		patternSequence12.add(0);
		patternSequence12.add(0);
		patternSequence12.add(1);
//		Pattern Sequences for Pattern 5
		ArrayList<ArrayList<Integer>> patternSequences5 = new ArrayList<ArrayList<Integer>>();
		patternSequences5.add(patternSequence7);
		patternSequences5.add(patternSequence8);
		patternSequences5.add(patternSequence9);
		patternSequences5.add(patternSequence10);
		patternSequences5.add(patternSequence11);
		patternSequences5.add(patternSequence12);
		
//		Pattern Sequence 13 for Pattern 6
		ArrayList<Integer> patternSequence13 = new ArrayList<Integer>();
		patternSequence13.add(0);
		patternSequence13.add(1);
		patternSequence13.add(2);
		patternSequence13.add(0);
//		Pattern Sequence 14 for Pattern 6
		ArrayList<Integer> patternSequence14 = new ArrayList<Integer>();
		patternSequence14.add(0);
		patternSequence14.add(1);
		patternSequence14.add(0);
		patternSequence14.add(2);
//		Pattern Sequence 15 for Pattern 6
		ArrayList<Integer> patternSequence15 = new ArrayList<Integer>();
		patternSequence15.add(0);
		patternSequence15.add(0);
		patternSequence15.add(1);
		patternSequence15.add(2);
//		Pattern Sequence 16 for Pattern 6
		ArrayList<Integer> patternSequence16 = new ArrayList<Integer>();
		patternSequence16.add(1);
		patternSequence16.add(0);
		patternSequence16.add(0);
		patternSequence16.add(2);
//		Pattern Sequence 17 for Pattern 6
		ArrayList<Integer> patternSequence17 = new ArrayList<Integer>();
		patternSequence17.add(1);
		patternSequence17.add(0);
		patternSequence17.add(2);
		patternSequence17.add(0);
//		Pattern Sequences for Pattern 6
		ArrayList<ArrayList<Integer>> patternSequences6 = new ArrayList<ArrayList<Integer>>();
		patternSequences6.add(patternSequence13);
		patternSequences6.add(patternSequence14);
		patternSequences6.add(patternSequence15);
		patternSequences6.add(patternSequence16);
		patternSequences6.add(patternSequence17);
		
		Pattern pattern1 = new Pattern(1, 2, 2, patternSequences1);
		Pattern pattern2 = new Pattern(2, 3, 3, patternSequences2);
		Pattern pattern3 = new Pattern(3, 3, 2, patternSequences3);
		Pattern pattern4 = new Pattern(4, 4, 4, patternSequences4);
		Pattern pattern5 = new Pattern(5, 4, 2, patternSequences5);
		Pattern pattern6 = new Pattern(6, 4, 3, patternSequences6);
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		
		patterns.add(pattern1);
		patterns.add(pattern2);
		patterns.add(pattern3);
		patterns.add(pattern4);
		patterns.add(pattern5);
		patterns.add(pattern6);
		
		return patterns;
	}
}
