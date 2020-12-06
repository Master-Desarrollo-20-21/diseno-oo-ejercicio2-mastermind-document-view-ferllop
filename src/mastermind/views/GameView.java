package mastermind.views;

import mastermind.models.Game;
import utils.ConsoleIO;

public class GameView extends View {
	
	PlayView playView;
	
	public GameView(Game game) {
		super(game);
		playView = new PlayView(game);
	}
	
	@Override
	public void interact() {
		do {	
			this.game.initialize();
			playView.interact();
		} while (this.resume());	
		ConsoleIO.getInstance().print("BYE BYE");
	}
	
	private boolean resume() {
		String answer;
		do {
			 answer = ConsoleIO.getInstance().getValidValue("¿Quieres volver a jugar? (s/n)", new char[] {'s', 'n'});			
		} while (!answer.equals("s") && !answer.equals("n") );	
		return answer.equals("s");
	}

}
