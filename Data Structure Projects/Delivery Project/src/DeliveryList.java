/**
 * This class represents The DeliveryList with Nodes head tail cursor, and a count variable. 
 * @author Hyuk Joon Kwon
 * ID: 109822712
 * Recitation: 14
 * CSE 214
 *
 */
public class DeliveryList {
	private DeliveryListNode head;
	private DeliveryListNode tail;
	private DeliveryListNode cursor;
	private int count;
	
	/**
	 * This is a default constructor that sets the elements head tail and cursor to null
	 */
	public DeliveryList() {
		head = null;
		tail = null;
		cursor = null;
	}
	
	/**
	 * This method returns the total number of delievery
	 * @return
	 */

	public int numDeliveries() {
		return count; // Need to fix how to run O(1)? //is this the right way to do it?
	}
	
	/**
	 * This method returns the Data of the current cursor
	 * @return
	 */

	public Delivery getCursor() {
		return cursor.getData();
	}
	
	/**
	 * This method sets the current cursor to head
	 */

	public void resetCursorToHead() {
		cursor = head;
	}
	
	/**
	 * This method sets the current cursor to tail
	 */

	public void resetCursorToTail() {
		cursor = tail;
	}
	
	/**
	 * This method sets the cursor to the next elements in the Linked list
	 * @throws EndOfListException
	 * When the cursor is tail
	 */

	public void cursorForward() throws EndOfListException {
		if (cursor == tail)
			throw new EndOfListException("Can not advance. Cursor is tail");
		cursor = cursor.getNext();
	}
	
	/**
	 * This method sets the cursor to the element previous in the Linked list
	 * @throws EndOfListException
	 * When the cursor is head
	 */

	public void cursorBackward() throws EndOfListException {
		if (cursor == head)
			throw new EndOfListException("Can not go back. Cursor is head");
		cursor = cursor.getPrev();
	}
	/**
	 * This method inserts a new Delivery object after the cursor depending on whether the cursor is null, tail or otherwise
	 * @param newDelivery
	 * The Delivery Object to be inseted in the linked list
	 */

	public void insertAfterCursor(Delivery newDelivery) {
		if (newDelivery == null)
			throw new IllegalArgumentException("The Delivery Object cannot be appended since it is null");
		System.out.println("insertAfterCursor method activated");
		DeliveryListNode newNode = new DeliveryListNode(newDelivery);
		if (cursor == null) {
			head = newNode;
			tail = newNode;
			cursor = newNode;
		} // The possibility that there are no elements in the array.

		else if (cursor.getNext() == null) {
			// cursor.setNext(newNode);
			// newNode.setPrev(cursor);
			// tail = newNode; // set new tail
			appendToTail(newDelivery);
			System.out.println("Order inserted");// If cursor == tail

		}

		else {
			newNode.setNext(cursor.getNext()); // This sets the next of the new node to the element after the cursor
			cursor.setNext(newNode); // This sets the next of the cursor to the new node
			newNode.setPrev(cursor);
			newNode.getNext().setPrev(newNode);
			// In conclusion the new node gets put in between the cursor and the value after
			if (cursor.getNext() == null)
				tail = cursor;

		}
		count++;
		System.out.println("Order inserted");
	}
	
	/**
	 * This method adds the current Delivery element to tail.
	 * @param newDelivery
	 * The delivery object to be added to the tail
	 */

	public void appendToTail(Delivery newDelivery) {
		if (newDelivery == null)
			throw new IllegalArgumentException("Cannot append to tail since Delivery is null");
		DeliveryListNode newNode = new DeliveryListNode(newDelivery);
		tail.setNext(newNode); // connect tail to new node
		newNode.setPrev(tail);// connect new node to tail
		tail = newNode; // set new tail
	}
	/**
	 * This method removes the Delivery Object at the current cursor There are different cases depending on weather the element is in the head tail or other
	 * @return
	 * The information of the Delivery object that is canceled
	 */

	public Delivery removeCursor() {
		if (cursor == null)
			throw new IllegalArgumentException("The cursor is null");

		Delivery returns = cursor.getData();// Is this necessary? Yes because you need to return what you have erased
		// What if cursor = tail
		
		if(cursor.getNext() == null && cursor.getPrev() == null) {//if cursor is the only element
			head = null;
			tail = null;
			cursor = null;
		}

		else if (cursor.getNext() == null) {// If cursor == tail
			System.out.println("if");
			cursor = cursor.getPrev();
			cursor.getNext().setPrev(null);
			cursor.setNext(null);
			tail = cursor;
		}

		else if (cursor.getPrev() == null) {// If cursor == head
			System.out.println("else if");
			cursor = cursor.getNext();
			cursor.getPrev().setNext(null);
			cursor.setPrev(null);
			head = cursor;
		}

		else {
			System.out.println("else");
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
		}

		return returns;
	}
	
	/**
	 * This method returns the current head of the list
	 * @return
	 * The current head element
	 */

	public DeliveryListNode getHead() {
		return head;
	}
	/**
	 * This method modifies the head to the parameter head
	 * @param head
	 * The head to be replaced
	 */

	public void setHead(DeliveryListNode head) {
		this.head = head;
	}
	
	/** 
	 * This method returns the current tail
	 * @return
	 * The current tail
	 */

	public DeliveryListNode getTail() {
		return tail;
	}
	
	/**
	 * This method sets the tail to a specified tail element
	 * @param tail
	 * The tail element to be replaced
	 */

	public void setTail(DeliveryListNode tail) {
		this.tail = tail;
		
	}
	
	/**
	 * This method sets the cursor to a specific cursor 
	 * @param cursor
	 * The cursor to be modified
	 */

	public void setCursor(DeliveryListNode cursor) {
		this.cursor = cursor;

	}

}
