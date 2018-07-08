package com.pitterpatpat.api1;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PatternWrapper {
	ArrayList<Integer> patternQuestion;
	ArrayList<String> type;
	ArrayList<Integer> answer;
	ArrayList<HashMap<String,String>> elements;
	
	public static final List<String> TYPES = (List<String>) asList("Color", "Shape", "Letter");
	
	public PatternWrapper(ArrayList<Integer> patternSequence, int typeCount, int answerCount,
			int elementCount) {
		super();
		this.answer = new ArrayList<Integer>();
		generatePatternQuestion(patternSequence, answerCount);
		this.elements = new Element().generateUniqueElements(elementCount);
		this.type = pickTypes(typeCount);
	}
	
	public ArrayList<Integer> getPatternQuestion() {
		return patternQuestion;
	}

	public ArrayList<String> getType() {
		return type;
	}

	public ArrayList<Integer> getAnswer() {
		return answer;
	}

	public ArrayList<HashMap<String, String>> getElements() {
		return elements;
	}
	
	private ArrayList<String> pickTypes(int count) {
		Random random = new Random();
		int index = random.nextInt(TYPES.size());
		
		ArrayList<String> types = new ArrayList<String>();
		
		types.add(TYPES.get(index));
		
		return types;
	}

	private void generatePatternQuestion(ArrayList<Integer> patternSequence, int answerCount) {
		ArrayList<Integer> patternQuestion = new ArrayList<Integer>();
		
		int index = 0;		
		for (int i = 0; i < 8; i++ ) {
			if (index == patternSequence.size()) {
				index = 0;
			}
			patternQuestion.add(patternSequence.get(index));
			index++;
		}
		
		ArrayList<Integer> answerIndices = new GetRandomIntegers().getArrayOfRandomInts(answerCount, patternQuestion.size());
		for (int j = 0; j < answerIndices.size(); j++) {
			this.answer.add(patternQuestion.get(answerIndices.get(j)));
			patternQuestion.set(answerIndices.get(j), -1);
		}
				
		this.patternQuestion = patternQuestion;
	}
	
	

}
