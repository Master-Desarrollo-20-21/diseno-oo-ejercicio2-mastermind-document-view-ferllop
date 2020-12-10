package mastermind.views;

import mastermind.models.Color;
import mastermind.models.MastermindCombinationChecker;
import mastermind.models.ProposedCombination;
import utils.ConsoleIO;

public class ProposedCombinationView {	
		
	public String renderCombinationInitials(ProposedCombination proposedCombination) {
		return Color.getInitials(proposedCombination.getColors());
	}
	
	public ProposedCombination read(String title) {
		String proposedCombination = "";
		String errorMessage = "";
		MastermindCombinationChecker combinationChecker;
		do {
			proposedCombination = ConsoleIO.getInstance().getString(title);
			combinationChecker = ProposedCombination.getChecker(proposedCombination);
			errorMessage = this.renderErrorMessage(combinationChecker);
			if (!errorMessage.isEmpty()) {
				ConsoleIO.getInstance().print(errorMessage);
			}
		} while (!combinationChecker.isValid());
		return new ProposedCombination(proposedCombination);
	}
	
	private String renderErrorMessage(MastermindCombinationChecker combinationChecker) {
		String errorMessage = "";
		if(!combinationChecker.hasValidLength()) {
			errorMessage += Message.NO_VALID_LENGTH.getMessage() + "\n";
		}		
		if(!combinationChecker.hasValidColors()) {
			errorMessage += Message.NO_VALID_VALUES.getMessage() + ": " + Color.getInitials() + "\n";
		}		
		if(combinationChecker.hasDuplicates()) {
			errorMessage += Message.NO_DUPLICATED_COLORS.getMessage();
		}
		return errorMessage.trim();
	}
	
				
}
