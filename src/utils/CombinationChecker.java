package utils;

import java.util.Arrays;
import java.util.HashSet;

public class CombinationChecker<T> {
	
	private T[] combination;
	
	public CombinationChecker(T[] combination) {
		this.combination = combination;
	}
	
	public boolean hasValidLength(int validLength) {
		assert(combination != null);
		return combination.length == validLength;
	}

	public boolean hasValidValues(T[] validValues) {
		assert(combination != null);
		for (T value : combination) {
			if (!Arrays.asList(validValues).contains(value)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasDuplicates() {
		assert(combination != null);
		HashSet<T> list = new HashSet<T>(Arrays.asList(combination));
		return list.size() < combination.length;
	}
}