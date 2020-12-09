package mastermind.models;

public class Attempt {

	private ProposedCombination proposedCombination;
	private Result result;
	
	public Attempt(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		this.proposedCombination = proposedCombination;
		result = new Result(proposedCombination, secretCombination);
	}
	
	public ProposedCombination getProposedCombination() {
		return proposedCombination;
	}
	
	public int getBlacks() {
		return result.getBlacks();
	}
	
	public int getWhites() {
		return result.getWhites();
	}		
}
