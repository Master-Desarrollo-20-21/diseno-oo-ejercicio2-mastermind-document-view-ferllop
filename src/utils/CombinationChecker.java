package utils;

import java.util.Arrays;
import java.util.HashSet;

public class CombinationChecker<T> {
	
	private T[] combination;
	
	public CombinationChecker(T[] combination) {
		this.combination = combination;
	}
	
	public boolean hasValidLength(int validLength) {
		return combination.length == validLength;
	}

	public boolean hasValidValues(T[] validValues) {
		for (T value : combination) {
			if (!Arrays.asList(validValues).contains(value)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasDuplicates() {
		HashSet<T> list = new HashSet<T>(Arrays.asList(combination));
		return list.size() < combination.length;
	}
}
