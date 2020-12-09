package mastermind.models;

public class CombinationChecker {	
	public static boolean isValid(String proposedCombination) {
		return hasValidLength(proposedCombination) && hasValidColors(proposedCombination) && !hasDuplicates(proposedCombination);
	}
	
	public static boolean hasValidLength(String proposedCombination) {
		return proposedCombination.length() == Game.COMBINATION_LENGTH;
	}
	
	public static boolean hasValidColors(String proposedCombination) {
		for(char letter : proposedCombination.toCharArray()) {
			if (Color.valueOf(letter) == null) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasDuplicates(String proposedCombination) {
		for (int i = 0; i< proposedCombination.length(); i++) {
			if (proposedCombination.substring(i+1).contains(Character.toString(proposedCombination.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
}
