import java.util.HashMap;
import java.util.Scanner;

import big.data.DataSource;

/**
 * This class represents the main method that will be allow the user to make
 * print out shortest path, max flow and destinations reachable.
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 7
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class IslandDesigner {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		IslandNetwork main = new IslandNetwork();
		String url;

		while (true) {
			try {
				System.out.println("Please enter an url: ");
				url = in.nextLine();
				main.loadFromFile(url);
				break;
			} catch (Exception e) {
				System.out.println("Please enter a valid url");
			}
		}

		// http://www3.cs.stonybrook.edu/~cse214/hw/hw7-images/hw7.xml

		// main.PrintAlphabetical();
		// main.PrintRoad();

		String option = null;

		while (true) {
			try {
				System.out.println("Menu: ");
				System.out.println("    D) Destinations reachable (Dephth First Search)");
				System.out.println("    F) Maximum Flow");
				System.out.println("    S) Shortest Path");
				System.out.println("    Q) Quit");
				System.out.print("Please select an option: ");
				option = in.nextLine();
				switch (option) {

				case ("D"):
				case ("d"):
					String start;
					System.out.println("The input is case and space sensitive");
					System.out.print("Please enter a starting city: ");
					start = in.nextLine();
					main.dfs(start);

					break;

				case ("F"):
				case ("f"):
					String from, to;
					System.out.print("Please enter a starting city: ");
					from = in.nextLine();
					System.out.print("Please enter a destination: ");
					to = in.nextLine();
					main.maxFlow(from, to);
					main.reset("http://www3.cs.stonybrook.edu/~cse214/hw/hw7-images/hw7.xml");
					break;

				case ("S"):
				case ("s"):
					String begin, end;
					System.out.print("Please enter a starting city: ");
					begin = in.nextLine();
					System.out.print("Please enter a destination: ");
					end = in.nextLine();
					main.djikstra(begin, end);

					break;
				case ("Q"):
				case ("q"):
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
