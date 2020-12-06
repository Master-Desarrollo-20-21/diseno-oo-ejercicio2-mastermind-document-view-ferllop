package mastermind.models;

public abstract class Combination {
	
	protected Color[] combination;
		
	
	
	public int getSize() {
		return combination.length;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < combination.length; i++) {
			result.append(combination[i].getLetter());
		}		
		return result.toString();
	}	
	
	public boolean contains(Color color) {
		for (int i = 0; i < this.combination.length; i++) {
			if (this.combination[i] == color) {
				return true;
			}
		}
		return false;
	}
}
