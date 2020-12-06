package mastermind.views;

import mastermind.models.Game;

public abstract class View {
	protected Game game;
	
	public View(Game game) {
		this.game = game;
	}
	
	public abstract void interact();
}
