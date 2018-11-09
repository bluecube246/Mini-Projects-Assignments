import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import big.data.DataSource;

/**
 * This class represents the entire island and is used to hold different methods
 * such as max flow depth first search and shrotest path. It also contains a
 * hashmap that includes all the cities.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 7
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class IslandNetwork {
	private HashMap<String, City> graph = new HashMap<String, City>();
	City temp;
	int totalMaxFlow = 0;
	int shortestPath = Integer.MAX_VALUE;
	ArrayList<String> shortest = new ArrayList<String>();

	/**
	 * This method is used to load data from the given URL
	 * 
	 * @param url
	 * @return
	 */
	public IslandNetwork loadFromFile(String url) {

		DataSource ds = DataSource.connectXML(url);
		ds.load();
		String cityNamesStr = ds.fetchString("cities");
		String[] cityNames = cityNamesStr.substring(1, cityNamesStr.length() - 1).replace("\"", "").split(",");

		String roadNamesStr = ds.fetchString("roads");
		String[] roadNames = roadNamesStr.substring(1, roadNamesStr.length() - 1).replace("\"", "").split(",");

		// for(String a: cityNames) {
		// System.out.println(a);
		// }
		//
		// System.out.println();
		// for(String b: roadNames) {
		// System.out.println(b);
		// }

		for (String c : cityNames) {
			temp = new City(c);
			graph.put(c, temp);
		}

		PrintAlphabetical();

		System.out.println("Road\t\t\t\t\tCapacity");
		System.out.println("------------------------------------------------");

		// for (int i = roadNames.length -1; i >0; i = i - 3) {
		// graph.get(roadNames[i-2]).getNeighbors().put(roadNames[i - 1],
		// Integer.parseInt(roadNames[i]));
		//
		// } // Another way to connect the roads

		for (int i = 0; i < roadNames.length; i = i + 3) {
			graph.get(roadNames[i]).getNeighbors().put(roadNames[i + 1], Integer.parseInt(roadNames[i + 2]));
			String temp = roadNames[i] + " to " + roadNames[i + 1];
			if (temp.length() < 24)
				System.out.println(temp + "\t\t\t" + roadNames[i + 2]);
			else
				System.out.println(temp + "\t\t" + roadNames[i + 2]);
		}

		System.out.println();
		System.out.println("Map loaded.");
		System.out.println();
		return this;
	}

	/**
	 * This method is used to reset all the data after using max flow
	 * 
	 * @param url
	 *            The url to restart
	 */
	public void reset(String url) {
		DataSource ds = DataSource.connectXML("http://www3.cs.stonybrook.edu/~cse214/hw/hw7-images/hw7.xml");
		ds.load();
		String cityNamesStr = ds.fetchString("cities");
		String[] cityNames = cityNamesStr.substring(1, cityNamesStr.length() - 1).replace("\"", "").split(",");

		String roadNamesStr = ds.fetchString("roads");
		String[] roadNames = roadNamesStr.substring(1, roadNamesStr.length() - 1).replace("\"", "").split(",");

		for (String c : cityNames) {
			temp = new City(c);
			graph.put(c, temp);
		}

		for (int i = 0; i < roadNames.length; i = i + 3) {
			graph.get(roadNames[i]).getNeighbors().put(roadNames[i + 1], Integer.parseInt(roadNames[i + 2]));

		}

		// System.out.println("Reset complete");
	}

	/**
	 * This method is used to print the cities in alphabetical order It will be used
	 * once at the begining
	 */
	public void PrintAlphabetical() {
		// for(String a: graph.keySet()) {
		// System.out.println(a + " ");
		// }// Hashmap stores elements randomly
		System.out.println("Cities:");
		System.out.println("------------------------------------------");
		List<String> alph = new ArrayList<String>(graph.keySet());
		Collections.sort(alph, new CityComparator());
		for (String a : alph) {
			System.out.println(a);
		}
		System.out.println();
	}

	/**
	 * This method is used to print the neighbors of a certain city It will only be
	 * used for testing
	 */
	public void PrintRoad() { // Not needed
		System.out.println("Road\t\t\t\t\tCapacity");
		System.out.println("------------------------------------------------");
		for (String b : graph.keySet()) {
			graph.get(b).printNeighbors();
		}
		System.out.println();
	}

	/**
	 * This method is used as a depth first search in searching the possible
	 * destinations.
	 * 
	 * @param from
	 *            This is the location where the search starts
	 * @return returns a list of the possible routs in depth first search
	 */
	public List<String> dfs(String from) {
		// HashMap<String, City> tempGraph = deepcopy(graph);
		if (graph.get(from) == null) {
			System.out.println("There is no such city try again");
			System.out.println();
			return null;
		}
		if (from.equals("Small Pear")) {
			System.out.println("No reachable cities. Small Pear is the final destination");
			System.out.println();
			return null;
		}
		dfsHelp(from, 0);
		System.out.println();
		cleanUp(from);
		System.out.println();
		System.out.println();
		return null;

	}

	/**
	 * This method is a helper method to efficiently print out the depth first
	 * search
	 * 
	 * @param from
	 *            This is the city that will be started from
	 * @param count
	 *            This is used to not print out the first element
	 */
	public void dfsHelp(String from, int count) {
		if (graph.get(from).getVisited() == true)
			return;
		graph.get(from).setVisited(true);
		if (count != 0) // So that it does not print out the first element
			System.out.print(from + ", ");
		if (from.equals("Small Pear")) // There will be nothing to return anyway
			return;
		for (String a : graph.get(from).getNeighbors().keySet())
			dfsHelp(a, count + 1);
	}

	/**
	 * This method is used to reset all the visited boolean into false and all the
	 * modified nodes back to normal This is used when modifying the distances
	 * during Depth first search.
	 * 
	 * @param from
	 *            The node where the depth first search started
	 */
	public void cleanUp(String from) {
		if (graph.get(from).getVisited() == true) {
			// System.out.println("Activated");
			graph.get(from).setVisited(false);
		}
		for (String a : graph.get(from).getNeighbors().keySet())
			cleanUp(a);
	}

	/**
	 * This method is used to print out the max flow of the city from startin point
	 * to destination
	 * 
	 * @param from
	 *            The starting point
	 * @param to
	 *            The destination
	 */
	public void maxFlow(String from, String to) {
		ArrayList<String> flow = new ArrayList<String>();
		if (from.equals(to)) {
			System.out.println("You are already there");
			return;
		}

		if (graph.get(from) == null || graph.get(to) == null) {
			System.out.println("There is no such city try again");
			System.out.println();
			return;
		}

		if (from.equals("Small Pear")) {
			System.out.println("No reachable cities. Small Pear is the final destination");
			System.out.println();
			return;
		}

		maxFlow(from, to, flow);
		// System.out.println("No more possibilities");
		if (totalMaxFlow != 0)
			System.out.println("Maximum Flow: " + totalMaxFlow);
		else
			System.out.println("No route available");
		totalMaxFlow = 0;

	}

	/**
	 * This method is a helper method that will include an array list so that it
	 * would be more convienient to print
	 * 
	 * @param from
	 *            The starting point
	 * @param to
	 *            The destination
	 * @param flow
	 *            The path the algorithm is taking
	 */
	public void maxFlow(String from, String to, ArrayList<String> flow) {
		// System.out.println("Current location: " + from);

		// Final statement Destination not found unless to is Small Pear
		if (from.equals("Small Pear") && !to.equals("Small Pear")) {
			return;
			// System.out.println("This route is wrong");
		}
		// else if (from.equals(to)) {
		// System.out.println("This route is unreachable");
		// return;
		// }

		else if (from.equals(to)) {
			// System.out.println("Destination found");
			flow.add(to);
			decrement(flow);
			flow.remove(flow.size() - 1);
		}

		// else if(from.equals("Small Pear")) {
		//
		// }

		else {
			for (String a : graph.get(from).getNeighbors().keySet()) {
				flow.add(from);
				maxFlow(a, to, flow);
				// System.out.println("Back to " + from);
				flow.remove(flow.size() - 1);

			}
		}

	}

	/**
	 * When a max flow path has been found this method is used to decrement the
	 * distances and add the flow to the total flow.
	 * 
	 * @param flow
	 *            The array containing a valid path.
	 */
	public void decrement(ArrayList<String> flow) {
		// for (String a : flow) {
		// if (flow.get(flow.size() - 1).equals(a))
		// System.out.print(a);
		// else
		// System.out.print(a + "=> ");
		// }

		// get the minimum path
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < flow.size() - 1; i++) {
			// System.out.println(flow.get(i));
			if (graph.get(flow.get(i)).getNeighbors().get(flow.get(i + 1)) < min)
				min = graph.get(flow.get(i)).getNeighbors().get(flow.get(i + 1));
		}

		if (min == 0) {
			// System.out.println();
			// System.out.println("Path not available");
			return;
		}

		for (String a : flow) {
			if (flow.get(flow.size() - 1).equals(a))
				System.out.print(a);
			else
				System.out.print(a + "=> ");
		}

		// decrease the paths by the minimum
		int current;
		for (int i = 0; i < flow.size() - 1; i++) {
			current = graph.get(flow.get(i)).getNeighbors().get(flow.get(i + 1));
			graph.get(flow.get(i)).getNeighbors().put(flow.get(i + 1), current - min);
		}

		System.out.println(": " + min);

		totalMaxFlow += min;

		// System.out.println("Decrement complete");
	}

	/**
	 * This method is used to get the shortest path from one node to another
	 * 
	 * @param from
	 *            the starting path
	 * @param to
	 *            the finished path
	 */
	public void djikstra(String from, String to) {
		ArrayList<String> djik = new ArrayList<String>();
		if (from.equals(to)) {
			System.out.println("You are already there");
			return;
		}

		if (graph.get(from) == null || graph.get(to) == null) {
			System.out.println("There is no such city try again");
			System.out.println();
			return;
		}

		if (from.equals("Small Pear")) {
			System.out.println("No reachable cities. Small Pear is the final destination");
			System.out.println();
			return;
		}

		djikstra(from, to, djik);
		// System.out.println("No more possibilities");
		System.out.println();
		System.out.println("Analysis complete");
		System.out.println("Shortest Path");
		if (shortest != null) {
			for (String a : shortest) {
				if (shortest.get(shortest.size() - 1).equals(a))
					System.out.print(a);
				else
					System.out.print(a + "=> ");
			}
		}

		System.out.println();
		if (shortestPath == Integer.MAX_VALUE)
			System.out.println("No route Available");
		else
			System.out.println("ShortestPath length: " + shortestPath);
		shortestPath = Integer.MAX_VALUE;
		shortest = null;
	}

	/**
	 * This method is an helper method used to store possible candidates in an array
	 * list
	 * 
	 * @param from
	 *            the starting point
	 * @param to
	 *            the ending node
	 * @param djik
	 *            Array containing possible shortest rout
	 */
	public void djikstra(String from, String to, ArrayList<String> djik) {
		// System.out.println("Current location: " + from);
		if (from.equals("Small Pear") && !to.equals("Small Pear")) {
			// System.out.println("This route is wrong");
		}

		else if (from.equals(to)) {
			// System.out.println("Destination found");
			djik.add(to);
			evalPath(djik);
			djik.remove(djik.size() - 1);
		}

		else {
			for (String a : graph.get(from).getNeighbors().keySet()) {
				djik.add(from);
				djikstra(a, to, djik);
				// System.out.println("Back to " + from);
				djik.remove(djik.size() - 1);

			}
		}

	}

	/**
	 * This method is used to identify if the current path is actually the shortest
	 * path
	 * 
	 * @param djik
	 *            the arraylist to be evaluated
	 */
	public void evalPath(ArrayList<String> djik) {
		// print current path
		// for (String a : djik) {
		// if (djik.get(djik.size() - 1).equals(a))
		// System.out.print(a);
		// else
		// System.out.print(a + "=> ");
		// }

		int sum = 0;
		for (int i = 0; i < djik.size() - 1; i++) {
			sum += graph.get(djik.get(i)).getNeighbors().get(djik.get(i + 1));
		}

		// System.out.println("Path length: " + sum);

		if (sum < shortestPath) {
			// System.out.println("New shortest path " + sum);
			shortestPath = sum;
			shortest = (ArrayList<String>) djik.clone();
		} else
			return;
	}

}
