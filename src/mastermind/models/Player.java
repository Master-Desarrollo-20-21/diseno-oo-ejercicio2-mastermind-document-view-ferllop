package mastermind.models;

import java.util.ArrayList;

public class Player {

	private ArrayList<Attempt> attempts;

	public Player() {
		attempts = new ArrayList<Attempt>();
	}
	
	public void saveAttempt(Attempt attempt) {
		this.attempts.add(attempt);
	}
	
	public Attempt getAttempt(int index) {
		return this.attempts.get(index);
	}	
	
	public Attempt getLastAttempt() {
		return this.getAttempt(attempts.size()-1);
	}	

	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}
}
