package Application;
import java.util.Scanner;
/**
 *  * This class Findplace is an implementation of Command used to find (store) a specific place
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class FindPlace implements Command{
	
	private String destination;
	
	/**
	 * This method is used to return the destination stored as string
	 * @return
	 * String of the current detination
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * This Default constructor is used to initialize the destination
	 * @param scanner
	 * Is used so that the user can type in the destination
	 */
	public FindPlace(Scanner scanner) {
		System.out.print("Please enter a location: ");
		destination = scanner.nextLine();

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
		return "->F: " + destination;
	}
	/**
	 * This method is used to return a string representation of the command that will be displayed on the screen
	 * @return
	 * A string to be displaced on the screen
	 */
	@Override
	public String toString() {
		return "Showing results for " + destination;
	}

	
}
