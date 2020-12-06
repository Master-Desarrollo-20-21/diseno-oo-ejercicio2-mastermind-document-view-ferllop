package mastermind.models;

import java.util.ArrayList;

public class Game {
	
	private Player player;	
	private SecretCombination secretCombination;
	int allowedTotalAttempts;
	int combinationLength;
	
	public Game(int allowedTotalAttempts, int combinationLength) {
		this.allowedTotalAttempts = allowedTotalAttempts;
		this.combinationLength = combinationLength;
		this.initialize();
	}

	public void initialize() {
		this.secretCombination = new SecretCombination(combinationLength);
		this.player = new Player();
	}
	
	public boolean isFinished() {
		return this.totalAttemptsSurpassed(allowedTotalAttempts) || 
				this.playerWins();
	}
	
	public boolean playerWins() {
		return this.allBlacksInProposedCombination(this.getLastProposedCombination());
	}
	
	private boolean totalAttemptsSurpassed(int allowedTotalAttempts) {
		if (player.getProposedCombinationsQuantity() >= allowedTotalAttempts) {
			return true;
		}		
		return false;
	}
	
	private boolean allBlacksInProposedCombination(ProposedCombination proposedCombination) {
		if (proposedCombination.countBlacks(secretCombination) == secretCombination.getSize()) {
			return true;
		};		
		return false;
	}
	
	private ProposedCombination getLastProposedCombination() {
		return player.getLastProposedCombination();
	}	

	public SecretCombination getSecretCombination() {
		return secretCombination;
	}

	public Player getPlayer() {
		return player;
	}
	
	public ArrayList<ProposedCombination> getProposedCombinations() {
		return player.getProposedCombinations();
	}

	public int getProposedCombinationsQuantity() {
		return player.getProposedCombinationsQuantity();
	}	
	
}
