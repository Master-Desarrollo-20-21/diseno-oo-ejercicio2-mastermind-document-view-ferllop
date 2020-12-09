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
		ConsoleIO.getInstance().print(this.game.getAttemptsCount() + " attempt(s):");
		this.secretCombinationView.write();
		this.printAttempts();
		ProposedCombination proposedCombination = this.proposedCombinationView.read(Message.PROPOSE_COMBINATION.getMessage() + ": ");
		this.game.saveAttempt(proposedCombination);
	}
	
	private void printAttempts() {
		for (Attempt attempt : this.game.getAttempts()) {
			ConsoleIO.getInstance().print(this.renderAttempt(attempt));
		}
	}	
	
	public String renderAttempt(Attempt attempt) {
		return this.proposedCombinationView.renderCombinationInitials(attempt.getProposedCombination()) + " --> " 
				+ attempt.getBlacks() + " blacks and " 
				+ attempt.getWhites() + " whites";
	}
}
