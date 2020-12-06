package mastermind.models;

import java.util.Random;

public class SecretCombination extends Combination {

	public SecretCombination(int combinationLength) {
		do {
			Color[] combination = new Color[combinationLength];
			for (int i = 0; i < combination.length; i++) {
				int randomValue = new Random().nextInt(Color.values().length);
				Color randomColor = Color.values()[randomValue];
				combination[i] = randomColor;
			}
			this.combination = combination;
		} while (this.hasDuplicates());
	}
	
	private boolean hasDuplicates() { //COPIA PEGA DEL ALGORITMO DE CONSOLE ARJJJJ!!
		String string = this.toString();
		
		for (int i = 0; i< string.length(); i++) {
			for (int j = 0; j < string.length(); j++) {
				if (j==i) {
					continue;
				}
				if (string.toCharArray()[j] == string.toCharArray()[i]) {
					return true;
				}
			}
		}		
		return false;
	}
}
