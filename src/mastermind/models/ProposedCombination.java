package mastermind.models;

public class ProposedCombination extends Combination{
	
	public ProposedCombination(char[] proposedCombination) {
		this.combination = new Color[proposedCombination.length];
		for (int i = 0; i < proposedCombination.length; i++) {
			this.combination[i] = Color.valueOf(proposedCombination[i]);
		}
	}
	
	public ProposedCombination(String proposedCombination) {
		this(proposedCombination.toCharArray());
	}
	
	public int countBlacks(SecretCombination secretCombination) {
		int blacks = 0;
		for (int i = 0; i < this.combination.length; i++) {
			if (this.combination[i] == secretCombination.combination[i]){
				blacks++;
			}
		}
		return blacks;
	}

	public int countWhites(SecretCombination secretCombination) {
		int whites = 0;
		for (int i = 0; i < this.combination.length; i++) {
			if(secretCombination.contains(this.combination[i])) {
				whites++;
			}
		}
		return whites - countBlacks(secretCombination);
	}
}
