import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 * This class represents the main method that will be used to control the entire
 * hashMap by adding editing deleting printing and saving storm objects
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 6
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class StormStatServer {
	private static HashMap<String, Storm> database = new HashMap<String, Storm>();

	public static void main(String[] args) {
		String filename = "hurricane.ser";
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dateD;
		String dateString;

		// if file exists import
		// or new HashMap
		File f = new File(filename);

		try {
			if (f.createNewFile())
				System.out.println("File is created");
			else {
				System.out.println("File already exists");
				FileInputStream fileout = new FileInputStream(f);
				ObjectInputStream objout = new ObjectInputStream(fileout);
				database = (HashMap<String, Storm>) objout.readObject();
			}
		} catch (EOFException e1) {
			System.out.println("File exists but nothing to import");
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		String option;

		// database.put("3", new Storm("Three", 3, 1, "2000"));
		// database.put("1", new Storm("One", 1, 3, "2001"));
		// database.put("2", new Storm("Two", 2, 2, "2002"));
		// System.out.println("added");

		while (true) {
			try {
				System.out.print("Please select an option: ");
				option = in.nextLine();
				System.out.println();

				switch (option) {
				case ("a"):
				case ("A"):
					while (true) {
						try {
							System.out.print("Please enter name: ");
							String name = in.nextLine();
							System.out.print("Please enter date: ");
							String date = in.nextLine();
							dateD = sdf.parse(date);
							System.out.print("Please enter precipitation (cm): ");
							double prec = in.nextDouble();
							in.nextLine();
							System.out.print("Please enter windspeed(km/h): ");
							double wind = in.nextDouble();
							in.nextLine();
							Storm storm = new Storm(name, prec, wind, date);
							database.put(name, storm);
							System.out.println(database.get(name).getName() + " added.");
							System.out.println();
							FileOutputStream file = new FileOutputStream(filename);
							ObjectOutputStream out = new ObjectOutputStream(file);

							out.writeObject(database);

							out.close();
							file.close();
							break;
						} catch (ParseException e2) {
							System.out.println("Please enter a valide date format: (yyyy-mm-dd)");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

					break;

				case ("L"):
				case ("l"):
					String look;
					System.out.print("Please enter a name: ");
					look = in.nextLine();
					if (database.get(look) == null) {
						System.out.println("Please enter a valid name");
						break;
					}
					System.out.println();
					System.out.println("Storm " + database.get(look).getName() + ": Date "
							+ database.get(look).getDate() + ", \n" + database.get(look).getWindspeed()
							+ " km/h winds, " + database.get(look).getPrecipitation() + " cm of rain");
					System.out.println();
					break;

				case ("D"):
				case ("d"):
					String delete;
					System.out.print("Please enter a name: ");
					delete = in.nextLine();
					if (database.get(delete) == null) {
						System.out.println("Plase enter a valid name");
						break;
					}
					Storm temp = database.remove(delete);
					System.out.println("Storm " + temp.getName() + " has been deleted");
					break;

				case ("E"):
				case ("e"):
					while (true) {
						try {
							String input;
							System.out.print("Please enter a name: ");
							String tempName = in.nextLine();
							if (!database.containsKey(tempName)) {
								throw new Exception("The name does not exist");
							}

							System.out.println("In edit Mode, press enter without any input to leave data unchanged");
							System.out.print("Please enter date: ");
							String tempDate = in.nextLine();
							if (tempDate.equals(""))
								tempDate = database.get(tempName).getDate();
							else {
								dateD = sdf.parse(tempDate);
							}
							System.out.print("Please enter precipitation (cm): ");
							input = in.nextLine();
							double tempPre;
							if (input.equals(""))
								tempPre = database.get(tempName).getPrecipitation();
							else
								tempPre = Double.parseDouble(input);

							System.out.print("Please enter windspeed (km/h): ");
							input = in.nextLine();
							double tempWind;

							if (input.equals(""))
								tempWind = database.get(tempName).getWindspeed();
							else
								tempWind = Double.parseDouble(input);
							database.put(tempName, new Storm(tempName, tempPre, tempWind, tempDate));
							System.out.println();
							System.out.println("Update complete");
							System.out.println();
							break;

						} catch (NumberFormatException e) {
							System.out.println("Error: Please put in a double ");
						} catch (ParseException e1) {
							System.out.println("Please enter a valid date format (yyyy-mm-dd");
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
						}
					}

					break;

				case ("R"):
				case ("r"):
					List<Storm> a = new ArrayList<Storm>(database.values());
					Collections.sort(a, new PrecipitationComparator());
					System.out.println("Name\t\tWindspeed\tRainfall");
					System.out.println("---------------------------------------------");
					for (Storm s : a) {
						System.out.println(s.toString());
					}
					System.out.println();
					break;

				case ("W"):
				case ("w"):
					List<Storm> b = new ArrayList<Storm>(database.values());
					Collections.sort(b, new WindSpeedComparator());
					System.out.println("Name\t\tWindspeed\tRainfall");
					System.out.println("--------------------------------------------");
					for (Storm s : b) {
						System.out.println(s.toString());
					}
					System.out.println();
					break;

				case ("X"):
				case ("x"):
					try {
						FileOutputStream file = new FileOutputStream(filename);
						ObjectOutputStream out = new ObjectOutputStream(file);

						out.writeObject(database);

						out.close();
						file.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("File saved to " + filename + " have a nice day.");

				case ("Q"):
				case ("q"):
					System.out.println("Exiting...");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
