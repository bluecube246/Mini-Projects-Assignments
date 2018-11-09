package Application;
import java.util.Scanner;
/**
 * This abstract class Represents an application template used for maps and safari
 * It has a stack as a variable that is used to manage activities
 * 
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public abstract class Application {
	protected CommandStack stack;

	/**
	 * This default constructor is used to create a new command stack
	 */
	public Application() {
		stack = new CommandStack();
	}
	
	/**
	 * 
	 * @param scanner Passes on a scanner to get input
	 * @return a true or false depending on wheather the method is readable
	 * @throws InvalidCommandException
	 * when the read command method is activated but cannot be used
	 */
	public abstract boolean readCommand(Scanner scanner) throws InvalidCommandException;
	
	/**
	 * This method is used to pop an element from the stack.
	 * @return whether popping an element can be done
	 */
	public abstract boolean goBack();
	
	
}
