import java.io.Serializable;
/**
 * This class extends the storm class that is used to store information 
 * of a Storm including its name, precipitation, windspeed, and date
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 6
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class Storm implements Serializable {
	private String name;
	private double precipitation;
	private double windspeed;
	String date;
	
	/**
	 * This default constuctor is used to initialize information of a storm
	 * @param name The name of the storm
	 * @param precipitation The amount of rain that has come
	 * @param windspeed The speed of the wind
	 * @param date The date at which the storm had come
	 */
	public Storm(String name, double precipitation, double windspeed, String date) {
		this.name = name;
		this.precipitation = precipitation;
		this.windspeed = windspeed;
		this.date = date;
	}
	
	/**
	 * This method is used to return the current name of the storm
	 * @return Name of the storm
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to modify the current name of the storm
	 * @param name the name to be modified
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to return the current precipiation of the storm
	 * @return Precipitation of the strom
	 */
	public double getPrecipitation() {
		return precipitation;
	}
	
	/**
	 * This method is used to modify the current precipitation of the storm
	 * @param precipitation The precipitation to be modified
	 */
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
	
	/**
	 * This method is used to get the current windspeed of the storm
	 * @return the current windspeed of the storm
	 */
	public double getWindspeed() {
		return windspeed;
	}

	/**
	 * This method is used to modify the current windspeed of the storm
	 * @param windspeed the windspeed of the storm to be modified
	 */
	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}

	/**
	 * This method is used to return the current Date of the storm
	 * @return the current date of the storm
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * This method is used to modify the current Date of the storm
	 * @param date The date of the storm to be modifed
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * This method returns the string value of the information of the storm used
	 * to print in the main method
	 */
	public String toString() {
		return name + "\t\t" + windspeed + "\t\t" + precipitation;
	}

}
