package Application;

/**
 * This class Startnavigation is an object that is going to be stacked in the
 * Command stack. It containes strings of source destination and option
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */

public class StartNavigation implements Command {

	private String source;
	private String destination;
	private String option;

	/**
	 * This method is used to initialize the start navigation class It will
	 * initialize differently depending on weather the peek is a Findplace.class or
	 * a PlanRoute.class
	 * 
	 * @param commandStack
	 *            The current stack and is needed to be peeked
	 * @throws InvalidCommandException
	 *             when the pop class is neither a findplace class nor a planroute
	 *             class
	 */
	public StartNavigation(CommandStack commandStack) throws InvalidCommandException {

		if (commandStack.isEmpty())
			throw new InvalidCommandException("No route or destination!");

		else if (commandStack.peek().getClass() == FindPlace.class) {
			option = "findPlace";
			System.out.println("Start Navigation constructor");
			destination = ((FindPlace) commandStack.peek()).getDestination();

			System.out.println("Destination " + destination);
			source = "";
		}

		else if (commandStack.peek().getClass() == PlanRoute.class) {
			option = "plan";
			destination = ((PlanRoute) commandStack.peek()).getDestination();
			source = ((PlanRoute) commandStack.peek()).getDestination();
		}

		else {
			throw new InvalidCommandException();
		}

	}

	/**
	 * This method is to check if the current command is valid
	 * 
	 * @param stack
	 *            Pops up from the stack
	 * @return True of false depending on the conditions
	 * @throws InvalidCommandException
	 *             If the stack cannot be stacked up due to certain conditions In
	 *             this case this method cannot be stacked it the current stack is
	 *             empty or the pop value is a startnavigation class
	 */
	@Override
	public boolean validCommand(CommandStack stack) throws InvalidCommandException {
		Command temp = stack.pop();
		if (stack.isEmpty() || stack.peek().getClass() == StartNavigation.class) {
			return false;
		}
		stack.push(temp);
		return true;
	}

	/**
	 * This method is used to return a string representation of the command stack
	 * 
	 * @return The string representation of the command stack.
	 */
	@Override
	public String toShortString() {
		if (option.equals("findPlace"))
			return "->N:" + destination;
		return "->N:" + destination + "-" + source;
	}

	/**
	 * This method is used to return a string representation of the command that
	 * will be displayed on the screen
	 * 
	 * @return A string to be displaced on the screen
	 */
	@Override
	public String toString() {
		if (option.equals("findPlace"))
			return "Current Screen: Navigating to " + destination;
		return "Navigating from " + destination + " to " + source;
	}

}
