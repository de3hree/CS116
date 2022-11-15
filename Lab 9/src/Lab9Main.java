import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Lab9Main {

	public static void main(String[] args) {
		ArrayList<Integer> test1k = new ArrayList<Integer>(1000);
		ArrayList<Integer> test2k = new ArrayList<Integer>(2000);
		ArrayList<Integer> test4k =new ArrayList<Integer>(4000);
		ArrayList<Integer> test8k = new ArrayList<Integer>(8000);
		ArrayList<Integer> test16k = new ArrayList<Integer>(16000);
		
		ArrayList<Integer> test100 = new ArrayList<Integer>(100);
		
		ArrayList<Integer> testL = new ArrayList<Integer>();
		testL.add(7);testL.add(2);testL.add(4);testL.add(3);testL.add(8);testL.add(5);testL.add(6);testL.add(10);
		testL.add(1);testL.add(9);testL.add(8);
		
		
		Random rng = new Random();
		
		for(int i = 0; i < 100;i++) {
			test1k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		for(int i = 0; i < 1000;i++) {
			test1k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		for(int i = 0; i < 2000;i++) {
			test2k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		for(int i = 0; i < 4000;i++) {
			test4k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		for(int i = 0; i < 8000;i++) {
			test8k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		for(int i = 0; i < 16000;i++) {
			test16k.add(Integer.valueOf(rng.nextInt(-10000, 10001)));
		}
		
		testBinaryInsertion(test1k);
		testInsertion(test1k);
		System.out.println("1k");
		testBinaryInsertion(test2k);
		testInsertion(test2k);
		System.out.println("2k");
		testBinaryInsertion(test4k);
		testInsertion(test4k);
		System.out.println("4k");
		testBinaryInsertion(test8k);
		testInsertion(test8k);
		System.out.println("8k");
		testBinaryInsertion(test16k);
		testInsertion(test16k);
		
		
		
		
	}
	
	
	//I know that the intended way to show the time elapsed for each 
	//   sort individually but using all 100 at the same time does kinda show the time difference as well
	private static void testInsertion(ArrayList currArray) {
		int x = 0;
		long startTime = System.nanoTime();
		while(x < 100) {
			insertionSort(currArray);
			x += 1;
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds : " + timeElapsed);
		System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
		
		
	}
	
	private static void testBinaryInsertion(ArrayList currArray) {
		int x = 0;
		long startTime = System.nanoTime();
		while(x < 100) {
			binaryInsertionSort(currArray);
			x += 1;
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds : " + timeElapsed);
		System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
		
		
	}
	
	
	public static void insertionSort(ArrayList<Integer> inputArr) {
		int temp = 0;
		for(int x = 1;x < inputArr.size();x++) {
			for(int y = x-1; y >= 0; y--) {
				if(inputArr.get(y) > inputArr.get(x)) {
					temp = inputArr.get(x);
					inputArr.set(x, inputArr.get(y));
					inputArr.set(y, temp);
					x -= 1;
				}
			}
		}
	}
	
	public static void binaryInsertionSort(ArrayList<Integer> inputArr) {
		for(int x = 1;x < inputArr.size();x++) {
			if(inputArr.get(x) < inputArr.get(x-1)) {
				int high = x;
				int low = 0;
				int mid = (high + low) / 2;
				while(high >= low) {
					if(inputArr.get(x) < inputArr.get(mid)) {
						high = mid - 1;
					} else if(inputArr.get(x) >= inputArr.get(mid)) {
						low = mid + 1;
					}
					mid = (high + low) / 2;
				}
				inputArr.add(low, inputArr.remove(x));
			}
		}
	}
}
