package mastermind.models;

public class Result {
	
	private int blacks;
	private int whites;
		
	public Result(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		this.blacks = countBlacks(proposedCombination, secretCombination);
		this.whites = countWhites(proposedCombination, secretCombination);				
	}

	private int countBlacks(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		int blacks = 0;
		for (int i = 0; i < secretCombination.getSize(); i++) {
			if (secretCombination.getColor(i) == proposedCombination.getColor(i)) {
				blacks++;
			}
		}
		return blacks;
	}

	private int countWhites(ProposedCombination proposedCombination, SecretCombination secretCombination) {
		int whites = 0;
		for (int i = 0; i < secretCombination.getSize(); i++) {
			if (proposedCombination.contains(secretCombination.getColor(i))) {
				whites++;
			}
		}
		return whites - this.blacks;
	}
	
	public int getBlacks() {
		return blacks;
	}
	
	public int getWhites() {
		return whites;
	}
}
