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
		ArrayList<Pattern> allPatterns = getAllPatterns();
		ArrayList<PatternWrapper> patternWrappers = new ArrayList<PatternWrapper>();
		for (Pattern pattern: allPatterns) {
			patternWrappers.add(new PatternWrapper(pattern.getPatternSequence(), 1, 1, pattern.getElementCount()));
		}
		
		System.out.println(patternWrappers);
		
		return allPatterns;
//		return patternWrappers;
		
	}
	
	@GetMapping("/patterns/{patternId}")
	public PatternWrapper getPattern(@PathVariable int patternId) {				
		
		Pattern thisPattern = retrievePattern(patternId);
		
		PatternWrapper patternLevel = new PatternWrapper(thisPattern.getPatternSequence(), 1, 1, thisPattern.getElementCount());

		return patternLevel;
		
	}
	
	@GetMapping("/patterns/duration/{duration}/{travelerType}")
	public String getPattern(@PathVariable int duration, @PathVariable String travelerType) {				
		
		return "I got this PARAMS: Duration--" + duration + " and  travelerType--" + travelerType;
		
	}
	
	private static ArrayList<Pattern> generatePatterns() {
		ArrayList<Integer> patternSequence1 = new ArrayList<Integer>();
		patternSequence1.add(0);
		patternSequence1.add(1);
		
		ArrayList<ArrayList<Integer>> patternSequences1 = new ArrayList<ArrayList<Integer>>();
		patternSequences1.add(patternSequence1);
		
		ArrayList<Integer> patternSequence2 = new ArrayList<Integer>();
		patternSequence2.add(0);
		patternSequence2.add(1);
		patternSequence2.add(2);
		
		ArrayList<ArrayList<Integer>> patternSequences2 = new ArrayList<ArrayList<Integer>>();
		patternSequences2.add(patternSequence2);
		
		ArrayList<Integer> patternSequence3 = new ArrayList<Integer>();
		patternSequence3.add(0);
		patternSequence3.add(1);
		patternSequence3.add(1);
		
		ArrayList<Integer> patternSequence4 = new ArrayList<Integer>();
		patternSequence4.add(0);
		patternSequence4.add(0);
		patternSequence4.add(1);
		
		ArrayList<Integer> patternSequence5 = new ArrayList<Integer>();
		patternSequence5.add(0);
		patternSequence5.add(1);
		patternSequence5.add(0);
		
		ArrayList<ArrayList<Integer>> patternSequences3 = new ArrayList<ArrayList<Integer>>();
		patternSequences3.add(patternSequence3);
		patternSequences3.add(patternSequence4);
		patternSequences3.add(patternSequence5);
		
		Pattern pattern1 = new Pattern(1, 2, 2, patternSequences1);
		Pattern pattern2 = new Pattern(2, 3, 3, patternSequences2);
		Pattern pattern3 = new Pattern(3, 3, 2, patternSequences3);
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(pattern1);
		patterns.add(pattern2);
		patterns.add(pattern3);
		return patterns;
	}
	
	private static ArrayList<Pattern> getAllPatterns() {
		return generatePatterns();
	}
	
	private static Pattern retrievePattern(int patternId) {
		return generatePatterns().get(patternId-1);
	}

}
