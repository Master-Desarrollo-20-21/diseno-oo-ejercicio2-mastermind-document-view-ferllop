package utils;

import java.util.Scanner;

import mastermind.models.ProposedCombination;

public class ConsoleIO {
	private Scanner scanner;
	private static ConsoleIO console;
		
	private ConsoleIO() {
		this.scanner = new Scanner(System.in);
	}

	public static ConsoleIO getInstance() {
		if(console == null) {
			console = new ConsoleIO();
		}
		return console;
	}

	public String getLowercaseString(String title) {
		String answer = "";
		do {
			System.out.print(title + ": ");
			answer = scanner.nextLine();
		} while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n"));
		return answer;
	}
	
	public void printAttempts(int attempts) {
		System.out.println(attempts + " attempt(s):");
	}

	public void printProposalResult(ProposedCombination proposedCombination, int blacks, int whites) {
		System.out.println(proposedCombination.toString() + " --> " + blacks + " blacks and " + whites + " whites");
	}

	public String getValidValue(String title, char[] validValues, int valueLength) {
		String value = "";
		do {
			value = getValidValue(title, validValues);
		} while (!this.hasSameLength(value, valueLength));
		return value;
	}
	
	public String getValidValue(String title, char[] validValues) {
		String value = "";
		do {
			System.out.print(title + ": ");
			value = scanner.nextLine();
		} while (this.hasDuplicates(value) || !this.hasValidValues(value, validValues));
		return value;
	}

	private boolean hasValidValues(String string, char[] validValues) {
		for(char value : string.toCharArray()) {
			boolean found = false;
			for(char validValue : validValues) {
				if (validValue == value) {
				 found = true;	
				}
			}
			if (!found) {
				System.out.println("Wrong colors, they must be: " + new String(validValues));
				return false;
			}
		}
		return true;
	}

	private boolean hasSameLength(String combination, int combinationLength) {
		if (combination.length() != combinationLength) {
			System.out.println("Wrong proposed combination length");
			return false;
		}
		return true;
	}
	
	private boolean hasDuplicates(String string) {
		for (int i = 0; i< string.length(); i++) {
			for (int j = 0; j < string.length(); j++) {
				if (j==i) {
					continue;
				}
				if (string.toCharArray()[j] == string.toCharArray()[i]) {
					System.out.println("Can't be duplicated colors");
					return true;
				}
			}
		}
		return false;
	}

	public void print(String string) {
		System.out.println(string);		
	}
}
