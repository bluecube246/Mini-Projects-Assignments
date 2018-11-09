import java.util.LinkedList;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * This class represents the Train class that will be used to store various information about a train.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 4
 * 
 * @author Hyuk Joon Kwon
 *
 */

public class Train {
	private int firstCapacity;
	private int fixedFirstCapacity;
	private int secondCapacity;
	private int fixedSecondCapacity;
	private int timeUntilNextArrival;
	LinkedList<Station> station = new LinkedList<Station>();
	LinkedList<Station> mainStation;
	private int time = 0;
	private int trainNumber;
	private int dequeueSum1 = 0;
	private int dequeueSum2 = 0;
	int one = 1;
	int stationIndex;
	
	/**
	 * This initial constructor is used to initialize various information about the train
	 * @param firstCapacity is used to set the fixed capacity of the first class train and another 
	 * to store the same capacity but will be decremented as a passenger boards the train
	 * @param secondCapacity is used to set the fixed capacity of the second class train and another 
	 * to store the same capacity but will be decremented as a passenger boards the train
	 * @param timeUntilNextArrival this value contains the time until the next train arrives
	 * @param trainNumber this value includes the index of the train. It will be used as trainNumber + 1
	 * @param mainStation is used as a reference to the station linked list in the main method. Unlike other station linked
	 * lists this one will have elements dequeued. 
	 */
	public Train(int firstCapacity, int secondCapacity, int timeUntilNextArrival, int trainNumber,
			LinkedList<Station> mainStation) {
		this.firstCapacity = firstCapacity;
		this.fixedFirstCapacity = firstCapacity;
		this.secondCapacity = secondCapacity;
		this.fixedSecondCapacity = secondCapacity;
		this.timeUntilNextArrival = timeUntilNextArrival;
		this.trainNumber = trainNumber;
		this.mainStation = mainStation;

		// station.get(0).setFirstClass(mainStation.get(0).getFirstClass());
	}
	
	/**
	 * This method is used to advance the train one time step and print out the result.
	 * If the train reaches the station it will print out information about the station and weather it can board passengers
	 * If the train is not at a station it will print out the number of minutes left until the train reaches the next station.
	 */
	public void simulateTimeStep() {

		// station.get(trainNumber).simulateTimestep();

		if (station.isEmpty())
			System.out.println("Train " + (trainNumber + 1) + " has stopped picking up passengers");
		else if (time % 5 == 0 && time >= trainNumber * 5) {
			System.out.println("Train " + (trainNumber + 1) + " arrived at " + station.getFirst().getStationName());
			System.out.println("In " + station.getFirst().getStationName() + ". There are "
					+ station.getFirst().getFirstClass().size() + " passengers in the first class and "
					+ station.getFirst().getSecondClass().size() + " in second class.");
			if(station.getFirst().getStationName().equals("Mineola"))
				stationIndex = 0;
			else if(station.getFirst().getStationName().equals("Hicksville"))
				stationIndex = 1;
			else if(station.getFirst().getStationName().equals("Syosset"))
				stationIndex = 2;
			else if(station.getFirst().getStationName().equals("Huntington"))
				stationIndex = 3;
			else 
				System.out.println("Invalid index Train line 53");
				
				

			if (firstCapacity == 0)
				System.out.println("Train " + (trainNumber+1)+ " is full (First Class)");
			else {
				while (!station.getFirst().getFirstClass().isEmpty()) {
					if (firstCapacity == 0) {
						System.out.println("Train "+ (trainNumber+1)+ " is full (First Class)");
						break;
					}
					//station.getFirst().getFirstClass().dequeue();
					dequeueSum1 = time - station.getFirst().getFirstClass().dequeue().getArrivalTime();
					mainStation.get(stationIndex).addDequeueSum1(dequeueSum1);
					mainStation.get(stationIndex).addDequeueCount1(one);
					firstCapacity--;
					System.out.println("Train " + (trainNumber+1) + ". First class status: " + (fixedFirstCapacity - firstCapacity) + "/" + fixedFirstCapacity);
				}
			}

			if (secondCapacity == 0)
				System.out.println("Train " + (trainNumber+1)+  " is full (Second Class)");
			else {
				while (!station.getFirst().getFirstClass().isEmpty()) {
					System.out.println("First class has priority.");
					if (secondCapacity == 0) {
						System.out.println("Train " + (trainNumber+1) +" is full (Second Class)");
						break;
					}
					dequeueSum1 = time - station.getFirst().getFirstClass().dequeue().getArrivalTime();
					mainStation.get(stationIndex).addDequeueSum1(dequeueSum1);
					mainStation.get(stationIndex).addDequeueCount1(one);
					secondCapacity--;
					System.out.println("Train " + (trainNumber+1) + ". Second class status: " + (fixedSecondCapacity - secondCapacity) + "/" + fixedSecondCapacity);

				}

				while (!station.getFirst().getSecondClass().isEmpty()) {
					if (secondCapacity == 0) {
						System.out.println("Train " + (trainNumber+1) +" is full (Second Class)");
						break;
					}
					dequeueSum2 = time - station.getFirst().getSecondClass().dequeue().getArrivalTime();
					mainStation.get(stationIndex).addDequeueSum2(dequeueSum2);
					mainStation.get(stationIndex).addDequeueCount2(one);
					secondCapacity--;
					System.out.println("Train " + (trainNumber+1) + ". Second class status: " + (fixedSecondCapacity - secondCapacity) + "/" + fixedSecondCapacity);

				}
			}

			//System.out.println(station.getFirst().getFirstClass().toString());
			station.removeFirst();
			timeUntilNextArrival = 5;

		} else {
			System.out.println("Train " + (trainNumber + 1) + " will arrive at " + station.getFirst().getStationName()
					+ " in " + (timeUntilNextArrival) + " minutes");
		}
		timeUntilNextArrival--;
		time++;
	}
	
	/**
	 * This method is used to return the current linkedlist station in this method
	 * @return the current linkedlist station associated with the specific train
	 */
	public LinkedList<Station> getStation() {
		return station;
	}

//	public void simulateTimeStepStation() {
//		station.get(trainNumber).simulateTimestep();
//	}

//	public int getFirstCapacity() {
//		return firstCapacity;
//	}
//
//	public void setFirstCapacity(int firstCapacity) {
//		this.firstCapacity = firstCapacity;
//	}
//
//	public int getSecondCapacity() {
//		return secondCapacity;
//	}
//
//	public void setSecondCapacity(int secondCapacity) {
//		this.secondCapacity = secondCapacity;
//	}

//	public int getTimeUntilNextArrival() {
//		return timeUntilNextArrival;
//	}

//	public void setTimeUntilNextArrival(int timeUntilNextArrival) {
//		this.timeUntilNextArrival = timeUntilNextArrival;
//	}

//	public void setStation(LinkedList<Station> station) {
//		this.station = station;
//	}
}
