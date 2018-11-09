/**
 * This class represents the Passenger class that will be used to store various information about a passenger.
 * It contins the pasengers id arrival time and a boolean method to check if it is first class. 
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 4
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class Passenger {
	private int id;
	private int arrivalTime;
	private boolean isFirstClass;
	
	/**
	 * This constructor is used to initialize the id arrivalTime and isFirstClass
	 * @param id The id of the passenger
	 * @param arrivalTime The time which the passenger has arrived
	 * @param isFirstClass Weather this person is first class or not
	 */
	public Passenger(int id, int arrivalTime, boolean isFirstClass) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.isFirstClass = isFirstClass;
	}
	
	/**
	 * returns the Id of the current passenger
	 * @return
	 */

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}
	
	/**
	 * returns the time that the passenger has arrived
	 * @return the arrival time of the passenger
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Sets the arrival time of the next train. Used when the train leaves 
	 * a station and heads for the next
	 * @param arrivalTime the time to be set. This value will always be 5
	 * since that is the time distance between the stations
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * 
	 * @return weather the current passenger is first class or not
	 */
	public boolean isFirstClass() {
		return isFirstClass;
	}

//	public void setFirstClass(boolean isFirstClass) {
//		this.isFirstClass = isFirstClass;
//	}
	
	/**
	 * returns the string representation of the current passenger
	 * This will be used in the queue in passengerqueue class
	 */
	public String toString() {
		return "P"+getId() + "@T" + getArrivalTime();
	}
}
