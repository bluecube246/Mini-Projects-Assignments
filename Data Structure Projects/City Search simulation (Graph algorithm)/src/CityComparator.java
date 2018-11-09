import java.util.Comparator;
/**
 * This class is used to print the cities in alphabetical order. 
 * This class will be used only once. 
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 7
 * 
 * @author Hyuk Joon Kwon
 *
 */
public class CityComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		char a = o1.charAt(0);
		char b = o2.charAt(0);
		if(a == b)
			return 0;
		if(a > b)
			return 1;
		else
			return -1;
	}
	
}
