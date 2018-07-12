package com.pitterpatpat.api1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PatternController {
	
	@GetMapping("/patterns")
//	public ArrayList<PatternWrapper> getPatterns() {
	public ArrayList<Pattern> getPatterns() {
		ArrayList<Pattern> allPatterns = Pattern.getAllPatterns();
		ArrayList<PatternWrapper> patternWrappers = new ArrayList<PatternWrapper>();
		for (Pattern pattern: allPatterns) {
			patternWrappers.add(new PatternWrapper("tapElement", pattern.getPatternSequence(), 1, 1, pattern.getElementCount()));
		}
		
		System.out.println(patternWrappers);
		
		return allPatterns;
//		return patternWrappers;
		
	}
	
	@GetMapping("/patterns/{patternId}")
	public PatternWrapper getPattern(@PathVariable int patternId) {				
		
		Pattern thisPattern = Pattern.retrievePattern(patternId);
		
		PatternWrapper patternLevel = new PatternWrapper("Select", thisPattern.getPatternSequence(), 1, 1, thisPattern.getElementCount());

		return patternLevel;
		
	}
	
//	Route to test the Pattern Class Method generateRandomSequence
//	@GetMapping("/patternSequences")
//	public ArrayList<ArrayList<Integer>> getPatternSequences() {
//		Pattern.generateRandomPatternSequences(4);
//		
//		return Pattern.generateRandomPatternSequences(4);
//		
//	}

}
