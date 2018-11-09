import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		Find find = new Find();
		//find.Readfromfile("g-r-7-7.txt");
		//find.Readfromfile("g-bt-10-9.txt");
		//find.Readfromfile("g-bt-12-11.txt");
		//find.Readfromfile("g-bt-15-14.txt");
		find.Readfromfile("g-bt-14-13.txt");
		//find.Readfromfile("g-bt-13-12.txt");
		
		long endTime = System.nanoTime();
		
		long timeElapsed = endTime - startTime;
		
		System.out.println();
		
		System.out.println("Execution time: " + timeElapsed/1000000000.0 + " Seconds");
	}
}

