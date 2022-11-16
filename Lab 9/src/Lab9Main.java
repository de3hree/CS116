import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Lab9Main {

	public static void main(String[] args) {

		// Make zero filled ArrayLists of the appropriate sizes for 1k, 2k, 4k, 8k and
		// 16k Integers
		ArrayList<Integer> test1k = new ArrayList<Integer>(Collections.nCopies(1000, 0));
		ArrayList<Integer> test2k = new ArrayList<Integer>(Collections.nCopies(2000, 0));
		ArrayList<Integer> test4k = new ArrayList<Integer>(Collections.nCopies(4000, 0));
		ArrayList<Integer> test8k = new ArrayList<Integer>(Collections.nCopies(8000, 0));
		ArrayList<Integer> test16k = new ArrayList<Integer>(Collections.nCopies(16000, 0));

		// Two longs, startTime to be overwritten on each sort call
		// timeSum is to collect the execution time of each sort in milliseconds and
		// then display it
		long startTime = System.nanoTime();
		long timeSum = 0;

		// Var to control amount of iterations for each sort as well as the average
		// calculation
		int iterationNum = 10;

		// Number generator for random integers to sort
		Random rng = new Random();

		// Looping variable, overwritten on each while loop
		int x = 0;

		// While loop that is repeated for each size of the array being tested, as well
		// as a duplicate for binarySearches below
		while (x < 100) {
			// Generate the random numbers for each iteration
			for (int i = 0; i < iterationNum; i++) {
				test1k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}
			// Start the timer
			startTime = System.nanoTime();

			// Call the relevant sorting method
			insertionSort(test1k);

			// End timer and calculate the difference
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;

			// Add time measurement to the timeSum
			timeSum += timeElapsed / 1000000;

			// Iterate loop
			x += 1;

		}
		// Print resulting average to console
		System.out.println("1k average: (milli) " + (timeSum / iterationNum));

		// Reset sum and looping variable for chaining tests
		timeSum = 0;
		x = 0;

		// Repeat above for the remaining 4 insertion sorts

		while (x < iterationNum) {
			for (int i = 0; i < 2000; i++) {
				test2k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			insertionSort(test2k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("2k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 4000; i++) {
				test4k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			insertionSort(test4k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("4k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 8000; i++) {
				test8k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			insertionSort(test8k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("8k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 16000; i++) {
				test16k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			insertionSort(test16k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("16k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0; 
		
		System.out.println("\nSTART OF BINARY SEARCH\n");

		// Binary sorting testing, same as above with the method changed

		while (x < 100) {
			// Generate the random numbers for each iteration
			for (int i = 0; i < iterationNum; i++) {
				test1k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}
			// Start the timer
			startTime = System.nanoTime();

			// Call the relevant sorting method
			binaryInsertionSort(test1k);

			// End timer and calculate the difference
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;

			// Add time measurement to the timeSum
			timeSum += timeElapsed / 1000000;

			// Iterate loop
			x += 1;

		}
		// Print resulting average to console
		System.out.println("1k average: (milli) " + (timeSum / iterationNum));

		// Reset sum and looping variable for chaining tests
		timeSum = 0;
		x = 0;
		
		while (x < iterationNum) {
			for (int i = 0; i < 2000; i++) {
				test2k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			binaryInsertionSort(test2k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("2k average: (milli) " + (timeSum / iterationNum));

		// Repeat above for the remaining 4 binary sorts

		System.out.println("2k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 4000; i++) {
				test4k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			binaryInsertionSort(test4k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("4k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 8000; i++) {
				test8k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			binaryInsertionSort(test8k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("8k average: (milli) " + (timeSum / iterationNum));

		timeSum = 0;
		x = 0;

		while (x < iterationNum) {
			for (int i = 0; i < 16000; i++) {
				test16k.set(i, Integer.valueOf(rng.nextInt(-10000, 10001)));
			}

			startTime = System.nanoTime();
			binaryInsertionSort(test16k);

			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			timeSum += timeElapsed / 1000000;
			x += 1;

		}

		System.out.println("16k average: (milli) " + (timeSum / iterationNum));

	}

	public static void insertionSort(ArrayList<Integer> inputArr) {
		int temp = 0;
		for (int x = 1; x < inputArr.size(); x++) {
			for (int y = x - 1; y >= 0; y--) {
				if (inputArr.get(y) > inputArr.get(x)) {
					temp = inputArr.get(x);
					inputArr.set(x, inputArr.get(y));
					inputArr.set(y, temp);
					x -= 1;
				}
			}
		}
	}

	public static void binaryInsertionSort(ArrayList<Integer> inputArr) {
		for (int x = 1; x < inputArr.size(); x++) {
			if (inputArr.get(x) < inputArr.get(x - 1)) {
				int high = x;
				int low = 0;
				int mid = (high + low) / 2;
				while (high >= low) {
					if (inputArr.get(x) < inputArr.get(mid)) {
						high = mid - 1;
					} else if (inputArr.get(x) >= inputArr.get(mid)) {
						low = mid + 1;
					}
					mid = (high + low) / 2;
				}
				inputArr.add(low, inputArr.remove(x));
			}
		}
	}
}
