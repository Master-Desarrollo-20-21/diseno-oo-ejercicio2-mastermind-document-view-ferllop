package mastermind.views;

import mastermind.models.Game;
import utils.ConsoleIO;

public class PlayView extends View {
	
	private AttemptView attemptView;
	
	public PlayView(Game game) {
		super(game);		
		attemptView = new AttemptView(game);
	}

	public void interact() {	
		do {	
			this.attemptView.interact();
			ConsoleIO.getInstance().printEmptyLine();
		} while (!this.game.isFinished());			
		ConsoleIO.getInstance().print(this.renderResultMessage());
	}	
	
	private String renderResultMessage() {
		if (this.game.playerWins()) {
			return Message.YOU_WIN.getMessage();
		}			
		return Message.YOU_LOSE.getMessage();
	}
}
