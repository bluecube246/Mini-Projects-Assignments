package Application;

import java.util.Scanner;

/**
 * This class Planroute is an object that implements command that is going to be stacked in the Command stack. 
 * It containes strings of source destination and option
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class PlanRoute implements Command {
	private String source;
	private String destination;
	
	/**
	 * This getter method returns the current String source
	 * @return the String source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * This getter method returns the current String destination
	 * @return the String destination
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * This method initializes the source and the destination Strings
	 * @param scanner To get user input
	 */
	public PlanRoute(Scanner scanner) {
		System.out.print("Select a source: ");
		source = scanner.nextLine();
		System.out.print("Select a destination: ");
		destination = scanner.nextLine();
	}
	
	/**
	 * This method is to check if the current command is valid
	 * @param stack Pops up from the stack 
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 * If the stack cannot be stacked up due to certain conditions
	 * In this case there are no particular constraints
	 */
	@Override
	public boolean validCommand(CommandStack stack) {

		return true;
	}
	
	/**
	 * This method is used to return a string representation of the command that will be displayed on the screen
	 * @return
	 * A string to be displaced on the screen
	 */
	@Override
	public String toString() {
		return "Current Screen: ";

	}
	
	/**
	 * This method is used to return a string representation of the command stack
	 * @return
	 * The string representation of the command stack.
	 */
	@Override
	public String toShortString() {
		return "-> P: " + source + "-" + destination;
	}

}
