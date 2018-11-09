package Application;
/**
 * This class Represents a Bookshelf that has a string of books, a count to count the number of books and a
 * finalized capacity
 * 
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class InvalidCommandException extends Exception {
/**
 * This default constructor automatically sends in a message to the superclass
 */
	public InvalidCommandException() {
		super("Error: Invalid command");
	}
/**
 * This default constructor takes in a value and sends it to the superclass constructor
 * @param e The message of the error to be displayed
 */
	
	public InvalidCommandException(String e) {
		super(e);
	}
}
