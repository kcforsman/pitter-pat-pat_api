package com.pitterpatpat.api1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PatternWrapper {
	ArrayList<Integer> patternQuestion;
	ArrayList<String> type;
	ArrayList<Integer> answer;
	ArrayList<HashMap<String,String>> elements;
	
	public PatternWrapper(ArrayList<Integer> patternSequence, int typeCount, int answerCount,
			int elementCount) {
		super();
		this.answer = new ArrayList<Integer>();
		this.patternQuestion = generatePatternQuestion(patternSequence);
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
//		Random random = new Random();
//		int index = random.nextInt(typeList.size());
		
		ArrayList<String> types = new ArrayList<String>();
		
		types.add("Color");
		
		return types;
	}

	private ArrayList<Integer> generatePatternQuestion(ArrayList<Integer> patternSequence) {
		ArrayList<Integer> patternQuestion = new ArrayList<Integer>();
		
		int index = 0;		
		for (int i = 0; i < 8; i++ ) {
			if (index == patternSequence.size()) {
				index = 0;
			}
			
			patternQuestion.add(patternSequence.get(index));
			index++;
			
		}
		
		int answerIndex = new Random().nextInt(patternQuestion.size());
		this.answer.add(patternQuestion.get(answerIndex));
		patternQuestion.set(answerIndex, -1);
		
		return patternQuestion;
	}

}
