import java.util.Comparator;
import java.util.HashMap;
/**
 * This class is used to represent the city Class
 * A city class will contain a hashmap of neighbors a name 
 * and boolean values of wheather it was discovered or visited.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 7
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class City implements Comparator<String> {
	HashMap<String, Integer> neighbors = new HashMap<String, Integer>();
	String name;
	Boolean discovered = false;
	Boolean visited = false;
	
	/**
	 * This method returns the name of the city
	 * @return The cities name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method sets the name of the city
	 * @param name The name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets the boolean value of discovered
	 * @return The boolean falue depending on its sate
	 */
	public Boolean getDiscovered() {
		return discovered;
	}
	
	/**
	 * This method is used to set the discovered boolean value
	 * @param discovered The boolean value depending on its state
	 */
	public void setDiscovered(Boolean discovered) {
		this.discovered = discovered;
	}
	
	/**
	 * This method gets the boolean value of getVisited
	 * @return The boolean falue depending on its sate
	 */
	public Boolean getVisited() {
		return visited;
	}

	/**
	 * This method is used to set the visited boolean value
	 * @param visited The boolean value depending on its state
	 */
	public void setVisited(Boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * This method is used to set the name of the city
	 * @param name THe name to be set
	 */
	public City(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to return the hashmap contining the neightbors
	 * @return The hashmap of the neighbors
	 */
	public HashMap<String, Integer> getNeighbors() {
		return neighbors;
	}
	
	/**
	 * This mehtod is sued to modify the neighbors hash map
	 * @param neighbors The hasp map to be modified
	 */
	public void setNeighbors(HashMap<String, Integer> neighbors) {
		this.neighbors = neighbors;
	}
	
	/**
	 * This method was used to print the neighbors of a City
	 * It was used for debugging
	 */
	public void printNeighbors() { //Connected to print road not needed
		String temp;
		for (String a : neighbors.keySet()) {
			temp = name + " to " + a;
			// System.out.println(temp.length());
			if (temp.length() < 24)
				System.out.println(temp + "\t\t\t" + neighbors.get(a));
			else
				System.out.println(temp + "\t\t" + neighbors.get(a));
		}
	}
	
	/**
	 * This method is used to print the cities in alphabetical order. 
	 */
	@Override
	public int compare(String arg0, String arg1) {
		char a = arg0.charAt(0);
		char b = arg1.charAt(0);
		if (a == b)
			return 0;
		if (a > b)
			return 1;
		else
			return -1;
	}

}
