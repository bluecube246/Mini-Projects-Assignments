import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * This class is the main method of the project
 * @author Hyuk Joon Kwon
 * ID: 109822712
 * Recitation: 14
 * CSE 214
 *
 */
public class DeliveryDriver {

	private static Scanner in;

	public static void main(String[] args) {
		DeliveryList first = new DeliveryList();
		DeliveryList second = new DeliveryList();
		DeliveryList third = new DeliveryList();
		DeliveryList current = first;
		Delivery copy = null;
		String option;

//		current.insertAfterCursor(new Delivery("a", "b", "c"));
//		current.insertAfterCursor(new Delivery("d", "e", "f"));
//		current.insertAfterCursor(new Delivery("g", "h", "i"));
		//for texting use

		in = new Scanner(System.in);

		while (true) {
			try {
				// try {
				// TimeUnit.SECONDS.sleep(2);
				// } catch (InterruptedException e1) {
				// System.out.println("Exception with TimeUnit.sleep");
				// }

				System.out.println();
				System.out.println("Welcone to Delinquent Dollar Delivery Scheduler");
				System.out.println("Menu: ");
				System.out.println("     A) Add a Delivery After Cursor");
				System.out.println("     R) Remove Delivery At Cursor");
				System.out.println("     X) Cut Cursor");
				System.out.println("     V) Paste After Cursor");
				System.out.println("     H) Cursor to Head");
				System.out.println("     T) Cursor to Tail");
				System.out.println("     F) Cursor Forward");
				System.out.println("     B) Cursor Backward");
				System.out.println("     S) Switch Delivery Lists");
				System.out.println("     P) Print current List");
				System.out.println("     Q) Quit");
				System.out.println();

				System.out.print("Please select an option: ");
				option = in.nextLine();
				System.out.println();

				switch (option) {
				case ("A"):
				case ("a"):
					current.insertAfterCursor(getInput());
					break;

				case ("R"):
				case ("r"):
					print(current.removeCursor());
					System.out.println("Has been removed");
					System.out.println();
					break;

				case ("X"):
				case ("x"):
					copy = current.removeCursor();
					break;

				case ("V"):
				case ("v"):
					if (copy == null) {
						System.out.println("There is nothing to paste");
						break;
					}
					current.insertAfterCursor(copy);
					break;

				case ("H"):
				case ("h"):
					current.resetCursorToHead();
					break;

				case ("T"):
				case ("t"):
					current.resetCursorToTail();
					break;

				case ("F"):
				case ("f"):

					current.cursorForward();
					break;

				case ("B"):
				case ("b"):

					current.cursorBackward();

					break;

				case ("S"):
				case ("s"):
					int temp;
					System.out.print("Type 1 for list 1 type 2 for list 2 type 3 for list three");
					temp = in.nextInt();
					in.nextLine();
					if (temp == 1)
						current = first;
					else if (temp == 2)
						current = second;
					else if (temp == 3)
						current = third;
					else
						System.out.println("Invalid index");

					break;

				case ("P"):
				case ("p"):
					DeliveryListNode nodeptr = current.getHead();

					System.out
							.println("------------------------------------------------------------------------------");
					while (nodeptr != null) {
						print(nodeptr);
						if (nodeptr.getData() == current.getCursor())
							System.out.println("->");
						else
							System.out.println("~");
						nodeptr = nodeptr.getNext();
					}

					System.out
							.println("------------------------------------------------------------------------------");

					break;

				case ("Q"):
				case ("q"):
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	/**
	 * This static method is used to Create a delivery Object
	 * @return
	 * The deliery Object
	 */
	public static Delivery getInput() {
		String source;
		String destination;
		String instruction;
		System.out.print("Please enter a source: ");
		source = in.nextLine();
		System.out.print("Please enter a destination: ");
		destination = in.nextLine();
		System.out.print("Please enter any special instructions: ");
		instruction = in.nextLine();
		Delivery temp = new Delivery(source, destination, instruction);
		return temp;
	}
	/**
	 * This static method is used to print out a specific node using DeliveryListNode Object
	 * @param nodeptr
	 * The DeliveryListNode Object to be printed
	 */

	public static void print(DeliveryListNode nodeptr) {
		System.out.print("To: " + nodeptr.getData().getDest());
		System.out.println(" | From:" + nodeptr.getData().getSource());
		System.out.println("Instruction: " + nodeptr.getData().getinstruction());
	}
	
	/**
	 * This static method is used to print out a specific node using the Delivery Object
	 * @param data
	 * The Delivery Object to be printed
	 */

	public static void print(Delivery data) {
		System.out.print("To: " + data.getDest());
		System.out.println(" | From:" + data.getSource());
		System.out.println("Instruction: " + data.getinstruction());
	}
}
