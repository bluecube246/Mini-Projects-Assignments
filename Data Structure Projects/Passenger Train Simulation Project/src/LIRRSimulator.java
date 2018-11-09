import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * This class represents the main method that will be used to input various
 * probabilities and initial data so that we can use it in the simulation
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 4
 * 
 * @author Hyuk Joon Kwon
 *
 */

public class LIRRSimulator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<Station> station = new LinkedList<Station>();
		LinkedList<Train> train = new LinkedList<Train>();
		double first = 0;
		double second = 0;
		int id = 1;
		int trains;
		int firstClass;
		int secondClass;
		int lastArrival;
		String[] tempStation = { "Mineola", "Hicksville", "Syosset", "Huntington" };
		String[] reverse = { "Huntington", "Syosset", "Hicksville", "Mineola" };

		System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");
		System.out.println();
		while (true) {
			try {
				while (true) {
					System.out.print("Please first class capacity ");
					firstClass = in.nextInt();
					// firstClass = 7;
					in.nextLine();
					if (firstClass > 0)
						break;
					else
						System.out.println("Please enter a positive capacity");
				}
				while (true) {
					System.out.print("Please enter second class capacity ");
					secondClass = in.nextInt();
					// secondClass = 15;
					in.nextLine();
					if (secondClass > 0)
						break;
					else
						System.out.println("Please enter a positive capacity");
				}
				while (true) {
					System.out.print("Please enter the number of trains ");
					// trains = 4;
					trains = in.nextInt();
					in.nextLine();
					if (trains > 0)
						break;
					// throw new Exception("Please enter a positive number of trains");
					else
						System.out.println("Please enter a positive capacity");
				}
				while (true) {
					System.out.print("Please enter last arrival time of passengers ");
					lastArrival = in.nextInt();
					in.nextLine();
					// lastArrival = 14;
					if (lastArrival > trains * 5 + 10)
						System.out.println("The passenger arrives after the last train has departed try again");
					else if (lastArrival <= 0)
						System.out.println("Please enter a positive time");
					else
						break;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input put in an integer");
				in.nextLine();
			}

			catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input");
				in.nextLine();
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				in.nextLine();
			}
		}

		// This loop adds the trains to the train linked list
		for (int k = 0; k < trains; k++) {
			train.add(new Train(firstClass, secondClass, k * 5, k, station));
		}

		// Initializes the trains and their probabilities
		for (int i = 0; i < tempStation.length; i++) {
			System.out.println(tempStation[i] + ":");
			while (true) {
				try {
					while (true) {
						System.out.print("Please enter first class arrival probability: ");
						first = in.nextDouble();
						in.nextLine();
						// first = 0.3;
						if (first <= 1 && first >= 0)
							break;
						System.out.println("Please enter a valid probabilty between 0 and 1");
					}
					while (true) {
						System.out.print("Please enter second class arrival probability: ");
						second = in.nextDouble();
						in.nextLine();
						// second = 0.7;
						if (second <= 1 && second >= 0)
							break;
						// add so that traversal is possible with get(k)
					}
					break;
				} catch (Exception e) {
					System.out.println("dPlease enter a valid probability between 0 and 1");
					in.nextLine();
				}
			}

				station.add(new Station(first, second, reverse[i], lastArrival));
				for (int k = 0; k < trains; k++) {
					train.get(k).getStation().add(new Station(first, second, reverse[i], lastArrival));
				}
			System.out.println();
		}

		// for (int k = 0; k < tempStation.length; k++) {
		// System.out.println(station.peek().getStationName());
		// System.out.println(station.get(k).getStationName());
		// }
		//
		// for (int k = 0; k < trains; k++) {
		// System.out.println(train.get(k).getFirstCapacity() + " " +
		// train.get(k).getSecondCapacity() + " "
		// + train.get(k).getTimeUntilNextArrival());
		// System.out.println();
		// }
		//

		// This method is used to link all the passenger queues to an identical
		for (int s = 0; s < tempStation.length; s++) {
			// System.out.println(s);
			for (int j = 0; j < trains; j++) {
				//System.out.println(s + "" + j + " 1 " + train.get(j).getStation().size());
				//System.out.println(s + "" + j + " 2 " + station.size());
				train.get(j).getStation().get(s).setFirstClass(station.get(s).getFirstClass());
				train.get(j).getStation().get(s).setSecondClass(station.get(s).getSecondClass());

			}
		}

		System.out.println("----------------------------------------------------");
		// This method is used to deal with a single time step
		for (int t = 0; t <= trains * 5 + 11; t++) {
			System.out.println();
			System.out.println("Time " + t + ":");
			System.out.println();
			System.out.println("Station overview");
			System.out.println();

			// print station names
			// for (int k = 0; k < tempStation.length; k++) {
			// System.out.println(station.get(k).getStationName());
			// }

			for (int s = tempStation.length - 1; s >= 0; s--) {
				station.get(s).simulateTimestep();
			}

			System.out.println();
			System.out.println("Trains:");

			for (int k = 0; k < trains; k++) {
				System.out.println();
				train.get(k).simulateTimeStep();
			}

		}

		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println("At the end of the simulation");
		System.out.println();
		System.out.println("A total of " + Station.getId() + " passengers was served,");
		int leftFirst = 0;
		int leftSecond = 0;
		for (int i = 0; i < tempStation.length; i++) {
			leftFirst += station.get(i).getFirstClass().size();
			leftSecond += station.get(i).getSecondClass().size();
		}
		System.out.println(leftFirst + " first class passengers were left without" + " a seat, ");

		System.out.println(leftSecond + " second class passengers were left" + " without a seat.");

		System.out.println();

		for (int s = tempStation.length - 1; s >= 0; s--) {
			System.out.println("At " + station.get(s).getStationName() + " " + station.get(s).getDequeueCount1()
					+ " First class customers were served with an average wait time of "
					+ station.get(s).getDequeueSum1() * 1.0 / station.get(s).getDequeueCount1() + ", "
					+ station.get(s).getDequeueCount2() + " Second");
			System.out.println("class customers were served with an average wait time of "
					+ station.get(s).getDequeueSum2() * 1.0 / station.get(s).getDequeueCount2() + ". "
					+ station.get(s).getFirstClass().size() + " first class passengers were left without a seat and "
					+ station.get(s).getSecondClass().size());
			System.out.println("second class " + " passengers were left without a seat.");
			System.out.println();
		}

		System.out.println("Station passenger status after last train has left");
		System.out.println();

		for (int s = tempStation.length - 1; s >= 0; s--) {
			System.out.println(station.get(s).getStationName() + " " + station.get(s).getFirstClass().toString() + " "
					+ station.get(s).getSecondClass().toString());
		}

	}

}
