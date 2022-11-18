
public class RecursionApp {

	public static void main(String[] args) {
		/*String testStr = "not a palindrome";
		String testStr2 = "tacocat";

		System.out.println(palindrome(testStr));
		System.out.println(palindrome(testStr2));*/
		
		double a = 11.0;
		double t = 0.3;
		
		System.out.print(squareRoot(a / 2,a,t));
		
		
		
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
		
		
		if(currIteration < 1.0) {
			return targetNum / 2;
		}
		
		double currentApprox = squareRoot(currIteration - 1,targetNum,approxRange);
		System.out.println(currentApprox + " iteration " + currIteration);
		
		if(Math.pow(currentApprox, 2.0) < targetNum + approxRange && Math.pow(currentApprox, 2.0) > targetNum - approxRange ) {
			System.out.println(currentApprox);
			return currentApprox;
		}
		
		return 0.5 * (currentApprox + (targetNum / currentApprox));
	}

}
