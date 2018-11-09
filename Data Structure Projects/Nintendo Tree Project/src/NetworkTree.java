import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class is used in defining the tree that stores all the network nodes.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 5
 * 
 * @author Hyuk Joon Kwon
 */
public class NetworkTree {
	private static NetworkNode root;
	private static NetworkNode cursor;
	private static NetworkTree instance;
	private static NetworkNode cut; 
	BufferedReader buffer;
	static int index;


	/**
	 * This method is used to read a file 
	 * @param string The name of the file to be read
	 * @return	The networkTree made from the file made
	 * @throws IOException if there is a file exeption
	 */

	public NetworkTree readFromFile(String string) throws IOException {
		File target = new File(string);
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);

		// NetworkTree temp = new NetworkTree();

		// NetworkNode nodeptr = temp.getRoot();

		root = new NetworkNode();

		cursor = root;

		try {
			String line;
			int index;
			while ((line = buffer.readLine()) != null) {
				//System.out.println(line);
				cursor = root;
				while (true) {
					if (!Character.isDigit(line.charAt(0))) {
						if(line.charAt(0) == '-'){
							cursor.setName(line.substring(1));
							cursor.setNintendo(true);
						}
						else {
							cursor.setName(line);
						}
//						if (!line.equals("SBU"))
//							System.out.println(cursor.getName() + " has a parent of " + cursor.getParent().getName());
						break;
					}

					index = Integer.parseInt(line.substring(0, 1)) - 1;
					line = line.substring(1);

					if (cursor.getChildren()[index] != null) {
						cursor = cursor.getChildren()[index];
					}

					else {
						cursor.getChildren()[index] = new NetworkNode();
						cursor.addCount(); //adds a counter
						cursor.getChildren()[index].setParent(cursor);
						//System.out.println(cursor.getChildren()[index].getName() + " has been set to "
						//		+ cursor.getChildren()[index].getParent().getName());
						cursor = cursor.getChildren()[index];
						cursor.setIndex(index);
					}
				}

			}

		} finally {
			cursor = root;
			buffer.close();
		}

		// instance = NetworkTree();

		return this;
	}
	
	/**
	 * This method is used to return the current cursor
	 * @return the current cursor
	 */
	public static NetworkNode getCursor() {
		return cursor;
	}
	
	/**
	 * This method is used to set the current cursor
	 * @param cursor the Networknode to be set as cursor
	 */
	public static void setCursor(NetworkNode cursor) {
		NetworkTree.cursor = cursor;
	}
	
	/**
	 * This method is used to get the current root of the tree
	 * @return the current root of the tree
	 */
	public static NetworkNode getRoot() {
		return root;
	}
	
	/**
	 * This method is used to set the current root of the tree
	 * @param root The networknode to be set as root
	 */
	public void setRoot(NetworkNode root) {
		this.root = root;
	}
	
	/**
	 * This method is used to set the cursor to the root
	 */
	public static void cursorToRoot() {
		cursor = root;
		System.out.println("Cursor set to Root");

	}
	
	/**
	 * This method is used to cut the current cursor including all its children
	 * @return the NetworkNode that is cut
	 */
	public static NetworkNode cutCursor() {
		cut = cursor;
		cursor = cursor.getParent();
		index = cut.getIndex();
		cursor.getChildren()[index] = null; // this will create a hole
		//System.out.print(index);
		cursor.arrayClean(index);
		System.out.println("Array clean finished. Elements shifted");
		return cut;

	}
	
	/**
	 * This method is used to paste the NetworkNode cut by cutCursor
	 */
	public static void paste() {
		cursor.getChildren()[cursor.getCount()] = cut;
		cursor.addCount();
	}
	
	/**
	 * THis method is used to add a child to the current cursor
	 * @param index the index to add the child
	 * @param node the NetworkNode to as a child
	 */
	public static void addChild(int index, NetworkNode node) {
		cursor.getChildren()[index] = node;
		cursor.getChildren()[index].setParent(cursor);
		cursor = cursor.getChildren()[index];
	}
	
	/**
	 * THis method is used to set the cursor to the cursors child at a given index
	 * @param index the index at which to set the cursor
	 */
	public static void cursorToChild(int index) {
		cursor = cursor.getChildren()[index];
		System.out.println("Cursor set to " + cursor.getName());
	}
	
	/**
	 * This method is used to set the cursor to its parent
	 */
	public static void cursorToParent() {
		cursor = cursor.getParent();
		System.out.println("Cursor set to " + cursor.getName());
	}
	
	/**
	 * This method is used to write the current tree into a file
	 * @param tree the tree to use creating the file
	 * @param filename the name of the file to save
	 * @throws IOException when there is a problem in writing the file
	 */
	public static void writeToFile(NetworkTree tree, String filename) throws IOException {
		File file = new File(filename);

		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists. ");
		}
		
		FileWriter writer = new FileWriter(file);
		writer.write("Test data");
		writer.close();
		
	}

	/**
	 * This method is extra credit. Something I didn't do. 
	 */
	public void cursorToMinimalBrokenSubtree() {

	}
}
