/**
 * This class represents the individual nodes of the Delivery Objects and is responsible for linking them
 * @author Hyuk Joon Kwon
 * ID: 109822712
 * Recitation: 14
 * CSE 214
 *
 */
public class DeliveryListNode {
	private Delivery data;
	private DeliveryListNode next;
	private DeliveryListNode prev;
	
	/**
	 * This default constructor sets the delivery Data with the given Delivery
	 * @param intData
	 * The data to be initialized 
	 */
	public DeliveryListNode(Delivery intData) {
		if (intData == null)
			throw new IllegalArgumentException();
		// What does wrap the indicated Delivery mean?
		this.data = intData; // Does it mean this?
		this.prev = null;
		this.next = null;
	}
	/**
	 * This method is used to get the data of the current Node
	 * @return
	 * The Delivery Data
	 */

	public Delivery getData() {
		return data;
	}
	
	/**
	 * This method is used to set the data of the current Node
	 * @param data
	 * The data to be set
	 */

	public void setData(Delivery data) {
		this.data = data;
	}
	
	/**
	 * This method gets the Next element of the current Node
	 * @return
	 * The next element that is linked to the current Node
	 */

	public DeliveryListNode getNext() {
		return next;
	}
	
	/**
	 * This method modifies the next node to a specific node
	 * @param next
	 * The node to set as the next
	 */

	public void setNext(DeliveryListNode next) {
		this.next = next;
	}
	
	/**
	 * This method returns the previous element of the current node
	 * @return
	 * The previous element of the current node.
	 */

	public DeliveryListNode getPrev() {
		return prev;
	}
	/**
	 * This method sets the previous element of the current node to a specific node
	 * @param prev
	 * The Object to set the previous value
	 */
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}
}
