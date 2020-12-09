package mastermind.views;

import mastermind.models.Game;
import utils.ConsoleIO;

public class GameView extends View {
	
	PlayView playView;
	ResumeView resumeView;
	
	public GameView(Game game) {
		super(game);
		this.playView = new PlayView(game);
		this.resumeView = new ResumeView();
	}
	
	public void interact() {
		do {	
			this.game.initialize();
			this.playView.interact();
		} while (this.resumeView.read(Message.PLAY_AGAIN.getMessage() + ": "));	
		ConsoleIO.getInstance().print(Message.END.getMessage());	
	}	
}
