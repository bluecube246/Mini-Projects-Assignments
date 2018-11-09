import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the main method that will be used to control the entire
 * tree including importing data and modifying it.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 5
 * 
 * @author Hyuk Joon Kwon
 *
 */

public class NintendoNetwork {
	static NetworkNode nodeptr;
	static NetworkNode space;
	static int i = 0;
	static NetworkTree tree;
	static String option;
	static Scanner in;
	static int child;
	static FileWriter writer;
	static BufferedWriter writer1;
	static StringBuilder num = new StringBuilder();
	static String read;

	public static void main(String[] args) throws IOException {
		NetworkNode array[];
		in = new Scanner(System.in);

		tree = new NetworkTree();
		// tree = tree.readFromFile("-sbutopology");

		// nodeptr = NetworkTree.getRoot();
		//
		// inorder();

		while (true) {
			try {
				System.out.println("Welcome to the Nintendo Network Manager");
				System.out.println("Menu:");
				System.out.println("\tL) Load from file");
				System.out.println("\tP) Print tree");
				System.out.println("\tC) Move cursor to a child node");
				System.out.println("\tR) Move cursor to root");
				System.out.println("\tU) Move cursor up to parent");
				System.out.println("\tA) Add a child");
				System.out.println("\tX) Remove/Cut Cursor and its subtree");
				System.out.println("\tV) Paste Cursor and its subtree");
				System.out.println("\tS) Save to file");
				System.out.println("\tB) Mark cursor as broken/fixed");
				System.out.println("\tQ) Quit");
				System.out.println();
				System.out.print("Please select an option: ");

				option = in.nextLine();

				switch (option) {
				case ("L"):
				case ("l"):
					System.out.println("Please include .txt if its a text file");
					System.out.print("Please enter a file name: ");
					read = in.nextLine();
					System.out.println(read);
					File f = new File(read);
					if (f.exists()) {
						System.out.println("File found");
						tree = tree.readFromFile(read);
					} else
						System.out.println("The file does not exist");

					break;
				case ("P"):
				case ("p"):
					nodeptr = NetworkTree.getRoot();
					inorder();
					System.out.println();
					break;
				case ("C"):
				case ("c"):
					System.out.print("Type in an index. ");
					System.out.print("Index starts at 1:");
					child = in.nextInt()-1;
					in.nextLine();
					if(child >= NetworkTree.getCursor().getCount()) {
						System.out.println("Invalid index ");
						break;
					}
						
					if (NetworkTree.getCursor().getChildren()[child] == null)
						System.out.println("Error: Cursor will be null");
					else
						NetworkTree.cursorToChild(child);

					// NetworkTree.setCursor(NetworkTree.getCursor().getChildren()[child]);
					// System.out.println("Cursor set to " + NetworkTree.getCursor().getName());
					break;
				case ("R"):
				case ("r"):
					NetworkTree.cursorToRoot();
					// NetworkTree.setCursor(NetworkTree.getRoot());
					// System.out.println("Cursor set to Root");
					break;
				case ("U"):
				case ("u"):
					if (NetworkTree.getCursor().getParent() == null)
						System.out.println("Error: The cursor is at root");
					else
						NetworkTree.cursorToParent();
					// NetworkTree.setCursor(NetworkTree.getCursor().getParent());
					// System.out.println("Cursor set to " + NetworkTree.getCursor().getName());
					break;

				case ("A"):
				case ("a"):
					if (NetworkTree.getCursor().isNintendo() == false) {
						NetworkNode temp;
						temp = new NetworkNode();
						int index1;
						String device;
						String isNintendo;
						System.out.println("Please enter an index: ");
						System.out.print("Index starts at 1: ");
						index1 = in.nextInt()-1;
						in.nextLine();
						if(index1 > NetworkTree.getCursor().getCount()) {
							System.out.println("Invalid index: Index is too high it will create a hole");
							break;
						}
						System.out.print("Please enter a device name: ");
						device = in.nextLine();
						while (true) {
							System.out.print("Is this Nintendo (y/n)?");
							isNintendo = in.nextLine();
							if (isNintendo.equalsIgnoreCase("y")) {
								temp.setNintendo(true);
								break;
							} else if (isNintendo.equalsIgnoreCase("n"))
								break; // false is default
							else
								System.out.println("Please enter a valid input");
						}

						temp.setName(device);
						temp.setIndex(index1);
						NetworkTree.addChild(index1, temp);
					}
					else
						System.out.println("This is a nintendo: Cannot add a tree");
					break;

				case ("B"):
				case ("b"):
					if (NetworkTree.getCursor().isNintendo() == true)
						if (NetworkTree.getCursor().isBroken() == true) {
							NetworkTree.getCursor().setBroken(false);
							System.out.println(NetworkTree.getCursor().getName() + " is fixed.");
						} else {
							NetworkTree.getCursor().setBroken(true);
							System.out.println(NetworkTree.getCursor().getName() + " is broken");
						}
					else
						System.out.println("The current cursor is not a nintendo");
					break;

				case ("X"):
				case ("x"):
					NetworkTree.cutCursor();
					break;

				case ("V"):
				case ("v"):
					NetworkTree.paste();
					break;

				case ("S"):
				case ("s"):
					// NetworkTree.writeToFile(tree, "tempfile");
					System.out.println("Please enter .txt if you want to save it as a text file");
					System.out.print("Type in a file name to save this file: ");
					String a = in.nextLine();

					File file = new File(a);

					if (file.createNewFile()) {
						System.out.println("File is created!");
					} else {
						System.out.println("File already exists. ");
					}
					System.out.println("Starting to write");

					System.out.println("1");
					writer = new FileWriter(file);
					System.out.println("2");
					writer1 = new BufferedWriter(writer);
					System.out.println("3");
					nodeptr = NetworkTree.getRoot();

					inorderFile();
					System.out.println("4");
					System.out.println("Writing complete");
					System.out.println("5");
					writer1.close();
					break;

				case ("Q"):
				case ("q"):
					System.exit(0);
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	// public static void inorder() {
	// System.out.println(nodeptr.getName());
	// if(nodeptr.getChildren()[0] != null){
	// for (int i = 0; i < nodeptr.getChildren().length; i++) {
	// System.out.print(" " + i);
	// if(nodeptr.getChildren()[i] == null) {
	// System.out.println("If statement");
	//// nodeptr = nodeptr.getParent();
	//// //error because null does not have a parent
	// break;
	// }
	// nodeptr = nodeptr.getChildren()[i];
	// inorder();
	// //System.out.println(nodeptr.getChildren()[i].getName());
	// }
	// }
	// else {
	// System.out.print("No children back to: ");
	// nodeptr = nodeptr.getParent();
	// System.out.println(nodeptr.getName());
	// }
	//
	// for(NetworkNode child: nodeptr.getChildren()) {
	//
	// }
	//
	// }

	// public static void inorder() {
	//
	// System.out.println(nodeptr.getName());
	// if (nodeptr.getChildren()[0] != null) { // Thus has children
	// for (NetworkNode child : nodeptr.getChildren()) {
	// if (child == null) {
	// System.out.print("No more children. Break: ");
	// if (!nodeptr.getName().equals("SBU"))
	// System.out.println("Back to parent "+nodeptr.getParent().getName());
	// break;
	// }
	// nodeptr = child;
	// inorder();
	// }
	// }
	//
	// else {
	// System.out.print(nodeptr.getName() + " has ");
	// System.out.print("no children back to: ");
	// nodeptr = nodeptr.getParent();
	// System.out.println(nodeptr.getName());
	//
	// }
	// }

	/**
	 * This method is used to print out the indorder traversal of the tree
	 */
	public static void inorder() {
		space = nodeptr;
		while (space.getParent() != null) {
			System.out.print("   ");
			space = space.getParent();
		}
		if (nodeptr.isNintendo() == true)
			System.out.print("-");
		else
			System.out.print("+");
		System.out.print(nodeptr.getName());
		if (NetworkTree.getCursor().equals(nodeptr))
			System.out.print(" <-");
		if (nodeptr.isBroken())
			System.out.println("\tBroken");
		else
			System.out.println();
		if (nodeptr.getChildren()[0] != null) { // Thus has children
			for (NetworkNode child : nodeptr.getChildren()) {
				if (child == null) {
					break;
				}
				nodeptr = child;
				inorder();
			}
		}

		else {
			nodeptr = nodeptr.getParent();

		}
	}

	/**
	 * This method is used to save the current tree to a file using an inorder
	 * method to traverse the tree.
	 * 
	 * @throws IOException
	 *             if there is a problem with the file
	 */
	public static void inorderFile() throws IOException {
		space = nodeptr;
		while (space.getParent() != null) {
			num.append(String.valueOf(space.getIndex() + 1));
			// writer1.write(String.valueOf(space.getIndex()+1));
			space = space.getParent();
		}

		num.reverse();

		writer1.write(num.toString());

		num.delete(0, num.length());

		if (nodeptr.isNintendo() == true) {
			writer1.write("-");
		}
		// else
		// writer1.write("+");
		writer1.write(nodeptr.getName());
		if (NetworkTree.getCursor().equals(nodeptr))
			writer1.newLine();
		// writer.write(" <-\n");
		else
			writer1.newLine();
		// writer1.write("\n");
		if (nodeptr.getChildren()[0] != null) { // Thus has children
			for (NetworkNode child : nodeptr.getChildren()) {
				if (child == null) {
					break;
				}
				nodeptr = child;
				inorderFile();
			}
		}

		else {
			nodeptr = nodeptr.getParent();

		}
	}

}
