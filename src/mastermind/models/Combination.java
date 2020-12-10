package mastermind.models;

import java.util.Arrays;

public abstract class Combination {
	
	protected Color[] combination;
	
	public Combination(int combinationLength) {
		combination = new Color[combinationLength];
	}
	
	public boolean contains(Color color) {
		return Arrays.asList(combination).contains(color);
	}

	public int getSize() {
		return combination.length;
	}	
	
	protected Color getColor(int position) {
		return combination[position];
	}
	
	public Color[] getColors() {
		return combination;
	}

	protected void setColor(int position, Color color) {
		combination[position] = color;
	}
	
}
