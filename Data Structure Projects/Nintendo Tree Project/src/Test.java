import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		String a = "1Central";
		String line = a.substring(1);
		System.out.println(line);
		String index = a.substring(0, 1);
		System.out.println(index);

		File file = new File("Leokwon");

		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
	}
}
