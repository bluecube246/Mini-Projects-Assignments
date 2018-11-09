import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/**
 * This class represents the PassengerQueue that will extend a linked list
 * so that it can obtain information about the current Queue 
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 4
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class PassengerQueue extends LinkedList<Passenger> {
	
	/**
	 * This method is used to add a passenger to the linked list
	 * @param P is added to the linked list
	 */
	public void enqueue(Passenger P) {
		add(P);
	}
	
	/**
	 * A passenger is dequeued from the queue 
	 * @return the information of the passenger that is dequeued
	 */
	public Passenger dequeue() {
		return removeFirst();
	}
	
	/**
	 * This method is used to print out the current queue 
	 */
	public String toString() {
		String temp = "[";
		if(peek() == null)
			return temp += "empty]";
		for (int i = 0; i < size(); i++) {
			temp += get(i).toString() + " ";
		}
		return temp;

		
	}
	
	/**
	 * This method is used to look at the next passenger to be boarded. 
	 */
	public Passenger peek() {
		return peekFirst();
		
	}
	

	
	

}
