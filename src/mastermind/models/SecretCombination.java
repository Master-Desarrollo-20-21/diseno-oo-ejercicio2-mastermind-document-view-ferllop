package mastermind.models;

import java.util.Arrays;
import java.util.Random;

public class SecretCombination extends Combination {
	public SecretCombination(int combinationLength) {
		super(combinationLength);
		this.populateRandomly();
	}	
	
	private void populateRandomly() {
		for (int i = 0; i < this.getSize(); i++) {
			this.setColor(i, this.getRandomColorAvoiding(this.getColors()));
		}
	}
	
	private Color getRandomColorAvoiding(Color[] colors) {
		Color color;
		do {
			int randomIndex = new Random().nextInt(Color.values().length);
			color = Color.values()[randomIndex];
		} while (Arrays.asList(colors).contains(color));
		return color;
	}
}
