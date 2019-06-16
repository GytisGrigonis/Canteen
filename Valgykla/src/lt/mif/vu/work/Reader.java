package lt.mif.vu.work;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	public static String read() throws FileNotFoundException{
		File file = new File("C:\\Users\\Gytis\\eclipse-workspace\\Valgykla\\src\\lt\\mif\\vu\\valgykla\\duom.txt");
		Scanner scanner = new Scanner(file);
		String line = scanner.nextLine();
		scanner.close();
		return line;
	}
}
