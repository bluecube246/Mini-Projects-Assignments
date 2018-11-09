/**
 * This class is a custom exceptions class that is thrown when an element after or before the head and tail are trying to be accessed
 * @author Hyuk Joon Kwon
 * ID: 109822712
 * Recitation: 14
 * CSE 214
 *
 */
public class EndOfListException extends Exception {
	public EndOfListException(String e) {
		super(e);
	}
}
