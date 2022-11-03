import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {
	
	private int prizeLocation;
	private Random rng = new Random();
	
	public Game() {
		prizeLocation = rng.nextInt(3) + 1; 
		
	}
	
	public int getPrizeLocation() {
		return prizeLocation;
	}
	
	public int getOpenDoor(int initialGuess) {
		if(initialGuess != prizeLocation) {
			return initialGuess ^ prizeLocation;//Bitwise XOR operation, happens to work due to limited choices
		}
		switch(prizeLocation) {
			case(1):
				return rng.nextInt(2)+2;
			case(2):
				int[] choices =  {1,3};
				return choices[rng.nextInt(2)];
			default:
				return rng.nextInt(2)+1;
		}
	}
	
	public void reset() {
		prizeLocation = rng.nextInt(3) + 1; 
	}
	

}
