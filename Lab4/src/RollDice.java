
public class RollDice {

	
	
	public static void main(String[] kwargs) {
		SixSidedDie A = new SixSidedDie();
		SixSidedDie B = new SixSidedDie();
		Game1(A,B);
		Game2(A,B);
		
		
		
	}
	//Prints results of Game1 to the screen
	private static void Game1(SixSidedDie A,SixSidedDie B) {
		System.out.println("\nGame 1");
		
		int val1 = 0;
		int val2 = 0;
		int sum = 0;
		
		for(int x = 1; x < 11; x++) {
			val1 = A.roll();
			val2 = B.roll();
			sum += val1 + val2;
			System.out.println("Iteration " + x + ": A " + A + " and B " + B );
		}
		
		System.out.println("\nFinal sum of rolls: " + sum);
	}
	
	
	//Print results of Game 2 to screen
	// do while() used for no real reason since just instantiating the values and then doing a normal while would be fine
	private static void Game2(SixSidedDie A,SixSidedDie B) {
		System.out.println("\nGame 2");
		int val1;
		int val2;
		int count = 0;
		
		do {
			count += 1;
			val1 = A.roll();
			val2 = B.roll();
			System.out.println("Iteration " + count + ": A " + A + " and B " + B );
			
		} while(val1 + val2 != 8);
		
		System.out.println("\nIt took " + count + " iterations to roll a sum of "+ (val1 + val2) + ".");
	}
}
