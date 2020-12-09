package mastermind.views;

import mastermind.models.Color;
import mastermind.models.CombinationChecker;
import mastermind.models.ProposedCombination;
import utils.ConsoleIO;

public class ProposedCombinationView {	
	public String renderCombinationInitials(ProposedCombination proposedCombination) {
		return Color.getInitials(proposedCombination.getColors());
	}
	
	public ProposedCombination read(String title) {
		String proposedCombination = "";
		String errorMessage = "";
		do {
			proposedCombination = ConsoleIO.getInstance().getString(title);
			errorMessage = renderErrorMessage(proposedCombination);
			if (!errorMessage.isEmpty()) {
				ConsoleIO.getInstance().print(errorMessage);
			}
		} while (!CombinationChecker.isValid(proposedCombination));
		return new ProposedCombination(proposedCombination);
	}
	
	private String renderErrorMessage(String value) {
		String errorMessage = "";		
		if(!CombinationChecker.hasValidLength(value)) {
			errorMessage += Message.NO_VALID_LENGTH.getMessage() + "\n";
		}		
		if(!CombinationChecker.hasValidColors(value)) {
			errorMessage += Message.NO_VALID_VALUES.getMessage() + ": " + Color.getInitials() + "\n";
		}		
		if(CombinationChecker.hasDuplicates(value)) {
			errorMessage += Message.NO_DUPLICATED_COLORS.getMessage();
		}
		return errorMessage.trim();
	}			
}
