package Application;
import java.util.Scanner;
/**
 * This class Command is a Interface is used as a template for the different functions of each application
 * 
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public interface Command {
	
	/**
	 * This method is to check if the current command is valid
	 * @param stack Pops up from the stack 
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 * If the stack cannot be stacked up due to certain conditions
	 */
	public boolean validCommand(CommandStack stack) throws InvalidCommandException;
	
	/**
	 * This method is used to return a string representation of the command that will be displayed on the screen
	 * @return
	 * A string to be displaced on the screen
	 */
	public String toString();
	/**
	 * This method is used to return a string representation of the command stack
	 * @return
	 * The string representation of the command stack.
	 */
	public String toShortString();
}
