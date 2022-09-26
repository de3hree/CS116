import java.util.Random;
import java.util.random.*;
public class SixSidedDie {

	
	private int value = 1;
	
	//Default constructor
	public SixSidedDie() {
		
	}
	
	//Sets value to a randomly generated value from 1-6
	public int roll() {
		Random roll = new Random();
		value = roll.nextInt(1,7); 
		return value;
	}
	
	//Override toString
	public String toString() {
		
		return "rolled " + value;
	}
}
