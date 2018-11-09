package Application;

import java.util.Scanner;

/**
 * This class FollowLink is an object that implements command that is going to be stacked in the Command stack. 
 * It containes strings of source destination and option
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class FollowLink implements Command{
	
	private String link;
	
	/**
	 * This method is used to initialize the link String
	 * @param scanner Used to take in a value
	 */
	
	public FollowLink(Scanner scanner) {
		System.out.print("Please enter a link: ");
		link = scanner.nextLine();
	}
	
	
	/**
	 * This method is to check if the current command is valid
	 * @param stack Pops up from the stack 
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 * If the stack cannot be stacked up due to certain conditions
	 * This method cannot be stacked on an empty stack.
	 */
	@Override
	public boolean validCommand(CommandStack stack) throws InvalidCommandException {
		Command temp = stack.pop();
		if(stack.isEmpty()) {
			System.out.println("False");
			return false;
		}
		stack.push(temp);
		System.out.println("True");
		return true;
	}
	
	/**
	 * This method is used to return a string representation of the command stack
	 * @return
	 * The string representation of the command stack.
	 */
	@Override
	public String toShortString() {
		return "->L:" + link;
	}
	/**
	 * This method is used to return a string representation of the command that will be displayed on the screen
	 * @return
	 * A string to be displaced on the screen
	 */
	public String toString() {
		return "Safari Home";
	}

}
