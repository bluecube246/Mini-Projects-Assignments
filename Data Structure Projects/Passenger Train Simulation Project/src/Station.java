/**
 * This class represents the Station class that will be used to store various
 * information about a station. The dequeCount and dequeue sum are used to count
 * the number of minutes each customer has waited before being dequed These four
 * references will only be used by the station array in the main method
 * 
 * The id will store the current id of the last boarded passenger. This will be
 * used in the statistics at the end of the program
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 4
 * 
 * @author Hyuk Joon Kwon
 *
 */

public class Station {
	private PassengerQueue firstClass;
	private PassengerQueue secondClass;
	private BooleanSource firstArrival;
	private BooleanSource secondArrival;
	private String stationName;
	private static int id = 0;
	private int dequeueCount1 = 0;
	private int dequeueSum1 = 0;
	private int dequeueCount2 = 0;
	private int dequeueSum2 = 0;
	private int time = 0;
	private int lastArrival;

	/**
	 * This default constructor is used to initilaize parameters
	 * 
	 * @param p1
	 *            is used to initialize the probability of firstclassArrival
	 * @param p2
	 *            is used to intitialize the probability of secondclassArrival
	 * @param stationName
	 *            is used to store the name of the current sttion
	 * @param lastArrival
	 *            is used to store the time of the last arrival of passengers
	 */

	public Station(double p1, double p2, String stationName, int lastArrival) {
		firstArrival = new BooleanSource(p1);
		secondArrival = new BooleanSource(p2);
		this.stationName = stationName;
		firstClass = new PassengerQueue();
		secondClass = new PassengerQueue();
		this.lastArrival = lastArrival;
	}

	/**
	 * This method is used to store the current passengers that are waiting in the
	 * station This is used as a queue trace. The firstclass secondclass queues are
	 * all shared between identical station objects.
	 */
	public void simulateTimestep() {

		System.out.println(stationName + ":");

		if (firstArrival.occurs() == true && time <= lastArrival) {
			id++;
			System.out.println("First class passenger ID " + id + " arrives");
			firstClass.enqueue(new Passenger(id, time, true));
			System.out.print("First ");
			System.out.println(firstClass.toString());
		} else {
			System.out.println("No first class passenger arrives");
			System.out.print("First ");
			System.out.println(firstClass.toString());
		}

		if (secondArrival.occurs() == true && time <= lastArrival) {
			id++;
			System.out.println("Second class passenger ID " + id + " arrives");
			secondClass.enqueue(new Passenger(id, time, false));
			System.out.print("Second ");
			System.out.println(secondClass.toString());
		} else {
			System.out.println("No second class passenger arrives");
			System.out.print("Second ");
			System.out.println(secondClass.toString());
		}
		time++;
	}

	/**
	 * This method is used to return the current number of passengers that have
	 * arrived
	 * 
	 * @return the current number of passengers that has arrived
	 */

	public static int getId() {
		return id;
	}

	/**
	 * This method returns the first class PassengerQueue
	 * 
	 * @return the first class Passenger Queue
	 */

	public PassengerQueue getFirstClass() {
		return firstClass;
	}

	/**
	 * This method sets the first class PassengerQueue
	 * 
	 * @param firstClass
	 *            is set by the given parameter
	 */

	public void setFirstClass(PassengerQueue firstClass) {
		this.firstClass = firstClass;
	}

	/**
	 * This method is used to get the second class Passenger Queue
	 * 
	 * @return the second class Passenger Queue
	 */
	public PassengerQueue getSecondClass() {
		return secondClass;
	}

	/**
	 * This method is used to set the second class passenger queue
	 * 
	 * @param secondClass
	 *            is set by the given parameter
	 */
	public void setSecondClass(PassengerQueue secondClass) {
		this.secondClass = secondClass;
	}

	// public BooleanSource getFirstArrival() {
	// return firstArrival;
	// }

	// public void setFirstArrival(BooleanSource firstArrival) {
	// this.firstArrival = firstArrival;
	// }

	// public BooleanSource getSecondArrival() {
	// return secondArrival;
	// }

	// public void setSecondArrival(BooleanSource secondArrival) {
	// this.secondArrival = secondArrival;
	// }

	/**
	 * This method returns the name of the current station
	 * 
	 * @return the name of the current station.
	 */
	public String getStationName() {
		return stationName;
	}

	// public void setStationName(String stationName) {
	// this.stationName = stationName;
	// }

	/**
	 * This method gets the sum of the number of passengers that have dequeue from
	 * first class
	 * 
	 * @return the number of passengers who have left the first class queue
	 */
	public int getDequeueCount1() {
		return dequeueCount1;
	}

	/**
	 * This method adds the average wait time of a passenger as they dequeue the
	 * passenger queue
	 * 
	 * @param dequeueCount1
	 *            this value will be one
	 */
	public void addDequeueCount1(int dequeueCount1) {
		this.dequeueCount1 += dequeueCount1;
	}

	/**
	 * This method is used to get the current sum of the wait time of the passengers
	 * in first class
	 * 
	 * @return the current sum of the wait time
	 */
	public int getDequeueSum1() {
		return dequeueSum1;
	}

	/**
	 * This method adds the average wait time of a passenger as they dequeue the
	 * first class passenger queue
	 * 
	 * @param dequeueCount1 this will be one since one passenger would be dequed
	 */
	public void addDequeueSum1(int dequeueSum1) {
		this.dequeueSum1 += dequeueSum1;
	}
	
	/**
	 *  This will return the number of second class passengeres deququed
	 * @return the number of second class passengers dequeued
	 */
	public int getDequeueCount2() {
		return dequeueCount2;
	}

	/**
	 * This method adds the average wait time of a passenger as they dequeue the
	 * second class passenger queue
	 * 
	 * @param dequeueCount2 this will be one since one passenger will be dequeued
	 */
	public void addDequeueCount2(int dequeueCount2) {
		this.dequeueCount2 += dequeueCount2;
	}
	
	/**
	 * The sum of the number of second class passengers dequeued
	 * @return the sum of the second class passengers dequeued
	 */
	public int getDequeueSum2() {
		return dequeueSum2;
	}
	
	/**
	 * The sum the wait time of a passenger after being dequeued
	 * @param dequeueSum2 the value to be summed
	 */

	public void addDequeueSum2(int dequeueSum2) {
		this.dequeueSum2 += dequeueSum2;
	}

}
