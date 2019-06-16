package lt.mif.vu.work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	public static void write(String line) throws IOException {
		File file1 = new File("rez.txt");
		FileWriter fileWriter = new FileWriter(file1, true);
		fileWriter.write(line + "\n");
		fileWriter.close();
	}
}
