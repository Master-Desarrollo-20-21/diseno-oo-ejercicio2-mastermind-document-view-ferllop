package mastermind.views;

import utils.ConsoleIO;

public class ResumeView {	
	public boolean read(String title) {
		String answer;
		do {
			 answer = ConsoleIO.getInstance().getString(title).toLowerCase();			
		} while (!answer.equals("s") && !answer.equals("n") );	
		return answer.equals("s");
	}
}
