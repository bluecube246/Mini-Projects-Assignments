package Application;
import java.util.LinkedList;

/**
 * This class Command stack method is used to control the command stack implemented as a linked list
 * Recitation: 14
 * Stony Brook ID: 109822712
 * Course: CSE 214
 * Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class CommandStack {
	LinkedList<Command> linkedlist = new LinkedList<Command>();
	
	/**
	 * This method is used to push a command object into the command stack
	 * @param command The stack to be pushed
	 * @throws InvalidCommandException
	 * If the stack cannot be pushed
	 */
	public void push(Command command) throws InvalidCommandException{
		linkedlist.push(command);
	}
	
	/**
	 * This method is used to pop a command object and return it
	 * @return The command object that has popped
	 * @throws InvalidCommandException
	 * Is the stack cannot be popped
	 */
	public Command pop() throws InvalidCommandException {
		if(linkedlist.isEmpty())
			throw new InvalidCommandException("Command Stack: Invalid Command Exception (Pop)");
		return linkedlist.pop();
	}
	
	/**
	 * THis method is used to peek from the current stack
	 * @return the Command object that has been popped
	 * @throws InvalidCommandException
	 * If the stack cannot be peeked
	 */
	public Command peek() throws InvalidCommandException{
		if(linkedlist.isEmpty())
			throw new InvalidCommandException("Command Stack: Invalid Command Exception (Peek)");
		return linkedlist.peek();
	}
	
	/**
	 * This method is to check if the current stack is empty
	 * @return True if the stack is empty false if it isn't
	 */
	public boolean isEmpty() {
		return linkedlist.isEmpty();
	}
	
	/**
	 * This method is used to get the String value of the current command
	 * @return the string value of the current command
	 * @throws InvalidCommandException
	 * If the String cannot be peeked
	 */
	public String getScreenCommand() throws InvalidCommandException {
		return peek().toString();
	}
	
	/**
	 * This method prints out the stack trace of the current stack
	 * @return the string of the entire stack trace
	 */
	public String toString() {
		String temp = "";
		Command ctemp;
		ctemp = linkedlist.getFirst();
		for(int i = linkedlist.size()-1; i >= 0; i--) {
			temp += linkedlist.get(i).toShortString();
			
		}
		
//		for(Command c: linkedlist) {
//			temp += c.toShortString();
//		}
		return temp;
	}
}
