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
			new CombinationView().print(this.game.getSecretCombination(), '*');
			this.printResults();
			new AttemptView(game).interact();
			this.printLine();
		} while (!this.game.isFinished());			
		this.printResultMessage();			
	}	
	
	private void printAttempts() {
		ConsoleIO.getInstance().printAttempts(this.game.getProposedCombinationsCount());
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
	
	private void printLine() {
		ConsoleIO.getInstance().print("");
	}

}
