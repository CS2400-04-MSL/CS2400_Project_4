import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxHeapFileTester {

	public static void main(String[] args) throws FileNotFoundException
	{
		File randomData = new File("C:\\Users\\Justin\\OneDrive - Cal Poly Pomona\\Progamming stuff\\CS2400_Project_4\\data_random.txt");
		Scanner reader1 = new Scanner(randomData);
		String[] random = new String[100];
		
		int i = 0;
		while (reader1.hasNextLine())
		{
			random[i] = reader1.nextLine();
			++i;
		}

		MaxHeap.buildMaxHeap_optimal(random);
	}
}
