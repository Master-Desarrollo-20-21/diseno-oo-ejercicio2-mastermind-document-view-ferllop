package mastermind.models;

public class ProposedCombination extends Combination{
	
	public ProposedCombination(String proposedCombination) {
		super(proposedCombination.length());
		assert(ProposedCombination.getChecker(proposedCombination).isValid());
		combination = Color.getColorsArray(proposedCombination);
	}
	
	public static MastermindCombinationChecker getChecker(String combination) {
		return new MastermindCombinationChecker(combination);
	}	
}
