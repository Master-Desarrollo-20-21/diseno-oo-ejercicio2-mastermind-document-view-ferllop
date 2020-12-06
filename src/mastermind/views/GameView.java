package mastermind.views;

import mastermind.models.Game;
import utils.ConsoleIO;

public class GameView extends View {
	
	public GameView(Game game) {
		super(game);		
	}
	
	@Override
	public void interact() {
		PlayView playView = new PlayView(game);
		ResumeView resumeView = new ResumeView();
		do {	
			this.game.initialize();
			playView.interact();
		} while (resumeView.interact());	
		new EndView().interact();		
	}	

}
