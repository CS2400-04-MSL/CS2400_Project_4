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
		Comparable[] arraySeq = new String[100];
		Comparable[] arrayOpt = new String[100];

		int i = 0;
		while (reader1.hasNextLine())
		{
			arraySeq[i] = reader1.nextLine();
			++i;
		}

		arrayOpt = Arrays.copyOf(arraySeq,arraySeq.length);

		MaxHeap heapSeq = new MaxHeap(arraySeq);
		int swapsSequential = MaxHeap.buildMaxHeap_sequential(arraySeq);

		//optimal method
		System.out.println(Arrays.toString(arrayOpt) + "\n");
		int swapsOptimal = MaxHeap.buildMaxHeap_optimal(arrayOpt);
		System.out.println("\n" + Arrays.toString(arrayOpt));
		System.out.println();


		Comparable[] sortedOptimal = new String[100];
		Comparable[] sortedSequential = new String[100];
		try {
			FileWriter writer = new FileWriter("output.txt");

			// sequential printing
			//i = 0;


			writer.write("Heap built using sequential insertions: ");

			for (int j = 0; j < 10; j++)
			{
				//sorted[i] = reader2.nextLine();
				writer.write(arraySeq[j] + ", "); //write first 10 ints to output
				heapSeq.removeMax(); //perform 10 removals
			}
			writer.write("...\nNumber of swaps in the heap creation: " + swapsSequential + "\n");


			writer.write("Heap after 10 removals: ");
			for (int j = 0; j < 10; j++)
			{
				//write to output heap after 10 removals
				sortedSequential[j] = heapSeq.removeMax();

				writer.write(sortedSequential[j] + ", ");
			}
			writer.write("...");

			// optimal printing
			//i = 0;
			MaxHeap heapOpt = new MaxHeap(arrayOpt);

			writer.write("\n\nHeap built using optimal Method: ");

			for (int j = 0; j < 10; j++)
			{
				//sorted[i] = reader2.nextLine();
				writer.write(arrayOpt[j] + ", "); //write first 10 ints to output
				heapOpt.removeMax(); //perform 10 removals
			}
			writer.write("...\nNumber of swaps in the heap creation: " + swapsOptimal + "\n");


			writer.write("Heap after 10 removals: ");
			for (int j = 0; j < 10; j++)
			{
				//write to output heap after 10 removals
				sortedOptimal[j] = heapOpt.removeMax();

				writer.write(sortedOptimal[j] + ", ");
			}
			writer.write("...");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
