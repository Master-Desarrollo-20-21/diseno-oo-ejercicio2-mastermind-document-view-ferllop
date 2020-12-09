package mastermind.models;

public class ProposedCombination extends Combination{
	public ProposedCombination(String proposedCombination) {
		super(proposedCombination.length());
		assert(CombinationChecker.isValid(proposedCombination));
		combination = Color.getColorsArray(proposedCombination);
	}	
}
