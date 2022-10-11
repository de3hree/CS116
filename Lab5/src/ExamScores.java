import java.util.Scanner;
import java.text.DecimalFormat;

public class ExamScores {
		
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		DecimalFormat display = new DecimalFormat("###.##");
		
		//Get array length from user
		System.out.print("How many scores do you have to enter?");
		int leng = input.nextInt();
		
		//Check if length of array is positive, otherwise exit program
		if (leng < 0) {
			System.out.println("Value entered is negative, this is not supported, exiting program...");
		} else {
			double sum = 0;
			int overAverage = 0;
			double[] scores = new double[leng];
			
			//Ask for the amount of scores previously indicated
			for(int i = 0; i < leng;i++) {
				System.out.print("Enter score #" + i + 1 +": ");
				double score = input.nextDouble();

				//Since this is an exam score it is expected to be between 100 and 0,
				//    if it is  not the value will be turned to the nearest valid value and prompt the user of the change
				if(score > 100.0) {
					System.out.println("Entered value was too high and has been defaulted to 100.");
					score = 100.0;
				} else if (score < 0.0) {
					System.out.println("Entered value was too low and has been defaulted to 0.");
					score = 0.0;
				}
				//Add score to array and the sum
				sum += score;
				scores[i] = score;
			}
			
			//Calculate average of the values entered
			double average = sum / leng;
			
			//Loop over the array to check how many values are above average 
			for(int i = 0; i < leng;i++) {
				if(average < scores[i]) {
					//Iterate the overAverage count for every found value
					overAverage += 1;
				}
			}
			
			//Check if the length was at zero since the average will be Nan if the length was zero
			if(leng != 0) {
				//Display the average with a formatted string
				System.out.println("The average score is " + display.format(average));
			} else {
				System.out.println("The average score is 0.00");
			}
			
			System.out.println("There are " + overAverage + " scores larger than average.");
			input.close();
			
		}
		
	}


}
