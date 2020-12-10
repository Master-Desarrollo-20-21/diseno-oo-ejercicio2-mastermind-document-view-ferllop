package mastermind.views;

public enum Message {
	PROPOSE_COMBINATION("Propose a combination"),
	YOU_WIN("You've won!!!"),
	YOU_LOSE("You've lost!!!"),
	PLAY_AGAIN("¿Quieres volver a jugar? (s/n)"),
	END("BYE BYE"),
	ATTEMPTS_COUNT("%1$1s attempt(s):"),
	RESULT("%1$1s --> %2$1s blacks and %3$1s whites"),
	NO_DUPLICATED_COLORS("Can't be duplicated colors"),
	NO_VALID_VALUES("Wrong colors, they must be"),
	NO_VALID_LENGTH("Wrong proposed combination length");	
	
	private String message;
	
	private Message(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getFormattedMessage(String[] values) {
		return String.format(this.message, (Object[]) values);
	}
}
