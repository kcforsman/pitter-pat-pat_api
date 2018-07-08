package com.pitterpatpat.api1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PatternController {
	
	@GetMapping("/patterns")
	public PatternWrapper getPattern() {
		ArrayList<Integer> patternSequence1 = new ArrayList<Integer>();
		patternSequence1.add(0);
		patternSequence1.add(1);
		
		ArrayList<ArrayList<Integer>> patternSequences = new ArrayList<ArrayList<Integer>>();
		patternSequences.add(patternSequence1);
		
		Pattern newPattern = new Pattern(1, 2, 2, patternSequences);
		
		
		PatternWrapper testWrapper = new PatternWrapper(newPattern.getPatternSequence(), 1, 1, newPattern.getElementCount());
		
		
		System.out.println(testWrapper);
		return testWrapper;
	}

}
