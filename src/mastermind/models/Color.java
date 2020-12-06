package mastermind.models;

public enum Color {
	RED('r'),
	BLUE('b'),
	YELLOW('y'),
	GREEN('g'),
	ORANGE('o'),
	PURPLE('p');
	
	private char letter;
	
	private Color(char initial) {
		this.letter = initial;
	}
	
	public char getLetter() {
		return letter;		
	}
	
	public static Color valueOf(char letter) {
        for (Color color : values()) {
            if (color.letter == letter) {
                return color;
            }
        }
        return null;
    }
}
