import java.util.Scanner;

public class ExamScores {

	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many scores do you have to enter?");
		int leng = input.nextInt();
		
		if (leng < 0) {
			System.out.println("Value entered is negative, this is not supported, exiting program...");
		} else {
			double sum = 0;
			int overAverage = 0;
			double[] scores = new double[leng];
			
			for(int i = 0; i < leng;i++) {
				System.out.print("Enter score #" + i +": ");
				double score = input.nextDouble();

				sum += score;
				scores[i] = score;
			}
			
			double average = sum / leng;
			
			
			for(int i = 0; i < leng;i++) {
				if(average < scores[i]) {
					overAverage += 1;
				}
			}
			
			if(leng != 0) {
				System.out.println("The average score is " + average);
			} else {
				System.out.println("The average score is  0");
			}
			
			System.out.println("There are " + overAverage + " scores larger than average.");
			input.close();
			
		}
		
	}


}
