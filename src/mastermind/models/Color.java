package mastermind.models;

public enum Color {
	
	RED('r'),
	BLUE('b'),
	YELLOW('y'),
	GREEN('g'),
	ORANGE('o'),
	PURPLE('p');
	
	private char initial;
	
	private Color(char initial) {
		this.initial = initial;
	}
	
	public char getInitial() {
		return initial;		
	}
	
	public static Color valueOf(char letter) {
        for (Color color : values()) {
            if (color.initial == letter) {
                return color;
            }
        }
        return null;
    }
	
	public static String getInitials(Color[] colors) {
		String colorsInitials = "";
		for (int i = 0; i < colors.length; i++) {
			colorsInitials += colors[i].getInitial();
		}
		return colorsInitials;
	}

	public static String getInitials() {
		return Color.getInitials(Color.values());
	}
	
	public static Color[] getColorsArray(String colorsInitials) {
		Color[] colors = new Color[colorsInitials.length()];
		char[] colorsInitialsChar = colorsInitials.toCharArray();
		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.valueOf(colorsInitialsChar[i]);
		}
		return colors;
	}	
	
}
