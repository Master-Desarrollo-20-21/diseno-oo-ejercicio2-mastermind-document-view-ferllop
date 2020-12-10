package mastermind.models;

import java.util.ArrayList;

public class Game {
	
	public static final int COMBINATION_LENGTH = 4;	
	private final int ALLOWED_TOTAL_ATTEMPTS = 10;
	private Player player;	
	private SecretCombination secretCombination;	
	
	public void initialize() {
		this.player = new Player();
		this.secretCombination = new SecretCombination(COMBINATION_LENGTH);
	}
	
	public void saveAttempt(ProposedCombination proposedCombination) {
		player.saveAttempt(new Attempt(proposedCombination, secretCombination));
	}	
	
	public boolean isFinished() {
		return this.playerLoses() || this.playerWins();
	}
	
	public boolean playerWins() {
		return this.player.getLastAttempt().getBlacks() == COMBINATION_LENGTH;
	}
	
	private boolean playerLoses() {
		return this.getAttemptsCount() >= ALLOWED_TOTAL_ATTEMPTS;
	}
	
	public int getAttemptsCount() {
		return this.player.getAttempts().size();
	}	
	
	public ArrayList<Attempt> getAttempts(){
		return this.player.getAttempts();
	}
}
