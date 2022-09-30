import java.util.*;

public class LoanDecisionApp {
	
	public static void main(String[] arhgs) {
		
		
		//Boolean to determine whether the applicant qualifies
		boolean qualify = true;
		//Boolean to determine if the program should stop looping and asking for input
		boolean validInput = false;
		
		//Store input for comparison
		int salary;
		int years;
		
		while(!validInput) {
		
			try {
			      // code that should be “tried"
				
				//Have to make a new Scanner each loop, 
				//  if not re-instantiated the Scanner will just repeat the mismatch input
				Scanner input = new Scanner(System.in);
			    
				
				System.out.println("\nPlease enter your salary:");
			    salary = input.nextInt();
			    
			    //Check salary qualifications and exit loop if it doesn't qualify
			    if (salary < 60000)
			    { 
			        qualify = false;
			        break;
			    }
			    System.out.println("Please enter your years worked:");
			     years = input.nextInt();
			    
			   //Check salary qualifications and only change the qualifications if it doesn't meet them
			    if (years <= 3){ qualify = false;}
			    
			    //Change looping variable to stop asking for input
			    validInput = true;
			    input.close();
	
			} catch (InputMismatchException mismatchException){
			     // code that will be executed when exception is “caught"
				
				//Log error and inform user of proper parameters
				System.out.println("ERROR: Invalid input.");
				System.out.println("Please enter input in the form of numbers without decimal places.");
				
			}
		}
		
		//Tell user results if the input is valid
		if(qualify) {
			System.out.println("Congratulations, you qualify for this loan.");
		} else {
			System.out.println("Unfortunately, you do not qualify for this loan.");
		}
		
		
	}

}
