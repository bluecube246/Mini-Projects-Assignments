import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		
//		double a = in.nextDouble();
//		System.out.println(a);
		
		String b = in.nextLine();
		if(b.equals(""))
			System.out.println("Empty");
		System.out.println(b);
		
		String date;
		Date date1;
		date = in.nextLine();
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		date1 = sfd.parse(date);
		System.out.println(sfd.format(date1));
		
		
	}
	
	
}
