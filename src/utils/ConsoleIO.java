package utils;

import java.util.Scanner;

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
	
	public void print(String string) {
		System.out.println(string);		
	}
	
	public void printEmptyLine() {
		this.print("");
	}
	
	public String getString(String title) {
		this.print(title);
		return scanner.nextLine();
	}
}
