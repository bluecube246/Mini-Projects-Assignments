package Application;

import java.util.Scanner;

/**
 * This class Represents a Map application that extends the abstract class
 * application
 * 
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class Maps extends Application {

	/**
	 * This method is used to read a command using a scanner and stack it up.
	 */
	@Override
	public boolean readCommand(Scanner scanner) throws InvalidCommandException {
		while (true) {
			try {
				print();
				String option;
				System.out.println("Maps Options");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				option = scanner.nextLine();

				if (option.equalsIgnoreCase("F")) {
					stack.push(new FindPlace(scanner));
					if (stack.peek().validCommand(stack) != true)
						stack.pop();
				}

				else if (option.equalsIgnoreCase("P")) {
					stack.push(new PlanRoute(scanner));
					if (stack.peek().validCommand(stack) != true)
						stack.pop();
				}

				else if (option.equalsIgnoreCase("N")) {
					stack.push(new StartNavigation(stack));
					if (stack.peek().validCommand(stack) != true)
						throw new InvalidCommandException();
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

				// if stack is empty return false
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * THis method is used to print the current stack trace
	 * 
	 * @throws InvalidCommandException
	 */
	public void print() throws InvalidCommandException {
		System.out.println("Stack debug:");
		if (stack.isEmpty()) {
			System.out.println("[Home->MapsHome");
			System.out.println("Current screen: MapsHome");
		} else {
			System.out.println("[Home->MapsHome" + stack.toString());
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
