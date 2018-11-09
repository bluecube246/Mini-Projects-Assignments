package Application;
/**
 * This Empty stack exception extends the exception class and is thrown when an empty stack is about to be accessed 
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class EmptyStackException extends Exception {
	/**
	 * This default constructor sends the current message to the exception superclass
	 */
	public EmptyStackException() {
		super("Error: Empty stack");
	}
	
	/**
	 * This default constructor sends the user defined String message to the superclass
	 * @param e
	 */
	public EmptyStackException(String e) {
		super(e);
	}

}
