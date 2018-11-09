import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		Tree tree = new Tree();
		
		tree.readfromFile("file1.txt");
		
		System.out.println();
		
		tree.bfs();
		
		System.out.println();
		
		tree.readfromFile("file2.txt");
		
		System.out.println();
		
		tree.bfs();
		
		System.out.println();
		
		tree.readfromFile("file3.txt");
		
		System.out.println();
		
		tree.bfs();
		
		System.out.println();
		
		tree.readfromFile("file4.txt");
		
		System.out.println();
		
		tree.bfs();
		
		System.out.println();
	}
}
