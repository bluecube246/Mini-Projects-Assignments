package Application;

import java.util.Scanner;
/**
 * This class GoogleSomething is an object that implements command that is going to be stacked in the Command stack. 
 * It containes strings of source destination and option
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class GoogleSomething implements Command{
	private String query;
	/**
	 * This Default constructor is used to initialize the string query
	 * @param scanner is used to get the user input
	 */
	public GoogleSomething(Scanner scanner) {
		System.out.print("Please enter a query: ");
		query = scanner.nextLine();
	}
	
	/**
	 * This method is to check if the current command is valid
	 * @param stack Pops up from the stack 
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 * If the stack cannot be stacked up due to certain conditions
	 */
	@Override
	public boolean validCommand(CommandStack stack) {
		return true;
	}
	
	/**
	 * This method is used to return a string representation of the command stack
	 * @return
	 * The string representation of the command stack.
	 */
	@Override
	public String toShortString() {
		return "->G:" + query;
	}
	
	/**
	 * This method is used to return a string representation of the command that will be displayed on the screen
	 * @return
	 * A string to be displaced on the screen
	 */
	public String toString() {
		return "Google: " + query;
	}

}
