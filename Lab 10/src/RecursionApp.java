
public class RecursionApp {

	public static void main(String[] args) {
		/*String testStr = "not a palindrome";
		String testStr2 = "tacocat";

		System.out.println(palindrome(testStr));
		System.out.println(palindrome(testStr2));*/
		
		double a = 200.0;
		double t = 10.0;
		
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
	
	public static double squareRoot(double currApprox, double targetNum, double approxRange) {
		
		
		if(Math.pow(currApprox, 2.0) < targetNum + approxRange && Math.pow(currApprox, 2.0) > targetNum - approxRange ) {
			return currApprox;
		}
		
		double nextApprox = 0.5 * (currApprox + targetNum/currApprox);
		System.out.println(currApprox + " iteration ");
		
		return squareRoot(nextApprox, targetNum,approxRange);
	}

}
