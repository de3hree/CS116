import java.util.Random;

public class RandomSwitchPlayer extends Player implements PlayerInterface {

	
	private Random rng = new Random();
	
	public RandomSwitchPlayer() {
		
	}
	
	public int selectDoor() {
		this.selectedDoor = rng.nextInt(3) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		if(Integer.toBinaryString(rng.nextInt(2)).equals("0")) {
			
			this.selectedDoor = this.getSelectedDoor() ^ openDoor;
		}
		return this.getSelectedDoor();
	}
}
