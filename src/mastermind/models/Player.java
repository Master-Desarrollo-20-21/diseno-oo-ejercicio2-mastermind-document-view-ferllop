package mastermind.models;

import java.util.ArrayList;

public class Player {

	private ArrayList<ProposedCombination> proposedCombinations;

	public Player() {
		proposedCombinations = new ArrayList<ProposedCombination>();
	}
	
	public void saveProposedCombination(ProposedCombination proposedCombination) {
		proposedCombinations.add(proposedCombination);
	}
	
	public ProposedCombination getLastProposedCombination() {
		return proposedCombinations.get(proposedCombinations.size()-1);
	}	

	public ArrayList<ProposedCombination> getProposedCombinations() {
		return proposedCombinations;
	}
}
