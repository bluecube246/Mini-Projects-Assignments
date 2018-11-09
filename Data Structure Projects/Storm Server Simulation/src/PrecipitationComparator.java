import java.util.Comparator;
/**
 * This class extends the comparator class and is used to sort the hashmap 
 * according to precipitation. This is used with an array list
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 6
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class PrecipitationComparator implements Comparator{

	/**
	 * This method takes in two Storm objects and returns integers depending on 
	 * their Precipitation value
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Storm e1 = (Storm)o1;
		Storm e2 = (Storm)o2;
		if(e1.getPrecipitation() == e2.getPrecipitation())
			return 0;
		if(e1.getPrecipitation() > e2.getPrecipitation())
			return 1;
		else
			return -1;
	}

}
