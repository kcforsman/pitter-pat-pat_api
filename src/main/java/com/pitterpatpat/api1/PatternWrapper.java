package com.pitterpatpat.api1;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PatternWrapper {
	String phase;
	String gameType;
	ArrayList<ArrayList<Integer>> questionSequences;
	ArrayList<ArrayList<Integer>> choiceSequences;
	ArrayList<ArrayList<Integer>> answerSequences;
	ArrayList<String> questionTypes;
	ArrayList<HashMap<String,String>> questionElements;
	ArrayList<String> answerTypes;
	ArrayList<HashMap<String,String>> answerElements;
	
	private static final List<String> TYPES = (List<String>) asList("Color", "Shape", "Letter");
	private static final List<String> GAMETYPES = (List<String>) asList("tapElement", "tapPattern");
	private static final List<String> PHASES = (List<String>) asList("extend", "transfer", "identify");

	public PatternWrapper(int phaseId, ArrayList<Integer> patternSequence, int typeCount, int answerCount,
			int elementCount) {
		super();
		this.phase = PHASES.get(phaseId - 1);
		this.questionSequences = new ArrayList<ArrayList<Integer>>();
		this.choiceSequences = new ArrayList<ArrayList<Integer>>();
		this.answerSequences = new ArrayList<ArrayList<Integer>>();
		this.questionTypes = new ArrayList<String>();
		this.questionElements = new ArrayList<HashMap<String,String>>();
		this.answerTypes = new ArrayList<String>();
		this.answerElements = new ArrayList<HashMap<String,String>>();
		pickGameType(elementCount, patternSequence.size());
		generateSequences(patternSequence, answerCount);
		generateChoiceSequences(elementCount);
		generateElementsAndTypes(elementCount, typeCount);
	}
	public String getPhase() {
		return phase;
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
	
	private static ArrayList<String> pickTypes(int count) {
		ArrayList<Integer> indices = GetRandomIntegers.getArrayOfRandomInts(count, TYPES.size());
		
		ArrayList<String> types = new ArrayList<String>();
		
		for (int i : indices) { types.add(TYPES.get(i)); }
		
		return types;
	}
	
	private void generateElementsAndTypes(int elementCount, int typeCount) {
//		will need logic for phases that generates different sets of objects
		if (this.phase.equals("transfer")) {
			ArrayList<String> types = pickTypes(typeCount * 2);
			int index = 0;
			for (int i = 0; i < typeCount; i++) {
				this.questionTypes.add(types.get(index));
				index++;
			}
			for (int j = 0; j < typeCount; j++) {
				this.answerTypes.add(types.get(index));
				index++;
			}

			ArrayList<HashMap<String, String>> elements = Element.generateUniqueElements((elementCount*2));
			System.out.println(elements);
			index = 0;
			for (int i = 0; i < elementCount; i++) {
				this.questionElements.add(elements.get(index));
				index++;
			}
			for (int j = 0; j < elementCount; j++) {
				this.answerElements.add(elements.get(index));
				index++;
			}
		} else {
			this.questionTypes = pickTypes(typeCount);
			this.questionElements = Element.generateUniqueElements(elementCount);

			this.answerElements = this.questionElements;
			this.answerTypes = this.questionTypes;
		}
	}
	
	private void pickGameType(int elementCount, int unitLength) {
//		will need logic for phases that generates different sets of objects
		if (this.phase.equals("transfer") || this.phase.equals("identify")) {
			this.gameType = "tapPattern";
		} else if (unitLength == 2){
			this.gameType = "tapElement";
		} else {
			ArrayList<Integer> typeIndices = GetRandomIntegers.getArrayOfRandomInts(1, GAMETYPES.size());
			this.gameType = GAMETYPES.get(typeIndices.get(0));
		}

	}

	private void generateSequences(ArrayList<Integer> patternSequence, int answerCount) {
		ArrayList<Integer> patternQuestion = generateSequence(patternSequence);

		if (this.gameType.equals("tapPattern")) {
			this.questionSequences.add(patternQuestion);
			this.answerSequences.add(patternQuestion);
			ArrayList<Integer> patternQuestion2 = new ArrayList<Integer>(patternQuestion.size());
			for (int i = 0; i < patternQuestion.size(); i++) { patternQuestion2.add(-1); }
			this.questionSequences.add(patternQuestion2);
		} else {		
			ArrayList<Integer> answerIndices = GetRandomIntegers.getArrayOfRandomInts(answerCount, patternQuestion.size());
			for (int j = 0; j < answerIndices.size(); j++) {
				ArrayList<Integer> answerSequence = new ArrayList<Integer>();
				answerSequence.add(patternQuestion.get(answerIndices.get(j)));
				this.answerSequences.add(answerSequence);
				patternQuestion.set(answerIndices.get(j), -1);
			}
			this.questionSequences.add(patternQuestion);
		}
	}
	
	private ArrayList<Integer> generateSequence(ArrayList<Integer> patternSequence) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		int index = 0;		
		for (int i = 0; i < 8; i++ ) {
			if (index == patternSequence.size()) {
				index = 0;
			}
			sequence.add(patternSequence.get(index));
			index++;
		}
		return sequence;
	}

	
	private void generateChoiceSequences(int elementCount) {
		if (this.gameType.equals("tapPattern")) {
			for (ArrayList<Integer> sequence : this.answerSequences) {
				this.choiceSequences.add(sequence);
			}
			ArrayList<ArrayList<Integer>> sequences= PatternUnit.generateCollectionOfPatternUnits(4 - this.answerSequences.size(), elementCount, 4);
			for (ArrayList<Integer> sequence: sequences) {
				sequence = generateSequence(sequence);
	            while ( this.choiceSequences.contains(sequence)) {
	    			sequence= generateSequence(PatternUnit.generateCollectionOfPatternUnits(1, elementCount, 4) .get(0));
	            }
	            this.choiceSequences.add(sequence);
			}
			Collections.shuffle(this.choiceSequences);
		} else {
			for (int i = 0; i < elementCount; i++) {
				ArrayList<Integer> choiceSequence = new ArrayList<Integer>();
				choiceSequence.add(i);
				this.choiceSequences.add(choiceSequence);
			}
		}
	}

}
