package com.pitterpatpat.api1;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PatternWrapper {
	String gameType;
	ArrayList<ArrayList<Integer>> questionSequences;
	ArrayList<ArrayList<Integer>> choiceSequences;
	ArrayList<ArrayList<Integer>> answerSequences;
	ArrayList<String> questionTypes;
	ArrayList<HashMap<String,String>> questionElements;
	ArrayList<String> answerTypes;
	ArrayList<HashMap<String,String>> answerElements;
	
	private static final List<String> TYPES = (List<String>) asList("Color", "Shape", "Letter");
	
	public PatternWrapper(String gameType, ArrayList<Integer> patternSequence, int typeCount, int answerCount,
			int elementCount) {
		super();
		this.gameType = gameType;
		this.questionTypes = pickTypes(typeCount);
		this.questionSequences = new ArrayList<ArrayList<Integer>>();
		this.answerSequences = new ArrayList<ArrayList<Integer>>();
		generateSequences(patternSequence, answerCount);
		this.choiceSequences = new ArrayList<ArrayList<Integer>>();
		generateChoiceSequences(elementCount);
		this.questionElements = new Element().generateUniqueElements(elementCount);
		generateAnswerElementsAndTypes();
	}
	
	public String getGameType() {
		return gameType;
	}
	public ArrayList<ArrayList<Integer>> getQuestionSequences() {
		return questionSequences;
	}
	public ArrayList<ArrayList<Integer>> getAnswerSequences() {
		return answerSequences;
	}
	public ArrayList<ArrayList<Integer>> getChoiceSequences() {
		return choiceSequences;
	}
	public ArrayList<String> getQuestionTypes() {
		return questionTypes;
	}
	public ArrayList<HashMap<String, String>> getQuestionElements() {
		return questionElements;
	}
	public ArrayList<String> getAnswerTypes() {
		return answerTypes;
	}
	public ArrayList<HashMap<String, String>> getAnswerElements() {
		return answerElements;
	}
	
	private ArrayList<String> pickTypes(int count) {
		ArrayList<Integer> indices = GetRandomIntegers.getArrayOfRandomInts(1, TYPES.size());
		
		ArrayList<String> types = new ArrayList<String>();
		
		types.add(TYPES.get(indices.get(0)));
		
		return types;
	}
	
	private void generateAnswerElementsAndTypes() {
//		will need logic for phases that generates different sets of objects
		this.answerElements = this.questionElements;
		this.answerTypes = this.questionTypes;
	}

	private void generateSequences(ArrayList<Integer> patternSequence, int answerCount) {
		ArrayList<Integer> patternQuestion = new ArrayList<Integer>();
		int index = 0;		
		for (int i = 0; i < 8; i++ ) {
			if (index == patternSequence.size()) {
				index = 0;
			}
			patternQuestion.add(patternSequence.get(index));
			index++;
		}		
		ArrayList<Integer> answerIndices = GetRandomIntegers.getArrayOfRandomInts(answerCount, patternQuestion.size());
		for (int j = 0; j < answerIndices.size(); j++) {
			ArrayList<Integer> answerSequence = new ArrayList<Integer>();
			answerSequence.add(patternQuestion.get(answerIndices.get(j)));
			this.answerSequences.add(answerSequence);
			patternQuestion.set(answerIndices.get(j), -1);
		}
		this.questionSequences.add(patternQuestion);
	}
	
	private void generateChoiceSequences(int elementCount) {
		for (int i = 0; i < elementCount; i++) {
			ArrayList<Integer> choiceSequence = new ArrayList<Integer>();
			choiceSequence.add(i);
			this.choiceSequences.add(choiceSequence);
		}
	}

}
