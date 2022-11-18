
public class RecursionApp {

	public static void main(String[] args) {
		String testStr = "not a palindrome";
		String testStr2 = "tacocat";

		System.out.println(palindrome(testStr));
		System.out.println(palindrome(testStr2));
		
		double a = 200.0;
		double t = 100.0;
		
		//System.out.print(squareRoot(a,a,t));
		
		
		
	}

	public static boolean palindrome(String inputStr) {

		if (inputStr.length() < 2) {
			return true;
		}
		
		System.out.println(inputStr.substring(0, 1) + " = " + inputStr.substring(inputStr.length() - 1));
		
		return inputStr.substring(0, 1).equals(inputStr.substring(inputStr.length() - 1))
				&& palindrome(inputStr.substring(1, inputStr.length() - 1));

	}
	
	public static double squareRoot(double currIteration, double targetNum, double approxRange) {
		
		
		if(currIteration == 0.0) {
			return targetNum / 2;
		}
		
		double currentApprox = squareRoot(currIteration - 1,targetNum,approxRange);
		System.out.println(currentApprox + " iteration " + currIteration);
		
		if(Math.pow(currentApprox, 2.0) < targetNum && Math.pow(currentApprox, 2.0) > targetNum - approxRange ) {
			System.out.println(currentApprox);
			return currentApprox;
		}
		
		return 0.5 * (currentApprox + (targetNum / currentApprox));
	}

}
