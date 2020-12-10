package mastermind.views;

import mastermind.models.Game;

public abstract class View {
	
	protected Game game;
	
	public View(Game game) {
		this.game = game;
	}
	
	protected abstract void interact();
}
