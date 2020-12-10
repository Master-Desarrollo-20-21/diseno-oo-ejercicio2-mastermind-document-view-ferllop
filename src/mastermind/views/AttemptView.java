package mastermind.views;

import mastermind.models.Attempt;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import utils.ConsoleIO;

public class AttemptView extends View {
	
	private ProposedCombinationView proposedCombinationView;
	private SecretCombinationView secretCombinationView;
	
	public AttemptView(Game game) {
		super(game);
		proposedCombinationView = new ProposedCombinationView();
		secretCombinationView = new SecretCombinationView();
	}
	
	@Override
	public void interact() {
		ConsoleIO.getInstance().print(
			Message.ATTEMPTS_COUNT.getFormattedMessage(new String[] {String.valueOf(this.game.getAttemptsCount())}
		));
		this.secretCombinationView.write();
		this.printAttempts();
		ProposedCombination proposedCombination = this.proposedCombinationView.read(Message.PROPOSE_COMBINATION.getMessage() + ": ");
		this.game.saveAttempt(proposedCombination);
	}
	
	private void printAttempts() {
		for (Attempt attempt : this.game.getAttempts()) {
			String combination = this.proposedCombinationView.renderCombinationInitials(attempt.getProposedCombination());
			ConsoleIO.getInstance().print(Message.RESULT.getFormattedMessage(
				new String[]{combination, String.valueOf(attempt.getBlacks()), String.valueOf(attempt.getWhites())}
			));
		}
	}		
}
