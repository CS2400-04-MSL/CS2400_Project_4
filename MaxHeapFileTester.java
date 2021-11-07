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
		
		System.out.println();
		
		File sortedData = new File("C:\\Users\\Justin\\OneDrive - Cal Poly Pomona\\Progamming stuff\\CS2400_Project_4\\data_sorted.txt");
		Scanner reader2 = new Scanner(sortedData);
		String[] sorted = new String[100];
		
		i = 0;
		while (reader1.hasNextLine())
		{
			sorted[i] = reader2.nextLine();
			++i;
		}
		
		MaxHeap.buildMaxHeap_optimal(sorted);
	}
}
