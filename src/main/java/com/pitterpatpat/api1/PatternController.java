package com.pitterpatpat.api1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PatternController {
	
	@GetMapping("/patterns")
	public ArrayList<PatternWrapper> getPatterns() {
//	public ArrayList<Pattern> getPatterns() {
		ArrayList<Pattern> allPatterns = Pattern.getAllPatterns();
		ArrayList<PatternWrapper> patternWrappers = new ArrayList<PatternWrapper>();
		for (Pattern pattern: allPatterns) {
			patternWrappers.add(new PatternWrapper(pattern.getPatternSequence(), 1, 1, pattern.getElementCount()));
		}
		
		System.out.println(patternWrappers);
		
//		return allPatterns;
		return patternWrappers;
		
	}
	
	@GetMapping("/patterns/{patternId}")
	public PatternWrapper getPattern(@PathVariable int patternId) {				
		
		Pattern thisPattern = Pattern.retrievePattern(patternId);
		
		PatternWrapper patternLevel = new PatternWrapper(thisPattern.getPatternSequence(), 1, 1, thisPattern.getElementCount());

		return patternLevel;
		
	}
	
//	Route to test the PatternUnit Class Method generateRandomSequence
	@GetMapping("/patternUnits")
	public ArrayList<ArrayList<Integer>> getPatternSequences() {
		return PatternUnit.generateCollectionOfPatternUnits(1, 4, 4);	
	}
	
//	Route to test the Pattern Class Method generateRandomSequence
//	@GetMapping("/patternSequences")
//	public ArrayList<ArrayList<Integer>> getPatternSequences() {
//		return Pattern.generateRandomPatternSequences(4);	
//	}

}
