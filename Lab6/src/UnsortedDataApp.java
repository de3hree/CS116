import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnsortedDataApp {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What is the name of the input file? ");
		String fileName = input.next();
		File userFile = new File(fileName);
		try {
			Scanner file1 = new Scanner(userFile);
			double[] results = new double[100];
			
			for(int x = 0; x < 100; x++) {
				results[x] = file1.nextDouble();
			}
			System.out.println("The amount of numbers out of position is " + UnsortedData.countOutOfPosition(results));
			UnsortedData.bubble(results);
			System.out.println("The amount of numbers out of position, after one bubble sort, is " + UnsortedData.countOutOfPosition(results));
			
		} catch(FileNotFoundException e){
			System.out.println("Cant spell lulw");
			return;
		}
		
		
		
		
	}
	
}
