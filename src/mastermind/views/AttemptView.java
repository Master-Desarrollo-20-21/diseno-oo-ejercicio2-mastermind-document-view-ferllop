package mastermind.views;

import mastermind.models.Color;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import utils.ConsoleIO;

public class AttemptView extends View {

	public AttemptView(Game game) {
		super(game);
	}
	
	@Override
	public void interact() {
		ProposedCombination combination = this.proposeCombination(this.game.getSecretCombination().getSize());
		this.game.saveProposedCombination(combination);
	}
	
	private ProposedCombination proposeCombination(int validLength) {
		char[] validColorsLetters = this.game.getValidColorsLetters();
		ProposedCombination proposedCombination = new ProposedCombination(
				ConsoleIO.getInstance().getValidValue("Propose a combination", validColorsLetters, validLength)
		);
		return proposedCombination;
	}
}
