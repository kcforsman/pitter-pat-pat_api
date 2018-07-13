package com.pitterpatpat.api1;

import java.util.ArrayList;

public class PatternUnit {
	public static ArrayList<ArrayList<Integer>> generateCollectionOfPatternUnits(int count, int elementCount, int unitLength) {
		ArrayList<ArrayList<Integer>> unitPermutations = makePatternUnitPermutations(elementCount, unitLength);
		ArrayList<Integer> indices = GetRandomIntegers.getArrayOfRandomInts(count, unitPermutations.size());
		ArrayList<ArrayList<Integer>> randomUnitPermutations = new ArrayList<ArrayList<Integer>>();
		
		for (int i : indices) { randomUnitPermutations.add(unitPermutations.get(i)); }
		
		return randomUnitPermutations;
	}
	
	private static ArrayList<ArrayList<Integer>> makePatternUnitPermutations(int elementCount, int unitLength) {		
		ArrayList<Integer> unit = new ArrayList<Integer>(unitLength);
		int j = 0;
		for (int k = 0; k < unitLength; k++ ) {
			if (j == elementCount) { j = 0; }
			unit.add(j);
			j++;
		}
		
		return permute(unit);
	}
	
	private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> unit) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        
        permutations.add(new ArrayList<Integer>());
        for(int i =0; i < unit.size(); i++){
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> l : permutations){
            	for(int j =0; j < l.size() + 1; j++){
                    l.add(j, unit.get(i));
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    if (!current.contains(temp)) { current.add(temp); }
                    l.remove(j);
                }
            }
            permutations = new ArrayList<ArrayList<Integer>>(current);
        }
        return permutations;
	}
}
