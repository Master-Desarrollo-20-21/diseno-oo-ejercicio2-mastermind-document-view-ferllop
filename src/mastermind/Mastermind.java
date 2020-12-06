package mastermind;

import mastermind.models.Game;
import mastermind.views.GameView;

class Mastermind {
	public final int ALLOWED_TOTAL_ATTEMPTS = 10;
	protected final int COMBINATION_LENGTH = 4;
	
	Game game;
	GameView gameView;
	
	public Mastermind() {
		game = new Game(ALLOWED_TOTAL_ATTEMPTS, COMBINATION_LENGTH);
		gameView = new GameView(game);
	}
	
	public void play() {		
		this.gameView.interact();
	}	

	public static void main(String[] args) {
		new Mastermind().play();
	}
}
