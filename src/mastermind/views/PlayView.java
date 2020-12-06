package mastermind.views;

import mastermind.models.Color;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import utils.ConsoleIO;

public class PlayView extends View {
	
	public PlayView(Game game) {
		super(game);
	}

	@Override
	public void interact() {		
		do {	
			this.printAttempts();
			this.printSecretCombinationUnhidden();
			this.printResults();
			ProposedCombination combination = this.proposeCombination(this.game.getSecretCombination().getSize());
			this.game.getPlayer().saveProposedCombination(combination);
		} while (!this.game.isFinished());			
		this.printResultMessage();			
	}
	
	private ProposedCombination proposeCombination(int validLength) {
		char[] validColorInitials = new char[Color.values().length];
		for (int i = 0; i < Color.values().length; i++) {
			validColorInitials[i] = Color.values()[i].getLetter();
		}
		ProposedCombination proposedCombination = new ProposedCombination(
				ConsoleIO.getInstance().getValidValue("Propose a combination", validColorInitials, validLength)
		);
		return proposedCombination;
	}
	
	private void printSecretCombinationHidden(char symbol) {
		ConsoleIO.getInstance().print(this.game.getSecretCombination().toString(symbol));
	}
	
	private void printSecretCombinationUnhidden() {		
		ConsoleIO.getInstance().print(this.game.getSecretCombination().toString());
	}	
	
	private void printAttempts() {
		ConsoleIO.getInstance().printAttempts(this.game.getProposedCombinationsQuantity()+1);
	}

	private void printResults() {
		for (ProposedCombination proposedCombination : this.game.getProposedCombinations()) {
			int blacks = proposedCombination.countBlacks(this.game.getSecretCombination());
			int whites = proposedCombination.countWhites(this.game.getSecretCombination());
			ConsoleIO.getInstance().printProposalResult(proposedCombination, blacks, whites);
		}
	}
	
	private void printResultMessage() {
		String message;
		if (this.game.playerWins()) {
			message = "You've won!!!";
		}		
		message = "You've lost!!!";	
		ConsoleIO.getInstance().print(message);
	}

}
