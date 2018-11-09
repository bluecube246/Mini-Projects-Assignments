import java.util.Comparator;
/**
 * This class extends the comparator class and is used to sort the hashmap 
 * according to WindSpeed. This is used with an array list
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 6
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class WindSpeedComparator implements Comparator<Storm>{
	
	/**
	 * This method takes in two Storm objects and returns integers depending on 
	 * their windspeed value
	 */
	@Override
	public int compare(Storm arg0, Storm arg1) {
		Storm e1 = (Storm)arg0;
		Storm e2 = (Storm)arg1;
		if(e1.getWindspeed()== e2.getWindspeed())
			return 0;
		if(e1.getWindspeed() > e2.getWindspeed())
			return 1;
		else
			return -1;
	}

}
