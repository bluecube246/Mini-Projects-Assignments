package Application;

import java.util.Scanner;

/**
 * This class Represents a Bookshelf that has a string of books, a count to
 * count the number of books and a finalized capacity
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 3
 * 
 * @author Hyuk Joon Kwon
 */
public class iCatchUp {
	static Scanner in;
	static Application map = new Maps();
	static Application safari = new Safari();
	static Application current;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while (true) {
			try {
				Boolean homeloop = true;
				while (homeloop == true) {

					String stack;
					System.out.println("You are on the home screen");
					System.out.println("Home Options:");
					System.out.println("\tS) Safari");
					System.out.println("\tM) Maps");
					System.out.println("\tQ) Quit");
					System.out.print("Please select an option: ");

					stack = in.nextLine();

					// run time error here fix
					switch (stack) {
					case ("M"):
					case ("m"):
						current = map;
						homeloop = false;
						break;
					case ("S"):
					case ("s"):
						current = safari;
						homeloop = false;
						break;
					case ("Q"):
					case ("q"):
						System.out.println("Exiting program");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input: try again");

					}
				}

				Boolean ask = true;
				while (ask) {
					ask = current.readCommand(in);
					// change them
					if (current.equals(safari))
						current = map;
					else if (current.equals(map))
						current = safari;
					else
						continue;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * This method is used to activate Either safari or maps
	 * 
	 * @param ask
	 *            is True to start the program
	 * @throws Exception
	 *             When an exception arises
	 */
	public static void ask(Boolean ask) throws Exception {
		while (ask) {
			try {
				ask = current.readCommand(in);
				// change them
				if (current.equals(safari))
					current = map;
				else if (current.equals(map))
					current = safari;
				else
					continue;
			} catch (Exception e) {
				throw new Exception(e);
			}
		}
	}
}
