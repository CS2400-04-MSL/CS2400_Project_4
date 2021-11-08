import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxHeapFileTester {

	public static void main(String[] args) throws FileNotFoundException
	{
		File randomData = new File("data_random.txt");
		Scanner reader1 = new Scanner(randomData);
		Comparable[] random = new String[100];
		
		int i = 0;
		while (reader1.hasNextLine())
		{
			random[i] = reader1.nextLine();
			++i;
		}


		//optimal method
		System.out.println(Arrays.toString(random) + "\n");
		int swaps = MaxHeap.buildMaxHeap_optimal(random);
		System.out.println("\n" + Arrays.toString(random));
		
		System.out.println();
		
		//File sortedData = new File("data_sorted.txt");
		//Scanner reader2 = new Scanner(sortedData);
		Comparable[] sorted = new String[100];
		try {
			FileWriter writer = new FileWriter("data_sorted.txt");

			//i = 0;
			MaxHeap heap = new MaxHeap(random);

			for (int j = 0; j < 10; j++)
			{
				//sorted[i] = reader2.nextLine();
				writer.write( (j + 1) + ": " + random[j] + "\n"); //write first 10 ints to output
				heap.removeMax(); //perform 10 removals
			}
			writer.write("Number of swaps: " + swaps + "\n\n");
			
			
			for (int j = 0; j < 10; j++)
			{
				//write to output heap after 10 removals
				sorted[j] = heap.removeMax();
				
				writer.write( (j + 1) + ": " + sorted[j] + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
