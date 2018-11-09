package Application;

import java.util.Scanner;

/**
 * This class Represents a Safari that is of type application. This method
 * extends the appliation calss
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class Safari extends Application {

	/**
	 * This method is used to read the current command and stack it to the safari
	 * stack.
	 */
	@Override
	public boolean readCommand(Scanner scanner) throws InvalidCommandException {
		while (true) {
			try {
				print();
				String option;
				System.out.println("Safari Options");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				option = scanner.nextLine();

				if (option.equalsIgnoreCase("G")) {
					stack.push(new GoogleSomething(scanner));
					if (stack.peek().validCommand(stack) != true)
						stack.pop();
				}

				else if (option.equalsIgnoreCase("F")) {
					stack.push(new GoToBookmark(scanner));
					if (stack.peek().validCommand(stack) != true)
						stack.pop();
				}

				else if (option.equalsIgnoreCase("L")) {
					stack.push(new FollowLink(scanner));
					if (stack.peek().validCommand(stack) != true) {
						throw new InvalidCommandException();
					}
				}

				else if (option.equalsIgnoreCase("S"))
					return true;

				else if (option.equalsIgnoreCase("H"))
					return false;

				else if (option.equalsIgnoreCase("B")) {
					if (goBack() == false)
						return false;
					// if (stack.isEmpty()) {
					// System.out.println("Stack is empty");
					// System.out.println("Returning to main menu");
					// return false;
					// }
					stack.pop();
				}

				else {
					System.out.println("Invalid input");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			// if stack is empty return false
		}
	}

	/**
	 * THis method is used to print the current stack trace for Safari application
	 * 
	 * @throws InvalidCommandException
	 */

	public void print() throws InvalidCommandException {
		System.out.println("Stack Debug: ");
		if (stack.isEmpty()) {
			System.out.println("[Home->SafariHome");
			System.out.println("Current screen: Safari Home");
		} else {
			System.out.println("[Home->SafariHome" + stack.toString());
			// System.out.println("Current screen: " + stack.peek().toString());
			System.out.println("Current screen: " + stack.getScreenCommand());
		}
	}

	/**
	 * This method is used to return to the previous event. Returns true if the
	 * conditions are met. If not it will send the user back to the main method
	 */
	@Override
	public boolean goBack() {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty");
			System.out.println("Returning to main menu");
			return false;
		}
		return true;
	}
}
