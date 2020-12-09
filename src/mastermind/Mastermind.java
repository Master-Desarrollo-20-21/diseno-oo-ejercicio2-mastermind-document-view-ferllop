package mastermind;

import mastermind.models.Game;
import mastermind.views.GameView;

class Mastermind {
	
	Game game;
	GameView gameView;
	
	public Mastermind() {
		game = new Game();
		gameView = new GameView(game);
	}
	
	public void play() {		
		this.gameView.interact();
	}	

	public static void main(String[] args) {
		new Mastermind().play();
	}
}
