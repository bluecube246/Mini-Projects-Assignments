package Application;

import java.util.Scanner;

/**
 * This class GoToBookmark is an object that implements command that is going to
 * be stacked in the Command stack. It containes strings of source destination
 * and option Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework:
 * 3
 * 
 * @author Hyuk Joon Kwon
 */
public class GoToBookmark implements Command {

	public String bookmark;

	/**
	 * This method is used to initialize String bookmark
	 * 
	 * @param scanner
	 *            Is used to take in the user input
	 */
	public GoToBookmark(Scanner scanner) {
		System.out.print("Enter a bookmark name: ");
		bookmark = scanner.nextLine();
	}

	/**
	 * This method is to check if the current command is valid
	 * 
	 * @param stack
	 *            Pops up from the stack
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 *             If the stack cannot be stacked up due to certain conditions
	 */
	@Override
	public boolean validCommand(CommandStack stack) {
		return true;
	}

	/**
	 * This method is used to return a string representation of the command stack
	 * 
	 * @return The string representation of the command stack.
	 */
	@Override
	public String toShortString() {
		return "->F:" + bookmark;
	}

	/**
	 * This method is used to return a string representation of the command that
	 * will be displayed on the screen
	 * 
	 * @return A string to be displaced on the screen
	 */
	public String toString() {
		return "Safari Home";
	}

}
