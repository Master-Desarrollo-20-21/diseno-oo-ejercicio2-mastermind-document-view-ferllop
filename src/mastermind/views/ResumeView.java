package mastermind.views;

import utils.ConsoleIO;

public class ResumeView {
	
	public boolean interact() {
		return this.resume();
	}
	
	private boolean resume() {
		String answer;
		do {
			 answer = ConsoleIO.getInstance().getValidValue("¿Quieres volver a jugar? (s/n)", new char[] {'s', 'n'});			
		} while (!answer.equals("s") && !answer.equals("n") );	
		return answer.equals("s");
	}

}
