package mastermind.views;

import mastermind.models.Combination;
import utils.ConsoleIO;

public class CombinationView{
		
	public void print(Combination combination, char symbol) {
		ConsoleIO.getInstance().print(renderHidden(combination, symbol));
	}
	
	public void print(Combination combination) {		
		ConsoleIO.getInstance().print(combination.toString());
	}
	
	private String renderHidden(Combination combination, char symbol) {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < combination.toString().length(); i++) {
			result.append(symbol);
		}		
		return result.toString();
	}
}
